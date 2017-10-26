<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<body bgcolor="#4db8ff" >
<p align="left">
<form action="CustOperation" method="post">
<input type="submit" value="Home" name="op" />
</form>
</p>
<p1 align="center">
<form action="ViewCustProductController" method="get">
<input type="submit" value="SHOPNOW" /></form>
</p1>
<p1 align="right">
<form action="logout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1>

<center>
<img src="images/zappy-logo.png"></img>
<h1 style="background-color:white">Edit Profile</h1>
<pre>
<%@page import="java.util.ArrayList,customerbean.Customer" %>
<h1><a href="changeCpwd.jsp">CHANGE PASSWORD</a></h1>
<form action="EditProfileController" method="post" >
<%
Customer cc=(Customer)request.getAttribute("c");
%>

<table > 
 <tr><td><h1>Name      <input type="text" value="<%=cc.getName()%>" pattern="[A-Za-z]{4,}+" name="name" required="required" /></h1></td></tr> 
 <tr><td><h1>Address   <input type="text" value="<%=cc.getAddress()%>" name="address" required="required" /></h1></td> </tr>
 <tr><td><h1>EMAIL     <input type="email" value="<%=cc.getEmail()%>" name="email" required="required" /></h1></td> </tr>
 <tr><td><h1>Mobile    <input type="text" value="<%=cc.getMobile()%>" pattern="[0-9]{10}" name="mobile" required="required" /></h1></td></tr>
         </table>
            <input type="submit" value="EDIT" name="edit" />
</form>

</pre>
 <footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String user=(String)session.getAttribute("user");
  if(user==null)
   response.sendRedirect("custLogin.jsp");
  %>

</center>
</body>
</html>