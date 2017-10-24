package customercontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import customerdao.OrderDao;
import dao.ProductDao;

/**
 * Servlet implementation class ShowOrderController
 */
@WebServlet("/ShowOrderController")
public class ShowOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //execution come from show order jsp page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//object creation of orderdao class
		OrderDao pd=new OrderDao();
		//get the field by name from jsp page
	     String email=(String)request.getAttribute("email");
	     //by orderdao class calling the method which return the info of orders
			ArrayList<Product>list=pd.showOrder(email);//return list which contain data
//forward the execution to the show order jsp page with particular customer detail which is logged in 
	RequestDispatcher rd=request.getRequestDispatcher("showOrders.jsp");
	  request.setAttribute("LIST", list);
	  rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
