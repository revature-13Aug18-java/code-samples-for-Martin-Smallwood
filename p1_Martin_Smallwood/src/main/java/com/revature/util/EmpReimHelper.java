package com.revature.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class EmpReimHelper {

	public EmpReimHelper() {
	}
	public static List<Reimbursement> process(HttpServletRequest request){
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		HttpSession session = request.getSession();
		return rdi.getReimbursementsByEmpId(Integer.parseInt(session.getAttribute("userId").toString()));
	}
}
