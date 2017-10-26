<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		   $('input[type="submit"]').prop('disabled', true);                 
		
		$("#email").blur(function(){
			          var email = "email="+$("#email").val();
						
						$.ajax({
							
							url:'FetchData.jsp',
							data:email,
							type:'post',
							success:function(result){
								if(result.match("0"))
									 $('input[type="submit"]').prop('disabled', false);   	
								else
									 alert("Email id already exist")   	
									
							}
							});
						
		                            });
		});
		
</script>
<<script>
$(document).ready(function() {
 
    $('').blur(function() {
       if($(this).val() != '') {
          $(':input[type="submit"]').prop('disabled', false);
       }
    });
});
</script>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />

<title>Customer Registration</title>

<body bgcolor=#4db8ff >
<p align="left">
<h1><a href="ViewCustProductController">GoToMainPage</a></h1>
</p>
<center>
<img src="images/zappy-logo.png"></img>

<h1 style="background-color:white">Customer Registration</h1>
<pre>
<font color="green">
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
</font>
<table border="3" >
 <form action="CustController" method="post">
 <h1><font color=white>Name         <input type="text" name="name" pattern="[A-Za-z]{4,}+" title="only alphabet" placeholder="Zibran Shaikh" required="required" /></font></h1>
 <h1><font color=white>Address      <input type="text" name="address" required="required" /></font></h1>
 <h1><font color=white>Email        <input type="email" name="email" id="email" required="required" /></font></h1>
 <h1><font color=white>Mobile       <input type="text" maxlength="10"  pattern="[0-9]{10}" title="Enter your mobile number 10 digit "name="mobile" required="required" /></font></h1>
 <h1><font color=white>Password     <input type="password" name="password" required="required" /></font></h1>
 
                                               
                                               <input type="submit" value="REGISTER" />
  </form>
  </table>
  </pre>
  
<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>
  
  </center>