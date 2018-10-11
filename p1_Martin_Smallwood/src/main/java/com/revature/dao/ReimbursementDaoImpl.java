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

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	private static Logger log = Logger.getRootLogger();
	private static String reimId = "REIM_ID";
	private static String empId = "EMP_ID";
	private static String reason = "REASON";
	private static String dateMade = "DATEMADE";
	private static String dateMan = "DATEMANAGED";
	private static String appr = "APPROVED";
	private static String amt = "AMOUNT";
	private static String manId = "MAN_ID";
	private static String manName = "MGR_NAME";
	@Override
	public List<Reimbursement> getReimbursements(Connection con) {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		log.info("hi from getreimbursements");
		String sql = "SELECT * FROM REIMBURSEMENT";
		
		try (Statement s = con.createStatement();
			 ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setEmpId(rs.getInt(empId));
				r.setReimId(rs.getInt(reimId));
				r.setReason(rs.getString(reason));
				r.setDateMade(rs.getDate(dateMade));
				r.setDateManaged(rs.getDate(dateMan));
				r.setAmount(rs.getFloat(amt));
				if(rs.getInt(appr)>0) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setManagerId(rs.getInt(manId));
				log.info(r.toString());
				reimbursementList.add(r);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return reimbursementList;
	}
	public List<Reimbursement> getReimbursementsWMgrName(){
		List<Reimbursement> reimbursementList = new ArrayList<>();
		
		String sql = "select E.EMP_NAME, R.REIM_ID, R.REASON, R.DATEMADE, R.DATEMANAGED, R.APPROVED, M.EMP_NAME AS MGR_NAME, R.AMOUNT from REIMBURSEMENT R, REMPLOYEE E, REMPLOYEE M WHERE E.EMP_ID = R.EMP_ID AND R.MAN_ID = M.EMP_ID";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setEmpName(rs.getString("EMP_NAME"));
				r.setReimId(rs.getInt(reimId));
				r.setReason(rs.getString(reason));
				r.setDateMade(rs.getDate(dateMade));
				r.setDateManaged(rs.getDate(dateMan));
				r.setAmount(rs.getFloat(amt));
				if(rs.getInt(appr)>0) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setMgrName(rs.getString(manName));
				reimbursementList.add(r);
			}
		}catch(SQLException|IOException e) {
			log.error(e);
		}
		return reimbursementList;
	}
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		
		String sql = "SELECT * FROM REIMBURSEMENT";
		
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
			 ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setEmpId(rs.getInt(empId));
				r.setReimId(rs.getInt(reimId));
				r.setReason(rs.getString(reason));
				r.setDateMade(rs.getDate(dateMade));
				r.setDateManaged(rs.getDate(dateMan));
				r.setAmount(rs.getFloat(amt));
				if(rs.getInt(appr)>0) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setManagerId(rs.getInt(manId));
				
				reimbursementList.add(r);
			}
		} catch (SQLException|IOException e) {
			log.error(e.getMessage());
		}
		return reimbursementList;
	}

	@Override
	public Reimbursement getReimbursementById(int id, Connection con) {
//	String sql = "SELECT * FROM REIMBURSEMENT WHERE "+reimId+"=?";
	String sql = "SELECT REIM_ID ,E.EMP_NAME,REASON ,DATEMADE ,DATEMANAGED ,APPROVED ,M.EMP_NAME AS MANAGER,AMOUNT  FROM REIMBURSEMENT R, REMPLOYEE M,REMPLOYEE E WHERE REIM_ID=? AND MAN_ID = M.EMP_ID AND R.EMP_ID = E.EMP_ID";
			
	Reimbursement r = new Reimbursement();
	ResultSet rs=null;
		try (PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				r = new Reimbursement();
				r.setEmpId(rs.getInt(empId));
				r.setReimId(rs.getInt(reimId));
				r.setReason(rs.getString(reason));
				r.setDateMade(rs.getDate(dateMade));
				r.setDateManaged(rs.getDate(dateMan));
				r.setAmount(rs.getFloat(amt));
				if(rs.getInt(appr)>0) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setManagerId(rs.getInt(manId));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error(e);;
				}
			}
		}
		return r;
	}
	
	public Reimbursement getReimbursementById(int id) {
		String sql = "SELECT * FROM REIMBURSEMENT WHERE "+reimId+"=?";
		Reimbursement r = new Reimbursement();
		ResultSet rs=null;
			try (Connection con = ConnectionUtil.getConnection();
					PreparedStatement ps = con.prepareStatement(sql);){
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					r = new Reimbursement();
					r.setEmpId(rs.getInt(empId));
					r.setReimId(rs.getInt(reimId));
					r.setReason(rs.getString(reason));
					r.setDateMade(rs.getDate(dateMade));
					r.setDateManaged(rs.getDate(dateMan));
					r.setAmount(rs.getFloat(amt));
					if(rs.getInt(appr)>0) {
						r.setApproved(true);
					}else {
						r.setApproved(false);
					}
					r.setManagerId(rs.getInt(manId));
				}
			} catch (SQLException|IOException e) {
				log.error(e.getMessage());
			}finally {
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						log.error(e);;
					}
				}
			}
			return r;
		}
	
	public List<Reimbursement> getReimbursementsByEmpId(int id) {
		String sql = "SELECT * FROM REIMBURSEMENT WHERE "+empId+"=?";
		List<Reimbursement> reimbursementList = new ArrayList<>();
		ResultSet rs=null;
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement s = con.prepareStatement(sql);
			 ){
			
			s.setInt(1, id);
			rs = s.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setEmpId(rs.getInt(empId));
				r.setReimId(rs.getInt(reimId));
				r.setReason(rs.getString(reason));
				r.setDateMade(rs.getDate(dateMade));
				r.setDateManaged(rs.getDate(dateMan));
				r.setAmount(rs.getFloat(amt));
				if(rs.getInt(appr)>0) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setManagerId(rs.getInt(manId));
				
				reimbursementList.add(r);
			}
		} catch (SQLException|IOException e) {
			log.error(e.getMessage());
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
		return reimbursementList;
		}

	@Override
	public int createReimbursement(Reimbursement reimbursement, Connection con) {
		String sql = "INSERT INTO REIMBURSEMENT("+empId+","+reason+","+dateMade+","+dateMan+","+appr+","+manId+") VALUES (?,?,?,?,?,?)";
		int reimsCreated = 0;
		try (PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setInt(1, reimbursement.getEmpId());
			ps.setString(2, reimbursement.getReason());
			ps.setDate(3, reimbursement.getDateMade());
			ps.setDate(4, reimbursement.getDateManaged());
			if(reimbursement.isApproved()) {
			ps.setInt(5, 1);
			}else {
				ps.setInt(5, 0);
			}
			ps.setInt(6, reimbursement.getManagerId());
			reimsCreated = ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		}
		return reimsCreated;
	}
	
	public int createReimbursement(Reimbursement reimbursement) {
		String sql = "INSERT INTO REIMBURSEMENT("+empId+","+reason+","+dateMade+","+dateMan+","+appr+","+amt+") VALUES (?,?,?,?,?,?)";
		int reimsCreated = 0;
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setInt(1, reimbursement.getEmpId());
			ps.setString(2, reimbursement.getReason());
			ps.setDate(3, reimbursement.getDateMade());
			ps.setDate(4, reimbursement.getDateManaged());
			if(reimbursement.isApproved()) {
			ps.setInt(5, 1);
			}else {
				ps.setInt(5, 0);
			}
			ps.setFloat(6, reimbursement.getAmount());
			reimsCreated = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			log.error(e);
		}
		return reimsCreated;
	}

	@Override
	public int updateReimbursement(Reimbursement reimbursement, Connection con) {
		int reimsUpdated = 0;
		
		String sql = "UPDATE REIMBURSEMENT"
				+ " SET "+dateMan+" = ?,"
				+ appr+" = ?"
				+ " WHERE "+reimId+" = ?";
		
		try (PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setDate(1, reimbursement.getDateManaged());
			if(reimbursement.isApproved()) {
				ps.setInt(2, 1);
				}else {
					ps.setInt(2, 0);
				}
			ps.setInt(3, reimbursement.getReimId());
			reimsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return reimsUpdated;
	}

	@Override
	public int deleteReimbursement(int id, Connection con) {
		int rowsDeleted = 0;
		
		String sql = "DELETE FROM REIMBURSEMENTS WHERE "+reimId+" = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return rowsDeleted;
	}



}
