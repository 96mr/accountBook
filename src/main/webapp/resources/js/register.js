const xhr = new XMLHttpRequest();	

let idInput = document.querySelector('input[name=id]');
let pwInput = document.querySelector('input[name=password]');
let pwChkInput = document.querySelector('input[name=pwCheck]');

//아이디 유효성, 중복 체크
idInput.addEventListener('keyup', function(e){
	let id = e.target.value;

	xhr.open('POST', getContextPath()+'/idChk', true);
	xhr.setRequestHeader('Content-Type', "application/json;charset=utf-8;");
	xhr.onload = function() {	   
		if (xhr.status === 200) {
			let result = xhr.response;
			let element = document.querySelector('#idError');
			if(result == 1){
				element.textContent = "사용가능한 아이디입니다.";
				element.style.color = "blue";
			}else if(result == -1){
				element.textContent = "이미 가입한 아이디입니다";
				element.style.color = "red";
			}else{
				element.textContent = "아이디는 4~20글자로 영문자, 숫자로만 이루어져야 합니다.";
				element.style.color = "red";
			}
		}
	};
	xhr.send(id=id);
});
	
//비밀번호 체크
pwInput.addEventListener('keyup', function(e){
	let pw = e.target.value;

	xhr.open('POST', getContextPath()+'/pwChk', true);
	xhr.setRequestHeader('Content-Type', "application/json;charset=utf-8;");
	xhr.onload = function() {	   
		if (xhr.status === 200) {
			var result = xhr.response;
			let element = document.querySelector('#pwError');
			if(result == 1){
				element.textContent = "사용가능한 비밀번호입니다";
				element.style.color = "blue";
			}else{
				element.textContent = "비밀번호는 8~30글자로 영문자, 숫자로만 이루어져야 합니다";
				element.style.color = "red";
			}
		}
	};
	xhr.send(password=pw);
});
pwChkInput.addEventListener('keyup', function(e){
	let pwchk = e.target.value;
	let element = document.querySelector('#pwChkError');
	if(pwchk == pwInput.value){
		element.textContent = "비밀번호가 일치합니다";
		element.style.color = "blue";
	}else{
		element.textContent = "비밀번호를 확인해주세요";
		element.style.color = "red";
	}
});