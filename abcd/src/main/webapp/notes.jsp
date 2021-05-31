<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.sql.*"%>

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
<% ServletContext sc = getServletContext();
int book_id=(int)sc.getAttribute("book_id");%>
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
<a href="addnote?id=<%=book_id%>" style="margin-right:10px;">ADD NOTE</a>&nbsp;
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
<div style="text-align:right; width:100%; padding:0;">
<!-- <form method="get" action="<%=request.getContextPath()%>/addnotebook.jsp">
   <button>Add NoteBook</button>
</form> -->
</div>
<div class="divj">
<br>
<br>
<br>


<%
                       Connection con = null;
                       PreparedStatement ps = null;
                      try
                       {
                       Class.forName(driverName);
                       con = DriverManager.getConnection(url,user,psw);
                       String sql = "SELECT * FROM note where notebook_id = ?";
                       ps = con.prepareStatement(sql);
                       ps.setInt(1, book_id);
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
                      <a href="notedetails?noteid=<c:out value="<%=note_id%>"/>" style="color:#1560BD;"><c:out value="<%=name%>"/></a>
                      <div style="margin-left:120px;margin-top:-1em;"><a >Started on <c:out value="<%=startdate%>"/></a></div>
                      <div style="margin-left:300px;margin-top:-1.4em;"><button style="margin-right:200px;"><c:out value="<%=status%>"/></button></div>
                      <div style="float:right;"><a href="editnote?noteid=<c:out value="<%=note_id%>"/>" style="color:#1560BD;"> <i class="fa fa-edit"></i><em> Edit</em></a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletenote?noteid=<c:out value="<%=note_id%>"/>" style="color:#1560BD;"><i class="fa fa-minus-circle"></i><em> Delete</em></a></div>

                               <p><c:out value="<%=description%>"/></p>
						
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