<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#4db8ff">
<%  String user=(String)session.getAttribute("user");%>

<%!int a=0;%>
 <%!String ipadd="";%>
<%@page import="java.net.InetAddress,dao.ProductDao"%>
   <%
   InetAddress addr=InetAddress.getLocalHost();
	String ipadd=addr.getHostAddress();
	if(user==null)
   {
		
	ProductDao pd=new ProductDao();
    a=pd.countProduct(ipadd);
   }
   else
   {   
	   ProductDao pd=new ProductDao();
	   a=pd.countProduct(user);
   }
%>
<p1 align="left" >
<form action="AdminLogin.jsp" method="get">
<input type="submit" value="AdminLogin" /></form></p1>
<p2 align="center" >
<form action="custLogin.jsp" method="get">
<input type="submit" value="CustomerLogin" /></form></p1>
<p3 align="right">
<form action="ShowCartController" method="get">
<input type="submit" value="ShowCart(<%=a%>)" /></form></p1>
<center><img src="images/zappy-logo.png"></img>
</center>
<%@page import="dao.ProductDao,bean.Product"%>
   <%
   ProductDao pd=new ProductDao();
   int pid=Integer.parseInt(request.getParameter("pid"));
   Product p=new Product();
    p=pd.viewProductDetail(pid);
    %>
<center>
<p><h1 style="background-color:white">Product Detail</h1></p>
 
    <table> 
        <tr><td>              <img src="images/<%=p.getImage()%>" heigth="300" width="300" /></td></tr>
                           <tr><td><h3>Image</h1></td></tr>
        <tr><td><h3>Product Name  </h3></td><td><h3><%=p.getPname()%></h3></td></tr> 
        <tr><td><h3>price         </h3></td><td><h3><%=p.getPrice()%></h3></td></tr>
        <tr><td><h3>weight        </h3></td><td><h3><%=p.getWeight()%></h3></td></tr>
        <tr><td><h3>Details       </h3></td><td><h3><%=p.getDetails()%></h3></td></tr>
        </table>
        <form action="AddToCartController" method="Post">
        <input type="hidden" value="<%=p.getPid()%>" name="pid" />
        <input type="hidden" value="<%=p.getPrice()%>" name="price" />
        <td><h3><input type="submit" value="AddToCart" /></h3></td>   
<td><h3>Quantity<input type="number" min="1" value="1" name="quantity" required/></h3></td>
    </form>
     
 <footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>

</center>
</body>
</html>