package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Meal;
import Model.MealRepository;

/**
 * Servlet implementation class MealEditServlet
 */
@WebServlet("/MealEdit")
public class MealEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("MealEdit.jsp");
		int mealId=Integer.parseInt( request.getParameter("mealId"));
		
		Meal meal= new Meal();
		meal= new MealRepository().getById(mealId);
		request.setAttribute("meal", meal);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mealId= Integer.parseInt( request.getParameter("mealId"));
		int mealCount = Integer.parseInt(request.getParameter("mealCount"));
		float groceryPrice= Float.parseFloat(request.getParameter("groceryPrice"));
		String groceryItem= request.getParameter("groceryItem");
		
		System.out.println(mealCount+ " " + mealId);
		
		Meal meal= new Meal(mealId, groceryPrice, mealCount, groceryItem);
		
		new MealRepository().edit(meal);
		response.sendRedirect("MonthlyDetails");
	}

}
