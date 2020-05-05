<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 05/05/2020
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>

    <div align="center">
        <h2>Please Login!</h2>
        <form>
            Email: <input type="text" size="10"><br/>
            Password: <input type="password" size="10"/>
            <input type="submit" value="Login"/>
        </form>
    </div>

    <jsp:directive.include file="footer.jsp"/>
</body>
</html>
