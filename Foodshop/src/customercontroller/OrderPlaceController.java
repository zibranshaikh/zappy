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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
		 
		CustomerDao ed=new CustomerDao();
	    Customer c=new Customer();
	    String email=y;
	    c=ed.viewCust(email);
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
