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

import Entity.Meal;
import Model.MealRepository;

/**
 * Servlet implementation class UserDetailsServlet
 */
@WebServlet("/UserDetails")
public class UserDetailsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("UserDetails.jsp");
		
HttpSession session= request.getSession(false);
		
		
		int userId= (int)session.getAttribute("userId");


		
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
}