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
	
	int quantity=Integer.parseInt(request.getParameter("quantity"));
	int cid=Integer.parseInt(request.getParameter("cid"));
	int pid=Integer.parseInt(request.getParameter("pid"));
    double price=Double.parseDouble(request.getParameter("price"));
    double tamount=quantity*price;
	String sql = "update cart set quantity=?,tamount=? where cid=? and pid=?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1,quantity);
	ps.setDouble(2,tamount);
	ps.setInt(3,cid);
	ps.setInt(4,pid);
	
	System.out.println(ps);
	int p= ps.executeUpdate();
	if(p!=0)
	{
		String sql1 = "select sum(tamount) from cart where cartid=1";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		
	ResultSet rs=ps1.executeQuery();
	
	if(rs.next())
	{
		System.out.println(rs.getDouble(1));
		out.println(rs.getDouble(1));
	}
	
	}
//end of start method try block
}
catch(Exception e)
{
	System.out.println("class Connect.start() exception"+e);
}
%>