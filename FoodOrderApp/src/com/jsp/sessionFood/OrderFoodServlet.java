package com.jsp.sessionFood;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		super.doGet(req, resp);
		doPost(req, resp);
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		String order=request.getParameter("cart");
		List<String> foodCart = (List<String>)session.getAttribute("foodCart");
			
		String[] foods = request.getParameterValues("food");
		
		for (String food : foods) 
		{
			foodCart.add(food);
		
		}
		System.out.println(foodCart);
		session.setAttribute("foodCart",foodCart);
		pw.println("<h1>Welcome "+"<a href=  \"LogoutServlet\">Log-out</a></h1>");
		pw.println("<br><h1><a href=  \"ViewOrderServlet\">ViewOrder</a></h1>");
		
		
	}
public void test()
{
	System.out.println("tset");
}

	

}
