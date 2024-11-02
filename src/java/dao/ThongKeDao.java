/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import utils.connectionDB;

/**
 *
 * @author hc
 */
public class ThongKeDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    
    
    
    
     // Method to get count of new orders
    public int getNewOrders() {
        String query = "SELECT COUNT(*) AS new_orders FROM DonHang WHERE trang_thai = 'dang_xu_ly'";
        int newOrders = 0;
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                newOrders = rs.getInt("new_orders");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return newOrders;
    }
    
       // Method to get count of received orders
    public int getReceivedOrders() {
        String query = "SELECT COUNT(*) AS received_orders FROM DonHang WHERE trang_thai = 'da_nhan'";
        int newOrders = 0;
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                newOrders = rs.getInt("received_orders");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return newOrders;
    }
    
    //dem so tai khoan
     public int getTotalUsers() {
        String query = "SELECT COUNT(*) AS total_users FROM TaiKhoan";
        int totalUsers = 0;
        try {
            conn =new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalUsers = rs.getInt("total_users");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return totalUsers;
    }

    // Method to get total sales amount
    public double getTotalSales() {
        String query = "SELECT SUM(tong_tien) AS total_sales FROM DonHang WHERE trang_thai = 'da_nhan'";
        double totalSales = 0.0;
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalSales = rs.getDouble("total_sales");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return totalSales;
    }
     // Method to get count of pending issues
    public int getPendingIssues() {
        String query = "SELECT COUNT(*) AS pending_issues FROM DonHang WHERE trang_thai = 'huy'";
        int pendingIssues = 0;
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                pendingIssues = rs.getInt("pending_issues");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return pendingIssues;
    }
    
    // dem so luong san pham
    public int getTotalProducts() {
    String query = "SELECT COUNT(id_sanpham) AS total_products FROM SanPham";
    int totalProducts = 0;
    try {
        conn = new connectionDB().getConnection();
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        if (rs.next()) {
            totalProducts = rs.getInt("total_products");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeResources();
    }
    return totalProducts;
}
    // thong ke don hang theo tung tháng
  public Map<String, Integer> getMonthlyOrders() {
        String query = "SELECT MONTH(ngay_dat) AS month, COUNT(*) AS total_orders FROM DonHang GROUP BY MONTH(ngay_dat)";
        Map<String, Integer> monthlyOrders = new HashMap<>();
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String month = rs.getString("month");
                int totalOrders = rs.getInt("total_orders");
                monthlyOrders.put(month, totalOrders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return monthlyOrders;
    }
  
   // Method to get count of orders by status
    public Map<String, Integer> getOrderStatusCounts() {
        String query = "SELECT trang_thai, COUNT(*) AS count FROM DonHang GROUP BY trang_thai";
        Map<String, Integer> orderStatusCounts = new HashMap<>();
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String status = rs.getString("trang_thai");
                int count = rs.getInt("count");
                orderStatusCounts.put(status, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return orderStatusCounts;
    }
    
     // Method to get revenue by month where order status is 'da_nhan'
    public Map<Integer, Double> getRevenueByMonth() {
        String query = "SELECT MONTH(ngay_dat) AS thang, SUM(tong_tien) AS doanh_thu " +
                       "FROM DonHang " +
                       "WHERE trang_thai = 'da_nhan' " +
                       "GROUP BY MONTH(ngay_dat)";
        
        Map<Integer, Double> revenueByMonth = new HashMap<>();
        
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int month = rs.getInt("thang");
                double revenue = rs.getDouble("doanh_thu");
                revenueByMonth.put(month, revenue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        
        return revenueByMonth;
    }
    
     
  
    // Method to close resources
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}
