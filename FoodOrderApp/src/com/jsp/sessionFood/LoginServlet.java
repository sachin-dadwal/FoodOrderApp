package com.jsp.sessionFood;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,String> users=new HashMap<String,String>();
	{
		users.put("sachin","sachin123");
		users.put("nandeesh","dinga");
		users.put("yahin","yahin");
		users.put("test","test");
	}
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		List<String> foodCart=new ArrayList<String>();
		PrintWriter pw=response.getWriter();
		HttpSession session=null;
		
		System.out.println("i am in service...");
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		if(users.containsKey(uname))
		{
			if(users.get(uname).equals(password))
			{
				session=request.getSession(true);
				
				session.setAttribute("username", uname);
				session.setAttribute("foodCart",foodCart);
				//session.setMaxInactiveInterval(60);
				
				//System.out.println(uname+"=\t"+session.getId());
				pw.println("<h1>Welcome"+"\t"+uname+"<a href=  \"LogoutServlet\">Log-out</a></h1>");
				pw.println("<br><h1><a href=  \"ViewOrderServlet\">ViewOrder</a></h1>");
				
				
				request.getRequestDispatcher("home1.html").include(request, response);
				
			}
		}
		else
		{
			pw.println("<h3><font color='red'>Invlid credentials</font></h3>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
	}

}
