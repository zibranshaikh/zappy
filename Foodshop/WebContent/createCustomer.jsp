<title>Customer Registration</title>

<body background="images/food.jpg" >

<p align="left">
<form action="ViewCustProductController" mehtod="">
<input type="submit" value="GoToMainPage" >
</form>
</p>
<center>
<img src="images/zappy-logo.png"></img>
<pre>
<font color="green">
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
</font>
<table border="3" bgcolor=blue>
 <form action="CustController" method="post">
 <tr><td><h1><font color=white>Name         <input type="text" name="name" pattern="[A-Za-z]{4,}+" title="only alphabet" placeholder="Zibran Shaikh" required="required" /></font></h1></td></tr>
 <tr><td><h1><font color=white>Address      <input type="text" name="address" required="required" /></font></h1></td></tr>
 <tr><td><h1><font color=white>Email        <input type="email" name="email" onblur="" required="required" /></font></h1></td></tr>
 <tr><td><h1><font color=white>Mobile       <input type="text" maxlength="10"  pattern="[0-9]{10}" title="Enter your mobile number 10 digit "name="mobile" required="required" /></font></h1></td></tr>
 <tr><td><h1><font color=white>Password     <input type="password" name="password" required="required" /></font></h1></td></tr>
 
                                            <tr><td><input type="submit" value="create" /></td></tr>
  </form>
  </table>
  </pre>
  
<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
  
  </center>