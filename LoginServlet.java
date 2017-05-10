package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.User;
import Model.UserRepository;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("LoginRegister.jsp");
		dispatcher.forward(request, response);
				
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean userase= new UserRepository().getLoginAccess(userName, password);
		if(userase){
			User user= new UserRepository().getByName(userName);
			HttpSession session= request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getUserName());
			if(user.getType().equals("ADMIN")){
				response.sendRedirect("AdminDashboard");
			}
			else{
			response.sendRedirect("UserHome");
			}
		}
	}

}
