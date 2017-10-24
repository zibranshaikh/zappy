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

import bean.Product;
import dao.ProductDao;

/**
 * Servlet implementation class OrderProductController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //execution come here from view customer product...
		 String pid=request.getParameter("pid");//get the field data by field name..
	     String op=request.getParameter("op");//get the field data by field name..
	     String quantity=request.getParameter("quantity");//get the field data by field name..
	     String price=request.getParameter("price");//get the field data by field name..
	     double price1=Double.parseDouble(price);//get the field data by field name..
	     int quantity1=Integer.parseInt(quantity);//get the field data by field name..
	     
	     double tamount= quantity1*price1;//calculating the total amount of the product
	     System.out.println(tamount);
	      
	        InetAddress addr=InetAddress.getLocalHost();
	    	String ipadd=addr.getHostAddress();//get the ip address of the system
	 		ProductDao ed=new ProductDao();//object creation
	 		//get the session for add to cart
	 		HttpSession ss=request.getSession();
	 		 String user=(String) ss.getAttribute("user");
	 		int p;
	 		//if user is not logged in then add to cart by ipaddress
	 		 if(user==null)
	 		 {
	 		//after that execution go to the productdao class
	 	      p=ed.addToCart(pid,ipadd,quantity1,tamount);//by ProductDao class object call method which return integer
	 		 }
	 		 else//if user is logged in then add to cart by userid
	 		 {
	 			//after that execution go to the productdao class
		 	   p=ed.addToCart(pid,user,quantity1,tamount);//by ProductDao class object call method which return integer
		 		 	 
	 		 }
	 	     if(p!=0)//if product is added to cart then condition true
	 	     {
	 	    	 //forward the execution to the view cust productcontroller
		  RequestDispatcher rd=request.getRequestDispatcher("ViewCustProductController");//forward the execution to view cust product controller 
	 	  request.setAttribute("msg", "Product is Added to cart");//with data
	 	  rd.forward(request, response);//forward the page and data
	 	     }
	 	     else if(p==0)//if product in not added condition true then execute inside block
	 	     {
	 	    	 RequestDispatcher rd=request.getRequestDispatcher("ViewCustProductController");//forward the execution to view cust product controller
	 		 	  request.setAttribute("msg", "Product is Already in cart");//with data
	 		 	  rd.forward(request, response);
	 	     }
	   	  

	}

}
