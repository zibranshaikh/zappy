package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLoginController")
public class CheckLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//execution come there from adminlogin.jsp
		String u=request.getParameter("uid");//get the field input by name
		String p=request.getParameter("pwd");//get the field input by name
		 
		   LoginDao ld=new LoginDao();//Object creation of login dao of admin
		   //execution go to LoginDao
		   int y=ld.check(u,p);//Method return the integer 
		   if(y==1)//condition true then go inside if block
		   {
			   
			   HttpSession ss=request.getSession();//
				 ss.setAttribute("admin", u);//set the admin userid as a authenticate user
			   response.sendRedirect("Admin.jsp");//send the execution to admin .jsp
		   }
		   else
		   { //if condition false then execute
		RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");//go to admin login with data failed message of login
		request.setAttribute("msg","login Fail,Try again");
		rd.forward(request, response);
			   //response.sendRedirect("index.jsp");
		   }
		
		
	}

}
