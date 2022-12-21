//라디오버튼(수입,지출)에 이벤트 등록
const radios = document.querySelectorAll('input[name=type]');
radios.forEach((e)=>{
	e.addEventListener('click',(e)=> drawCalendar(e.target.value));
});

document.addEventListener('DOMContentLoaded', function() {
	let type = document.querySelector('input[name=type]:checked').value;
	drawCalendar(type);
});
		
const xhr = new XMLHttpRequest();
let dataList = [];
function ajaxList(type, start, end){
	var jsonData = {type:type, start: start, end: end};
	xhr.open('POST', getContextPath()+'/account/list', false);
	xhr.setRequestHeader('Content-Type', "application/json;charset=utf-8;");
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4){	   
			if (xhr.status === 200) {
				dataList = [];
				var result = xhr.response;
				var data = JSON.parse(result);
				var color = type==="income"?'green':'red';
				
         		document.querySelector('#totalAmount').innerText = data.amountTotal.T_AMOUNT +"원";
         		document.querySelector('#incomeAmount').innerText = data.amountTotal.I_AMOUNT +"원";
         		document.querySelector('#expendAmount').innerText = data.amountTotal.E_AMOUNT +"원";
				
         		for(key in data.list){				
         			dataList.push({
						id : data.list[key].no,
						title: data.list[key].categoryList.name +" "+ data.list[key].amount,
						start: new Date(new Date(data.list[key].regdate).getTime() + 3240 * 3 * 10000).toISOString().substring(0, 10),
						color: color
					});
				}
			}
		}
	};
	xhr.send(JSON.stringify(jsonData));
}
var calendar;
function drawCalendar(type){
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
				initialView: 'dayGridMonth',
	        	timeZone:'local',
	        	headerToolbar : {
	              	left:'prevYear, prev',
					center : 'title',
					right:'next, nextYear'
				},
				titleFormat:{
					 year: 'numeric', month: '2-digit' 
				},
	          	locale:'ko',
	          	selectable:'true',
	          	expandRows:true,   
	         	events: function(info, successCallback, failureCallback) {
	         		var start = new Date(info.start).toISOString().split('T')[0];
	         		var end = new Date(info.end).toISOString().split('T')[0];
	         		ajaxList(type, start, end);
	         		successCallback(dataList);
	         	},
	         	eventClick:function(event){	
	                if(confirm("'"+event.event.title+"' 내역을 삭제하겠습니까?")){
	        			var event_info = {"no" : event.event.id, "type" : type};
	        			event.event.remove();
	        			
	        			xhr.open('POST', getContextPath()+'/account/delete', true);
	        			xhr.setRequestHeader('Content-Type', "application/json;charset=utf-8;");
	        			xhr.onreadystatechange = function() {
	        				if(xhr.readyState === 4){	   
	        					if (xhr.status === 200) {
	        						var result = xhr.response;
	        						alert("삭제되었습니다!");
	        						window.location.href = getContextPath()+result;
	        					}
	        				}
	        			};
	        			xhr.send(JSON.stringify({no:event.event.id, type:type}));
	         		}	
	            }
	});
	calendar.render();
}