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

/**
 * Servlet implementation class CustOperation
 */
@WebServlet("/CustOperation")
public class CustOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustOperation() {
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
		String op=request.getParameter("op");
	if(op.equals("Home"))
	{
		response.sendRedirect("Customer.jsp");
	}
   if(op.equals("MyOrders"))
	{   
	   String email=request.getParameter("email");
	  	 RequestDispatcher rd=request.getRequestDispatcher("ShowOrderController");
	  	 request.setAttribute("email", email);
	  	 rd.forward(request,response);
	}
   if(op.equals("MYCart"))
  	{
	   response.sendRedirect("ShowCartController");
  	}
   if(op.equals("EditProfile"))
  	{
	 response.sendRedirect("EditProfileController");
  	 
  	}
	if(op.equals("CheckOrderStatus"))
	{
	response.sendRedirect("CheckOrderStatusController");

	}
	}

}
