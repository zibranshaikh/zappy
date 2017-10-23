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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String pid=request.getParameter("pid");
		ProductDao ed=new ProductDao();
	     int y=0;
	        InetAddress addr=InetAddress.getLocalHost();
	    	String ipadd=addr.getHostAddress();
	    	HttpSession ss=request.getSession();
	    	String user=(String) ss.getAttribute("user");
	    	if(user==null)
	    	{
	    	y=ed.removeProduct(pid,ipadd);
	    	}
	    	else
	    	{
	    		y=ed.removeProduct(pid,user);
		    		
	    	}
	    	if(y!=0)
	      {
	    	 RequestDispatcher rd=request.getRequestDispatcher("ShowCartController");
	 	  request.setAttribute("msg","Product removed from cart");
	 	  rd.forward(request, response);
	    
	}
	}
}
