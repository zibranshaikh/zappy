<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Login</title>
</head>
<body bgcolor=#4db8ff >
<p align="left">
<form action="ViewCustProductController" mehtod="">
<input type="submit" value="GoToMainPage" >
</form>
</p>
<center>
<img src="images/zappy-logo.png"></img>
<pre>
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
<%
String m1=(String)request.getAttribute("msg1");
if(m1!=null)
	out.println(m1);
%>
<%
String m2=(String)request.getAttribute("msg2");
if(m2!=null)
	out.println(m2);
%>
<p><h1 style="background-color:white">Customer Login</h1></p>
 <h1><font color=white>Already have an account</font></h1>
  <form action="CustLoginController" method="post">
 <h1><font color=white>EMAIL Address </font><input type="text" name="uid" required="required" /></h1>
 <h1><font color=white>Password      </font><input type="password" name="pwd" required="required" /></h1>

 <input type="submit" value="Login" />
 
 <h1><a href="createCustomer.jsp">Create new Account</a></h1>
 </form>
 <h1><a href="forgotPass.jsp">Forgot Password?</a></h1>
 	<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");

  %>
 </pre>
 <footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
 
 </center>

</body>
</html>