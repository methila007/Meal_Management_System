package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jmx.mbeanserver.Repository;

import Entity.Meal;
import Entity.User;
import Model.MealRepository;
import Model.UserRepository;


@WebServlet("/AdminDashboard")
public class AdminDashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("Admin.jsp");
		ArrayList<User> userinfo= new ArrayList<User>();
		userinfo.addAll(new UserRepository().getAdminTable());
		
		
	ArrayList<Meal> allmeals= new MealRepository().getAll();

		int alltotalmealcount=0;
		float alltotalgorceryspent=0;
		for(Meal alml: allmeals){
			alltotalmealcount+=alml.getMealCount();
			alltotalgorceryspent+=alml.getGroceryPrice();
	
		}
		float avgmeal =(float)alltotalgorceryspent/alltotalmealcount;
	
		
		
		request.setAttribute("avgmeal", avgmeal);
		request.setAttribute("alltotalmealcount", alltotalmealcount); 
		request.setAttribute("alltotalgorceryspent", alltotalgorceryspent); 
		
		
		System.out.println(userinfo);
		request.setAttribute("userinfo", userinfo);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
