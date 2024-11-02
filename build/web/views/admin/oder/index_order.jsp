<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản Lý Đơn Hàng</title>
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
                            <!--                    <i class="fas fa-user"></i>  -->
                            <%-- Accessing session attributes using JSTL --%>
                            <c:if test="${not empty sessionScope.user}">
                                Hello ,${sessionScope.user.ten_dangnhap}!
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
                        <a class="nav-link " href="loadproduct"><i class="fas fa-boxes"></i> Quản Lý Sản Phẩm</a>
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
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h1>Danh Sách Đơn Hàng</h1>
                    <div class="d-flex">
                        <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search">
                    </div>
                </div>
                <div class="table-responsive" style="max-height: 500px; overflow-y: auto; width: 1400px;">
                    <table class="table table-striped table-hover" style="width: 100%;">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">ID Đơn Hàng</th>
                                <th scope="col">Khách Hàng</th>
                                <th scope="col">Sản Phẩm</th>
                                <th scope="col">Số Lượng</th>
                                <th scope="col">Ngày Đặt</th>

                                <th scope="col">Trạng Thái</th>
                                <th scope="col">Hình Thức Thanh Toán</th>
                                <th scope="col">Tổng Tiền</th>
                                <th scope="col">Hành Động</th>

                            </tr>
                        </thead>
                        <tbody id="orderTable">
                            <c:forEach items="${listDonHangs}" var="order" varStatus="loop">
                                <tr>
                                    <td><strong>${loop.index + 1}</strong></td>
                                    <th scope="row">${order.id_donhang}</th>
                                    <td hidden>${order.id_khachhang}</td>
                                    <td>${order.ho_ten}</td>
                                    <td hidden>${order.id_sanpham}</td>
                                    <td><img src="./assets/img/${order.link_anh}" alt="Product Image" class="product-image"></td>
                                    <td>${order.so_luong}</td>
                                    <td>${order.ngay_dat}</td>
                                    <td>${order.trang_thai}</td>
                                    <td>${order.hinh_thuc_thanh_toan}</td>

                                    <td>${order.tong_tien}</td>

                                    <td>
                                        <button hidden class="btn btn-danger btn-sm delete">Delete</button>
                                        <button class="btn btn-warning btn-sm edit"><a href="update_oder?id=${order.id_donhang}">Update</button>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <p class="text-danger">Lưu ý (*): Vui lòng thao tác cẩn thận</p>
            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

    </body>
</html>
