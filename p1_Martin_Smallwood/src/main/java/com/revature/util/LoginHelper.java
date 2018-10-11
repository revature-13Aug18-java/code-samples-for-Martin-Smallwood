package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.dao.REmployeeDao;
import com.revature.dao.REmployeeDaoImpl;
import com.revature.model.REmployee;

public class LoginHelper {
	
	static Logger log = Logger.getRootLogger();
	
	public static REmployee process(HttpServletRequest request) {
		
		REmployeeDaoImpl red = new REmployeeDaoImpl();
		REmployee re = new REmployee();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			re = red.getREmployeeByUserPass(request.getParameter("uname"), request.getParameter("psw"), con);
		}catch (SQLException|IOException e) {

			e.printStackTrace();
		}
		
		return re;
		
	}

}
