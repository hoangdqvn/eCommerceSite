<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 08/05/2020
  Time: 20:22
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
        <h1 class="pageheading">
            <c:if test="${userE != null}">Edit User</c:if>
            <c:if test="${userE == null}">Create New User</c:if>
        </h1>
    </div>

    <div align="center">

        <c:if test="${userE != null}">
            <form action="update_user" method="post" id="userForm">
                <input type="hidden" name="userId" value="${userE.userId}"/>
        </c:if>
        <c:if test="${userE == null}">
            <form action="create_user" method="post" id="userForm">
        </c:if>

            <table class="form">
                <tr>
                    <td align="right">Email:</td>
                    <td align="left"><input type="text" id="email" name="email" size="20" value="${userE.email}"/></td>
                </tr>
                <tr>
                    <td align="right">Fullname:</td>
                    <td align="left"><input type="text" id="fullname" name="fullname" size="20" value="${userE.fullName}"/></td>
                </tr>
                <tr>
                    <td align="right">Password:</td>
                    <td align="left"><input type="password" id="password" name="password" size="20" value="${userE.password}"/></td>
                </tr>
                <tr><td>&nbsp;</td></tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit">Save</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button id="buttonCancel">Cancel</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#userForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
                fullname: "required",
                password: "required"
            },
            messages: {
                email: {
                    required: "Please enter email",
                    email: "This is not a valid email address"
                },
                fullname: "Please enter full name",
                password: "Please enter password"
            }
        });

        $("#buttonCancel").click(function () {
            history.go(-1);
        })
    });
</script>
</html>
