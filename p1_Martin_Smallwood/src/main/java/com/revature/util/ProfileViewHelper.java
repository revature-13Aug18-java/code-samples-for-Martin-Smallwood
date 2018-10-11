package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.dao.REmployeeDaoImpl;
import com.revature.model.REmployee;

public class ProfileViewHelper {

	private ProfileViewHelper() {
	
	}
	public static REmployee process(HttpServletRequest request) {
		REmployeeDaoImpl red = new REmployeeDaoImpl();
		REmployee re = new REmployee();
		HttpSession session = request.getSession(false);
		try {
			Connection con = ConnectionUtil.getConnection();
			re = red.getREmployeeById(Integer.parseInt(session.getAttribute("userId").toString()),con);
		}catch (SQLException|IOException e) {
			e.printStackTrace();
		}
		return re;
	}

}
