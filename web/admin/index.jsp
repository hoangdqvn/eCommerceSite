<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 06/05/2020
  Time: 06:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Hedspi Books - Administration</title>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>

    <div align="center">
        <h1 class="pageheading">Administrative Dashboard</h1>
    </div>

    <div align="center">
        <hr width="60%"/>
        <h2 class="pageheading">Quick Actions:</h2>
        <b>
            <a href="create_book">New Book</a> &nbsp;
            <a href="user_form.jsp">New User</a> &nbsp;
            <a href="category_form.jsp">New Category</a> &nbsp;
            <a href="create_customer">New Customer</a> &nbsp;
        </b>
    </div>

    <div align="center">
        <hr width="60%"/>
        <h2 class="pageheading">Recent Sales:</h2>
    </div>

    <div align="center">
        <hr width="60%"/>
        <h2 class="pageheading">Statistics:</h2>
        <hr width="60%"/>
    </div>

    <jsp:directive.include file="footer.jsp"/>
</body>
</html>
