<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body bgcolor="#4db8ff" >

<%  String user=(String)session.getAttribute("user");
    if(user!=null)
   {%>
<p1 align="left">
<form action="Customer.jsp" method="" >
<input type="submit" value="Home" /></form></p1>
<p1 align="right">
<form action="logout.jsp" method="">
<input type="submit" value="LogOut" /></form></p1>

<%} %>
<p1 align="center">
<form action="ViewCustProductController" method="get">

<input type="submit" value="SHOP NOW" /></form></p1>
<pre>
<center>
<img src="images/zappy-logo.png"></img>
<p><h1 style="background-color:white">YOUR CART</h1></p>
<h1><%String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%></h1>

 <%@page import="java.util.ArrayList,bean.Product" %>
<%
ArrayList<Product> ar1=(ArrayList<Product>)request.getAttribute("LIST");
if(ar1.isEmpty())
{
%><h1>There are No Product in Cart Please Go to Shop</h1>
<p1 align="center">
<form action="ViewCustProductController" method="get">

<input type="submit" value="SHOP NOW" /></form></p1>
<% 	
}
double tamount=0;
if(ar1!=null)
{	int a2=0;
	%><table border="1" width=80%><%
			for(Product cc:ar1)
			{
				
			if(a2%4==0)
			{
			out.println("<tr>");
		    %>
			 <form action="RemoveProductController" method="Post">
   <td>
	<center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<a href="ShowProductDetail.jsp?pid=<%=cc.getPid()%>"><%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%> gms.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
    <center><b>Quantity</b>   : <%=cc.getQuantity()%><br/></center>
    <center><h4><input type="submit" value="Remove From Cart" /></h4></center>   
    <input type="hidden" value="<%=cc.getPid()%>" name="pid" />
    <%tamount=tamount+Double.parseDouble(cc.getTamount()); %>
   </td> 				
		</form>
	<%
			}else{
				%>

 <form action="RemoveProductController" method="Post">
   <td>
    <center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<a href="ShowProductDetail.jsp?pid=<%=cc.getPid()%>"><%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%> gms.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
    <center><b>Quantity</b>   : <%=cc.getQuantity()%><br/></center>
    <center><h4><input type="submit" value="Remove From Cart" /></h4></center>   
    <input type="hidden" value="<%=cc.getPid()%>" name="pid" />
     <%tamount=tamount+Double.parseDouble(cc.getTamount()); %>
    </td>
</form>
				<%
			if(a2%4==3)
				out.println("</tr>");
			    	
		    }		
			a2++;

		}
%>
		</table>				
	<%
}
%>
<%!int a=0;%>
 <%!String ipadd="";%>
<%@page import="java.net.InetAddress,dao.ProductDao"%>
   <%
   InetAddress addr=InetAddress.getLocalHost();
	String ipadd=addr.getHostAddress();
	ProductDao pd=new ProductDao();
if(user==null)
{
	 a=pd.countProduct(ipadd);
}
else
{
     a=pd.countProduct(user);
    	
}
%>
 <%if(a!=0)
    	 { %><table border="2" bgcolor=white>
     <form action="OrderPlaceController" method="get" />
 <tr><td><h1><font color=blue>Total product</font></h1></td><td><h1><%=a%></h1></td></tr>
     <tr><td><h1><font color=blue>Total Amount</font></h1></td><td><h1><%=tamount%></h1></td></tr>
    
     <tr><td><input type="submit" value="CheckOut" name="op" /></td></tr>
    <%}%>
    </form>   
    </table>

    <footer class="container-fluid text-center">
  <p><h2 style="background-color:white"><font color=black>@ Copyright Zappy FoodShop Powered and Developed By Systango</font></h2></p>
</footer>
    
</center>
</pre>
</body>
</html>