<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home</title>
</head>
<body bgcolor=#e0e0eb>
<%!int a=0;%>
 <%!String ipadd="";%>
<%@page import="dao.ProductDao"%>
   <%
   ipadd =request.getRemoteAddr();
   ProductDao pd=new ProductDao();
   int a=pd.countProduct(ipadd);
%>
<p1 align="center">
<form action="ViewCustProductController" method="get">

<input type="submit" value="Shop Now" /></form></p1>

<p1 align="right">
<form action="logout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1>
<pre>
<center>
<img src="images/zappy-logo.png"></img>
<%String m1=(String)session.getAttribute("user");if(m1!=null) %>
<p><h1 style="background-color:white">Welcome <%out.println(m1);%></h1></p>
<%String m=(String)request.getAttribute("msg");
if(m!=null)
{ %>
  <h1 style="background-color:white"><%out.println(m);%></h1>
 <%} %> 
<%String m2=(String)request.getAttribute("pro");
if(m2!=null)
{	%>
	<h1 style="background-color:white"><%out.println(m2);%></h1>
<%} %>
<table border="3">
<tr>
<form action="CustOperation" method="post">
       
       <th><input type="submit" value="MyOrders" name="op" /></th>
       <th><input type="submit" value="MYCart" name="op" /></th>
       <th><input type="submit" value="CheckOrderStatus" name="op" /></th>
       <th><input type="submit" value="EditProfile" name="op" /></th>
       <input type="hidden" value="<%=m1%>" name="email" />
     
</form>
</tr>
</table>







<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String user=(String)session.getAttribute("user");
  if(user==null)
   response.sendRedirect("custLogin.jsp");
  %>


<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>

</center>
</pre>
</body>
</html>