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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pd=new ProductDao();
        InetAddress addr=InetAddress.getLocalHost();
    	String ipadd=addr.getHostAddress();
	    HttpSession ss=request.getSession();
        String user=(String) ss.getAttribute("user");

    	if(user!=null)
    	   {
    		ArrayList<Product>list=pd.showCart(user);
			  RequestDispatcher rd=request.getRequestDispatcher("showCart.jsp");
			  request.setAttribute("LIST", list);
			  rd.forward(request, response);
			
    		}
    	   else
    	   {
    			  ArrayList<Product>list=pd.showCart(ipadd);
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
