package dao;

import utils.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TaiKhoan;

public class TaiKhoanDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public TaiKhoanDao() {
    }

    // Lay danh sach tai khoan
    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> tk = new ArrayList<>();
        String query = "SELECT * FROM TaiKhoan;";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                tk.add(new TaiKhoan(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return tk;
    }

    // Login
    public TaiKhoan login(String ten_dangnhap, String matkhau) {
        String query = "SELECT * FROM TaiKhoan WHERE ten_dangnhap = ? AND matkhau = ?";
        try {
            conn = connectionDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ten_dangnhap);
            ps.setString(2, matkhau);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new TaiKhoan(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    // Them tai khoan
    public void addTaiKhoan(String ten_dangnhap, String matkhau, String email, String vai_tro, String trang_thai) {
        String query = "INSERT INTO TaiKhoan (ten_dangnhap, matkhau, email, vai_tro, trang_thai) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ten_dangnhap);
            ps.setString(2, matkhau);
            ps.setString(3, email);
            ps.setString(4, vai_tro);
            ps.setString(5, trang_thai);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Xoa tai khoan
    public void deleteTaiKhoan(String id_nguoidung) {
        String query = "DELETE FROM TaiKhoan WHERE id_nguoidung = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id_nguoidung);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Cap nhat tai khoan
    public void updateTaiKhoan(String ten_dangnhap, String matkhau, String email, String vai_tro, String trang_thai, String id_nguoidung) {
        String query = "UPDATE TaiKhoan SET ten_dangnhap = ?, matkhau = ?, email = ?, vai_tro = ?, trang_thai = ? WHERE id_nguoidung = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ten_dangnhap);
            ps.setString(2, matkhau);
            ps.setString(3, email);
            ps.setString(4, vai_tro);
            ps.setString(5, trang_thai);
            ps.setString(6, id_nguoidung);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Lay thong tin tai khoan bang id
    public TaiKhoan getidNguoiDung(int id_nguoidung) {
        String query = "SELECT * FROM TaiKhoan WHERE id_nguoidung = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_nguoidung);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new TaiKhoan(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    // Tim kiem tai khoan bang ten
    public List<TaiKhoan> searchUserByName(String ten_dangnhap) {
        List<TaiKhoan> sp = new ArrayList<>();
        String query = "SELECT * FROM TaiKhoan WHERE ten_dangnhap LIKE ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + ten_dangnhap + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new TaiKhoan(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return sp;
    }

    // Kiem tra username da ton tai
    public boolean usernameExists(String ten_dangnhap) {
        String query = "SELECT * FROM TaiKhoan WHERE ten_dangnhap = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ten_dangnhap);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    // Kiem tra email da ton tai
    public boolean emailExists(String email) {
        String query = "SELECT * FROM TaiKhoan WHERE email = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    // Dong tai nguyen
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
