<%@ page import="app.entities.Book" %>
<%@ page import="app.entities.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Yevgeniya
  Date: 04.02.2018
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" buffer="8kb"
         session="true" isErrorPage="false" isThreadSafe="true" info="forum_page" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Document</title>
</head>
<body>

</body>
</html>
<html>
<head>
    <title>Fantasy</title>
</head>
<body>
<h1>Forum page</h1>

<%
    List<User> userList = (List<User>)request.getAttribute("users");

    for(User user:userList){
        out.println("<h5>User "+user.getId()+"</h5>");
        out.println("<p>Login "+user.getLogin()+"</p>");
        out.println("<p>Email "+user.getEmail()+"</p>");
        out.println("<p>Password "+user.getPassword()+"</p>");
    }
%>

</body>
</html>
