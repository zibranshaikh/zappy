package customercontroller;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

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
 * Servlet implementation class ShowCartController
 */
@WebServlet("/ShowCartController")
public class ShowCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //execution come from show cart button 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//object creation of productdao class
		ProductDao pd=new ProductDao();
        //get the local unique ipaddress of system
		InetAddress addr=InetAddress.getLocalHost();
    	String ipadd=addr.getHostAddress();
    	//get the session to check if user logged in or not
	    HttpSession ss=request.getSession();
        String user=(String) ss.getAttribute("user");
//if customer logged in then condition true go inside if block
    	if(user!=null)
    	   {
    		//by product dao class calling the method which return the result according to user and data contain by arralist
    		ArrayList<Product>list=pd.showCart(user);//return list 
    		//forward the execution to showcart jsp where data are shown and with data is also send
			  RequestDispatcher rd=request.getRequestDispatcher("showCart.jsp");
			  request.setAttribute("LIST", list);
			  rd.forward(request, response);
			
    		}
    	   else
    	   {
    		 //by product dao class calling the method which return the result according to ipaddress and data contain by arralist
       			  ArrayList<Product>list=pd.showCart(ipadd);//return list
       			//forward the execution to showcart jsp where data are shown and with data is also send
    			  	  RequestDispatcher rd=request.getRequestDispatcher("showCart.jsp");
        		  request.setAttribute("LIST", list);
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
