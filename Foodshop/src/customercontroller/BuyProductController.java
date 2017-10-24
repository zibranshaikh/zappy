package customercontroller;
import customerdao.OrderDao;
import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class BuyProductController
 */
@WebServlet("/BuyProductController")
public class BuyProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyProductController() {
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
	//execution come from buy product controller
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the session or userid for checking the logging while buy the product 
		HttpSession ss=request.getSession();
		 String y=(String)ss.getAttribute("user");
		 //if user not logged in then it redirect to login page by this code
		if(y==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("custLogin.jsp");
			request.setAttribute("msg2","Not Login, Login First");
			rd.forward(request, response);
		}
	else //condition false if user logged in then go to placeorder
		{
		     String email=y;//set the email as userid
		     //object creation of order dao class
		     OrderDao od=new OrderDao();
		     //by this object we call the method to buy the product
		     String ipadd=y;
	//get the field by name
		     String pin=request.getParameter("pin");
		     String pmode=request.getParameter("pmode");
	//calling the method for buy the product which insert into order table
		     int p=od.buyProduct(email,ipadd,pin,pmode);//return the integer value
	 	     System.out.println("p in buy="+p);
	 	     if(p!=0)//if order table inserted condition true
	 	     {
	 	    	 //forward the execution to the customer jsp page with successful message
		  RequestDispatcher rd=request.getRequestDispatcher("Customer.jsp");
	 	  request.setAttribute("msg", "order successfully placed");
	 	  rd.forward(request, response);
	 	     }

	}
		}

}
