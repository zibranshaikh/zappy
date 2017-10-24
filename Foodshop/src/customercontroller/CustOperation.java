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
	//execution come from customer jsp page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the field by name
		String op=request.getParameter("op");
	if(op.equals("Home"))//if button name is equal to home then inside block
	{  
		//redirect the page to the customer home
		response.sendRedirect("Customer.jsp");
	}
   if(op.equals("MyOrders"))//if button is equal to my orders then inside block
	{   
	   //get the field by name from jsp page
	   String email=request.getParameter("email");
	   //forward the page execution to show order controller with data contain a email address
	  	 RequestDispatcher rd=request.getRequestDispatcher("ShowOrderController");
	  	 request.setAttribute("email", email);
	  	 rd.forward(request,response);
	}
   if(op.equals("MYCart"))//if button is equal to my cart then inside block
  	{
	   //redirect the execution to the show cart controller which shows the cart
	   response.sendRedirect("ShowCartController");
  	}
   if(op.equals("EditProfile"))//if button is equal to edit profile then inside block
  	{
	   //forward the execution to the edit profile controller 
	 response.sendRedirect("EditProfileController");
  	 
  	}
	if(op.equals("CheckOrderStatus"))//if button is equal to my orders then inside block
	{
		   //forward the execution to the check order status controller 

	response.sendRedirect("CheckOrderStatusController");

	}
	}

}
