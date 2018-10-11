function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.onreadystatechange = function(){
		if(this.readyState==4 && this.status==200){
			func(this);
		}
	}
	xhr.open("GET",url);
	xhr.send();
}

sendAjaxGet("http://localhost:8082/p1_Martin_Smallwood/ProfileInfo",display);

function display(xhr){
	employee = JSON.parse(xhr.responseText);
	console.log(employee);
	let user = document.getElementById("User");
	user.innerHTML = employee.employee.username;
	let email = document.getElementById("Email");
	email.innerHTML = employee.employee.email;
}

function showPassField(){
	document.getElementById("passForm").hidden=false;
}