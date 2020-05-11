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
    <title>Manage Users - Hedspi Books - Administration</title>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>

    <div align="center">
        <h2>
            <c:if test="${userE != null}">Edit User</c:if>
            <c:if test="${userE == null}">Create New User</c:if>
        </h2>
    </div>

    <div align="center">

        <c:if test="${userE != null}">
            <form action="update_user" method="post" onsubmit="return validateFormInput()">
                <input type="hidden" name="userId" value="${userE.userId}"/>
        </c:if>
        <c:if test="${userE == null}">
            <form action="create_user" method="post" onsubmit="return validateFormInput()">
        </c:if>

            <table>
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
                        <input type="submit" value="Save"/>
                        <input type="button" value="Cancel" onclick="javascript:history.go(-1);"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
    function validateFormInput() {
        var fieldEmail = document.getElementById("email");
        var fieldFullname = document.getElementById("fullname");
        var fieldPassword = document.getElementById("password");

        if( fieldEmail.value.length == 0){
            alert("Email is required!");
            fieldEmail.focus();
            return false;
        }

        if( fieldFullname.value.length == 0){
            alert("Full name is required!");
            fieldFullname.focus();
            return false;
        }

        if( fieldPassword.value.length == 0){
            alert("Password is required!");
            fieldPassword.focus();
            return false;
        }

        return true;
    }
</script>
</html>
