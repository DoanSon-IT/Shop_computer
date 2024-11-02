<%-- 
    Document   : update_custommer
    Created on : Jun 12, 2024, 3:42:08 AM
    Author     : hc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cập Nhật Khách Hàng</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- FontAwesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link href="./assets/css/admin.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto align-items-center">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-bell"></i>
                        <span class="badge badge-danger">3</span>
                        Notifications
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-envelope"></i>
                        <span class="badge badge-primary">5</span>
                        Messages
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="./assets/img/imageadmin.jpg" alt="" class="rounded-circle" width="30" height="30">
<!--                    <i class="fas fa-user"></i>  Icon added here -->
                     <%-- Accessing session attributes using JSTL --%>
                     <c:if test="${not empty sessionScope.user}">
                         ${sessionScope.user.ten_dangnhap}!
                         <p hidden>You are logged in as: ${sessionScope.user.email}</p>
                     </c:if>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Profile</a>
                        <a class="dropdown-item" href="#">Settings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="logout">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <div class="d-flex">
        <div class="sidebar bg-light p-3">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="loaddashboard"><i class="fas fa-tachometer-alt"></i> Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="loaduser"><i class="fas fa-users"></i>Quản Lý Tài Khoản</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="loadproduct"><i class="fas fa-boxes"></i> Quản Lý Sản Phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="loadoder"><i class="fas fa-shopping-cart"></i> Quản Lý Đơn Hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="loadcustommer"><i class="fas fa-user"></i> Quản Lý Khách Hàng</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="loadstatistics"><i class="fas fa-chart-bar"></i>Thống Kê</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="loadsetting"><i class="fas fa-cogs"></i> Cài đặt</a>
                </li>
            </ul>
        </div>

        <div class="content">
            <div class="container mt-5">
        <h2 class="mb-4">Cập Nhật Thông Tin Khách Hàng</h2>
        <form  action="update_custommer" method="post">
            <input hidden type="hidden" name="id_khachhang" value="${customer.id_khachhang}" />
            <div  class="form-group">
                <label for="ho_ten">Họ Tên:</label>
                <input type="text" class="form-control" id="ho_ten" name="ho_ten" value="${customer.ho_ten}" readonly >
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${customer.email}" readonly>
            </div>
            <div class="form-group">
                <label for="dia_chi">Địa Chỉ:</label>
                <input type="text" class="form-control" id="dia_chi" name="dia_chi" value="${customer.dia_chi}">
            </div>
            <div class="form-group">
                <label for="so_dien_thoai">Số Điện Thoại:</label>
                <input type="text" class="form-control" id="so_dien_thoai" name="so_dien_thoai" value="${customer.so_dien_thoai}" readonly>
            </div>
            <div hidden class="form-group">
                <label for="id_nguoidung">ID Người Dùng:</label>
                <input type="text" class="form-control" id="id_nguoidung" name="id_nguoidung" value="${customer.id_nguoidung}">
            </div>
            <button type="submit" class="btn btn-primary" >Cập Nhật</button>
            <a href="loadcustommer" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
   
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    
</body>
</html>
