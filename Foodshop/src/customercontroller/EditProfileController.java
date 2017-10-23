package customercontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import customerbean.Customer;
import customerdao.CustomerDao;
import dao.ProductDao;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet("/EditProfileController")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CustomerDao ed=new CustomerDao();
	     Customer p=new Customer();
	     HttpSession ss=request.getSession();
	     String email=(String)ss.getAttribute("user");
	     p=ed.viewProfileUpdate(email);
	  RequestDispatcher rd=request.getRequestDispatcher("editProfile.jsp");
	  request.setAttribute("c", p);
	  rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession();
		String email1=(String) ss.getAttribute("user");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String pwd=request.getParameter("pwd");
		System.out.println(name);
		CustomerDao ed=new CustomerDao();
	    int p=0;
	     p=ed.editProfile(email1,name,address,email,mobile,pwd);
	     if(p!=0)
	     {
	  RequestDispatcher rd=request.getRequestDispatcher("Customer.jsp");
	  request.setAttribute("pro","Profile Successfully Edited");
	  rd.forward(request, response);
	     }
		
	}

}
