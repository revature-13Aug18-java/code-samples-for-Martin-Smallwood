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

sendAjaxGet("http://localhost:8082/p1_Martin_Smallwood/GetAllEmp",display);

function display(xhr){
	employees = JSON.parse(xhr.responseText);
	console.log(employees);
	employeeArr = employees.employees;
	let table = document.getElementById("table");
	for(i in employeeArr){
		let newRow = document.createElement("tr");
		
		
		let empId = `${employeeArr[i].empId}`;
		let empName = `${employeeArr[i].empName}`;
		let isManager = `${employeeArr[i].manager}`;
		let managerId = `${employeeArr[i].managerId}`;
		
		let username = `${employeeArr[i].username}`;
		let email = `${employeeArr[i].email}`;
		newRow.innerHTML = `<td>${empId}</td>
		<td>${empName}</td>
		<td>${username}</td>
		<td>${email}</td>
		<td>${isManager}</td>
		<td>${managerId}</td>`;
		
		table.appendChild(newRow);
	}
}

function sortTable(n) {
	  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	  table = document.getElementById("table");
	  switching = true;
	  dir = "asc"; 
	  while (switching) {
	    switching = false;
	    rows = table.rows;
	    for (i = 1; i < (rows.length - 1); i++) {
	      shouldSwitch = false;
	      x = rows[i].getElementsByTagName("TD")[n];
	      y = rows[i + 1].getElementsByTagName("TD")[n];
	      if (dir == "asc") {
	        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
	          shouldSwitch = true;
	          break;
	        }
	      } else if (dir == "desc") {
	        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
	          shouldSwitch = true;
	          break;
	        }
	      }
	    }
	    if (shouldSwitch) {
	      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
	      switching = true;
	      switchcount ++; 
	    } else {
	      if (switchcount == 0 && dir == "asc") {
	        dir = "desc";
	        switching = true;
	      }
	    }
	  }
	}