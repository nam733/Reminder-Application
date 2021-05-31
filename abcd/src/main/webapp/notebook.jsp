<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.sql.*"%>
    <%@page import="javax.servlet.http.HttpSession" %>
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
<%! String driverName = "com.mysql.jdbc.Driver";%>
            <%!String url = "jdbc:mysql://localhost:3306/notification";%>
            <%!String user = "root";%>
             <%!String psw = "root";%>
<body>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if((int)session.getAttribute("user_id") == 0)
      response.sendRedirect("login.jsp");

%>
<%
int user_id = (int) session.getAttribute("user_id"); 
String uname= (String) session.getAttribute("name");%>
<%
                       Connection conn = null;
                       PreparedStatement pss = null;
                      try
                       {
                    	  int no=0;
                       Class.forName(driverName);
                       conn = DriverManager.getConnection(url,user,psw);
                       String sql = "select note_name , start_date from note where reminder_date=curdate() and reg_id="+user_id;
                       pss = conn.prepareStatement(sql);
                       ResultSet rs = pss.executeQuery();%>
                    
                       
<div class="divi" >
<div style="text-align:right;color:white;padding:30px;">
<a href="<%=request.getContextPath()%>/addnotebook.jsp" style="margin-right:50px;">NEW NOTEBOOK</a>&nbsp;
<div class="dropdown">   
    <div class="dropdown-content">
    <h4>Reminder</h4>
      <%while(rs.next())
                       {
                       String notename = rs.getString("note_name"); 
                       String startdate=rs.getString("start_date");
                       no++;
 %>
    
    <div style="width:100%;background-color:lightgrey;">
      <p><c:out value="<%=notename%>"/></p>
      <p><c:out value="<%=startdate%>"/></p>
      </div>
    
    <% 
            }
                       
                       %>
                       </div>
                       <button class="dropbtn" style="margin-left:120px;margin-top:-1em;">
             <span class="fa fa-bell"></span>
             <span class="label label-primary"><c:out value="<%=no%>"/></span>
    </button>
  </div>&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/logoutt"><i class="fa fa-sign-out-alt"><em>&nbsp;&nbsp;Logout</em></i></a>
   <%  }
                      catch(SQLException sqe)
                     { 
                     out.println(sqe);
                     }
                     %>
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
            
             
                            
  <nav class="s-sidebar__nav">
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
<p style="margin-left:250px;"><b>NOTE BOOKS</b></p>
<br>

<%
int count=0;
                       Connection con = null;
                       PreparedStatement ps = null;
                      try
                       {
                       Class.forName(driverName);
                       con = DriverManager.getConnection(url,user,psw);
                       String sql = "SELECT * FROM notebooks where reg_id = ?";
                       ps = con.prepareStatement(sql);
                       ps.setInt(1, user_id);
                       ResultSet rs = ps.executeQuery();
                      
                     %>
				   
				
						
					
                           <%
                         while(rs.next())
                         {
                         String name = rs.getString("notebookname"); 
                         int id=rs.getInt("id");
                         ps = con.prepareStatement("SELECT count(*) as cm FROM note where notebook_id="+id);
                         ResultSet rss = ps.executeQuery();
                         rss.next();
                         count = rss.getInt("cm") ;
                         //String emailid = rs.getString("emailid"); 
                          %>
                          <div class="myDiv">
                          <input type="hidden" name="notebookid" value="<c:out value="<%=id%>"/>"/>
                        <p><a href="display?id=<c:out value="<%=id%>"/>"  style="color:#1560BD;margin-left:10px;font-size:19px;"><b><c:out value="<%=name%>"/></b></a><br></a><div style="float:right;"><a href="edit?id=<c:out value="<%=id%>"/>" style="color:#1560BD;"><i class="fa fa-edit"></i><em> Edit</em></a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value="<%=id%>"/>" style="color:#1560BD;"><i class="fa fa-minus-circle"></i><em> Delete</em></a></div>
								</p>
                        
								<p style="margin-left:10px;"><c:out value="<%=count%>"/>&nbsp;&nbsp;Notes</p>
						
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