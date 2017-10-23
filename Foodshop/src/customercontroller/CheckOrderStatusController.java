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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao pd=new OrderDao();
		HttpSession ss=request.getSession();
		String email=(String) ss.getAttribute("user");
		ArrayList<Product>list=pd.showOrderStatus(email);
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
