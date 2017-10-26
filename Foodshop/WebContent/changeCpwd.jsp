 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<title>Customer Change Password</title>
<script type="text/javascript">
  function validate()
  {
	  var npass1=document.getElementById("npass1").value;
	  var npass2=document.getElementById("npass2").value;
	  if(npass1!=npass2)
		  {
		  alert("New Password and Confirm Password not match ");
		  return false;
		  }
  return true;
  }
</script>


<body bgcolor=#4db8ff >
<p1 align="left">
<form action="Customer.jsp" method="">

<input type="submit" value="Home" /></form></p1><!-- button for go to admin home -->
<p1 align="center">
<form action="ViewCustProductController" method="get">
<input type="submit" value="SHOPNOW" /></form>
</p1>
<p1 align="right">
<form action="logout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1><!-- button for admin logout -->

<center>
<img src="images/zappy-logo.png"></img>
<pre>

<p><h1 style="background-color:white">Change Password</h1></p>
<h1><font color=white>
<%String m2=(String)request.getAttribute("msg");//contain the message of updation
if(m2!=null) 
out.println(m2); %>
</font></h1>
<form action="EditProfileController" method="post">

Current Password  <input type="text" name="cpass" required="required" placeholder="123@zibran" onblur="pwdCheck()"/>
New Password      <input type="text" name="npass1" id="npass1" required="required"  placeholder="123@zibran" />
Confirm Password  <input type="text" name="npass2" id="npass2" required="required" placeholder="123@zibran" onblur="return validate()"/>
                          
             <input type="submit" value="Change Password" name="edit" /><!-- button to submit the field and go to adeditcontroller -->
</form>
<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String user=(String)session.getAttribute("user");
  if(user==null)
   response.sendRedirect("custLogin.jsp");
  %>

</pre>

<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
</center>
</body>