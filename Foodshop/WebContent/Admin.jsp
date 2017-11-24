 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<title>Admin Home</title>
<body bgcolor=#e0e0eb>
<p1 align="right">
<form action="adminlogout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1>

</p1>
<center>
<h1 style="background-color:white">Welcome
 <%String m1=(String)session.getAttribute("admin");
                  if(m1!=null) 
                 out.println(m1); %><!-- show the identity of the admin -->
           </h1>
</h1>
<pre>
<img src="images/zappy-logo.png"></img>
<table border="1" bgcolor=white >
       <tr>
       <!-- admin functions heading  -->
           <th><h1>Product</h1></th>
           <th><h1>Customer</h1></th>
           <th><h1>OrderInfo</h1></th>
           <th><h1>Account Settings</h1></th>

           
       </tr>
<tr>
<!-- admin fucntions with hyperlink , click on link and go to precise contoller or jsp page-->
<td><a href="uploadProduct.jsp"><h2><font color=blue>Add Product</font></h2></a></td><!-- upload the porduct -->
<td><a href="ViewCustomerController"><h2><font color=blue>View All Customer</font></h2></a></td><!-- view all customer -->
<td><a href="ViewTodayOrderController"><h2><font color=blue>Pending Order</font></h2></a></td><!-- pending order -->
<td><a href="aEditProfile.jsp"><h2><font color=blue>Account Settings</font></h2></a></td><!-- account setting of admin like password change -->
<tr>
<td><a href="ViewProductController"><h2><font color=blue>View All Product</font></h2></a></td><!-- show all product -->
<td></td>
<td><a href="ViewPHistoryController"><h2><font color=blue>Order History</font></h2></a></td><!-- history of products -->
<td></td>
</tr>      
</table>
<!-- here we destroy the admin session if admin logout  -->
<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String admin=(String)session.getAttribute("admin");
  if(admin==null)
   response.sendRedirect("AdminLogin.jsp");
  %>


</pre>
<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
</center>
</body>