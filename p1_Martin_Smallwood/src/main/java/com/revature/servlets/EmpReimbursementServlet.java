package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;
import com.revature.util.EmpReimHelper;


public class EmpReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpReimbursementServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Reimbursement> reimbursements = EmpReimHelper.process(request);
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		String reimbursementString = om.writeValueAsString(reimbursements);
		reimbursementString = "{\"reimbursements\":"+reimbursementString+"}";
		pw.println(reimbursementString);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
