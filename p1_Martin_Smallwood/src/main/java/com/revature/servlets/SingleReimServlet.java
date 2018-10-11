package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;
import com.revature.util.SingleReimHelper;

/**
 * Servlet implementation class SingleReimServlet
 */
public class SingleReimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SingleReimServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Reimbursement reim = SingleReimHelper.process(request);
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		String reimbursementString = om.writeValueAsString(reim);
		reimbursementString = "{\"reimbursements\":"+reimbursementString+"}";
		pw.println(reimbursementString);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reimbursement reim = SingleReimHelper.process(request);
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		String reimbursementString = om.writeValueAsString(reim);
		reimbursementString = "{\"reimbursements\":"+reimbursementString+"}";
		pw.println(reimbursementString);
	}
}