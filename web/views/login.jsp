<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Authentication Page</title>
    <link rel="stylesheet" href="./assets/css/login.css">
    <style>
        .error-message {
            color: red;
            font-weight: bold;
        }
        body{
           background: url('./assets/img/login1.jpg') no-repeat center center fixed;
           background-size: cover;
        }
    </style>
    
</head>
<body>
    <div class="auth-container">
        <form class="auth-form" id="login-form" method="post" action="loadlogin">
            <h2>Login</h2>
            <c:if test="${not empty errorMessage}">
                <div class="error-message">${errorMessage}</div>
            </c:if>
            <div class="form-group">
                <label for="login-username">Username</label>
                <input type="text" id="login-username" name="login-username" placeholder="Enter your username" required>
            </div>
            <div class="form-group">
                <label for="login-password">Password</label>
                <input type="password" id="login-password" name="login-password" placeholder="Enter your password" required>
            </div>
            <div class="form-group remember-me">
                <input type="checkbox" id="remember-me" name="remember-me">
                <label for="remember-me">Remember Me</label>
            </div>
            <div class="form-group">
                <a href="#" class="forgot-password">Forget Password?</a>
            </div>
            <button type="submit" class="auth-button">Log In</button>
            <div class="form-group switch-form">
                <p>Don't have an account? <a href="dangkyServlet">Register</a></p>
            </div>
        </form>
    </div>
</body>

</html>
