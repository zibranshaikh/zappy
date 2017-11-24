<!--execution come from product page to there  -->

<link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<title>Admin Login</title>

<body  bgcolor=#e0e0eb>

<p align="left">
<form action="ViewCustProductController" method="">
<input type="submit" value="GoToMainPage" ><!-- button for go to product page -->
</form>
</p>
<center>
<img src="images/zappy-logo.png"></img><!-- logo -->
<pre>
<h1><font color="red">
<%
String m=(String)request.getAttribute("msg");//msg which contain data of login fail message
if(m!=null)
	out.println(m);
%>
</font></h1>
<p><h1 style="background-color:white">Admin Login</h1></p>
 <form action="CheckLoginController" method="post">
<h1><font color=white>UserId   <input type="text" name="uid" required="required" /></font></h1><!-- textfield which contain userid -->
<h1><font color=white>Password <input type="password" name="pwd" required="required" /></font></h1><!-- textfield which contain password -->
 <input type="submit" value="Login" /><!-- button for login go to check login controller -->
 </form>
 </pre> 	<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");

  %>
 <footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
 </center>
 </body>