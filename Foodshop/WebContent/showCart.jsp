<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
function getData(i)
{
	
	//alert("asdfasd"+i);
	var q=document.getElementById('quant'+i).value;  
	var cid=document.getElementById('cid'+i).value;
	var pid=document.getElementById('pid'+i).value; 
	var up=document.getElementById('price'+i).value; 
	 var data= "cid="+cid+"&pid="+pid+"&quantity="+q+"&price="+up;
	//	alert(data);
	if(q==0)
		{
			alert("Quantity Should not be zero");
		}
	if(q!=0)
		{
	var url="updateCartQ.jsp?"+data;
		var request;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send(); 
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		function getInfo(){  
			if(request.readyState==4){
			var val=request.responseText;  
	//		alert("Now Total amount is"+val);
			document.getElementById('res').value=val;
			/* var strarray = val.split('.');
			document.getElementById('pdate').value=(strarray[0]).trim();  
			document.getElementById('ptype').value=(strarray[1]).trim();
			document.getElementById('CostCenter').value=(strarray[2]).trim();  
			document.getElementById('currency').value=(strarray[3]).trim();   */
			}		
		
		}
		}
	}
	

	</script>
</head>
<body bgcolor="#e0e0eb" >

<%  String user=(String)session.getAttribute("user");
    if(user!=null)
   {%>
<p1 align="left">
<a href="Customer.jsp">Home</a>
</p1>
<p1 align="right">
<a href="logout.jsp">LogOut</a>
</p1>

<%}
    else
    {
    %>
    <p2 align="left" >
<a href="custLogin.jsp">CustomerLogin</a>
</p2>
    <%} %>
<p1 align="center">
<a href="ViewCustProductController">SHOP NOW</a>
</p1>
<pre>
<center>
<img src="images/zappy-logo.png"></img>
<p><h1 style="background-color:white">YOUR CART</h1></p>
<h1><%String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%></h1>

 <%@page import="java.util.ArrayList,bean.Product" %>
<%
ArrayList<Product> ar1=(ArrayList<Product>)request.getAttribute("LIST");
if(ar1.isEmpty())
{
%><h1>There are No Product in Cart Please Go to Shop</h1>
<p1 align="center">
<form action="ViewCustProductController" method="get">

<input type="submit" value="SHOP NOW" /></form></p1>
<% 	
}
double tamount=0;
if(ar1!=null)
{	int a2=0;
	%><table border="1" width=80%><%
			for(Product cc:ar1)
			{
				
			if(a2%4==0)
			{
			out.println("<tr>");
		    %>
	 <td>
    <input type="hidden" value="<%=cc.getCartid()%>" name="cid" id="cid<%=a2%>" />
	<input type="hidden" value="<%=cc.getPrice()%>" name="price" id="price<%=a2%>" />
	<center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<a href="ShowProductDetail.jsp?pid=<%=cc.getPid()%>"><%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%> gms.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
    <center><b>Quantity</b>  :<input type="number" id="quant<%=a2%>" min="1" name="quantity" value="<%=cc.getQuantity()%>" required="required"  onchange="getData(<%=a2%>);"/><br/></center>
    <form action="RemoveProductController" method="Post">
  <center><h4><input type="submit" value="Remove From Cart" /></h4></center>   
    <input type="hidden" value="<%=cc.getPid()%>" name="pid" id="pid<%=a2%>"  />
    <%tamount=tamount+Double.parseDouble(cc.getTamount()); %>
   </td> 				
		</form>
	<%
			}else{
				%>

   <td>
   <input type="hidden" value="<%=cc.getCartid()%>" name="cid" id="cid<%=a2%>" />
	<input type="hidden" value="<%=cc.getPrice()%>" name="price" id="price<%=a2%>" />
    <center><h4>Product Id :<%=cc.getPid()%></h4></center>
    <center><h4>Product Name :<a href="ShowProductDetail.jsp?pid=<%=cc.getPid()%>"><%=cc.getPname()%></a></h4></center>
    <center><b>Price</b>     : <%=cc.getPrice()%> Rs.<br/></center>
    <center><img src="images/<%=cc.getImage()%>" heigth="150" width="150" /></center>
    <center><b>Weight</b>    : <%=cc.getWeight()%> gms.<br/></center>
    <center><b>Details</b>   : <%=cc.getDetails()%><br/></center>
    <center><b>Quantity</b>  :<input type="number" id="quant<%=a2%>" min="1" name="quantity" value="<%=cc.getQuantity()%>" required="required" onchange="getData(<%=a2%>);" />  <br/></center>
    <form action="RemoveProductController" method="Post">
    <center><h4><input type="submit" value="Remove From Cart" /></h4></center>   
    <input type="hidden" value="<%=cc.getPid()%>" name="pid" id="pid<%=a2%>" />
     <%tamount=tamount+Double.parseDouble(cc.getTamount()); %>
    </td>
</form>
				<%
			if(a2%4==3)
				out.println("</tr>");
			    	
		    }		
			a2++;

		}
%>
		</table>				
	<%
}
%>
<%!int a=0;%>
 <%!String ipadd="";%>
<%@page import="java.net.InetAddress,dao.ProductDao"%>
   <%
   InetAddress addr=InetAddress.getLocalHost();
	String ipadd=addr.getHostAddress();
	ProductDao pd=new ProductDao();
if(user==null)
{
	 a=pd.countProduct(ipadd);
}
else
{
     a=pd.countProduct(user);
    	
}
%>
<style>
#res{font-size:24px;}
</style>
 <%if(a!=0)
    	 { %><table border="2" bgcolor=white>
     <form action="OrderPlaceController" method="get" />
 <tr><td><h1><font color=blue>Total product</font></h1></td><td><h1><%=a%></h1></td></tr>
     <tr><td><h1><font color=blue>Total Amount</font></h1></td><td><input type="text" id="res" value="<%=tamount%>" readonly/></td></tr>
    
     <tr><td></td><td><input type="submit" value="CheckOut" name="op" /></td></tr>
    <%}%>
    </form>   
    </table>

    <footer class="container-fluid text-center">
  <p><h2 style="background-color:white"><font color=black>@ Copyright Zappy FoodShop Powered and Developed By Systango</font></h2></p>
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