package customercontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import customerdao.OrderDao;

/**
 * Servlet implementation class CheckOrderStatusController
 */
@WebServlet("/CheckOrderStatusController")
public class CheckOrderStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOrderStatusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //execution come from cust operation controller
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//object creation of orderdao class
		OrderDao pd=new OrderDao();
		//get the session to show the order to current authenticate user 
		HttpSession ss=request.getSession();
		String email=(String) ss.getAttribute("user");
		//by orderdao object calling the method which give the info of orders
		ArrayList<Product>list=pd.showOrderStatus(email);//return the arraylist
		//forward the execution to the show order status jsp page with data or list which contain the all the info of orders
	  RequestDispatcher rd=request.getRequestDispatcher("showOrderStatus.jsp");
	  request.setAttribute("LIST", list);
	  rd.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		
		
	}

}
