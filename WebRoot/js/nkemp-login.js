function userLogin(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	
	alert(userName+"=="+password);
	document.forms[0].submit();
}
	