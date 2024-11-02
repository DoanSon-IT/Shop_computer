/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.DonHangDao;
import dao.KhachHangDao;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.DonHang;

/**
 *
 * @author hc
 */
@WebServlet(name = "OderSevrlet", urlPatterns = {"/loadoder"})
public class OderSevrlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet oder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet oder at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        DonHangDao dh = new DonHangDao();
        List<DonHang> listDonHang = dh.getAllDonHang();
        KhachHangDao khd = new KhachHangDao();
        ProductDao sanPhamDao = new ProductDao();
        for (DonHang order : listDonHang) {
            int id_khachhang = order.getId_khachhang();
            int id_sanpham = order.getId_sanpham();
            String ho_ten = khd.getTenKHById(id_khachhang);
            String link_anh = sanPhamDao.getAnhSanPhamById(id_sanpham);
            order.setHo_ten(ho_ten);
            order.setLink_anh(link_anh);// Set the image link to the order object
        }
        request.setAttribute("listDonHangs", listDonHang);
        request.getRequestDispatcher("./views/admin/oder/index_order.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
