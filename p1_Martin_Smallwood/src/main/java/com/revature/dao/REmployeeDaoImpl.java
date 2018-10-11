package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.REmployee;
import com.revature.util.ConnectionUtil;

public class REmployeeDaoImpl implements REmployeeDao {
	private static Logger log = Logger.getRootLogger();
	private static String empId = "EMP_ID";
	private static String pass = "PASS";
	private static String email = "EMAIL";
	private static String name = "EMP_NAME";
	private static String isMan = "IS_MANAGER";
	private static String manId = "MANAGER_ID";
	private static String username = "USERNAME";
	public REmployeeDaoImpl() {
		super();
	}

	public List<REmployee> getREmployees(Connection con) {
		List<REmployee> rEmployeeList = new ArrayList<>();
		
		String sql = "SELECT * FROM REMPLOYEE";
		
		try (Statement s = con.createStatement();
			 ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				REmployee re = new REmployee();
				re.setEmpId(rs.getInt(empId));
				re.setEmail(rs.getString(email));
				re.setEmpName(rs.getString(name));
				if(rs.getInt(isMan)>0) {
					re.setManager(true);
				}else {
					re.setManager(false);
				}
				re.setPass(rs.getString(pass));
				re.setManagerId(rs.getInt(manId));
				re.setUsername(rs.getString(username));
				
				rEmployeeList.add(re);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return rEmployeeList;
	}

	public List<REmployee> getREmployees() {
		List<REmployee> rEmployeeList = new ArrayList<>();
		
		String sql = "SELECT * FROM REMPLOYEE";
		
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
			 ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				REmployee re = new REmployee();
				re.setEmpId(rs.getInt(empId));
				re.setEmail(rs.getString(email));
				re.setEmpName(rs.getString(name));
				if(rs.getInt(isMan)>0) {
					re.setManager(true);
				}else {
					re.setManager(false);
				}
				re.setPass(rs.getString(pass));
				re.setManagerId(rs.getInt(manId));
				re.setUsername(rs.getString(username));
				
				rEmployeeList.add(re);
			}
		} catch (SQLException | IOException e) {
			log.error(e.getMessage());
		}
		return rEmployeeList;
	}
	public REmployee getREmployeeById(int id, Connection con) {
		String sql = "SELECT * FROM REMPLOYEE WHERE EMP_ID = ?";
		REmployee re = new REmployee();
		ResultSet rs = null;
		try (PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				re.setEmpId(rs.getInt(empId));
				re.setEmail(rs.getString(email));
				re.setEmpName(rs.getString(name));
				if(rs.getInt(isMan)>0) {
					re.setManager(true);
				}else {
					re.setManager(false);
				}
				re.setPass(rs.getString(pass));
				re.setManagerId(rs.getInt(manId));
				re.setUsername(rs.getString(username));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return re;
	}
	public REmployee getREmployeeById(int id) {
		String sql = "SELECT * FROM REMPLOYEE WHERE EMP_ID = ?";
		REmployee re = new REmployee();
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				re.setEmpId(rs.getInt(empId));
				re.setEmail(rs.getString(email));
				re.setEmpName(rs.getString(name));
				if(rs.getInt(isMan)>0) {
					re.setManager(true);
				}else {
					re.setManager(false);
				}
				re.setPass(rs.getString(pass));
				re.setManagerId(rs.getInt(manId));
				re.setUsername(rs.getString(username));
			}
		} catch (SQLException|IOException e) {
			log.error(e);
		}
		return re;
	}
	
	public REmployee getREmployeeByUserPass(String uname, String psw, Connection con) {
		String sql = "SELECT * FROM REMPLOYEE WHERE USERNAME = ? AND PASS = ?";
		REmployee re = new REmployee();
		ResultSet rs = null;
		try (PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, uname);
			ps.setString(2, psw);
			rs = ps.executeQuery();
			while(rs.next()) {
				re.setEmpId(rs.getInt(empId));
				re.setEmail(rs.getString(email));
				re.setEmpName(rs.getString(name));
				if(rs.getInt(isMan)==1) {
					re.setManager(true);
				}else {
					re.setManager(false);
				}
				re.setPass(rs.getString(pass));
				re.setManagerId(rs.getInt(manId));
				re.setUsername(rs.getString(username));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error(e);
				}
			}
		}
		return re;
	}

	public int createREmployee(REmployee rEmployee, Connection con) {
		String sql = "INSERT INTO REMPLOYEE("+name+","+username+","+pass+","+manId+","+isMan+","+email+") VALUES (?,?,?,?,?,?)";
		int rEmpsCreated = 0;
		try (PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1, rEmployee.getEmpName());
			ps.setString(2, rEmployee.getUsername());
			ps.setString(3, rEmployee.getPass());
			ps.setInt(4, rEmployee.getManagerId());
			if(rEmployee.isManager()) {
			ps.setInt(5, 1);
			}else {
				ps.setInt(5, 0);
			}
			ps.setString(6, rEmployee.getEmail());
			rEmpsCreated = ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		}
		return rEmpsCreated;
	}

	public int updateREmployee(REmployee rEmployee, Connection con) {
		int rEmployeesUpdated = 0;
		
		String sql = "UPDATE REMPLOYEE"
				+ " SET " + email + " = ?,"
				+ pass + " = ?"
				+ " WHERE "+empId+" = ?";
		
		try (PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, rEmployee.getEmail());
			ps.setString(2, rEmployee.getPass());
			ps.setInt(3, rEmployee.getEmpId());
			rEmployeesUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return rEmployeesUpdated;
	}
	
	public int updateEmailPassById(int userId, String psw, String email) {
		int updated =0;
		
		String sql = "UPDATE REMPLOYEE SET " + this.email +" = ?," + this.pass + " = ?"+
		"WHERE "+empId+" = ?";
		
//		UPDATE REMPLOYEE 
//		SET EMAIL = ?,
//		PASS = ?
//		WHERE EMP_ID = ?;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1,email);
			ps.setString(2,psw);
			ps.setInt(3, userId);
			updated = ps.executeUpdate();
			
//			UPDATE REMPLOYEE 
//			SET EMAIL = "examplo@gmail.com",
//			PASS = "ex4mpl3"
//			WHERE EMP_ID = 3;
			
		} catch (SQLException|IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return updated;
	}

	public int deleteREmployeeById(int id, Connection con) {
		int rowsDeleted = 0;
		
		String sql = "DELETE FROM REMPLOYEE WHERE "+empId+" = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return rowsDeleted;
	}
}
