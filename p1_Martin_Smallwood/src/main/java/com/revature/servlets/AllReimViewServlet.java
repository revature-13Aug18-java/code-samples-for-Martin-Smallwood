package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AllReimViewServlet
 */
public class AllReimViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AllReimViewServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("isMan").toString());
		if(session.getAttribute("isMan").toString().equals("true")) {
			request.getRequestDispatcher("allreimbursements.html").forward(request, response);
		}else{
			response.sendRedirect("/p1_Martin_Smallwood/Home");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
