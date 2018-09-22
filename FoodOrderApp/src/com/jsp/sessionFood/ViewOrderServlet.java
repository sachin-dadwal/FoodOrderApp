package com.jsp.sessionFood;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewOrderServlet
 */
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			System.out.println("id="+session.getId());
			
			List<String> foodCart=(List<String>)session.getAttribute("foodCart");
			/*for(String s:arr)
			{
				System.out.println(s);
			}*/
			if(foodCart.size() ==  0)
			{
				response.getWriter().append("you dont have anything in here");
				System.out.println("***********");
				//pw.println("please order something first");
				//request.getRequestDispatcher("ViewOrderServlet");
			}
			
		else
		{ 
			pw.println("<center>");
			pw.println("Welcome to hilton hotel");
			pw.println("<h1>Welcome "+"<a href=  \"LogoutServlet\">Log-out</a></h1>");
			pw.println("<br><br>");
			pw.println("<h1><font color='red'>Your ordered food is </h1><br><br></font>");
		
			
			
			for(String food:foodCart)
			{
				
				//pw.println("<h1>Welcome "+"<a href=  \"LogoutServlet\">Log-out</a></h1>");
			
				pw.println("<h1>"+food +"</h1>");
			}
				pw.println("</center>");
				request.getRequestDispatcher("home1.html").include(request, response);
			
			
			
		}
		}
	}

		
	
		
	}

	


