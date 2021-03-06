<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<style type="text/css">
table { 
  width: 100%; 
  border-collapse: collapse; 
}
/* Zebra striping */
tr:nth-of-type(odd) { 
  background: #eee; 
}
/* Zebra striping */
tr:nth-of-type(even) { 
  background: #eee; 
}
th { 
  background: #333; 
  color: white; 
  font-weight: bold; 
}
td, th { 
  padding: 6px; 
  border: 1px solid #ccc; 
  text-align: left; 
}
@media 
only screen and (max-width: 760px),
(min-device-width: 768px) and (max-device-width: 1024px)  {

	/* Force table to not be like tables anymore */
	table, thead, tbody, th, td, tr { 
		display: block; 
	}
	
	/* Hide table headers (but not display: none;, for accessibility) */
	thead tr { 
		position: absolute;
		top: -9999px;
		left: -9999px;
	}
	
	tr { border: 1px solid #ccc; }
	
	td { 
		/* Behave  like a "row" */
		border: none;
		border-bottom: 1px solid #eee; 
		position: relative;
		padding-left: 50%; 
	}
	
	td:before { 
		/* Now like a table header */
		position: absolute;
		/* Top/left values mimic padding */
		top: 6px;
		left: 6px;
		width: 45%; 
		padding-right: 10px; 
		white-space: nowrap;
	}
	

}
</style>
<script type="text/javascript">
function show(input) {
        debugger;
        var validExtensions = ['jpg','png','jpeg']; //array of valid extensions
        var fileName = input.files[0].name;
        var fileNameExt = fileName.substr(fileName.lastIndexOf('.') + 1);
        if ($.inArray(fileNameExt, validExtensions) == -1) {
            input.type = ''
            input.type = 'file'
            $('#user_img').attr('src',"");
            alert("Only these file types are accepted : "+validExtensions.join(', '));
        }
        else
        {
        if (input.files && input.files[0]) {
            var filerdr = new FileReader();
            filerdr.onload = function (e) {
                $('#user_img').attr('src', e.target.result);
            }
            filerdr.readAsDataURL(input.files[0]);
        }
        }
    }

</script>
</head>
<body bgcolor="#e0e0eb" >
<p1 align="left">
<a href="Admin.jsp">Home</a>
</p1>
<p1 align="right">
<a href="adminlogout.jsp">LogOut</a>
</p1><!-- button for logout admin -->
<script>
function confirmTest()
{
	var a=confirm("Do you Really want to Delete Product");//popup for confimation of delete operation
	return a;
	}
</script>
<pre>
<center>
<img src="images/zappy-logo.png"></img>
  <p><h1 style="background-color:white"><font color=black>Product Details</font></h2></p>
<%String m=(String)request.getAttribute("msg");//msg come from view product controller which contain delete information
if(m!=null)
	out.println(m);
%>
<%String m1=(String)request.getAttribute("msg1");
if(m1!=null)
	out.println(m1);
%>
<!-- import package -->
<%@page import="java.util.ArrayList,bean.Product" %>
<%
//get the list from contoller to jsp page
ArrayList<Product> ar1=(ArrayList<Product>)request.getAttribute("LIST");
if(ar1!=null)
{	int a1=0;
	%><table border="1" width=100%><%
			for(Product cc:ar1)
			{
				
			if(a1%4==0)
			{
			out.println("<tr>");
		    %>
   <!-- first row of the product which contain 4 product with all the information -->
<td>
<form action="UpdateDelProductController" method="get">
    
	   <input type="hidden" value="<%=cc.getPid()%>" name="pid" />
     <center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
   </form><center><b>Weight</b>    : <%=cc.getWeight()%> gms.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
<!-- two button are there update and delete , on click both button execution will go to updatedelproductcontroller -->
    <center><h4><input type="submit" name="op" value="Update" /><input type="submit" name="op" value="Delete" onclick="return confirmTest();" /></form></center>   
 				
		</form>
		 <form action="UpdateImageController" method="post" enctype="multipart/form-data">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
 <div class="form-group">
 <center><h3>Update Image</h3></center>
                          <center> <input type="file" title="search image" id="file" name="file" onchange="show(this)" required="required"/></div></div></h1></div></center>                       
                         <center> <input type="hidden" value="<%=cc.getPid()%>" name="pid"  /></center>
                          <center><input type="submit" value="updateimage" /></center>  
</td>		
	<%
			}else{
				%>
<!-- second row of the product which contain 4 product with all the information -->
<td>

<form action="UpdateDelProductController" method="get">
    
  <input type="hidden" value="<%=cc.getPid()%>" name="pid" />
      <center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%> gms.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
<!-- two button are there update and delete , on click both button execution will go to updatedelproductcontroller -->
    <center><h4><input type="submit" name="op" value="Update" /><input type="submit" name="op" value="Delete" onclick="return confirmTest();" /></form></center>   
	  
</form>
<form action="UpdateImageController" method="post" enctype="multipart/form-data">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
 <div class="form-group">
 <center><h3>Update Image</h3></center>
  <center><input type="file" title="search image" id="file" name="file" onchange="show(this)" required="required"/></div></div></h1></div></center>                       
                          <center><input type="hidden" value="<%=cc.getPid()%>" name="pid" /></center>
                          <center><input type="submit" value="updateimage" /></center>  
</form>
	</td>			<%
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
<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String admin=(String)session.getAttribute("admin");
  if(admin==null)
   response.sendRedirect("AdminLogin.jsp");
  %>

<footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>

</center>
</pre>

</body>
</html>