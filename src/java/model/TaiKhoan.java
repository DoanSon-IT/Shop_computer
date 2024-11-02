/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hc
 */
public class TaiKhoan {
    private String id_nguoidung;
    private String ten_dangnhap ;
    private String matkhau ;
    private String email ;
    private String vai_tro ; 
    private String trang_thai ; 

    public TaiKhoan() {
    }

    public TaiKhoan(String id_nguoidung, String ten_dangnhap, String matkhau, String email, String vai_tro, String trang_thai) {
        this.id_nguoidung = id_nguoidung;
        this.ten_dangnhap = ten_dangnhap;
        this.matkhau = matkhau;
        this.email = email;
        this.vai_tro = vai_tro;
        this.trang_thai = trang_thai;
    }

    public String getId_nguoidung() {
        return id_nguoidung;
    }

    public void setId_nguoidung(String id_nguoidung) {
        this.id_nguoidung = id_nguoidung;
    }

    public String getTen_dangnhap() {
        return ten_dangnhap;
    }

    public void setTen_dangnhap(String ten_dangnhap) {
        this.ten_dangnhap = ten_dangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVai_tro() {
        return vai_tro;
    }

    public void setVai_tro(String vai_tro) {
        this.vai_tro = vai_tro;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "id_nguoidung=" + id_nguoidung + ", ten_dangnhap=" + ten_dangnhap + ", matkhau=" + matkhau + ", email=" + email + ", vai_tro=" + vai_tro + ", trang_thai=" + trang_thai + '}';
    }

    
    
    
}
