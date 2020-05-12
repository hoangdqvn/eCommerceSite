<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 05/05/2020
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<div align="center">
    <div>
        <img src="../images/BookstoreLogo.png"/>
    </div>

    <div>
        <input type="text" name="keyword" size="50"/>
        <input type="button" value="Search"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="login">Sign In</a> |
        <a href="register">Register</a>|
        <a href="view_cart">Cart</a>
    </div>
    <br/>
    <div>
        <b>
            <c:forEach var="category" items="${listCategory}" varStatus="status">
                <a href="view_category?=${category.categoryId}">
                    <font size="+1">${category.name}</font>
                </a>
                <c:if test="${not status.last}">
                &nbsp; | &nbsp;
                </c:if>
            </c:forEach>
        </b>
    </div>
</div>
