<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Status</title>
</head>
<body bgcolor="#4db8ff " >
<p1 align="left">
<form action="Customer.jsp" method="">
<input type="submit" value="Home" /></form>
</p1>
<p1 align="right">
<form action="logout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1>


<pre>
<center> 
<img src="images/zappy-logo.png"></img>
   
<p><h1 style="background-color:white">ORDER HISTORY</h1></p>
<%@page import="java.util.ArrayList,bean.Product" %>
<%
ArrayList<Product> ar1=(ArrayList<Product>)request.getAttribute("LIST");
if(ar1.isEmpty())
{
%><h1>There are No Orders Please go to shop</h1>
<% 	
}
if(ar1!=null)
{	int a2=0;
	%><table border="1" width=80%><%
			for(Product cc:ar1)
			{
				
			if(a2%4==0)
			{
			out.println("<tr>");
		    %>
  <td>
    <center><h4>Order Id     :<%=cc.getOrderid()%></h4></center>
	<center><h4>Product Id   :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<a href="ShowProductDetail.jsp?pid=<%=cc.getPid()%>"><%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
    <center><b>Quantity</b>  : <%=cc.getQuantity()%></center>
    <center><b>Total Amount</b> :<%=cc.getTamount()%></center>
        <%  int st=0;
      String status="";
      st=cc.getStatus(); 
      if(st==1)
      {
    	  status="Dispatched";
      }
      else if(st==0)
      {
    	  status="Pending";
      }
      else if(st==2)
      {
    	  status="Cancelled";
      }
      else if(st==3)
      {
    	  status="Delivered";
      }
      %>

    <center><b>Status</b>  :<%=status%></center>
    <center><b>To</b>      :<%=cc.getEmail()%></center> 
    </td> 				
		</form>
	<%
			}else{
				%>

 <td>   
    <center><h4>Order Id     :<%=cc.getOrderid()%></h4></center>
    <center><h4>Product Id   :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<a href="ShowProductDetail.jsp?pid=<%=cc.getPid()%>"><%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
    <center><b>Quantity</b>  : <%=cc.getQuantity()%></center>
 <center><b>Total Amount</b> :<%=cc.getTamount()%></center>
    
      <%  int st=0;
      String status="";
      st=cc.getStatus(); 
      if(st==1)
      {
    	  status="Dispatched";
      }
      else if(st==0)
      {
    	  status="Pending";
      }
      else if(st==2)
      {
    	  status="Cancelled";
      }
      else if(st==3)
      {
    	  status="Delivered";
      }
      %>
      
    <center><b>Status</b>  :<%=status%></center> 
    <center><b>To</b>      :<%=cc.getEmail()%></center> 
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
</pre>
</body>
</html>