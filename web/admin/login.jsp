<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 14/05/2020
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Admin Login</title>
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
    <div align="center">
        <h1>Hedspi BookStore Administration</h1>
        <h2>Admin Login</h2>

        <form id="loginForm" action="login" method="post">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email" size="20"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" id="password" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit">Login</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
                password: "required"
            },
            messages: {
                email: {
                    required: "Please enter email",
                    email: "This is not a valid email address"
                },
                password: "Please enter password"
            }
        });
    });
</script>
</html>
