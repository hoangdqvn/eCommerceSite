<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 12/05/2020
  Time: 07:14
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
        <h1 class="pageheading">Categories Management</h1>
        <h3><a href="category_form.jsp">Create New Category</a></h3>
    </div>

    <div align="center">
        <h4 class="message">${message}</h4>
    </div>

    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Index</th>
                <th>ID</th>
                <th>Category Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="category" items="${listCategory}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${category.categoryId}</td>
                    <td>${category.name}</td>
                    <td>
                        <a href="edit_category?id=${category.categoryId}">Edit</a> &nbsp;&nbsp;
                        <a href="javascript:void(0);" class="deleteLink" id="${category.categoryId}">Delete</a>
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
                    var categoryId = $(this).attr("id");
                    if (confirm("Are you sure you want to delete the category with ID "+ categoryId +"?"))
                        window.location = 'delete_category?id=' + categoryId;
                });
            });
        });
    </script>
</body>
</html>
