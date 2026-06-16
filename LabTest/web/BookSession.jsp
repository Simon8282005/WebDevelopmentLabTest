<%-- 
    Document   : book_session
    Created on : 16 Jun 2026, 2:49:32 PM
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Session</title>
    </head>
    <body>
        <h1>Book new session here...</h1>
        <form method="POST" action="BookSessionServlet">
            <label>Student Name: </label>
            <input type="text" name="name" placeholder="Your name..."><br/><br/>
            <label>Branch Location </label>
            <select name="location">
                <option value="KL">KL</option>
                <option value="JB">JB</option>
                <option value="KT">KT</option>
            </select><br/><br/>
            <label>Lesson Type: </label>
            <select name="lesson">
                <option value="Manual">Manual Car</option>
                <option value="Auto">Auto Car</option>
            </select><br/><br/>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
<%@include file="footer.jsp" %>
