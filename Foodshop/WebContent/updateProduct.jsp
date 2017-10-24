<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
</head>
<body bgcolor=#4db8ff>
<p1 align="left">
<form action="Admin.jsp" method="">
<input type="submit" value="Home" /></form>
</p1>

<p1 align="right">
<form action="adminlogout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1>
<center>
<pre>
<img src="images/zappy-logo.png"></img>

<h1 style="background-color:white">Update Product</h1>
<%@page import="java.util.ArrayList,bean.Product" %>
<form action="UpdateDelProductController" method="post" >
<%
Product cc=(Product)request.getAttribute("p");
%>

<table> 
 <tr><td>Product Name     <input type="text" required="required" value="<%=cc.getPname()%>" name="pname"   /></td></tr> 
 <tr><td>price(INR)       <input type="text" pattern="\d+(\.\d{1,2})?" title="Enter price of product "name="price" required="required" value="<%=cc.getPrice()%>" name="price"   /></td> </tr>
 <tr><td>weight(KG)       <input type="text" value="<%=cc.getWeight()%>" pattern="\d{1-4}[G-Mg-m]{2}" name="weight" required="required"/></td> </tr>
 <tr><td>Details          <textarea name="details" pattern="^\S+.*?\S+$" /><%=cc.getDetails()%></textarea></td></tr>
 </table>
            <input type="submit" value="update" />
</form>
<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String admin=(String)session.getAttribute("admin");
  if(admin==null)
   response.sendRedirect("AdminLogin.jsp");
  %>

<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
</pre>
</center>
</body>
</html>