<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Admin.jsp" method="">
<input type="submit" value="Home" /></form>
</p1>
<p1 align="right">
<form action="adminlogout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1>

<center>
<h1 style="background-color:white">Update Product Image</h1>
<% String m=(String)request.getAttribute("msg");
   if(m!=null)
	out.println(m);
%>
<%@page import="java.util.ArrayList,bean.Product,dao.ProductDao" %>
<%
             int pid=Integer.parseInt(request.getParameter("pid"));
             System.out.println("pid in update image jsp "+pid);
             ProductDao ed=new ProductDao();
	 	     Product p=new Product();
	 	     p=ed.viewProductUpdate(pid);
	 	     
%>
<form action="UpdateImageController" method="post" enctype="multipart/form-data">
 <center><h1>Current Image</h1><img src="images/<%=p.getImage()%>" heigth="150" width="150" /></center>
 <center><h1>New Image         <input type="file" name="file" accept="image/*" required="required" /></h1></center>
                               <input type="hidden" value="<%=pid%>" name="pid"  />
                               <input type="submit" value="update" >  
</form>
<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String admin=(String)session.getAttribute("admin");
  if(admin==null)
   response.sendRedirect("AdminLogin.jsp");
  %>

</center>
</body>
</html>