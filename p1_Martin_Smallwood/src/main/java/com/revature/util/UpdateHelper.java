package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.dao.REmployeeDaoImpl;

public class UpdateHelper {

	private UpdateHelper() {
	}
	public static int process(HttpServletRequest request) {
		HttpSession session = request.getSession();
		REmployeeDaoImpl redi = new REmployeeDaoImpl();
		return redi.updateEmailPassById
				(Integer.parseInt(session.getAttribute("userId").toString()),
						session.getAttribute("psw").toString(),
						session.getAttribute("email").toString());
		
	}
}
