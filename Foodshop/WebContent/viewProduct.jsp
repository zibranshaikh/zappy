<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body bgcolor="#4db8ff" >
<p1 align="right">
<form action="adminlogout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1><!-- button for logout admin -->

<p1 align="left">
<form action="Admin.jsp" method="">
<input type="submit" value="Home" /></form><!-- button for go to admin home  -->
</p1>
<script>
function confirmTest()
{
	var a=confirm("Do you Really want to Delete Product");//popup for confimation of delete operation
	return a;
	}
</script>
<pre>
<center>
<img src="images/zappy-logo.png"></img>
  <p><h1 style="background-color:white"><font color=black>Product Details</font></h2></p>
<%String m=(String)request.getAttribute("msg");//msg come from view product controller which contain delete information
if(m!=null)
	out.println(m);
%>
<%String m1=(String)request.getAttribute("msg1");
if(m1!=null)
	out.println(m1);
%>
<!-- import package -->
<%@page import="java.util.ArrayList,bean.Product" %>
<%
//get the list from contoller to jsp page
ArrayList<Product> ar1=(ArrayList<Product>)request.getAttribute("LIST");
if(ar1!=null)
{	int a1=0;
	%><table border="1" width=100%><%
			for(Product cc:ar1)
			{
				
			if(a1%4==0)
			{
			out.println("<tr>");
		    %>
   <!-- first row of the product which contain 4 product with all the information -->
<form action="UpdateDelProductController" method="get">
    <td>
	   <input type="hidden" value="<%=cc.getPid()%>" name="pid" />
     <center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><a href="UpdateImage.jsp?pid=<%=cc.getPid()%>">Update Image</a></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%> gms.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
<!-- two button are there update and delete , on click both button execution will go to updatedelproductcontroller -->
    <center><h4><input type="submit" name="op" value="Update" /><input type="submit" name="op" value="Delete" onclick="return confirmTest();" /></form></center>   

</td> 				
		</form>
	<%
			}else{
				%>
<!-- second row of the product which contain 4 product with all the information -->
<form action="UpdateDelProductController" method="get">
    <td>
  <input type="hidden" value="<%=cc.getPid()%>" name="pid" />
      <center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><a href="UpdateImage.jsp?pid=<%=cc.getPid()%>">Update Image</a></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%> gms.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
<!-- two button are there update and delete , on click both button execution will go to updatedelproductcontroller -->
    <center><h4><input type="submit" name="op" value="Update" /><input type="submit" name="op" value="Delete" onclick="return confirmTest();" /></form></center>   
	  </td>
</form>
				<%
			if(a1%4==3)
				out.println("</tr>");
			    	
		    }		
			a1++;

		}
%>
		</table>				
	<%
}
%>
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

</center>
</pre>

</body>
</html>