<%-- 
    Document   : customerInformation
    Created on : Jun 17, 2024, 12:52:42 AM
    Author     : hc
--%>
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
        <!-- bootstrap links -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!-- bootstrap links -->
        <!-- fonts links -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Merriweather&display=swap" rel="stylesheet">
        <!-- fonts links -->
        <style>
            .table-responsive {
                overflow-x: auto; /* Ensure table content doesn't overflow */
            }

            .ab li a {
                color: black !important; /* Set text color to black */
                transition: 0.5s ease;
            }

            .ab li a:hover {
                background-color: rgb(67 0 86);
                color: #ffc800 !important; /* Optional: Set hover text color */
            }

            .product-image {
                width: 50px;
                height: 50px;
                object-fit: cover;
            }

            .cancel-button {
                background-color: red;
                color: white;
                border: none;
                padding: 5px 10px;
                cursor: pointer;
                border-radius: 5px;
            }

            .cancel-button:hover {
                background-color: darkred;
            }

            .btn-back a {
                margin-top: 20px;
                display: inline-block;
            }

            .customer-details {
                margin: 20px auto;
                max-width: 600px;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 10px;
            }

            /* Modal CSS */
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgb(0, 0, 0);
                background-color: rgba(0, 0, 0, 0.4);
                padding-top: 60px;
            }

            .modal-content {
                background-color: #fefefe;
                margin: 5% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
                max-width: 600px;
                border-radius: 10px;
                position: relative;
            }

            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
                position: absolute;
                right: 10px;
                top: 10px;
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
                            <a class="nav-link" href="contact.html">Contact</a>
                        </li>
                    </ul>
                    <form class="d-flex" id="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- navbar -->

        <div class="container">
            <div class="customer-details">
                <h2>Thông Tin Khách Hàng</h2>
                <c:if test="${not empty khachHang}">
                    <p hidden><strong>ID:</strong> ${khachHang.id_khachhang}</p>
                    <p><strong>Name:</strong> ${khachHang.ho_ten}</p>
                    <p><strong>Email:</strong> ${khachHang.email}</p>
                    <p><strong>Phone:</strong> ${khachHang.so_dien_thoai}</p>
                    <p><strong>Address:</strong> ${khachHang.dia_chi}</p>
                    <button class="btn btn-warning" onclick="toggleUpdateForm()">Update</button>
                </c:if>
                <c:if test="${empty khachHang}">
                    <p>No customer found with the provided ID.</p>
                </c:if>
            </div>

            <div id="updateForm" class="modal">
                <div class="modal-content">
                    <span class="close" onclick="toggleUpdateForm()">&times;</span>
                    <form action="update_information_custommerServlet" method="post">
                        <input type="hidden" name="id_khachhang" value="${khachHang.id_khachhang}">
                        <div class="mb-3">
                            <label for="ho_ten" class="form-label">Name</label>
                            <input type="text" class="form-control" id="ho_ten" name="ho_ten" value="${khachHang.ho_ten}" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="${khachHang.email}" required>
                        </div>
                        <div class="mb-3">
                            <label for="so_dien_thoai" class="form-label">Phone</label>
                            <input type="text" class="form-control" id="so_dien_thoai" name="so_dien_thoai" value="${khachHang.so_dien_thoai}" required>
                        </div>
                        <div class="mb-3">
                            <label for="dia_chi" class="form-label">Address</label>
                            <input type="text" class="form-control" id="dia_chi" name="dia_chi" value="${khachHang.dia_chi}" required>
                        </div>
                        <button type="submit" class="btn btn-success">Update</button>
                        <button type="button" class="btn btn-secondary" onclick="toggleUpdateForm()">Cancel</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- footer -->
        <footer id="footer">
            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 footer-contact">
                            <h3>Computer Shop</h3>
                            <p>
                                Karachi <br>
                                Sindh <br>
                                Pakistan <br>
                            </p>
                            <strong>Phone:</strong> +84867127278 <br>
                            <strong>Email:</strong> computershop@.com <br>
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
                    </div>0
                </div>
            </div>
            <hr>
            <div class="container py-4">
                <div class="copyright">
                    &copy; Copyright <strong><span>Computer Shop</span></strong>. All Rights Reserved
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
            function toggleUpdateForm() {
                var updateForm = document.getElementById("updateForm");
                if (updateForm.style.display === "none" || updateForm.style.display === "") {
                    updateForm.style.display = "block";
                } else {
                    updateForm.style.display = "none";
                }
            }
        </script>
    </body>
</html>
