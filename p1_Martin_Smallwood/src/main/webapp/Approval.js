

var getParams = function (url) {
	var params = {};
	var parser = document.createElement('a');
	parser.href = url;
	var query = parser.search.substring(1);
	var vars = query.split('&');
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split('=');
		params[pair[0]] = decodeURIComponent(pair[1]);
	}
	return params;
};

var thing = getParams(window.location.href);
var reimID = document.getElementById("reimId");
reimID.value = thing.id;

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

sendAjaxGet("http://localhost:8082/p1_Martin_Smallwood/SingleReim",display);

function display(xhr){
	reimbursement = JSON.parse(xhr.responseText);
	reimbursement = reimbursement.reimbursements;
	console.log(reimbursement);
	document.getElementById("rId").innerHTML = reimbursement.reimId;
	document.getElementById("datemade").innerHTML = reimbursement.dateMade;
	document.getElementById("empId").innerHTML = reimbursement.empId;
	document.getElementById("reason").innerHTML = reimbursement.reason;
}

function deny(){
	sendAjaxGet("http://localhost:8082/p1_Martin_Smallwood/Deny",changeDeny);
}

function approve(){
	sendAjaxGet("http://localhost:8082/p1_Martin_Smallwood/Approve",changeApprove);
}

function changeDeny(){
	
	document.getElementById("appField").innerHTML = "Denied Reimbursement.";
}

function changeApprove(){
	document.getElementById("appField").innerHTML = "Approved Reimbursement.";
}