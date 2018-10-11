package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.REmployee;
import com.revature.util.LoginHelper;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		REmployee re = LoginHelper.process(request);
		
		HttpSession session = request.getSession();
		
		if(re.getUsername()!=null) {
			session.setAttribute("userId", re.getEmpId());
			session.setAttribute("username",re.getUsername());
			session.setAttribute("isMan", re.isManager());
			session.setAttribute("email", re.getEmail());
			session.setAttribute("psw", re.getPass());
			System.out.println(session.getAttribute("isMan"));
			response.sendRedirect("Home");
		}else {
			response.sendRedirect("Login");
		}
	}
}
