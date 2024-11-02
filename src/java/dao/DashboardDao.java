/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DonHang;
import utils.connectionDB;
/**
 *
 * @author hc
 */



public class DashboardDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    // Method to get total users count
   

   

   

    // Method to get recent orders
    public List<DonHang> getRecentOrders() {
        List<DonHang> orders = new ArrayList<>();
        String query = "SELECT * FROM DonHang ORDER BY ngay_dat DESC LIMIT 10";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                DonHang order = new DonHang(
                        rs.getInt("id_donhang"),
                        rs.getInt("id_khachhang"),
                        rs.getInt("id_sanpham"),
                         rs.getInt("so_luong"),
                        
                        rs.getDate("ngay_dat"),
                        rs.getString("trang_thai"),
                         rs.getString("hinh_thuc_thanh_toan"),
                        
                        rs.getFloat("tong_tien")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return orders;
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
