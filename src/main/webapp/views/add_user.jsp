<%@ page import="app.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Yevgeniya
  Date: 04.02.2018
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Join us!</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../user.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Cuprum|Rye" rel="stylesheet">
    <script src="https://use.fontawesome.com/583b2d2cff.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script|Indie+Flower|Pacifico" rel="stylesheet">
    <script src="../script.js" type="text/javascript"></script>
</head>
<body>
<div id="wrap">
    <div id="header">
        <h1>Plaisir</h1>
        <h2>Online-book about books</h2>
        <nav class="inner-navigation">
            <ul>
                <li><a href="../index.html"><i class="fa fa-home" aria-hidden="true"></i>Main Page</a></li>
                <li><a href="#me"><i class="fa fa-smile-o" aria-hidden="true"></i>About us</a></li>
                <li><a href="#"><i class="fa fa-weixin" aria-hidden="true"></i>Forum</a></li>
            </ul>
        </nav>
    </div>
    <div id="content">
        <div id="left"></div>
        <div id="central">
            <p id="description">Registration form</p>
            <form name="data" method="post">
                <label>Login (this name will be displayed in your account and at the forum):
                <input id="loginID" type="text" name="login" value="Your login" onclick="remove(id)"><br/>
                </label>
                <label>Enter your e-mail:
                    <input id="emailID" type="text" name="email" value="E-mail" onclick="remove(id)"><br/>
                </label>
                <label>Enter your password:
                    <input type="password" name="password"><br/>
                </label>
                <label>Re-enter your password:
                    <input type="password" name="password2"><br/>
                </label>
                <button type="submit">Submit</button>
            </form>
            <%
                User user = (User)request.getAttribute("savedUser");
                if(user!=null)
                out.println("<p>"+user.getLogin()+"</p>");
            %>
        </div>
        <div id="right"></div>
    </div>
    <div id="footer"></div>
</div>
</body>
</html>