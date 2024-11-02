/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hc
 */
public class Product {
    private int id_sanpham;
    private String ten_sanpham;
    private String thuong_hieu;
    private float gia;
    private String mo_ta;
    private int so_luong;
    private String link_anh;

    public Product() {
    }
    
    
    public Product(int id_sanpham, String ten_sanpham, String thuong_hieu, float gia, String mo_ta, int so_luong, String link_anh) {
        this.id_sanpham = id_sanpham;
        this.ten_sanpham = ten_sanpham;
        this.thuong_hieu = thuong_hieu;
        this.gia = gia;
        this.mo_ta = mo_ta;
        this.so_luong = so_luong;
        this.link_anh = link_anh;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public String getTen_sanpham() {
        return ten_sanpham;
    }

    public void setTen_sanpham(String ten_sanpham) {
        this.ten_sanpham = ten_sanpham;
    }

    public String getThuong_hieu() {
        return thuong_hieu;
    }

    public void setThuong_hieu(String thuong_hieu) {
        this.thuong_hieu = thuong_hieu;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getLink_anh() {
        return link_anh;
    }

    public void setLink_anh(String link_anh) {
        this.link_anh = link_anh;
    }

    @Override
    public String toString() {
        return "Product{" + "id_sanpham=" + id_sanpham + ", ten_sanpham=" + ten_sanpham + ", thuong_hieu=" + thuong_hieu + ", gia=" + gia + ", mo_ta=" + mo_ta + ", so_luong=" + so_luong + ", link_anh=" + link_anh + '}';
    }
    
    
}
