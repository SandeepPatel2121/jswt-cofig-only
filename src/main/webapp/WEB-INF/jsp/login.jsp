<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="${pageContext.request.contextPath}/login">
            <table>
                <th><h1>Welcome Back !</h1></th>
                <tr>
                    <td>Username
                    <td><input type="text" name="username"/>
                </tr>
                <tr>
                    <td>Password
                    <td><input type="password" name="password"/>
                </tr>
                <tr>
                    <td colspan="2"><a href="#">Forgot Password?</a>
                </tr>
                <tr>
                    <td colspan="2"><button class="button"/>Log In</button>
                </tr>
            </table>
        </form>
        <h1>${SPRING_SECURITY_LAST_EXCEPTION.message}</h1>
    </body>
</html>
