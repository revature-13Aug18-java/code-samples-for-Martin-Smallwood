package com.revature.util;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class SingleReimHelper {

	public SingleReimHelper() {
	}

	public static Reimbursement process(HttpServletRequest request) {
		ReimbursementDaoImpl red = new ReimbursementDaoImpl();
		Reimbursement r;
		System.out.println(request.getParameter("reimId"));
		r = red.getReimbursementById(514);
		return r;
	}
}
