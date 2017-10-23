//this is package of customer controller...
package customercontroller;
//here we import the necessary packages which is used for the execution..
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
 * Servlet implementation class ViewCustProductController
 */
//servlet url which is use to call servlet
@WebServlet("/ViewCustProductController")

//user defined servlet is created there.... which extends the HttpServlet class...

public class ViewCustProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//default constructor is call there
	public ViewCustProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//doget method to send the content to the web page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductDao ed=new ProductDao();//there is a object creation of ProductDao class which is data access object.. 
	    //after object creation we need to call method which get the contain of product..
		//execution go to the ProductDao class.
		ArrayList<Product>list=ed.viewProduct();//this method return the list which contain the product details
	      String msg=(String)request.getAttribute("msg");//data is come from
	      String m1=(String)request.getAttribute("m1");//data is come from 
		RequestDispatcher rd=request.getRequestDispatcher("viewCustProduct.jsp");//it sends the execution to view customer product page where all the product is visible..
	  request.setAttribute("LIST", list);//and also send the data to that page also..
	  request.setAttribute("msg", msg);//msg contain data send to viewCustProduct page..
	  rd.forward(request, response);//this method forward the execution to page with data....
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
