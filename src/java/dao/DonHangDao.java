package dao;

import model.DonHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.connectionDB;

public class DonHangDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public DonHangDao() {
    }
    
   // Lấy danh sách đơn hàng của một người dùng cụ thể
    public List<DonHang> getOrdersByUserId(int id_khachhang) {
        List<DonHang> orders = new ArrayList<>();
        String query = "SELECT * FROM DonHang WHERE id_khachhang = ?";
        try {
            conn = connectionDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_khachhang);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_donhang = rs.getInt("id_donhang");
                int id_sanpham = rs.getInt("id_sanpham");
                int so_luong = rs.getInt("so_luong");
                Date ngay_dat = rs.getDate("ngay_dat");
                String trang_thai = rs.getString("trang_thai");
                String hinh_thuc_thanh_toan = rs.getString("hinh_thuc_thanh_toan");
                float tong_tien = rs.getFloat("tong_tien");

                DonHang order = new DonHang(id_donhang, id_khachhang, id_sanpham, so_luong, ngay_dat, trang_thai, hinh_thuc_thanh_toan, tong_tien);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return orders;
    }

    public DonHang getDonHangById(int id_donhang) {
        DonHang donHang = null;
        String query = "SELECT * FROM DonHang WHERE id_donhang = ?";
        try {
            conn = connectionDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_donhang);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id_khachhang = rs.getInt("id_khachhang");
                int id_sanpham = rs.getInt("id_sanpham");
                int so_luong = rs.getInt("so_luong");
                Date ngay_dat = rs.getDate("ngay_dat");
                String trang_thai = rs.getString("trang_thai");
                String hinh_thuc_thanh_toan = rs.getString("hinh_thuc_thanh_toan");
                float tong_tien = rs.getFloat("tong_tien");

                donHang = new DonHang(id_donhang, id_khachhang, id_sanpham, so_luong, ngay_dat, trang_thai, hinh_thuc_thanh_toan, tong_tien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return donHang;
    }


   
    // Lấy danh sách tất cả đơn hàng
    public List<DonHang> getAllDonHang() {
        List<DonHang> listDonHang = new ArrayList<>();
        String query = "SELECT * FROM DonHang";
        try {
            conn = connectionDB.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_donhang = rs.getInt("id_donhang");
                int id_khachhang = rs.getInt("id_khachhang");
                int id_sanpham = rs.getInt("id_sanpham");
                int so_luong = rs.getInt("so_luong");
                
                Date ngay_dat = rs.getDate("ngay_dat");
                String trang_thai = rs.getString("trang_thai");
                String hinh_thuc_thanh_toan =rs.getString("hinh_thuc_thanh_toan");
                float tong_tien = rs.getFloat("tong_tien");

                DonHang donHang = new DonHang(id_donhang, id_khachhang,id_sanpham,so_luong, ngay_dat, trang_thai,hinh_thuc_thanh_toan, tong_tien);
                listDonHang.add(donHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return listDonHang;
    }

    // Thêm đơn hàng mới
    public void addDonHang(int id_khachhang,int id_sanpham ,int so_luong,Date ngay_dat, String trang_thai,String hinh_thuc_thanh_toan, float tong_tien) {
        String query = "INSERT INTO DonHang (id_khachhang,id_sanpham,so_luong, ngay_dat, trang_thai,hinh_thuc_thanh_toan, tong_tien) VALUES (?, ?, ?, ?,?,?,?)";
        try {
            conn = connectionDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_khachhang);
             ps.setInt(2, id_sanpham);
              ps.setInt(3, so_luong);
      
            ps.setDate(4, new java.sql.Date(ngay_dat.getTime()));
            ps.setString(5, trang_thai);
             ps.setString(6, hinh_thuc_thanh_toan);
            
            ps.setFloat(7, tong_tien);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Xóa đơn hàng theo id_donhang
   public boolean deleteOrder(int id_donhang) {
    String query = "DELETE FROM DonHang WHERE id_donhang = ? AND trang_thai = 'dang_xu_ly'";
    try {
        conn = connectionDB.getConnection();
        ps = conn.prepareStatement(query);
        ps.setInt(1, id_donhang);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0; // Return true if at least one row was deleted
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        closeResources();
    }
}


    // Cập nhật thông tin đơn hàng
 public void updateDonHang(int id_khachhang, int id_sanpham, int so_luong, Date ngay_dat, String trang_thai, String hinh_thuc_thanh_toan, float tong_tien, int id_donhang) {
        String query = "UPDATE DonHang SET id_khachhang = ?, id_sanpham = ?, so_luong = ?, ngay_dat = ?, trang_thai = ?, hinh_thuc_thanh_toan = ?, tong_tien = ? WHERE id_donhang = ?";
        PreparedStatement ps = null;
        
        try {
            // Get the database connection
            conn = connectionDB.getConnection();
            
            // Prepare the statement
            ps = conn.prepareStatement(query);
            
            // Set the parameters
            ps.setInt(1, id_khachhang);
            ps.setInt(2, id_sanpham);
            ps.setInt(3, so_luong);
            ps.setDate(4, new java.sql.Date(ngay_dat.getTime()));
            ps.setString(5, trang_thai);
            ps.setString(6, hinh_thuc_thanh_toan);
            ps.setFloat(7, tong_tien);
            ps.setInt(8, id_donhang);
            
            // Execute the update
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 

    // Tìm kiếm đơn hàng theo id_donhang
//    public DonHang getDonHangById(int id_donhang) {
//        String query = "SELECT * FROM DonHang WHERE id_donhang = ?";
//        try {
//            conn = connectionDB.getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, id_donhang);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                int id_khachhang = rs.getInt("id_khachhang");
//                Date ngay_dat = rs.getDate("ngay_dat");
//                String trang_thai = rs.getString("trang_thai");
//                float tong_tien = rs.getFloat("tong_tien");
//
//                return new DonHang(id_donhang, id_khachhang, ngay_dat, trang_thai, tong_tien);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeResources();
//        }
//        return null;
//    }

    // Đóng tất cả các resource (ResultSet, PreparedStatement, Connection)
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
