/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author hc
 */
public class DonHang {

    private int id_donhang;
    private int id_khachhang;
    private int id_sanpham;
    private int so_luong;
    private Date ngay_dat;
    private String trang_thai;
    private String hinh_thuc_thanh_toan;
    private float tong_tien;
    private String link_anh; // Thêm thuộc tính này
    private String ho_ten; // Thêm thuộc tính này
   

    public DonHang() {
    }

    public DonHang(int id_donhang, int id_khachhang, int id_sanpham, int so_luong, Date ngay_dat, String trang_thai, String hinh_thuc_thanh_toan, float tong_tien) {
        this.id_donhang = id_donhang;
        this.id_khachhang = id_khachhang;
        this.id_sanpham = id_sanpham;
        this.so_luong = so_luong;
        this.ngay_dat = ngay_dat;
        this.trang_thai = trang_thai;
        this.hinh_thuc_thanh_toan = hinh_thuc_thanh_toan;
        this.tong_tien = tong_tien;
    }

    public int getId_donhang() {
        return id_donhang;
    }

    public void setId_donhang(int id_donhang) {
        this.id_donhang = id_donhang;
    }

    public int getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(int id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public Date getNgay_dat() {
        return ngay_dat;
    }

    public void setNgay_dat(Date ngay_dat) {
        this.ngay_dat = ngay_dat;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public String getHinh_thuc_thanh_toan() {
        return hinh_thuc_thanh_toan;
    }

    public void setHinh_thuc_thanh_toan(String hinh_thuc_thanh_toan) {
        this.hinh_thuc_thanh_toan = hinh_thuc_thanh_toan;
    }

    public float getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(float tong_tien) {
        this.tong_tien = tong_tien;
    }

    public String getLink_anh() {
        return link_anh;
    }

    public void setLink_anh(String link_anh) {
        this.link_anh = link_anh;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }


    

    @Override
    public String toString() {
        return "DonHang{" + "id_donhang=" + id_donhang + ", id_khachhang=" + id_khachhang + ", id_sanpham=" + id_sanpham + ", so_luong=" + so_luong + ", ngay_dat=" + ngay_dat + ", trang_thai=" + trang_thai + ", hinh_thuc_thanh_toan=" + hinh_thuc_thanh_toan + ", tong_tien=" + tong_tien + '}';
    }

}
