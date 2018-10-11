package com.revature.model;

public class REmployee {
	int empId;
	String empName;
	String username;
	String pass;
	int managerId;
	boolean isManager;
	String email;
	String manName;
	
	public String getManName() {
		return manName;
	}
	public void setManName(String manName) {
		this.manName = manName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + (isManager ? 1231 : 1237);
		result = prime * result + managerId;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		REmployee other = (REmployee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (isManager != other.isManager)
			return false;
		if (managerId != other.managerId)
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "REmployee [empId=" + empId + ", empName=" + empName + ", username=" + username + ", pass=" + pass
				+ ", managerId=" + managerId + ", isManager=" + isManager + ", email=" + email + "]";
	}
	public REmployee(int empId, String empName, String username, String pass, int managerId, boolean isManager,
			String email) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.username = username;
		this.pass = pass;
		this.managerId = managerId;
		this.isManager = isManager;
		this.email = email;
	}
	public REmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
