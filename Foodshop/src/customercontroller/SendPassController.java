package customercontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerbean.Customer;
import customerdao.CustomerDao;

/**
 * Servlet implementation class SendPassController
 */
@WebServlet("/SendPassController")
public class SendPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPassController() {
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

          String email=request.getParameter("email");
	      CustomerDao c=new CustomerDao();
	      Customer cc=new Customer();
	      
	        cc=c.getPass(email);
	        String subject="Zappy Foods Password";
	        String message="Your password is : "+cc.getPassword()+" user id is : "+email;
	    	CustController c1=new CustController();
	    	          c1.sendMail(email,message,subject);
	    	       
	   //forward the execution to the forgot password jsp page with successful message
	    RequestDispatcher rd=request.getRequestDispatcher("forgotPass.jsp");
	    request.setAttribute("msg", "Password successfully sent to your email id");
	    	rd.forward(request, response);
	    		 	   
	
	}

}
