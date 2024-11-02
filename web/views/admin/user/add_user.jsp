<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Người Dùng</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- FontAwesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link href="./assets/css/add_user.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">More account</h2>
        <form action="add_user" method="post">
            <div class="form-group">
                <label for="ten_dangnhap">Username</label>
                <input type="text" class="form-control" id="ten_dangnhap" name="ten_dangnhap" required>
            </div>
            <div class="form-group password-toggle">
                <label for="matkhau">Password</label>
                <input type="password" class="form-control" id="matkhau" name="matkhau"  required>
                <i class="fas fa-eye toggle-password" onclick="togglePasswordVisibility()"></i>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="vai_tro">Vai Trò</label>
                <select class="form-control" id="vai_tro" name="vai_tro" required>
                    <option value="admin">Admin</option>
                    <option value="Nhân Viên">Nhân Viên</option>
                </select>
            </div>
            <div hidden class="form-group">
                <label for="trang_thai">Trạng Thái</label>
                <input type="text" class="form-control" id="trang_thai" name="trang_thai" value="ON" required>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
            <a href="loaduser" class="btn btn-secondary">Cancel</a>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
<script>
        function togglePasswordVisibility() {
            var passwordInput = document.getElementById('matkhau');
            var toggleIcon = document.querySelector('.toggle-password');
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                toggleIcon.classList.remove('fa-eye');
                toggleIcon.classList.add('fa-eye-slash');
            } else {
                passwordInput.type = 'password';
                toggleIcon.classList.remove('fa-eye-slash');
                toggleIcon.classList.add('fa-eye');
            }
        }
    </script>
</html>
