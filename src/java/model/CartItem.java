/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hc
 */
public class CartItem {
    private int id_cart;
    private int id_sanpham;
    private float gia;
    private int so_luong;
    private int id_nguoidung; 
    private String link_anh;

    public CartItem() {
    }

    public CartItem(int id_cart, int id_sanpham, float gia, int so_luong, int id_nguoidung, String link_anh) {
        this.id_cart = id_cart;
        this.id_sanpham = id_sanpham;
        this.gia = gia;
        this.so_luong = so_luong;
        this.id_nguoidung = id_nguoidung;
        this.link_anh = link_anh;
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getId_nguoidung() {
        return id_nguoidung;
    }

    public void setId_nguoidung(int id_nguoidung) {
        this.id_nguoidung = id_nguoidung;
    }

    public String getLink_anh() {
        return link_anh;
    }

    public void setLink_anh(String link_anh) {
        this.link_anh = link_anh;
    }

    @Override
    public String toString() {
        return "CartItem{" + "id_cart=" + id_cart + ", id_sanpham=" + id_sanpham + ", gia=" + gia + ", so_luong=" + so_luong + ", id_nguoidung=" + id_nguoidung + ", link_anh=" + link_anh + '}';
    }

    
    
    
    
}
