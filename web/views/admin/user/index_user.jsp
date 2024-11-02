<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controller.login.PasswordEncryption" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản Lý Người Dùng</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- FontAwesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        <link href="./assets/css/admin.css" rel="stylesheet">
        <link href="./assets/css/index_user.css" rel="stylesheet">
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
                            <c:if test="${not empty sessionScope.user}">
                                Hello, ${sessionScope.user.ten_dangnhap}!
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
                    <h1>Danh Sách Người Dùng</h1>
                    <div class="d-flex">
                        <a href="add_user" class="btn btn-primary mr-2">Add</a>
                        <form action="search_user" method="get">
                            <input type="text" id="searchName" class="form-control mr-2"  name="searchName"  placeholder="Tìm kiếm ..."  required>
                            <input hidden type="submit" value="Tìm kiếm">
                        </form>
                    </div>
                </div>
                <div class="table-responsive" style="max-height: 500px; overflow-y: auto; width: 1400px;">
                    <table class="table table-striped table-hover" style="width: 100%;">
                        <thead class="thead-light">
                            <tr> 
                                <th>STT</th>
                                <th hidden>ID</th>
                                <th>UserName</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Vai Trò</th>
                                <th>Trạng Thái</th>
                                <th>Hành Động</th>
                            </tr>
                        </thead>
                        <tbody id="userTable">
                            <c:forEach items="${tkss}" var="x" varStatus="loop"> 
                                <tr>
                                   <td><strong>${loop.index + 1}</strong></td> <!-- Số thứ tự in đậm -->
                                    <th hidden scope="row">${x.id_nguoidung}</th>
                                    <td>${x.ten_dangnhap}</td>
                                    <td>${PasswordEncryption.encryptPassword(x.matkhau)}</td><!-- Mã hóa mật khẩu khi hiển thị -->

                                    <td>${x.email}</td>
                                    <td>${x.vai_tro}</td>
                                    <td>
                                        <label class="switch">
                                            <input readonly type="checkbox"  class="status-toggle" data-id="${x.id_nguoidung}" <c:if test="${x.trang_thai == 'ON'}" >checked</c:if>>
                                                <span class="slider round" ></span>
                                            </label>
                                        </td>
                                        <td>
                                            <button class="btn btn-danger btn-sm delete" data-toggle="modal" data-target="#confirmDeleteModal" data-id="${x.id_nguoidung}">Delete</button>
                                        <button class="btn btn-warning btn-sm edit" data-toggle="modal" data-target="#confirmUpdateModal" data-id="${x.id_nguoidung}">Update</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <p class="text-danger">Lưu ý (*): Vui lòng thao tác cẩn thận</p>
            </div>
        </div>

        <!-- Delete Confirmation Modal -->
        <div class="modal fade" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="confirmDeleteModalLabel">Confirm Delete</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to delete this user?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                        <a href="#" id="deleteConfirmButton" class="btn btn-danger">Yes</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Update Confirmation Modal -->
        <div class="modal fade" id="confirmUpdateModal" tabindex="-1" role="dialog" aria-labelledby="confirmUpdateModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="confirmUpdateModalLabel">Confirm Update</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to update this user?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                        <a href="#" id="updateConfirmButton" class="btn btn-warning">Yes</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                $('.status-toggle').change(function () {
                    var userId = $(this).data('id');
                    var status = $(this).is(':checked') ? 'ON' : 'OFF';

                    $.ajax({
                        url: 'updateStatus',
                        method: 'POST',
                        data: {
                            id: userId,
                            status: status
                        },
                        success: function (response) {
                            alert('Status updated successfully!');
                        },
                        error: function (xhr, status, error) {
                            alert('Error updating status!');
                        }
                    });
                });

                // Handle delete confirmation
                $('#confirmDeleteModal').on('show.bs.modal', function (event) {
                    var button = $(event.relatedTarget);
                    var userId = button.data('id');
                    var modal = $(this);
                    var deleteUrl = 'delete_user?id=' + userId;
                    modal.find('#deleteConfirmButton').attr('href', deleteUrl);
                });

                // Handle update confirmation
                $('#confirmUpdateModal').on('show.bs.modal', function (event) {
                    var button = $(event.relatedTarget);
                    var userId = button.data('id');
                    var modal = $(this);
                    var updateUrl = 'update_user?id=' + userId;
                    modal.find('#updateConfirmButton').attr('href', updateUrl);
                });
            });
        </script>
    </body>
</html>
