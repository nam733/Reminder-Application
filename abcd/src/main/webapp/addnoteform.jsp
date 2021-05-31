<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RemindMe</title>
<style><%@include file="/WEB-INF/login.css"%></style>
	<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet">
<script>
	     
	     $(document).ready(function () {
	    	 var minDate = new Date();
	    	 var maxDate = new Date();
	    	 $("#start").datepicker({
	    		 showAnim: 'drop',
	    		 numberOfMonth: 1,
	    		 minDate: minDate,
	    		 maxDate: maxDate,
	    		 dateFormat: 'yy-mm-dd',
	    		 onClose: function (selectedDate){
	    			 $('#end').datepicker("option","minDate",selectedDate);
	    		 }
	    	 });
	    	 
	    	 $("#end").datepicker({
	    		 showAnim: 'drop',
	    		 numberOfMonth: 1,
	    		 dateFormat: 'yy-mm-dd',
	    		 onClose: function (selectedDate){
	    			 $('#remind').datepicker("option","maxDate",selectedDate);
	    		 }
	    	 });
	    	 
	    	 $("#remind").datepicker({
	    		 showAnim: 'drop',
	    		 numberOfMonth: 1,
	    		 minDate: minDate,
	    		 maxDate:maxDate,
	    		 maxdate:$("#end").datepicker,
	    		 dateFormat: 'yy-mm-dd',
	    		 onClose: function (selectedDate){
	    			 $('#end').datepicker("option","minDate",selectedDate);
	    		 }
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
<div class="sign-up-page">
<a class="topright" href="<%=request.getContextPath()%>/notebook.jsp">
      <img id="logo" src="data:image/png;base64,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" width="30" height="30" alt="Talk Fusion"> 
  </a>
<br>
<br>
<br>
<br>
<br>
  <div class="form">
  <h2><b>ADD NOTE</b></h2>
    <form class="login-form" action="<%=request.getContextPath()%>/add" method="post">
    <input type="hidden" name="idd" value="<c:out value='${id}'/>"/> 
    <input type="text" name="name" placeholder="name" required autocomplete="off"/>
    <input type="text" name="startdate" id="start" placeholder="startdate" placeholder="startdate" required autocomplete="off"/>
    <input type="text" name="enddate" id="end" placeholder="enddate" required autocomplete="off"/>
    <input name="reminderdate" id="remind" placeholder="reminderdate"  required autocomplete="off"/>
    <input type="text" name="status" placeholder="status" required autocomplete="off"/>
     <input type="text" name="tag" placeholder="tag" required autocomplete="off"/>
      <input type="text" name="description" placeholder="description" required autocomplete="off"/>
      <button>ADD</button>
    </form>
  </div>
</div>
</body>
</html>