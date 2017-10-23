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
 * Servlet implementation class AdEditPController
 */
@WebServlet("/AdEditPController")
public class AdEditPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdEditPController() {
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
         
		//execution come from the aeditprofile jsp page..
		//get the field by name
		String cpass=request.getParameter("cpass");
		String npass2=request.getParameter("npass2");
	    //get the session means a id of a authenticate user
		HttpSession ss=request.getSession();
	    String userid=(String) ss.getAttribute("admin");
		LoginDao ld=new LoginDao();//object creation of logindao
		//by this object calling the method for change the password
		int y=ld.changePwd(cpass,npass2,userid);//method return the integer value...
	if(y!=0)//if password change condition true
	{
		//forward the execution to the aeditprofile jsp page with message or data
		RequestDispatcher rd=request.getRequestDispatcher("aEditProfile.jsp");
		request.setAttribute("msg","Password is Changed");
		rd.forward(request, response);
	}
	else//if password not change condition false
	{	//forward the execution to the aeditprofile jsp page with message or data
		RequestDispatcher rd=request.getRequestDispatcher("aEditProfile.jsp");
		request.setAttribute("msg","Current Password Doesn't match, Password is Not Changed");
		rd.forward(request, response);
		
	}
	}

}
