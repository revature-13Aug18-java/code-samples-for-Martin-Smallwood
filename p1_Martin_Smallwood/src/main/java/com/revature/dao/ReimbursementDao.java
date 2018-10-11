package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementDao {
	public List<Reimbursement> getReimbursements(Connection con);
	public Reimbursement getReimbursementById(int id, Connection con);
	public int createReimbursement(Reimbursement reimbursement, Connection con);
	public int updateReimbursement(Reimbursement reimbursement, Connection con);
	public int deleteReimbursement(int id, Connection con);
}
