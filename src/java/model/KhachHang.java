/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hc
 */
public class KhachHang {
    private int id_khachhang;
    private String  ho_ten;
    private String  email;
    private String dia_chi;
    private int so_dien_thoai;
    private int id_nguoidung;

    public KhachHang() {
    }

    public KhachHang(int id_khachhang, String ho_ten, String email, String dia_chi, int so_dien_thoai, int id_nguoidung) {
        this.id_khachhang = id_khachhang;
        this.ho_ten = ho_ten;
        this.email = email;
        this.dia_chi = dia_chi;
        this.so_dien_thoai = so_dien_thoai;
        this.id_nguoidung = id_nguoidung;
    }

    public int getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(int id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public int getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(int so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public int getId_nguoidung() {
        return id_nguoidung;
    }

    public void setId_nguoidung(int id_nguoidung) {
        this.id_nguoidung = id_nguoidung;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id_khachhang=" + id_khachhang + ", ho_ten=" + ho_ten + ", email=" + email + ", dia_chi=" + dia_chi + ", so_dien_thoai=" + so_dien_thoai + ", id_nguoidung=" + id_nguoidung + '}';
    }
    
    
    
}
