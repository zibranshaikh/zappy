<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Home</title>
  
<style>

header {
    padding: 1em;
    color: white;
    background-color: white;
    clear: left;
    text-align: center;
}

</style>

</head>
<body bgcolor=#4db8ff><!-- background color set of body -->
<%  String user=(String)session.getAttribute("user");%><!-- to authenticate user we get the session by this method  -->

<%!int a=0;%>                                          <!-- initialization of variable -->
 <%!String ipadd="";%>                                 <!-- initialization of variable -->
<%@page import="java.net.InetAddress,dao.ProductDao"%> <!-- import the needy packages -->
   <%
   InetAddress addr=InetAddress.getLocalHost();
	String ipadd=addr.getHostAddress();//it gives the unique ip address of a particular system..
	if(user==null)//condition check for user
   {
		
	ProductDao pd=new ProductDao();//object creation of class
    a=pd.countProduct(ipadd);//calling method for count the no. of product in cart with particular system by ipaddress
   }
   else
   {   
	   ProductDao pd=new ProductDao();
	   a=pd.countProduct(user);//calling method for count the no. of product in cart with particular user by userid
   }
%>

<header>
<font size="5" color=black align="left">
<p align="left">
<% if(user==null)
   {%>
   <a href="AdminLogin.jsp">AdminLogin</a>
   <a href="custLogin.jsp">CustomerLogin</a>
<%} %>
   <% if(user!=null)
   {%>
<a href="Customer.jsp">Home</a>
<a href="logout.jsp">LogOut</a>
<%} %>
<a href="ShowCartController">ShowCart(<%=a%>)</a>
</p>
</font>
</header>
<pre>
<center>
<img src="images/zappy-logo.png"></img><!-- logo of the site -->
<font color=white>    
<h3><%String m=(String)request.getAttribute("msg");//msg which contain data
if(m!=null)
	out.println(m);//printing of data
%></h3>
<h3> <%String m1=(String)request.getAttribute("m1");
if(m1!=null)
	out.println(m1);
%></h3>
</font>
<h1 style="background-color:white">Welcome To Zappy Foodshop</h1>
<h1 style="background-color:white">Our Products</h1>
<%@page import="java.util.ArrayList,bean.Product" %>
<%
ArrayList<Product> ar=(ArrayList<Product>)request.getAttribute("LIST");//get the list 
if(ar!=null)
{	int a1=0;
	%><table border="1" width=70%><%
			for(Product cc:ar)//one bye one fetch data by object 
			{
				
			if(a1%4==0)
			{
			out.println("<tr>");
		    %>
			<form action="AddToCartController" method="post">
<td>
	<center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<a href="ShowProductDetail.jsp?pid=<%=cc.getPid()%>"><%=cc.getPname()%></a></h4></center>
     <center><b>Price</b>     : <%=cc.getPrice()%>Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="100" width="100" /></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%>kg.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
    <center><input type="number" min="1" value="1" name="quantity" required/></center>
    <center><h4><input type="submit" value="AddToCart" /></h4></center><!-- button for adding the product in cart execution go to the add to cart controller-->   
	<input type="hidden" value="<%=cc.getPid()%>" name="pid" />
    <input type="hidden" value="<%=cc.getPrice()%>" name="price" />
</td> 				
		</form>
	<%
			}else{
				%>

					<form action="AddToCartController" method="post">									</br>
<td>
    <center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<a href="ShowProductDetail.jsp?pid=<%=cc.getPid()%>"><%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="100" width="100" /></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%> kg.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
    <center><input type="number" min="1" value="1" name="quantity" required/></center>
    <center><h4><input type="submit" value="AddToCart" /></h4></center><!-- button for adding the product in cart execution go to the add to cart controller-->   
    <input type="hidden" value="<%=cc.getPid()%>" name="pid" />
    <input type="hidden" value="<%=cc.getPrice()%>" name="price" />
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


<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
	</center>
</pre>
	<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");

  %>
</body>
</html>