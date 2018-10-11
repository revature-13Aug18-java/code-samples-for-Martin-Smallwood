package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.model.REmployee;

public interface REmployeeDao {
	public List<REmployee> getREmployees(Connection con);
	public REmployee getREmployeeById(int id, Connection con);
	public int createREmployee(REmployee rEmployee, Connection con);
	public int updateREmployee(REmployee rEmployee, Connection con);
	public int deleteREmployeeById(int id, Connection con);
}
