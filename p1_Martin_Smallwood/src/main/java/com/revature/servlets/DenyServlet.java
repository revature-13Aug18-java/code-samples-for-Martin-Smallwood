package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class DenyServlet
 */
public class DenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Logger log = Logger.getRootLogger();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reimbursement r = new Reimbursement();
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		Date d = new Date(System.currentTimeMillis());
		r.setReimId(514);
		r.setDateManaged(d);
		r.setApproved(false);
		try(Connection con = ConnectionUtil.getConnection()){
		rdi.updateReimbursement(r, con);
		}catch(SQLException e) {
			log.error(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
