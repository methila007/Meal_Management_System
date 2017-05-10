package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import Entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Controller.UserController;


@WebServlet("/UserTable")
public class UserTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("UserInfo.jsp");
		ArrayList<User> users= new UserController().getAll();
		System.out.println(users);
		request.setAttribute("users", users); 
		dispatcher.forward(request, response);
		
		
	
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
