package com.cont;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MatchDao;
import com.model.User;

/**
 * Servlet implementation class RegisterCont
 */
@WebServlet("/RegisterCont")
public class RegisterCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCont() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost1(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String name=request.getParameter("name").trim();
			String a=request.getParameter("age").trim();
			int age=Integer.parseInt(a);
			String gender=request.getParameter("gender").trim();
			String address=request.getParameter("address").trim();
			ArrayList<String> list=new ArrayList<String>();
			if(name.length()==0) {
				list.add("Enter name field!!!");
			}
			if(age<0) {
				list.add("Enter the age!!!");
			}
			if(gender==null) {
				list.add("Enter gender!!!");
			}
			
			if(address.length()==0) {
				list.add("Enter address!!!");
			}
			
			if(!list.isEmpty()) {
				request.setAttribute("errors", list);
				RequestDispatcher rd=request.getRequestDispatcher("RegisterForm.jsp");
				rd.forward(request, response);
				return;
			}
			
			User u=new User(name,age,gender,address);
			request.setAttribute("data", u);

			HttpSession session =request.getSession();
			session.setAttribute("data", u);
		
			Cookie ck=new Cookie("myck", name);
			response.addCookie(ck);
			RequestDispatcher rd1=request.getRequestDispatcher("/Success.jsp");
			rd1.forward(request, response);
		}

	}










