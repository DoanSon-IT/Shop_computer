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
public class ThanhToan {
    private int id_thanhtoan;
    private int id_donhang;
    private Date ngay_thanhtoan;
    private double so_tien;
    private String phuong_thuc;
    private String ma_giaodich;

    public ThanhToan(int id_thanhtoan, int id_donhang, Date ngay_thanhtoan, double so_tien, String phuong_thuc, String ma_giaodich) {
        this.id_thanhtoan = id_thanhtoan;
        this.id_donhang = id_donhang;
        this.ngay_thanhtoan = ngay_thanhtoan;
        this.so_tien = so_tien;
        this.phuong_thuc = phuong_thuc;
        this.ma_giaodich = ma_giaodich;
    }

    
}
