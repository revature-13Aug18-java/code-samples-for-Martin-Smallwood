package com.revature.model;

import java.sql.Date;

public class Reimbursement {
	int reimId;
	int empId;
	String reason;
	Date dateMade;
	Date dateManaged;
	boolean approved;
	int managerId;
	float amount;
	String mgrName;
	String empName;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getMgrName() {
		return mgrName;
	}
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getAmount() {
		return amount;
	}
	public int getReimId() {
		return reimId;
	}
	public void setReimId(int reimId) {
		this.reimId = reimId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDateMade() {
		return dateMade;
	}
	public void setDateMade(Date dateMade) {
		this.dateMade = dateMade;
	}
	public Date getDateManaged() {
		return dateManaged;
	}
	public void setDateManaged(Date dateManaged) {
		this.dateManaged = dateManaged;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + ((dateMade == null) ? 0 : dateMade.hashCode());
		result = prime * result + ((dateManaged == null) ? 0 : dateManaged.hashCode());
		result = prime * result + empId;
		result = prime * result + managerId;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reimId;
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
		Reimbursement other = (Reimbursement) obj;
		if (approved != other.approved)
			return false;
		if (dateMade == null) {
			if (other.dateMade != null)
				return false;
		} else if (!dateMade.equals(other.dateMade))
			return false;
		if (dateManaged == null) {
			if (other.dateManaged != null)
				return false;
		} else if (!dateManaged.equals(other.dateManaged))
			return false;
		if (empId != other.empId)
			return false;
		if (managerId != other.managerId)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reimId != other.reimId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", empId=" + empId + ", reason=" + reason + ", dateMade=" + dateMade
				+ ", dateManaged=" + dateManaged + ", approved=" + approved + ", managerId=" + managerId + "]";
	}
	public Reimbursement(int reimId, int empId, String reason, Date dateMade, Date dateManaged, boolean approved,
			int managerId) {
		super();
		this.reimId = reimId;
		this.empId = empId;
		this.reason = reason;
		this.dateMade = dateMade;
		this.dateManaged = dateManaged;
		this.approved = approved;
		this.managerId = managerId;
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
