package dao;

import utils.connectionDB;
import model.KhachHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Customers.
 */
public class KhachHangDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public KhachHangDao() {
    }
    // lay tat ca khach hang
    public List<KhachHang> getAllCustomers() {
        List<KhachHang> customers = new ArrayList<>();
        String query = "SELECT * FROM KhachHang;";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                customers.add(new KhachHang(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return customers;
    }
    
    // kiem tra khach hang ton tai chua
    public boolean customerExists(int id_nguoidung) {
    String query = "SELECT COUNT(*) FROM KhachHang WHERE id_nguoidung = ?";
    try {
        conn = new connectionDB().getConnection();
        ps = conn.prepareStatement(query);
        ps.setInt(1, id_nguoidung);
        ResultSet rs = ps.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeResources();
    }
    return false;
}


     // add
    
    public boolean addCustomer(int id_khachhang,String ho_ten, String email, String dia_chi, int so_dien_thoai,int id_nguoidung) {
        String query = "INSERT INTO KhachHang (id_khachhang,ho_ten, email, dia_chi, so_dien_thoai , id_nguoidung) VALUES (?, ?, ?, ?,?,?)";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_khachhang);
            ps.setString(2, ho_ten);
            ps.setString(3, email);
            ps.setString(4, dia_chi);
            ps.setInt(5, so_dien_thoai);
            ps.setInt(6, id_nguoidung);
            ps.executeUpdate();
         return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //delete
    public void deleteCustomer(String id_khachhang) {
        String query = "DELETE FROM KhachHang WHERE id_khachhang = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id_khachhang);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    public String getTenKHById(int id_khachhang) {
        String ho_ten = null;
        String query = "SELECT ho_ten FROM KhachHang WHERE id_khachhang = ?";
        try {
            conn = connectionDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_khachhang);
            rs = ps.executeQuery();
            if (rs.next()) {
                ho_ten = rs.getString("ho_ten");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ho_ten;
    }
// lay 1 khach hang
    public KhachHang getCustomerById(int id_khachhang) {
        String query = "SELECT * FROM KhachHang WHERE id_khachhang = ?";
        KhachHang khachHang = null;
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_khachhang);
            rs = ps.executeQuery();
            if (rs.next()) {
                khachHang = new KhachHang(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return khachHang;
    }

   //update khach hang
    public void updateCustomer(int id_khachhang, String ho_ten, String email, String dia_chi, int so_dien_thoai ,int id_nguoidung) {
        String query = "UPDATE KhachHang SET ho_ten = ?, email = ?, dia_chi = ?, so_dien_thoai = ? , id_nguoidung = ? WHERE id_khachhang = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ho_ten);
            ps.setString(2, email);
            ps.setString(3, dia_chi);
            ps.setInt(4, so_dien_thoai);
            ps.setInt(5, id_khachhang);
            ps.setInt(6, id_nguoidung);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // tim kiem khach hang
    public List<KhachHang> searchCustomersByName(String ho_ten) {
        List<KhachHang> customers = new ArrayList<>();
        String query = "SELECT * FROM KhachHang WHERE ho_ten LIKE ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + ho_ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                customers.add(new KhachHang(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return customers;
    }

    /**
     * Closes all open resources (Connection, PreparedStatement, ResultSet).
     */
    
    
    
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
