<title>Customer Details</title>
<body bgcolor=#4db8ff >

<p1 align="left">
<form action="Admin.jsp" method="">

<input type="submit" value="Home" /></form></p1>
<p1 align="right">
<form action="adminlogout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1>
<pre>
<center>
<img src="images/zappy-logo.png"></img>
<p><h1 style="background-color:white">Customer Details</h1></p>
<table border="1" bgcolor=white width="100%">
<tr>
    <th><h1>Name</h1></th>
    <th><h1>Address</h1></th>
    <th><h1>MailID</h1></th>
    <th><h1>Mobile</h1></th>
    <th><h1>Password</h1></th>
</tr>
<%@page import="java.util.ArrayList,customerbean.Customer" %>
<%
ArrayList<Customer> ar=(ArrayList<Customer>)request.getAttribute("LIST");
for(Customer cc:ar)
{
	%>
<tr>
    <td><h2><%=cc.getName()%></h2></td>
    <td><h2><%=cc.getAddress()%></h2></td>
    <td><h2><%=cc.getEmail()%></h2></td>
    <td><h2><%=cc.getMobile()%></h2></td>
    <td><h2><%=cc.getPassword()%></h2></td>
    </tr>
<% 
}
%>

</table>
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