package customercontroller;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerbean.Customer;
import customerdao.CustomerDao;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/CustController")
public class CustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustController() {
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
	//execution come from create customer jsp page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get the fields from create customer jsp page by name
		String name=request.getParameter("name");
	String address=request.getParameter("address");
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile");
	String password=request.getParameter("password");
	//get the local host unique ipaddress
    InetAddress addr=InetAddress.getLocalHost();
	String ipadd=addr.getHostAddress();//set the ipaddress to variable
	//object creation of customer bean class to set the value of each field
	Customer e=new Customer(ipadd,name,address,email,Long.parseLong(mobile),password);

   	//object creation of customer dao class
		CustomerDao ed=new CustomerDao();
		//by this object calling the method which insert the customer info to the database
	int y=ed.insertCust(e);//return the integer value
	System.out.println("value of y in custcontroller "+y);
		if(y==1)//if condition true inside block
		{   
			String subject="Zeppy Account Creation & Password";
			String message="Welcome at Zeppy FoodShop your login id is "+email+" and your password "+password;
			//call the method which sends the mail to the customer
			 sendMail(email,message,subject);
		        
			 //forward execution to custlogin.jsp page with message of registration
	RequestDispatcher rd=request.getRequestDispatcher("custLogin.jsp");
		request.setAttribute("msg","Registration Successfull , Login now");
		rd.forward(request, response);
	
		}
	}
	//execution come from if block
	 public void sendMail(String email, String message1,String subject)
	   {
			  // Recipient's email ID needs to be mentioned.
		      String to =email;//request.getParameter("id");//change accordingly
		      String sub=subject;
//		      long p=System.currentTimeMillis();//439807598430759083
//		      String pwd=(p+"").substring(7);
		      
		      String msg=message1;
		      // Sender's email ID needs to be mentioned
		      String from = "zshaikh1990s@gmail.com";
		      final String username = "zshaikh1990s@gmail.com";//change accordingly
		      final String password = "93009300";//change accordingly

		      // Assuming you are sending email through relay.jangosmtp.net
		      String host = "smtp.gmail.com";

		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.port", "587");

		      // Get the Session object.
		      Session session = Session.getInstance(props,
		      new javax.mail.Authenticator() {
		         protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username, password);
		         }
		      });

		      try {
		         // Create a default MimeMessage object.
		         Message message = new MimeMessage(session);

		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.setRecipients(Message.RecipientType.TO,
		         InternetAddress.parse(to));

		         // Set Subject: header field
		         message.setSubject(sub);

		         // Now set the actual message
		         message.setText(msg);

		         // Send message
		         
		         Transport.send(message);
//		         PrintWriter out=response.getWriter();
//		        out.println("Sent message successfully....");
		         } catch (MessagingException e) {
		    	  e.printStackTrace();
		    	     }	
		      }

}
