<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pie Chart Example</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <div style="width: 400px;">
        <canvas id="myPieChart"></canvas>
    </div>
 
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
