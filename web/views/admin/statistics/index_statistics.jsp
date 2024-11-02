<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thống Kê</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- FontAwesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        <!-- Chart.js CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.css" rel="stylesheet">
        <link href="./assets/css/admin.css" rel="stylesheet">
    </head>
    <body>
        <script>
            // JavaScript to get the message from the URL and display it (if any)
            window.onload = function () {
                var urlParams = new URLSearchParams(window.location.search);
                var message = urlParams.get('message');

                if (message) {
                    alert(decodeURIComponent(message));
                }
            };
        </script>
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

            <div class="content p-4">
                <div class="d-flex justify-content-between align-items-center mb-4">
                    <h1>Thống Kê</h1>
                </div>

                <!-- Dashboard metrics -->
                <div class="row mb-4">
                    <div class="col-md-3">
                        <div class="card text-white bg-primary mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Total Users</h5>
                                <p class="card-text">${totalUsers}</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card text-white bg-success mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Total Sales</h5>
                                <p class="card-text">$${totalSales}</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card text-white bg-warning mb-3">
                            <div class="card-body">
                                <h5 class="card-title">New Orders</h5>
                                <p class="card-text">${newOrders}</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card text-white bg-danger mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Pending Iss</h5>
                                <p class="card-text">${pendingIssues}</p> 
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card text-white bg-warning mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Total Products</h5>
                                <p class="card-text">${totalProductss}</p> 
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card text-white bg-warning mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Received Oder</h5>
                                <p class="card-text">${receivedOders}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
       <div class="container mt-5">
    <div class="row">
        <!-- Cột cho biểu đồ thứ nhất -->
        <div class="col-md-6">
            <div style="width: 100%; height: 300px;">
                <h1 class="text-center">Monthly Orders</h1>
                <canvas id="monthlyOrdersChart"></canvas>
            </div>
        </div>
        
        <!-- Cột cho biểu đồ thứ hai -->
        <div class="col-md-6">
            <div style="width: 70%; height: 200px;">
                <canvas id="myPieChart"></canvas>
            </div>
        </div>
   
</div>
</div>

        

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <!-- Chart.js JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"></script>

        <script>
                $(document).ready(function () {
                    var ctx = document.getElementById('monthlyOrdersChart').getContext('2d');
                    var monthlyOrdersChart = new Chart(ctx, {
                        type: 'bar',
                        data: {
                            labels: [<c:forEach var="entry" items="${monthlyOrders}">${entry.key}, </c:forEach>],
                            datasets: [{
                                    label: 'Total Orders',
                                    data: [<c:forEach var="entry" items="${monthlyOrders}">${entry.value}, </c:forEach>],
                                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                                    borderColor: 'rgba(54, 162, 235, 1)',
                                    borderWidth: 1
                                }]
                        },
                        options: {
                            scales: {
                                y: {
                                    beginAtZero: true
                                }
                            }
                        }
                    });
                });
        </script>
        <script>
        // Dữ liệu từ servlet
        var pieData = {
            labels: [
                <% // Loop through orderStatusCounts keys to generate labels %>
                <% for (String status : ((Map<String, Integer>) request.getAttribute("orderStatusCounts")).keySet()) { %>
                    '<%= status %>',
                <% } %>
            ],
            datasets: [{
                label: 'Trạng thái đơn hàng',
                data: [
                    <% // Loop through orderStatusCounts values to generate data points %>
                    <% for (Integer count : ((Map<String, Integer>) request.getAttribute("orderStatusCounts")).values()) { %>
                        <%= count %>,
                    <% } %>
                ],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.8)',
                    'rgba(54, 162, 235, 0.8)',
                    'rgba(255, 205, 86, 0.8)',
                    'rgba(75, 192, 192, 0.8)'
                ],
                borderWidth: 1
            }]
        };

        // Lấy context của canvas và vẽ biểu đồ tròn
        var ctx = document.getElementById('myPieChart').getContext('2d');
        var myPieChart = new Chart(ctx, {
            type: 'pie',
            data: pieData,
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    tooltip: {
                        callbacks: {
                            label: function(tooltipItem) {
                                return tooltipItem.label + ': ' + tooltipItem.formattedValue + ' đơn hàng';
                            }
                        }
                    }
                }
            }
        });
    </script>

    </body>
</html>
