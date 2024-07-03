package com.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddPlayerForm")

public class AddPlayerForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList<String> list=(ArrayList<String>) request.getAttribute("errors");
		
		out.println("<html>");
		out.println("<body>");
		if(list!=null) {
			Iterator<String> itr=list.iterator();
			out.println("<ul>");
			while(itr.hasNext()) {
			out.println("<li>"+itr.next()+"</li>");
		}
		out.println("</ul>");
		}
		out.println("<h2>Add Player Details </h2>");
		out.println("<form action='AddPlayerCont' method='post' enctype='multipart/form-data'>");
		out.println("Player name<input type='text' name='name'><br/><br/>");
		out.println("Age<input type='text' name='age'><br/><br/>");
		out.println("Profile<input type='file' name='profile'><br/><br/>");
		out.println("<input type='submit' name='Submit'>");
		out.println("</form></body></html>");
		//response.getWriter();//.append("Served at: ").append(request.getContextPath());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	

	}

}