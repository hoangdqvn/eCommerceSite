<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 12/05/2020
  Time: 07:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Manage Categories - Hedspi Books - Administration</title>
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>
    
    <div align="center">
        <h1 class="pageheading">
            <c:if test="${categoryE != null}">Edit Category</c:if>
            <c:if test="${categoryE == null}">Create New Category</c:if>
        </h1>
    </div>
    
    <div align="center">
    
        <c:if test="${categoryE != null}">
            <form action="update_category" method="post" id="categoryForm">
            <input type="hidden" name="categoryId" value="${categoryE.categoryId}"/>
        </c:if>
        <c:if test="${categoryE == null}">
            <form action="create_category" method="post" id="categoryForm">
        </c:if>
                <table class="form">
                    <tr>
                        <td align="right">Name:</td>
                        <td align="left"><input type="text" id="name" name="name" size="20" value="${categoryE.name}"/></td>
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
        $("#categoryForm").validate({
            rules: {
                name: "required"
            },
            messages: {
                name: "Please enter the category name"
            }
        });

        $("#buttonCancel").click(function() {
            history.go(-1);
        });
    });
</script>
</html>
