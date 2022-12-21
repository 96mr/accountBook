let type;
let chartData = [];
let chartList = document.querySelector('#chartList');
let currentMonth = document.querySelector('#currentMonth');
let today = new Date(+new Date() + 3240 * 10000);
let start;
let end;


const radios = document.querySelectorAll('input[name=type]');
radios.forEach((e)=>{
	e.addEventListener('click',(e)=> drawChart(e.target.value, start, end));
});


document.addEventListener('DOMContentLoaded', function() {	
	currentMonth.value = today.toISOString().slice(0, 7);
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
});

currentMonth.addEventListener('change',(event)=>{
	var year = event.target.value.slice(0,4);
	var month = event.target.value.slice(5);
	start = new Date(+new Date(year,month-1,1) + 3240 * 10000).toISOString().split('T')[0];
	end = new Date(+new Date(year,month,0) + 3240 * 10000).toISOString().split('T')[0];
	type = document.querySelector('input[name=type]:checked').value;
	
	drawChart(type, start, end);
});

function drawChart(type, start, end) {
	ajax_list(type, start, end);

    var data = new google.visualization.DataTable();
    
    data.addColumn('string', '카테고리');
    data.addColumn('number', '금액');
  
    data.addRows(chartData);
    
    var options = {
    	'title': type =='expend'? '지출':'수입',
    	pieSliceText:'label'
    };

    var chart = new google.visualization.PieChart(document.getElementById('chart'));
    chart.draw(data, options);

}

const xhr = new XMLHttpRequest();
function ajax_list(type, start, end){
	if(type == null) type = document.querySelector('input[name=type]:checked').value;
	if(start == null) start =new Date(+new Date(today.getFullYear(), today.getMonth(), 1 )+ 3240 * 10000).toISOString().split('T')[0];
	if(end == null) end = new Date(+new Date(today.getFullYear(), today.getMonth() + 1, 0 )+ 3240 * 10000).toISOString().split('T')[0];
	var jsonData = {type:type, start: start, end: end};
	console.log(start);
	console.log(end);
	xhr.open('POST', getContextPath()+'/account/list', false);
	xhr.setRequestHeader('Content-Type', "application/json;charset=utf-8;");
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4){	   
			if (xhr.status === 200) {
				var result = xhr.response;
				var data = JSON.parse(result);
				document.querySelector('#totalAmount').innerText = data.amountTotal.T_AMOUNT +"원";
				document.querySelector('#incomeAmount').innerText = data.amountTotal.I_AMOUNT +"원";
				document.querySelector('#expendAmount').innerText = data.amountTotal.E_AMOUNT +"원";
				
				chartData = [];
				var pre_trs = chartList.getElementsByTagName('tr');
				var len = pre_trs.length;
				for(var i = 0 ; i < len; i++){
					pre_trs[0].remove();
				}
				var cnt = 0;
				for(key in data.list){
					cnt++;
					chartData.push([data.list[key].categoryList.name, data.list[key].amount]);
					
					let tr = document.createElement("tr"); 
					let th = document.createElement("th");
					th.innerHTML = cnt;
					let td1= document.createElement("td");
					td1.innerHTML = new Date(new Date(data.list[key].regdate).getTime() + 3240 * 3 * 10000).toISOString().substring(0, 10);
					let td2 = document.createElement("td");
					td2.innerHTML = data.list[key].categoryList.name;
					let td3= document.createElement("td");
					td3.innerHTML = data.list[key].amount;
					tr.appendChild(th);
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					chartList.appendChild(tr);
				}
			}
		}
	};
	xhr.send(JSON.stringify(jsonData));
}