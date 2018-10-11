package com.revature.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.REmployeeDaoImpl;
import com.revature.model.REmployee;

public class AllEmployeesHelper {

	public static List<REmployee> process() {
			REmployeeDaoImpl edi = new REmployeeDaoImpl();
			return edi.getREmployees();
		}
	}