/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import utils.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author hc
 */
public class ProductDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProductDao() {
    }
    //    getAllProduct
    public List<Product> getAllProduct() {
        List<Product> sp = new ArrayList<>();
        String query = "SELECT * FROM SanPham;";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }
    
    
    // Lấy đường dẫn ảnh từ id_sanpham
    public String getAnhSanPhamById(int id_sanpham) {
        String link_anh = null;
        String query = "SELECT link_anh FROM SanPham WHERE id_sanpham = ?";
        try {
            conn = connectionDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_sanpham);
            rs = ps.executeQuery();
            if (rs.next()) {
                link_anh = rs.getString("link_anh");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return link_anh;
    }
    //lấy sản phẩm mới
    public List<Product> getNewProduct() {
        List<Product> sp = new ArrayList<>();
        String query = "SELECT * \n"
                + "FROM SanPham \n"
                + "ORDER BY id_sanpham DESC \n"
                + "LIMIT 20;;";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }
    // san pham dat nhat
     public List<Product> getExpensiveProduct() {
        List<Product> sp = new ArrayList<>();
        String query = "SELECT * \n"
                + "FROM SanPham \n"
                + "ORDER BY gia DESC \n"
                + "LIMIT 20;;";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }
    //    addProduct
    public void addProduct( String ten_sanpham,String thuong_hieu, float gia,String mo_ta,int so_luong,String link_anh ) {
            String query = "INSERT INTO SanPham ( ten_sanpham, thuong_hieu, gia, mo_ta, so_luong, link_anh) VALUES ( ?, ?, ?, ?,?,?)";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,ten_sanpham);
            ps.setString(2,thuong_hieu);
            ps.setFloat(3, gia);
            ps.setString(4,mo_ta);
            ps.setInt(5, so_luong);
            ps.setString(6,link_anh);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }     
    }
    
    //delete 
    public void deleteSanPham(String id_sanpham) {
    String query = "DELETE FROM SanPham WHERE id_sanpham = ?";
    try {
        conn = new connectionDB().getConnection();
        ps = conn.prepareStatement(query);
        ps.setString(1, id_sanpham);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    // lay thong tin 
    public  Product getmaProduct(int id_sanpham){
        String query ="SELECT* FROM SanPham WHERE id_sanpham = ?";
        try {
        conn = new connectionDB().getConnection();
        ps = conn.prepareStatement(query);
        ps.setInt(1, id_sanpham);
        rs = ps.executeQuery();
         while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    };
   
//    updateProduct
    public void updateProduct( String ten_sanpham,String thuong_hieu, float gia,String mo_ta,int so_luong,String link_anh ,int id_sanpham) {
    String query = "UPDATE SanPham SET ten_sanpham = ?, thuong_hieu = ?, gia = ?, mo_ta = ?, so_luong = ?,link_anh=?  WHERE id_sanpham = ?";
    try {
        conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,ten_sanpham);
            ps.setString(2,thuong_hieu);
            ps.setFloat(3, gia);
            ps.setString(4,mo_ta);
            ps.setInt(5, so_luong);
            ps.setString(6,link_anh);
             ps.setInt(7, id_sanpham);
            ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
//searchProductByName
 public List<Product> searchProductByName(String ten_sanpham) {
        List<Product> sp = new ArrayList<>();
        String query = "SELECT * FROM SanPham WHERE ten_sanpham LIKE ?";
        
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + ten_sanpham + "%");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                sp.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return sp;
    }
}