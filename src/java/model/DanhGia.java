/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.Timestamp;
import java.util.Date;

/**
 *
 * @author hc
 */
public class DanhGia {
    private int id_danhgia;
    private int id_sanpham;
    private int id_taikhoan;
    private int danh_gia;
    private String binh_luan;
    private Date ngay_danhgia;
    private int id_nguoidung;

    public DanhGia() {
    }
    
    public DanhGia(int id_danhgia, int id_sanpham, int id_taikhoan, int danh_gia, String binh_luan, Date ngay_danhgia, int id_nguoidung) {
        this.id_danhgia = id_danhgia;
        this.id_sanpham = id_sanpham;
        this.id_taikhoan = id_taikhoan;
        this.danh_gia = danh_gia;
        this.binh_luan = binh_luan;
        this.ngay_danhgia = ngay_danhgia;
        this.id_nguoidung = id_nguoidung;
    }

    public int getId_danhgia() {
        return id_danhgia;
    }

    public void setId_danhgia(int id_danhgia) {
        this.id_danhgia = id_danhgia;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public int getId_taikhoan() {
        return id_taikhoan;
    }

    public void setId_taikhoan(int id_taikhoan) {
        this.id_taikhoan = id_taikhoan;
    }

    public int getDanh_gia() {
        return danh_gia;
    }

    public void setDanh_gia(int danh_gia) {
        this.danh_gia = danh_gia;
    }

    public String getBinh_luan() {
        return binh_luan;
    }

    public void setBinh_luan(String binh_luan) {
        this.binh_luan = binh_luan;
    }

    public Date getNgay_danhgia() {
        return ngay_danhgia;
    }

    public void setNgay_danhgia(Date ngay_danhgia) {
        this.ngay_danhgia = ngay_danhgia;
    }

    public int getId_nguoidung() {
        return id_nguoidung;
    }

    public void setId_nguoidung(int id_nguoidung) {
        this.id_nguoidung = id_nguoidung;
    }

    @Override
    public String toString() {
        return "DanhGia{" + "id_danhgia=" + id_danhgia + ", id_sanpham=" + id_sanpham + ", id_taikhoan=" + id_taikhoan + ", danh_gia=" + danh_gia + ", binh_luan=" + binh_luan + ", ngay_danhgia=" + ngay_danhgia + ", id_nguoidung=" + id_nguoidung + '}';
    }
    
    

    
}