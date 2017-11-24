<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="shortcut icon" type="image/x-icon" href="images/zappy-logo.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Insert title here</title>
</head>
<body bgcolor=#e0e0eb >
<form action="Admin.jsp" method="">
<input type="submit" value="Home" /></form>
</p1>
<p1 align="right">
<form action="adminlogout.jsp" method="">

<input type="submit" value="LogOut" /></form></p1>

<center>
<img src="images/zappy-logo.png"></img>
<h1 style="background-color:white">Update Product Image</h1>
<% String m=(String)request.getAttribute("msg");
   if(m!=null)
	out.println(m);
%>
<%@page import="java.util.ArrayList,bean.Product,dao.ProductDao" %>
<%
             int pid=Integer.parseInt(request.getParameter("pid"));
             System.out.println("pid in update image jsp "+pid);
             ProductDao ed=new ProductDao();
	 	     Product p=new Product();
	 	     p=ed.viewProductUpdate(pid);
	 	     
%>
<form action="UpdateImageController" method="post" enctype="multipart/form-data">
 <center><h1>Current Image</h1><img src="images/<%=p.getImage()%>" heigth="150" width="150" /></center>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
 <div class="form-group">
 <center><h1>Upload New Image<div class="col-md-10"><div><img id="user_img" height="130" width="130" style="border:solid" /></div><div>
       
                                   <input type="file" title="search image" id="file" name="file" onchange="show(this)" required="required"/></div></div></h1></div></center>                       
                          <input type="hidden" value="<%=pid%>" name="pid"  />
                          <center><input type="submit" value="update" /></center>  
</form>
<%
  response.addHeader("pragma", "no-cache");
  response.addHeader("cache-control", "no-store");
  response.addHeader("expire", "0");
  String admin=(String)session.getAttribute("admin");
  if(admin==null)
   response.sendRedirect("AdminLogin.jsp");
  %>
</center>
</body>
</html>