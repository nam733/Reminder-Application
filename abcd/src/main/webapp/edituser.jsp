<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
	<%@ page import="java.sql.*"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RemindMe</title>
<style><%@include file="/WEB-INF/edituser.css"%></style>
<style><%@include file="/WEB-INF/mainpage.css"%></style>
<style><%@include file="/WEB-INF/dropdown.css"%></style>

<script type="text/javascript" src="${pageContext.request.contextPath}/WEB-INF/node.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<script>
$(document).ready(function(){
  $("i").click(function(){
    $("#wrapper").toggle();
  });
});
</script>
</head>
<body>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if((int)session.getAttribute("user_id") == 0)
      response.sendRedirect("login.jsp");

  %>
<div class="divi" >
<div style="text-align:right;color:white;padding:30px;">
<a href="<%=request.getContextPath()%>/login.jsp"><i class="fa fa-sign-out-alt"><em>&nbsp;&nbsp;Logout</em></i></a>
</div>
</div>
<a class="s-sidebar__trigger" href="#0">
     <i class="fa fa-bars"></i>
  </a>
  <div id="wrapper">
<div class="s-layout__sidebar">
  <a class="s-sidebar__trigger" href="#0">
     <i class="fa fa-bars"></i>
  </a>
  
            <%! String driverName = "com.mysql.jdbc.Driver";%>
            <%!String url = "jdbc:mysql://localhost:3306/notification";%>
            <%!String user = "root";%>
             <%!String psw = "root";%>
             
                            
  <nav class="s-sidebar__nav">
  
     <ul>
        <li>
           <a class="s-sidebar__nav-link" href="<%=request.getContextPath()%>/notebook.jsp">
              <i class="fa fa-book-open"></i><em>NoteBooks</em>
           </a>
        </li>
        <li>
           <a class="s-sidebar__nav-link" href="<%=request.getContextPath()%>/displaynotes.jsp">
             <i class="fa fa-sticky-note"></i><em>Notes</em>
           </a>
        </li>
        <li>
           <a class="s-sidebar__nav-link" href="<%=request.getContextPath()%>/mainpage">
              <i class="fa fa-user"></i><em>Edit User</em>
           </a>
        </li>
     </ul>
  </nav>
</div>
</div>
 
<div class="sign-up-page">

<br>
<br>
  <div style="text-align:right; width:100%; padding:0px;">
<h1>EDIT USER</h1>
</div>
  <div class="form">

    <form class="login-form" action="<%=request.getContextPath()%>/update" method="post"> 
   <i class="fa fa-user"></i> Name      <input type="text" name="name" value="<c:out value='${dash.name}'/>"/>
   <i class="fa fa-phone"></i> Phone <input type="tel" name="phone"   pattern="[789][0-9]{9}" title="Must be ten digit number" value="<c:out value='${dash.phone}'/>"/>
   <i class="fa fa-envelope"></i> Email  <input type="email" name="email" value="<c:out value='${dash.email}'/>" readonly/>
   <i class="fa fa-key"></i> Password  <input type="password" id="password" name="psw" value="<c:out value='${dash.password}'/>"/>
   <i class="fa fa-key"></i> Confirm Password   <input type="password" id="confirm_password" name="psww" value="<c:out value='${dash.psw}'/>"/>
      <button>Save</button>
    </form>
  </div>
</div>
<script src="signupandlogin/vendor/jquery/jquery.min.js"></script>
    <script src="signupandlogin/js/main.js"></script>
    <script>
    var password = document.getElementById("password")
    , confirm_password = document.getElementById("confirm_password");

  function validatePassword(){
    if(password.value != confirm_password.value) {
      confirm_password.setCustomValidity("Passwords Don't Match");
    } else {
      confirm_password.setCustomValidity('');
    }
  }

  password.onchange = validatePassword;
  confirm_password.onkeyup = validatePassword;
    </script>
</body>
</html>