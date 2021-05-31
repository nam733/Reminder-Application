<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RemindMe</title>
<style><%@include file="/WEB-INF/login.css"%></style>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<div class="login-page">
<h1>RemindMe</h1>
  <div class="form">
 <i class="fa fa-sign-in-alt"style="font-size: 1.5em;"></i>
   <h2><b>Login</b></h2>
    <form class="login-form" action="<%=request.getContextPath()%>/loginn" method="post">
      <input type="email" name="email"  placeholder="email" required autocomplete="off"/>
      <input type="password" name="password" placeholder="password" required autocomplete="off"/>
      <button>login</button>
      <p class="message">Not a member?<a href="signup.jsp">SignUp</a></p>
    </form>
  </div>
</div>
</body>
</html>