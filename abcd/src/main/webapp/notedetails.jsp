<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <style><%@include file="/WEB-INF/table.css"%></style>
 <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>RemindMe</title>
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
<table>
  <caption><i class="fa fa-book-open"></i><em> Note</em><br>
  <br><br></caption>
  
  <tbody>
    <tr>
    <td scope="row" data-label="Name"><b>Name</b></td>
      <td scope="row" data-label="Name"><c:out value='${task.name}'/></td>
    </tr>
    <tr>
    <td scope="row" data-label="Name"><b>Start-Date</b></td>
      <td scope="row" data-label="Start-Date"><c:out value='${task.startdate}'/></td>
    </tr>
    <tr>
    <td scope="row" data-label="Name"><b>End-Date</b></td>
      <td scope="row" data-label="End-Date"><c:out value='${task.enddate}'/></td>
    </tr>
    <tr>
    <td scope="row" data-label="Name"><b>Reminder-Date</b></td>
      <td scope="row" data-label="Reminder-Date"><c:out value='${task.reminderdate}'/></td>
    </tr>
    <tr>
    <td scope="row" data-label="Name"><b>Status</b></td>
      <td scope="row" data-label="Status"><c:out value='${task.status}'/></td>
    </tr>
    <tr>
    <td scope="row" data-label="Name"><b>Tag</b></td>
      <td scope="row" data-label="Tag"><c:out value='${task.tag}'/></td>
    </tr>
    <tr>
    <td scope="row" data-label="Name"><b>Description</b></td>
      <td scope="row" data-label="Description"><c:out value='${task.description}'/></td>
    </tr>
  </tbody>
</table>
<br>
<br>
<button class="button" onclick="history.go(-1)">Back</button>
</body>
</html>