package customercontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customerdao.CLoginDao;
import dao.ProductDao;

/**
 * Servlet implementation class CustLoginController
 */
@WebServlet("/CustLoginController")
public class CustLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustLoginController() {
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
	//execution come from customer login jsp page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the field by name from custlogin jsp page 
		String u=request.getParameter("uid");
		String p=request.getParameter("pwd");
		//object creatrion of clogindao class
		CLoginDao ld=new CLoginDao();
		//by this object calling the method which check the customer
		   int y=ld.check(u,p);//return the integer value if customer found in database
		   if(y==1)//condition true if customer found
		   {    
                //get session to set the user cart
			    HttpSession ss=request.getSession();
		        ss.setAttribute("user",u);
//object creation of productdao class
		 		ProductDao ed=new ProductDao();
	//by this object calling the method which set the ipaddress as email
		 		int p1=ed.updateCart(u);//return the integer value
		        response.sendRedirect("Customer.jsp");//send to the customer jsp
		   }
		   else
		   {
			   //forward the execution to custlogin jsp page with message contain login info
		RequestDispatcher rd=request.getRequestDispatcher("custLogin.jsp");
		request.setAttribute("msg1","login Fail,Try again");
		rd.forward(request, response);
		
	}

}
}
