function checkLogin(userName,n,str) {
	if (n == 0 && userName.value == str){userName.value="";userName.style.cssText = "color:#000"}
	if (n == 1){
		if(userName.value == str){userName.value="";}
		userName.style.cssText = "color:#000";
	}
	if (n == 2 && userName.value == ""){userName.value = str;userName.style.cssText = "color:#aaa"}
}
function loginSubmit(){
	var userName = document.all.userid1;
	var password = document.all.password1;
	if(userName.value == "¡™√À’ ∫≈/ø®∫≈"){
	alert("«Î ‰»Î¡™√À’ ∫≈/ø®∫≈");
	userName.focus();
	return false
	}
	if(password.value == ""){alert("«Î ‰»Î√‹¬Î");password.focus();return false}
	document.all.loginform.userid.value=userName.value;
	document.all.loginform.password.value=password.value;
	window.status='';
	document.all.loginform.submit();
	window.status='';
}