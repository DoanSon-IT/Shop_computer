package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.CartItem;
import utils.connectionDB;

public class CartDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public CartDao() {
    }
   
    // lay cart theo tung nguoi dung
    public List<CartItem> getCartItems(int id_nguoidung) {
    List<CartItem> cartItems = new ArrayList<>();
    String query = "SELECT * FROM Cart WHERE id_nguoidung = ?";
    try {
        conn = new connectionDB().getConnection();
        ps = conn.prepareStatement(query);
        ps.setInt(1, id_nguoidung);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            CartItem item = new CartItem();
            item.setId_cart(rs.getInt("id_cart"));
            item.setId_sanpham(rs.getInt("id_sanpham"));
            item.setSo_luong(rs.getInt("so_luong"));
            item.setGia(rs.getFloat("gia"));
            cartItems.add(item);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeResources();
    }
    return cartItems;
}

// Thêm phương thức clearCart để xóa tất cả các mục trong giỏ hàng của người dùng
    public void clearCart(int id_nguoidung) {
        String query = "DELETE FROM Cart WHERE id_nguoidung = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_nguoidung);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    // Method to get all items in the cart
    public List<CartItem> getAllItems() {
        List<CartItem> items = new ArrayList<>();
        String query = "SELECT * FROM Cart";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6)
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    // Method to check if an item exists in the cart for a user
    public CartItem getItemByUserAndProduct(int id_nguoidung, int id_sanpham) {
        String query = "SELECT * FROM cart WHERE id_nguoidung = ? AND id_sanpham = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_nguoidung);
            ps.setInt(2, id_sanpham);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new CartItem(
                        rs.getInt("id_cart"),
                        rs.getInt("id_sanpham"),
                        rs.getFloat("gia"),
                        rs.getInt("so_luong"),
                        rs.getInt("id_nguoidung"),
                        rs.getString("link_anh")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    // Method to update the quantity of an existing item
    public void updateCartItemQuantity(int id_cart, int newQuantity) {
        String query = "UPDATE cart SET so_luong = ? WHERE id_cart = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, newQuantity);
            ps.setInt(2, id_cart);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Method to get items by user ID
    public List<CartItem> getItemsByUserId(int id_nguoidung) {
        List<CartItem> items = new ArrayList<>();
        String query = "SELECT * FROM Cart WHERE id_nguoidung = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_nguoidung);
            rs = ps.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6)
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return items;
    }

    // Method to add an item to the cart
    public void addToCart(int id_sanpham, float gia, int so_luong, int id_nguoidung, String link_anh) {
        String query = "INSERT INTO cart (id_sanpham, gia, so_luong, id_nguoidung, link_anh)\n"
                + "VALUES   (?, ?, ?, ?, ?)";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_sanpham);
            ps.setFloat(2, gia);
            ps.setInt(3, so_luong);
            ps.setInt(4, id_nguoidung);
            ps.setString(5, link_anh);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an item from the cart
   public void deleteItem(int id_cart,String id_nguoidung) {
    String query = "DELETE FROM cart WHERE id_cart = ? AND id_nguoidung = ?";
    try {
        conn = new connectionDB().getConnection();
        ps = conn.prepareStatement(query);
        ps.setInt(1, id_cart);
        ps.setString(2, id_nguoidung);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeResources();
    }
}


    // Method to get item by ID
    public CartItem getItemById(int id_cart) {
        String query = "SELECT * FROM cart WHERE id_cart = ?";
        try {
            conn = new connectionDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_cart);
            rs = ps.executeQuery();
            if (rs.next()) {
                CartItem item = new CartItem(
                        rs.getInt("id_cart"),
                        rs.getInt("id_sanpham"),
                        rs.getFloat("gia"),
                        rs.getInt("so_luong"),
                        rs.getInt("id_nguoidung"),
                        rs.getString("link_anh")
                );
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
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
