<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.DriverManager" %>
      <%@page import="java.sql.PreparedStatement" %>
        <%@page import="java.sql.ResultSet" %>
    
<%

try
{	
	//loading the class		
	Class.forName("com.mysql.jdbc.Driver");
	
	//establishing connection  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodshop","root","");
	String email1="";
	String email=request.getParameter("email");

	String sql = "select email from customer where email=?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1,email);
	
	System.out.println(ps);
	ResultSet rs = ps.executeQuery();
	
	if(rs.next())
	{
		
		out.println("1");
	}
	else
	{
		out.println("0");
	}
	
//end of start method try block
}
catch(Exception e)
{
	System.out.println("class Connect.start() exception"+e);
}
%>