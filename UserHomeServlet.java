package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.UserController;
import Entity.Meal;
import Entity.User;
import Model.MealRepository;
import Model.UserRepository;


@WebServlet("/UserHome")
public class UserHomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("UserHome.jsp");
		HttpSession session= request.getSession(false);
		
		
		int userId= (int)session.getAttribute("userId");  
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		System.out.println(date);

		
		ArrayList<Meal> meals= new MealRepository().getByUserId(userId);
		
		ArrayList<Meal> allmeals= new MealRepository().getAll();
		
		int totalmealcount=0;
		float totalgorceryspent=0;
		for(Meal mealc: meals){
			totalmealcount+=mealc.getMealCount();
			totalgorceryspent+=mealc.getGroceryPrice();
		}
		
		int alltotalmealcount=0;
		float alltotalgorceryspent=0;
		for(Meal alml: allmeals){
			alltotalmealcount+=alml.getMealCount();
			alltotalgorceryspent+=alml.getGroceryPrice();
	
		}
		float avgmeal =(float)alltotalgorceryspent/alltotalmealcount;
		float probablemeal=((avgmeal*totalmealcount)-totalgorceryspent );
		
		
		System.out.println(totalgorceryspent);
		System.out.println(meals);
		request.setAttribute("probablemeal", probablemeal);
		request.setAttribute("avgmeal", avgmeal);
		request.setAttribute("totalmealcount", totalmealcount); 
		request.setAttribute("totalgorceryspent", totalgorceryspent); 
		request.setAttribute("meals", meals); 
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session= request.getSession(false);
		
		
		int userId= (int)session.getAttribute("userId");
		
		int mealCount=Integer.parseInt(request.getParameter("meal"));
		int groceryPrice=Integer.parseInt(request.getParameter("shopping"));
		String groceryItem= request.getParameter("grocery");
		
		java.sql.Date entryDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Meal meal=new Meal(userId, entryDate, groceryPrice, mealCount, groceryItem);
		
		boolean isValid=true;
		
		
		new MealRepository().add(meal);
		System.out.println("succfull");
		response.sendRedirect("UserHome");
		
		
		
	}

}
