/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

///**

import java.util.Date;

// *
// * @author hc
// * 
// * /
public class ChiTietVanChuyen {
    private int id_chitietvanchuyen;
    private int id_donhang;
    private Date ngay_vanchuyen;
    private String dia_chi;
    private String thanh_pho;
    private String tinh_trang;
    private String quoc_gia;
    private String ma_theo_doi;

    public ChiTietVanChuyen(int id_chitietvanchuyen, int id_donhang, Date ngay_vanchuyen, String dia_chi, String thanh_pho, String tinh_trang, String quoc_gia, String ma_theo_doi) {
        this.id_chitietvanchuyen = id_chitietvanchuyen;
        this.id_donhang = id_donhang;
        this.ngay_vanchuyen = ngay_vanchuyen;
        this.dia_chi = dia_chi;
        this.thanh_pho = thanh_pho;
        this.tinh_trang = tinh_trang;
        this.quoc_gia = quoc_gia;
        this.ma_theo_doi = ma_theo_doi;
    }

    // Các phương thức get và set
}