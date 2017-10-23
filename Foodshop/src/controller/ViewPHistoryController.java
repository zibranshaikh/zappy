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
 * Servlet implementation class ViewPHistoryController
 */
@WebServlet("/ViewPHistoryController")
public class ViewPHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPHistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//execution come from hyperlink which is show order history
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//object creation of order dao..
		OrderDao pd=new OrderDao();
		//by this object calling the method which give the data of history
		ArrayList<Product>list=pd.showOrderHistory();//return the array list of type product 
		//forward to the page show order history jsp with data of the order history which contains by array list
	  RequestDispatcher rd=request.getRequestDispatcher("showOrderHistory.jsp");
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
