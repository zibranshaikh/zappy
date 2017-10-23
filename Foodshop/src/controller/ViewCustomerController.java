package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerbean.Customer;
import customerdao.CustomerDao;

/**
 * Servlet implementation class CustViewController
 */
@WebServlet("/ViewCustomerController")
public class ViewCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

    //execution come from hyperlink view all customer
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//object creation of customer dao class
		
	      CustomerDao ed=new CustomerDao();
	    //by this object calling the method which give the detail of all customer
	      ArrayList<Customer>list=ed.viewCust();//it will  return arraylist of type customer
	      //list store the data
	      //forward to the view customer jsp page with data contain the list..
	  RequestDispatcher rd=request.getRequestDispatcher("viewCustomer.jsp");
	  request.setAttribute("LIST", list);
	  rd.forward(request, response);
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
