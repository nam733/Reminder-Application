<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.sql.*"%>
<%@ page import="java.util.*, javax.mail.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>RemindMe</title>
<style><%@include file="/WEB-INF/notebook.css"%></style>
<style><%@include file="/WEB-INF/mainpage.css"%></style>
<style><%@include file="/WEB-INF/dropdown.css"%></style>
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
  <%

String uname= (String) session.getAttribute("name");%>
     <ul>
     <li>
        <a class="s-sidebar__nav-link" href="#">
              <p style="margin-left:25px;font-size:19px;"><b>WELCOME&nbsp;&nbsp;<c:out value="<%=uname%>"/></b>&nbsp;!!!</p>
           </a>
     </li>
        <li>
           <a class="s-sidebar__nav-link" href="<%=request.getContextPath()%>/notebook.jsp">
             <i class="fa fa-book-open"></i><em>NoteBooks</em>
           </a>
        </li>
        <li>
           <a class="s-sidebar__nav-link" href="<%=request.getContextPath()%>/displaynotes.jsp">
             <i class="fa fa-sticky-note"></i><em>All Notes</em>
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

<!-- Content -->
<div class="divj">
<p style="margin-left:250px;"><b>NOTES</b></p>

<br>
<%
int user_id = (int) session.getAttribute("user_id"); %>
<%
                       Connection con = null;
                       PreparedStatement ps = null;
                      try
                       {
                       Class.forName(driverName);
                       con = DriverManager.getConnection(url,user,psw);
                       String sql = "SELECT * FROM note where reg_id = ?";
                       ps = con.prepareStatement(sql);
                       ps.setInt(1, user_id);
                       ResultSet rs = ps.executeQuery();
                      
                     %>
				
				
						
					
                           <%
                         while(rs.next())
                         {
                        	 String name = rs.getString("note_name"); 
                             String startdate = rs.getString("start_date"); 
                             String enddate = rs.getString("end_date");
                             String reminderdate = rs.getString("reminder_date");
                             String status = rs.getString("status");
                             String description = rs.getString("description");
                             int note_id=rs.getInt("note_id");
                         //String emailid = rs.getString("emailid"); 
                          %>
                          <div class="myDiv">
                        <p><b><c:out value="<%=name%>"/></b>
                        <div style="margin-left:120px;margin-top:-2em;"><a >Started on <c:out value="<%=startdate%>"/></a></div>
                      <div style="margin-left:300px;margin-top:-1.8em;"><button style="margin-right:200px;"><c:out value="<%=status%>"/></button></div>
                                <input type="hidden" id="field1" value="<c:out value="<%=description%>"/>">
                                <p><i class="fa fa-book-open"></i>&nbsp;&nbsp;&nbsp;<c:out value="<%=description%>"/></p>
								</div>
								<br>
								
                    <% 
                         }
                     %>
							
						
				



<%
                       }
                        catch(SQLException sqe)
                       { 
                       out.println(sqe);
                       }
                       %>
  
</div>
   </body>
</html>