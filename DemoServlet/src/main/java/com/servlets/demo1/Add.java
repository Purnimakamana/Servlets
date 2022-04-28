package com.servlets.demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

public class Add extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("fnum"));
		int num2 = Integer.parseInt(request.getParameter("snum"));
		int sum = num1+num2;
		
		PrintWriter out = response.getWriter();
		out.print("The Sum is:"+sum);
		
	}

}
