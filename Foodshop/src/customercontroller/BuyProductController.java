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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession ss=request.getSession();
		 String y=(String)ss.getAttribute("user");
		if(y==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("custLogin.jsp");
			request.setAttribute("msg2","Not Login, Login First");
			rd.forward(request, response);
		}
	else 
		{
		     String email=y;
		     OrderDao od=new OrderDao();
		     String ipadd=y;
	
		     String pin=request.getParameter("pin");
		     String pmode=request.getParameter("pmode");
	
		     int p=od.buyProduct(email,ipadd,pin,pmode);
	 	     System.out.println("p in buy="+p);
	 	     if(p!=0)
	 	     {
		  RequestDispatcher rd=request.getRequestDispatcher("Customer.jsp");
	 	  request.setAttribute("msg", "order successfully placed");
	 	  rd.forward(request, response);
	 	     }

	}
		}

}
