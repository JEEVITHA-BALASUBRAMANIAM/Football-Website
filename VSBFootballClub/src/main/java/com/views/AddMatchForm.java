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

/**
 * Servlet implementation class AddMatchForm
 */
@WebServlet("/AddMatchForm")
public class AddMatchForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMatchForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList<String> list=(ArrayList<String>)request.getAttribute("errors");
		out.println("<html>");
		out.println("<body>");
		if(list!=null)
		{
			Iterator<String> itr=list.iterator();
			out.println("<ul>");
			while(itr.hasNext()) {
				out.println("<li>"+itr.next()+"<li>");
			}
			out.println("</ul>");
		}
		
		out.println("<h2>AddMatchDetails</h2>");
		out.println("<form action= 'AddMatchCont ' method= 'post'>");
		out.println("title<input type='text' name='title'> <br> <br>");
		out.println("place<input type='text' name='place'><br><br>");
		out.println("MatchDate<input type='dt' name='date'>");
		out.println("<input type='submit' value='submit'>");
		out.println("</form> </body> </html>");
		
	}
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
