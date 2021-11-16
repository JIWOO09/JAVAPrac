/**
 * 
 */
window.onload = function() {
	document.getElementById("id_pass2").addEventListener("blur", passwordCheck);
}

function passwordCheck() {//비밀번호가 일치하는지 
	var password = document.getElementById("id_pass1");
	if(this.value === password.value) {
		this.nextElementSibling.firstChild.innerText = "올바른 입력값 입니다.";
	} else {
		this.nextElementSibling.firstChild.innerText = "패스워드를 다시 확인 하세요.";
	}
}	