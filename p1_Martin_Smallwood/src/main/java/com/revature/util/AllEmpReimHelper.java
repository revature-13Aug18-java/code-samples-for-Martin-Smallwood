package com.revature.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class AllEmpReimHelper {

	public AllEmpReimHelper() {
	}
	public static List<Reimbursement> process(HttpServletRequest request){
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		return rdi.getReimbursementsWMgrName();
	}
}
