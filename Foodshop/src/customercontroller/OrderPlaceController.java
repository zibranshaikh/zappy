package customercontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customerbean.Customer;
import customerdao.CustomerDao;
import customerdao.OrderDao;

/**
 * Servlet implementation class OrderPlaceController
 */
@WebServlet("/OrderPlaceController")
public class OrderPlaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPlaceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //execution come from show cart jsp page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get the session or authenticate user to go to orders
		HttpSession ss=request.getSession();
		String y=(String)ss.getAttribute("user");
		//if not logged in then block execute condition true
		if(y==null)
		{
			//forward to the customer login page with message
			RequestDispatcher rd=request.getRequestDispatcher("custLogin.jsp");
			request.setAttribute("msg2","Not Login, Login First");
			rd.forward(request, response);
		
		}
	else //condition false if logged in
		{
		 //object creation of customerdao class
		CustomerDao ed=new CustomerDao();
		//object creation of customer class
	    Customer c=new Customer();
	    //assign the user to email
	    String email=y;
	    //by customerdao object calling the method which view the customer detail in orderjsp page
	    c=ed.viewCust(email);//return the object of customer
	    //forward the execution to the order place jsp page with particular customer detail which is logged in 
	    RequestDispatcher rd=request.getRequestDispatcher("orderPlace.jsp");
	    request.setAttribute("c", c);
	    rd.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
