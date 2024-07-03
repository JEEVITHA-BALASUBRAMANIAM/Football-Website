package com.cont;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Match;
import com.model.MatchDao;

@WebServlet("/AddMatchCont")
public class AddMatchCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title=request.getParameter("title").trim();
		String place=request.getParameter("place").trim();
		String dt=request.getParameter("date").trim();
		ArrayList<String> list=new ArrayList<String>();
		if(title.length()==0) {
			list.add("Enter title field!!!");
		}
		if(place.length()==0) {
			list.add("Enter the place!!!");
		}
		if(dt.length()==0) {
			list.add("Enter date!!!");
		}
		
		if(!list.isEmpty()) {
			request.setAttribute("errors", list);
			RequestDispatcher rd=request.getRequestDispatcher("AddMatchForm");
			rd.forward(request, response);
			return;
		}
		Match m=new Match(title,place,dt);
		MatchDao md=new MatchDao();
		md.storeData(m);
		request.setAttribute("tl", title);
		RequestDispatcher rd1=request.getRequestDispatcher("Success.html");
		rd1.forward(request, response);


	}

}