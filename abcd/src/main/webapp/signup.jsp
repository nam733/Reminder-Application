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
<div class="sign-up-page">
<br>
<br>
<br>
<br>
<br>
  <div class="form">
  <h2><b>Sign-Up</b></h2>
    <form class="login-form" action="<%=request.getContextPath()%>/register" method="post"> 
    <input type="text" name="name" placeholder="username" required autocomplete="off"/>
    <input type="tel" name="phone"  placeholder="mobilenumber" pattern="[789][0-9]{9}" title="Must be ten digit number" required autocomplete="off"/>
      <input type="email" name="email"  placeholder="email" required autocomplete="off"/>
      <input type="password" id="password" name="psw" placeholder="password" required autocomplete="off"/>  
      <input type="password" id="confirm_password" name="psww" placeholder="confirmpassword" required autocomplete="off"/>
      <button>Submit</button>
      <p class="message">Already a member?<a href="login.jsp">Login</a></p>
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