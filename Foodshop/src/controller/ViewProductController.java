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
import dao.ProductDao;

/**
 * Servlet implementation class ViewProductController
 */
@WebServlet("/ViewProductController")
public class ViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//execution come from view all product hyperlink..
	
		//one more execution come here from update delete product controller to view the product to the admin and the delete message
		
		
		ProductDao ed=new ProductDao();//object creation of productdao
		//by this object we call method of productdao to view product
		
	      ArrayList<Product>list=ed.viewProduct();//it will return a arraylist
	      String msg=(String)request.getAttribute("msg");
	  RequestDispatcher rd=request.getRequestDispatcher("viewProduct.jsp");//forwarded to page and the data also
	  request.setAttribute("msg", msg);// message come from update delete product controller  
	  request.setAttribute("LIST", list);//this list contain the product and send it to the view product page of admin..
	  rd.forward(request, response);//forward the contain to page and redirect it with data
	//execution go to the viewproduct.jsp.....
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
