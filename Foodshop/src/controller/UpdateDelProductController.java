package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Product;
import dao.ProductDao;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateDelProductController")
public class UpdateDelProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	   private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 100 * 4096;
	   private File file ;


    public UpdateDelProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//execution come from view product jsp page to here
		
		int pid=Integer.parseInt(request.getParameter("pid"));//get the field parameter by name
		System.out.println(pid);
	     String op=request.getParameter("op");//get the button by name both button have same name but different values
	     if(op.equals("Update"))//if button value is update then condition true
	     {
	    	
	 		ProductDao ed=new ProductDao();//object creation of productdao class
	 	     Product p=new Product();//object creation of product class
	 	     //execution go to the productdao class
	 	     p=ed.viewProductUpdate(pid);//this return the object of product class which contain a particular product information
		  RequestDispatcher rd=request.getRequestDispatcher("updateProduct.jsp");//send the execution to update product jsp page
	 	  request.setAttribute("p", p);//the contain of the particular product in this object and it sends to the update product jsp page
	 	  rd.forward(request, response);//forward the page
	 	  
	     }
	     else if(op.equals("Delete"))//if button value is delete then condition true
	     {
	    	 ProductDao ed=new ProductDao();//object creation of product dao class
	 	     int y=0;
	 	     //by product dao class object calling the method for delete the product with product id
	 	     y=ed.deleteProduct(pid);//return the integer value
	 	     if(y!=0)//if delete the product then y is not zero
	 	      {
	 	    	 //condition true inside the block
	 	    RequestDispatcher rd=request.getRequestDispatcher("ViewProductController");//send to view product controller  
		 	  request.setAttribute("msg","Product Successfully deleted");//merge the delete msg data with page
		 	  rd.forward(request, response);//forward to the servlet with data
	 	      }
	 	     else
	 	      {
	 	    	 //if condition is false then go to view product controller with failed msg of delete the product
	 	    	 RequestDispatcher rd=request.getRequestDispatcher("ViewProductController");
		 	  request.setAttribute("msg1","Product failed to delete");
		 	  rd.forward(request, response);
	 	      }
	     }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//click on update button and execution come here
		
		//get the parameter by name from the view product jsp
     String productname=request.getParameter("pname");
     String productprice=request.getParameter("price");
     String productweight=request.getParameter("weight");
     String productdetails=request.getParameter("details");
       
     String pid=request.getParameter("pid");
     System.out.println("pid in updateproduct "+pid);  
     int y=0;
       ProductDao pd=new ProductDao();//object creation of productdao class
       //by this object calling the method for update the product..
       y=pd.updateProduct(productname,productprice,productweight,productdetails);//return the integer value while update the product
     if(y!=0)//condition true then go inside
	    {	
    	 //forward the execution to the view product controller servlet with 
    	 RequestDispatcher rd=request.getRequestDispatcher("ViewProductController");
	    	request.setAttribute("msg","Product succuessfully Updated");
	    	rd.forward(request,response);
	    }

	
	
	
	}


	}


