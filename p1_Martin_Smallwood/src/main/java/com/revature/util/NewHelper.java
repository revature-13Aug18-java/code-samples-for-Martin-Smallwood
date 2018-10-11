package com.revature.util;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class NewHelper {
	private NewHelper() {
		
	}
	public static int process(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Reimbursement r = new Reimbursement();
		Date d = new Date(System.currentTimeMillis());
		ReimbursementDaoImpl redi = new ReimbursementDaoImpl();
		r.setAmount(Float.parseFloat(request.getParameter("amount")));
		r.setReason(request.getParameter("reason"));
		r.setDateMade(d);
		r.setEmpId(Integer.parseInt(session.getAttribute("userId").toString()));
		r.setApproved(false);
		r.setDateManaged(null);
		
		return redi.createReimbursement(r);
	}

}
