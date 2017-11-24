<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Placement</title>
</head>
<body bgcolor="#e0e0eb" >
<p1 align="left">
<form action="Customer.jsp" method="" >
<input type="submit" value="Home" /></form></p1>

<p1 align="center">
<form action="ViewCustProductController" method="get">
<input type="submit" value="GoToProducts" /></form></p1>

<p1 align="right">
<form action="logout.jsp" method="">
<input type="submit" value="LogOut" /></form></p1>

<center>
<img src="images/zappy-logo.png"></img>
<pre>
<p><h2 style="background-color:white">Order Placement</h2></p>

<%@page import="java.util.ArrayList,customerbean.Customer" %>

 
<form action="BuyProductController" method="post" >
<%
Customer cc=(Customer)request.getAttribute("c");
%>
<table border="3">
 <tr><td><h1>Name         <input type="text"  value="<%=cc.getName()%>" pattern="[A-Za-z]{4,}+" name="name" required="required" /></h1></td></tr> 
 <tr><td><h1>Address      <input type="text" value="<%=cc.getAddress()%>" name="address" required="required" /></h1></td></tr>
 <tr><td><h1>EMAIL        <input type="email" value="<%=cc.getEmail()%>" name="email"    required="required" /></h1></td></tr>
 <tr><td><h1>Mobile       <input type="text"  value="<%=cc.getMobile()%>" name="mobile"  pattern="[0-9]{10}" required="required" /></h1></td></tr>
 <tr><td><h1>PINCODE      <input type="text"  pattern="^[0-9]*$" name="pin" placeholder="450001" required="required" /></h1></td></tr>
 <tr><td><h1>Payment Mode <select name="pmode">
                     
                     <option>visa card       </option>
                     <option>credit card     </option>
                     <option>debit card      </option>
                     <option>Internet banking</option>
                     <option>Case on Delievery</option>
                     </select></h1></td></tr>

<tr><td>                 <input type="submit" value="Place Order" /></td></tr>
 </table>
</form>
<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
</pre>
</center>
<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String user=(String)session.getAttribute("user");
  if(user==null)
   response.sendRedirect("custLogin.jsp");
  %>

</body>
</html>