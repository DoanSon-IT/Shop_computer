<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Electronic Shop</title>
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Merriweather&display=swap" rel="stylesheet">
        <style>
            .ab li a {
                color: black !important; /* Set text color to black */
                transition: 0.5s ease;
            }

            .ab li a:hover {
                background-color: rgb(67 0 86);
                color: #ffc800 !important; /* Optional: Set hover text color */
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px; /* Thêm khoảng cách giữa navbar và bảng */
            }
            table th, table td {
                padding: 12px; /* Tăng padding để dễ đọc hơn */
                text-align: center; /* Căn giữa nội dung */
            }
            table th {
                background-color: #f2f2f2; /* Màu nền cho header */
            }
            .cart-item img {
                max-width: 80px; /* Giảm kích thước hình ảnh */
                height: auto;
                border-radius: 5px; /* Bo tròn các hình ảnh */
            }
            .cart-total {
                font-size: 18px; /* Tăng kích thước font cho tổng cộng */
                font-weight: bold;
                padding-top: 10px; /* Khoảng cách với các nội dung khác */
            }
            .table-bordered {
                border-collapse: collapse;
            }

            .table-bordered th,
            .table-bordered td {
                border: none; /* Loại bỏ border */
                border-bottom: 1px solid #dee2e6; /* Thêm border phía dưới */
            }

            .table-bordered thead th {
                border-bottom: 2px solid #dee2e6; /* Border dày hơn ở header */
            }

            /* Style for the modal form */
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgb(0,0,0);
                background-color: rgba(0,0,0,0.4);
                padding-top: 60px;
            }

            .modal-content {
                background-color: #fefefe;
                margin: 5% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
                max-width: 500px;
                border-radius: 5px;
            }

            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <!-- top navbar -->
        <div class="top-navbar d-flex justify-content-between align-items-center">
            <p>WELCOME TO COMPUTER SHOP</p>
            <div class="icons d-flex align-items-center">
                <a href="CartServlet?sid=${sessionScope.user.id_nguoidung}" class="me-3"><img src="./assets/img/OIP.jpg" alt="User Avatar" width="30" height="30" style="border-radius: 50%;"> </i> Cart</a>
                <div class="dropdown">
                    <a class="dropdown-toggle" href="#" role="button" id="accountDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="./assets/img/th.jpg" alt="User Avatar" width="30" height="30" style="border-radius: 50%;">
                        <c:if test="${not empty sessionScope.user}">
                            ${sessionScope.user.ten_dangnhap}!
                            <p hidden>You are logged in as: ${sessionScope.user.email}</p>
                        </c:if>
                    </a>
                    <ul class="dropdown-menu ab" aria-labelledby="accountDropdown">
                        <li><a class="dropdown-item" href="loadlogin">Login</a></li>
                        <li><a class="dropdown-item" href="dangkyServlet">Register</a></li>
                        <li><a class="dropdown-item" href="customerInformationServlet?sid=${sessionScope.user.id_nguoidung}">Profile</a></li>
                        <li><a class="dropdown-item" href="OderServlet?sid=${sessionScope.user.id_nguoidung}">Orders</a></li>
                        <li><a class="dropdown-item" href="logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- top navbar -->

        <!-- navbar -->
        <nav class="navbar navbar-expand-lg" id="navbar">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.html" id="logo"><span id="span1">C</span>omputer <span>Shop</span></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span><img src="./assets/img/OIG2.jpg" alt="" width="30px"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="loadhome">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Product</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Category
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="background-color: rgb(67 0 86);">
                                <li><a class="dropdown-item" href="#">LapTop Dell</a></li>
                                <li><a class="dropdown-item" href="#">Mac</a></li>
                                <li><a class="dropdown-item" href="#">HP </a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.html">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact.html">Contact</a></li>
                    </ul>
                    <form class="d-flex" id="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- navbar -->

        <div class="container mt-4">
            <h2 class="my-4">Giỏ Hàng</h2>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead class="table-light">
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Hình Ảnh</th>
                            <th hidden scope="col">Tên Sản Phẩm</th>
                            <th scope="col">Đơn Giá</th>
                            <th scope="col">Số Lượng</th>
                            <th scope="col">Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${cartItems}" var="item" varStatus="loop">
                            <tr class="cart-item">
                                <td><strong>${loop.index + 1}</strong></td>
                                <td><img src="./assets/img/${item.link_anh}" alt="${item.id_sanpham}" class="img-fluid"></td>
                                <td hidden>${item.id_sanpham}</td>
                                <td>${item.gia}$</td>
                                <td>
                                    <input type="number" class="form-control quantity-input" value="${item.so_luong}" min="1" data-price="${item.gia}" style="width: 100px">
                                    <input type="hidden" name="idNguoiDung" value="${sessionScope.user.id_nguoidung}">
                                </td>
                                <td>
                                    <div class="text-end">
                                        <a href="delete_Cart?id=${item.id_cart}&id_nguoidung=${sessionScope.user.id_nguoidung}" class="btn btn-outline-secondary btn-sm">Xóa</a>
                                    </div>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div colspan="4" class="text-end cart-total">
                    <!--                    Ngày: 13 Jun 2024<br>
                                        <div class="dropdown-divider"></div>
                                        Phí Vận Chuyển: 10$<br>
                                        <div class="dropdown-divider"></div>
                                        Phí Vật Lý: 5$<br>
                                        <div class="dropdown-divider"></div>
                                        Mã giảm giá: ABC123 (5%)<br>
                                        <div class="dropdown-divider"></div>-->
                    Tổng Cộng: <span id="total-price">0$</span><br>
                </div>
                <c:if test="${empty cartItems}">
                    <p> giỏ hàng của bạn chưa có gì !.</p>
                </c:if>
            </div>
            <% 
              Boolean customerExists = (Boolean) session.getAttribute("customerExists");
                    if (customerExists == null) {
                        customerExists = false;
             }
            %>

            <div class="text-end mt-4">
                <a href="" class="btn btn-outline-secondary me-2">Đóng</a>
                <button id="checkoutBtn" class="btn btn-primary">Thanh Toán</button>
            </div>
        </div>

        <!-- Customer Information Modal -->
        <div id="customerModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h2>Thông Tin Khách Hàng</h2>
                <form id="orderForm" action="AddKhachHangServlet" method="post">
                    <%
                        if (!customerExists) {
                    %>

                    <div class="mb-3">
                        <label for="ho_ten" class="form-label">Tên Khách Hàng</label>
                        <input type="text" class="form-control" id="ho_ten" name="ho_ten" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="so_dien_thoai" class="form-label">Số Điện Thoại</label>
                        <input type="tel" class="form-control" id="so_dien_thoai" name="so_dien_thoai" required>
                    </div>
                    <div class="mb-3">
                        <label for="dia_chi" class="form-label">Địa Chỉ</label>
                        <input type="text" class="form-control" id="dia_chi" name="dia_chi" required>
                    </div>
                    <% 
                        } 
                    %>
                    <div class="mb-3">
                        <label for="hinh_thuc_thanh_toan" class="form-label">Phương Thức Thanh Toán</label>
                        <select class="form-control" id="hinh_thuc_thanh_toan" name="hinh_thuc_thanh_toan" required>
                            <option value="trả tiền khi nhận hàng">Tiền Mặt</option>

                            <option value="momo">Chuyển Khoản Ngân Hàng MOMO</option>

                        </select>
                    </div>
                    <input type="hidden" id="id_nguoidung" value="${sessionScope.user.id_nguoidung}" name="id_nguoidung">
                    <input type="hidden" id="customerExists" value="<%= customerExists %>" name="customerExists">
                    <div id="orderItemsContainer"></div>
                    <button type="submit" class="btn btn-primary">Xác Nhận</button>
                </form>
            </div>
        </div>





        <!-- footer -->
        <footer id="footer">
            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 footer-contact">
                            <h3>Electronic Shop</h3>
                            <p>
                                Karachi <br>
                                Sindh <br>
                                Pakistan <br>
                            </p>
                            <strong>Phone:</strong> +000000000000000 <br>
                            <strong>Email:</strong> electronicshop@.com <br>
                        </div>
                        <div class="col-lg-3 col-md-6 footer-links">
                            <h4>Useful Links</h4>
                            <ul>
                                <li><a href="#">Home</a></li>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Services</a></li>
                                <li><a href="#">Terms of service</a></li>
                                <li><a href="#">Privacy policy</a></li>
                            </ul>
                        </div>
                        <div class="col-lg-3 col-md-6 footer-links">
                            <h4>Our Services</h4>
                            <ul>
                                <li><a href="#">PS 5</a></li>
                                <li><a href="#">Computer</a></li>
                                <li><a href="#">Gaming Laptop</a></li>
                                <li><a href="#">Mobile Phone</a></li>
                                <li><a href="#">Gaming Gadget</a></li>
                            </ul>
                        </div>
                        <div class="col-lg-3 col-md-6 footer-links">
                            <h4>Our Social Networks</h4>
                            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quia, quibusdam.</p>
                            <div class="social-links mt-3">
                                <a href="#"><i class="fa-brands fa-twitter"></i></a>
                                <a href="#"><i class="fa-brands fa-facebook-f"></i></a>
                                <a href="#"><i class="fa-brands fa-instagram"></i></a>
                                <a href="#"><i class="fa-brands fa-skype"></i></a>
                                <a href="#"><i class="fa-brands fa-linkedin"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="container py-4">
                <div class="copyright">
                    &copy; Copyright <strong><span>Electronic Shop</span></strong>. All Rights Reserved
                </div>
                <div class="credits">
                    Designed by <a href="#">SA coding</a>
                </div>
            </div>
        </footer>
        <!-- footer -->

        <a href="#" class="arrow"><i><img src="./images/arrow.png" alt=""></i></a>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var quantityInputs = document.querySelectorAll('.quantity-input');
                var totalElement = document.getElementById('total-price');

                // Tính tổng tiền ban đầu
                calculateTotal();

                // Bắt sự kiện khi thay đổi số lượng
                quantityInputs.forEach(function (input) {
                    input.addEventListener('input', function () {
                        calculateTotal();
                    });
                });
                // Hàm tính tổng tiền
                function calculateTotal() {
                    var total = 0;
                    quantityInputs.forEach(function (input) {
                        var price = parseFloat(input.getAttribute('data-price'));
                        var quantity = parseInt(input.value);
                        if (!isNaN(price) && !isNaN(quantity)) {
                            total += price * quantity;
                        }
                    });
                    totalElement.textContent = total.toFixed(2) + '$';
                }

                // Modal handling
                var modal = document.getElementById('customerModal');
                var btn = document.getElementById('checkoutBtn');
                var span = document.getElementsByClassName('close')[0];

                btn.onclick = function () {
                    modal.style.display = 'block';
                }

                span.onclick = function () {
                    modal.style.display = 'none';
                }

                window.onclick = function (event) {
                    if (event.target == modal) {
                        modal.style.display = 'none';
                    }
                }
            });

        </script>
    </body>
</html>
