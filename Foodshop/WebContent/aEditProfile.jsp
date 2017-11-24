 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<title>Admin Change Password</title>
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


<body bgcolor=#e0e0eb>
<p1 align="left">
<form action="Admin.jsp" method="">

<input type="submit" value="Home" /></form></p1><!-- button for go to admin home -->
<p1 align="right">
<form action="adminlogout.jsp" method="">

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
<form action="AdEditPController" method="post">

Current Password  <input type="text" name="cpass" required="required" placeholder="123@zibran" onblur="pwdCheck()"/>
New Password      <input type="text" name="npass1" id="npass1" required="required"  placeholder="123@zibran" />
Confirm Password  <input type="text" name="npass2" id="npass2" required="required" placeholder="123@zibran" onblur="return validate()"/>
                          
             <input type="submit" value="Change Password" /><!-- button to submit the field and go to adeditcontroller -->
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