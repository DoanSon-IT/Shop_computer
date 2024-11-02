<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cập nhật đơn hàng </title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- FontAwesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        <link href="./assets/css/admin.css" rel="stylesheet">
        <link href="./assets/css/update_oder.css" rel="stylesheet">
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

            <div class="content" style="width: 1000px ;padding-left: 300px ;margin-bottom:150px">

                <div class="container">
                    <div class="alert alert-success mt-4" id="successAlert">
                        Order updated successfully.
                    </div>
                    <h2 class="my-4">Update Status Order</h2>
                    <form id="updateOrderForm" action="update_oder" method="post">
                        <div class="form-group mb-3">
                            <label for="id_donhang">Order ID:</label>
                            <input type="text" class="form-control" id="id_donhang" name="id_donhang" value="${dhss.id_donhang}" required>
                        </div>

                        <div class="form-group mb-3">
                            <label for="id_khachhang">Customer ID:</label>
                            <input type="text" class="form-control" id="id_khachhang" name="id_khachhang" value="${dhss.id_khachhang}" required>
                        </div>

                        <div class="form-group mb-3">
                            <label for="id_sanpham">Product ID:</label>
                            <input type="text" class="form-control" id="id_sanpham" name="id_sanpham" value="${dhss.id_sanpham}" required>
                        </div>

                        <div class="form-group mb-3">
                            <label for="so_luong">Quantity:</label>
                            <input type="number" class="form-control" id="so_luong" name="so_luong" value="${dhss.so_luong}" required>
                        </div>

                        <div class="form-group mb-3">
                            <label for="ngay_dat">Order Date:</label>
                            <input type="date" class="form-control" id="ngay_dat" name="ngay_dat" value="${dhss.ngay_dat}" required>
                        </div>

                        <div class="form-group mb-3">
                            <label for="trang_thai">Status:</label>
                            <select class="form-control" id="trang_thai" name="trang_thai" required>
                                <option value="dang_xu_ly" ${dhss.trang_thai == 'dang_xu_ly' ? 'selected' : ''}>Đang xử lý</option>
                                <option value="da_giao" ${dhss.trang_thai == 'da_giao' ? 'selected' : ''}>Đã giao</option>
                                <option value="da_nhan" ${dhss.trang_thai == 'da_nhan' ? 'selected' : ''}>Đã nhận</option>
                                <option value="huy" ${dhss.trang_thai == 'huy' ? 'selected' : ''}>Hủy</option>
                            </select>
                        </div>

                        <div class="form-group mb-3">
                            <label for="hinh_thuc_thanh_toan">Payment Method:</label>
                            <input type="text" class="form-control" id="hinh_thuc_thanh_toan" name="hinh_thuc_thanh_toan" value="${dhss.hinh_thuc_thanh_toan}" required>
                        </div>

                        <div class="form-group mb-3">
                            <label for="tong_tien">Total Amount:</label>
                            <input type="number" class="form-control" id="tong_tien" name="tong_tien" value="${dhss.tong_tien}" required>
                        </div>

                        <button type="button" id="confirmUpdate" class="btn btn-primary">Xác Nhận</button>
                    </form>
                </div>

            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                $('#confirmUpdate').click(function () {
                    if (confirm('Bạn có chắc chắn muốn cập nhật đơn hàng này không?')) {
                        $('#updateOrderForm').submit();
                    }
                });

                // Handle success notification
                let urlParams = new URLSearchParams(window.location.search);
                if (urlParams.has('success') && urlParams.get('success') === 'true') {
                    $('#successAlert').fadeIn().delay(3000).fadeOut();
                }
            });
        </script>

    </body>
</html>
