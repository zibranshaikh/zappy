<title>Upload Product</title>
<body bgcolor=#4db8ff >

<p1 align="left">
<form action="Admin.jsp" method="">

<input type="submit" value="Home" /></form></p1><!-- button for go back to admin home -->
<p1 align="right">
<form action="adminlogout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1><!-- logout button for admin -->
<center>
<img src="images/zappy-logo.png"></img>
<pre>
<p><h1 style="background-color:white">Upload Product</h1></p>
 <%String msg=(String)request.getAttribute("msg");
if(msg!=null)
out.println(msg);//msg which contain data
%> 

<!-- upload product by fill the all text fields -->
 <form action="UploadProductController" method="post" enctype="multipart/form-data">
 <h1>Product Name   <input type="text" name="pname" placeholder="Chocolate cake" required="required" /></h1>
 <h1>price(INR)     <input type="text" pattern="\d+(\.\d{1,2})?" title="Enter price of product in INR" name="price" required="required" placeholder="100.00" /></h1>  
 <h1>weight(KG)     <input type="text" name="weight" pattern="\d+(\.\d{1,2})?" required="required" placeholder="100"/></h1>  
 <h1>Details        <textarea name="details" pattern="[A-Za-z]{4,}+" required="required" ></textarea></h1>
 <h1>       Image           <input type="file" name="file" accept="image/*" required="required" /></h1>
       
                   <input type="submit" value="upload" /><!-- button for submit the all text field and go to upload product controller -->
 </form>
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
 <%-- <%String iname="jpeg.jpg" %>
 <img src="images\<%=iname%>" heigth="100" width="100"/> --%>