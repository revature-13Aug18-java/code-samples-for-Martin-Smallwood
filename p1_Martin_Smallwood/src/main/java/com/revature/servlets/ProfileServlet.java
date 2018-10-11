package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.UpdateHelper;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("profile.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int modified = 0;
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if(request.getParameter("oldPsw").equals(session.getAttribute("psw").toString())
			&& request.getParameter("newPsw").equals(request.getParameter("newPswRep"))) {
			session.setAttribute("psw", request.getParameter("newPsw"));
			 modified = UpdateHelper.process(request);
			if(modified==1) {
				request.getRequestDispatcher("profile.html").forward(request, response);
				pw.println("Password Change Successful");
				
			}else {
				pw.println("Password Change Failed");
			}
		}
	}

}
