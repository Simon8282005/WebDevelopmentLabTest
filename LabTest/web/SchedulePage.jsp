<%-- 
    Document   : SchedulePage
    Created on : 16 Jun 2026, 3:03:24 PM
    Author     : Simon
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.SessionBean"%>
<%@page import="model.SessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Session</title>
    </head>
    <body>
        <h1>All sessions</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Student Name</th>
                <th>Branch Location</th>
                <th>Lesson Type</th>
                <th>Status</th>
                <th>Action</th>
            </tr>   
            
            <%
                ArrayList<SessionBean> sessionList = null;
                
                if (request.getAttribute("sessionList") != null) {
                    sessionList = (ArrayList<SessionBean>) request.getAttribute("sessionList");
                }
                
            %>
            
            <%
                for (int i = 0; i < sessionList.size(); i++) {
            %>
                <tr>
                    <td><%= String.format("S%03d", sessionList.get(i).getSession_id()) %></td>
                    <td><%= sessionList.get(i).getStudent_name()%></td>
                    <td><%= sessionList.get(i).getBranch_location()%></td>
                    <td><%= sessionList.get(i).getLesson_type()%></td>
                    <td><%= sessionList.get(i).getStatus()%></td>
                    <td><button onclick="window.location.href = 'ScheduleServlet?action=delete&id=<%= sessionList.get(i).getSession_id()%>'">Delete</button></td>
                </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
<%@include file="footer.jsp" %>
