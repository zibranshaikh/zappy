package customercontroller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;

/**
 * Servlet implementation class RemoveBookController
 */
@WebServlet("/RemoveProductController")
public class RemoveProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductController() {
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
	//execution come from showcart jsp page..
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //get the field by name
		String cid=request.getParameter("cid");
		System.out.println("cid in remove product controller = "+cid);
	    //it may contain some spaces so we trimmed it        
		cid=cid.trim();
		//convert it into integer
       int cid1=Integer.parseInt(cid);       
		//object creation of productdao class
       ProductDao ed=new ProductDao();
	     int y=0;
	     //get the unique ipaddress of system
	        InetAddress addr=InetAddress.getLocalHost();
	    	String ipadd=addr.getHostAddress();
	    	//get the session or authenticate user to check logged in or not 
	    	HttpSession ss=request.getSession();
	    	String user=(String) ss.getAttribute("user");
	  //if not logged in then inside if block
	    	if(user==null)
	    	{
	    		//by productdao object calling the method which remove the product from cart by ipaddress
	    	y=ed.removeProduct(cid1,ipadd);//return the integer value
	    	}
	    	else//if logged in then inside else block
	    	{
	 //by productdao object calling the method which remove the product from cart by user id
		    		y=ed.removeProduct(cid1,user);
		    		
	    	}
	    	if(y!=0)//if product removed then condition true
	      {
	    		//forward the execution to the show cart controller with message of remove product
	    	 RequestDispatcher rd=request.getRequestDispatcher("ShowCartController");
	 	  request.setAttribute("msg","Product removed from cart");
	 	  rd.forward(request, response);
	    
	}
	}
}
