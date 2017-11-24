<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
<style type="text/css">
table { 
  width: 100%; 
  border-collapse: collapse; 
}
/* Zebra striping */
tr:nth-of-type(odd) { 
  background: #eee; 
}
/* Zebra striping */
tr:nth-of-type(even) { 
  background: #eee; 
}
th { 
  background: #333; 
  color: white; 
  font-weight: bold; 
}
td, th { 
  padding: 6px; 
  border: 1px solid #ccc; 
  text-align: left; 
}
@media 
only screen and (max-width: 760px),
(min-device-width: 768px) and (max-device-width: 1024px)  {

	/* Force table to not be like tables anymore */
	table, thead, tbody, th, td, tr { 
		display: block; 
	}
	
	/* Hide table headers (but not display: none;, for accessibility) */
	thead tr { 
		position: absolute;
		top: -9999px;
		left: -9999px;
	}
	
	tr { border: 1px solid #ccc; }
	
	td { 
		/* Behave  like a "row" */
		border: none;
		border-bottom: 1px solid #eee; 
		position: relative;
		padding-left: 50%; 
	}
	
	td:before { 
		/* Now like a table header */
		position: absolute;
		/* Top/left values mimic padding */
		top: 6px;
		left: 6px;
		width: 45%; 
		padding-right: 10px; 
		white-space: nowrap;
	}
	

}
</style>
</head>
<body bgcolor=#e0e0eb>
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