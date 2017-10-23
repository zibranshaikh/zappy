package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerdao.OrderDao;
import dao.ProductDao;

/**
 * Servlet implementation class DispatchOrderController
 */
@WebServlet("/DispatchOrderController")
public class DispatchOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchOrderController() {
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
	    
			OrderDao od=new OrderDao();
		     int y=0;
		     String pid=(String)request.getAttribute("pid");
		     y=od.dispatchProduct(Integer.parseInt(pid));
		     if(y==1)
		      {
		      RequestDispatcher rd=request.getRequestDispatcher("ViewTodayOrderController");
		 	  request.setAttribute("msg","Product Dispatched successfully");
		 	  rd.forward(request, response);
		    
		}
	}

}
