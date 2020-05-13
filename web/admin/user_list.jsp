<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 07/05/2020
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Manage Users - Hedspi Books - Administration</title>
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>

    <div align="center">
        <h1 class="pageheading">Users Management</h1>
        <h3><a href="user_form.jsp">Create New User</a></h3>
    </div>

    <div align="center">
        <h4 class="message">${message}</h4>
    </div>

    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Index</th>
                <th>ID</th>
                <th>Email</th>
                <th>Full Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUsers}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${user.userId}</td>
                    <td>${user.email}</td>
                    <td>${user.fullName}</td>
                    <td>
                        <a href="edit_user?id=${user.userId}">Edit</a> &nbsp;&nbsp;
                        <a href="javascript:void(0);" class="deleteLink" id="${user.userId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <jsp:directive.include file="footer.jsp"/>

    <script>
        $(document).ready(function () {
            $(".deleteLink").each(function () {
                $(this).on("click", function () {
                    var userId = $(this).attr("id");
                    if (confirm("Are you sure you want to delete the user with ID "+ userId +"?"))
                        window.location = 'delete_user?id=' + userId;
                });
            });
        });
    </script>

</body>
</html>
