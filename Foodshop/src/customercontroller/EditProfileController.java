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
    //execution come from custoperation controller
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//object creation of customer dao class
		CustomerDao ed=new CustomerDao();
		//object creation of customer bean class
	     Customer p=new Customer();
	     //get the session to view a particular authenticate user profile
	     HttpSession ss=request.getSession();
	     String email=(String)ss.getAttribute("user");
	     //calling the method by customer object which return the object of customer class
	     p=ed.viewProfileUpdate(email);//contains the info in object of customer
	     //forward the execution to the editprofile.jsp page with data which contain by object p
	  RequestDispatcher rd=request.getRequestDispatcher("editProfile.jsp");
	  request.setAttribute("c", p);
	  rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//execution come from editprofile jsp page of customer
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the session to edit a particular authenticate user profile
	    HttpSession ss=request.getSession();
		String email1=(String) ss.getAttribute("user");
		String edit=request.getParameter("edit");

       if(edit.equalsIgnoreCase("EDIT"))
		{
		//get the field by name from edit profile jsp page of customer
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");

		//object creation of customer dao class
				CustomerDao ed=new CustomerDao();
			    int p=0;
			    //by object of custmer dao calling the method which edit the info of customer
			    p=ed.editProfile(email1,name,address,email,mobile);//return the integer value
			     if(p!=0)//if edited then condition true
			     {    
			    		String subject="Zappy Foods Profile Edited";
			 	        String message="Your profile has been edited your Login id is "+email+" Address "+address+" Mobile "+mobile;
			 	    	CustController cc=new CustController();
			 	    	          cc.sendMail(email,message,subject);
					 	    	 
			    	 //forward the execution to customer home page with updation message
			  RequestDispatcher rd=request.getRequestDispatcher("Customer.jsp");
			  request.setAttribute("pro","Profile Successfully Edited");
			  rd.forward(request, response);
			     }
			    	     

		}
		else if(edit.equalsIgnoreCase("Change Password"))
		{
		String cpass=request.getParameter("cpass");
	    String npass2=request.getParameter("npass2");
        //object creation of customer dao class
		CustomerDao ed=new CustomerDao();
	    int p=0;
	    //by object of customer dao calling the method which edit the info of customer
	    p=ed.changeCpwd(cpass,npass2,email1); 
	    if(p!=0)//if edited then condition true
	     {    
	    	 
	    	String subject="Zappy Foods Password Changed";
 	        String message="Your Password has been Changed your Login id is "+email1+" And Password is "+npass2;
 	    	CustController cc=new CustController();
 	    	          cc.sendMail(email1,message,subject);
		 	
	   //forward the execution to customer password change page with updation message
	  RequestDispatcher rd=request.getRequestDispatcher("changeCpwd.jsp");
	  request.setAttribute("msg","Password Successfully changed");
	  rd.forward(request, response);
	     }
	    else
	    {
	    	//forward the execution to customer password change page with updation message
	      RequestDispatcher rd=request.getRequestDispatcher("changeCpwd.jsp");
	  	  request.setAttribute("msg","Password not changed because current password doesn't match");
	  	  rd.forward(request, response);
	  	  
	    }
	}
	}
}
