package controller;

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

/**
 * Servlet implementation class ViewTodayOrderController
 */
@WebServlet("/ViewTodayOrderController")
public class ViewTodayOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTodayOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//execution come from hyperlink view today order 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//object creation of order dao class
		OrderDao pd=new OrderDao();
		int status=0;
		//by this object calling the method which give the pending orders
		ArrayList<Product>list=pd.showTodayOrder(status);//return the array list which contain the order details
		String msg=(String)request.getAttribute("msg");//data
		//forward to show today order jsp page and also sends the array list which contain order detail and one message
	  RequestDispatcher rd=request.getRequestDispatcher("showTodayOrders.jsp");
	  request.setAttribute("LIST", list);
	  request.setAttribute("msg", msg);
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
