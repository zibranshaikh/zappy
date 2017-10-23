package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

/**
 * Servlet implementation class AdminOperation
 */
@WebServlet("/AdminOperation")
public class AdminOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOperation() {
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
	//come execution here from show todays order jsp 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //get the field by name
		String op=request.getParameter("op");
	    
		if(op.equals("Dispatch"))//if button contain dispatch then condition true
	    { 
	    	int y=0;
	    	//get the field by name from show todays order jsp
	    	String pid=request.getParameter("pid");
	    	String pname=request.getParameter("pname");
	    	int status=1;
	    	
	          ProductDao p=new ProductDao();//object creation of productdao class 
	          //by this object calling the method for dispatch the order
	         y=p.dispatchProduct(pname,status);//return the integer value after updation
	       if(y!=0)//if order dipatched then condition true
	       {
	    	   //forward the execution from here to view today order controller with message of updation
		  	 RequestDispatcher rd=request.getRequestDispatcher("ViewTodayOrderController");
		  	 request.setAttribute("msg", pname+" Order is dispatched");
		  	 rd.forward(request,response);
	       }
	    }
	    else if(op.equals("Cancel"))//if button contain cancel then condition true
		   {
	    	//get the field by name from show todays order jsp page
	    	String pid=request.getParameter("pid");
	     	String pname=request.getParameter("pname");
	    	int status=2;
	        int y=0;
	        //object creation of product dao class
	    	ProductDao p=new ProductDao();
	    	//by this object calling the method for cancel the order
	         y=p.cancelProduct(pname,status);//return the integer value 
	       if(y!=0)//if product cancelled condition true
	       {
	    	   //forward the execution from here to view today order controller with message of order cancelled
			  	RequestDispatcher rd=request.getRequestDispatcher("ViewTodayOrderController");
			  	 request.setAttribute("msg", pname+" Order is cancelled");
			  	 rd.forward(request,response); }	
	    }
	    
	}

}
