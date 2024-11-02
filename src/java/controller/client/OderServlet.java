/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.client;

import dao.DonHangDao;
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
@WebServlet(name="OderServlet", urlPatterns={"/OderServlet"})
public class OderServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OderServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OderServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
       
        int id_khachhang = -1;
        try {
            id_khachhang = Integer.parseInt(request.getParameter("sid"));
       
        } catch (NumberFormatException e) {
            // Nếu không thể parse được id_khachhang, chuyển hướng về trang đăng nhập
            response.sendRedirect("loadlogin");
            return;
        }
       
        DonHangDao donHangDao = new DonHangDao();
        List<DonHang> orders = donHangDao.getOrdersByUserId(id_khachhang);
        ProductDao sanPhamDao = new ProductDao();
        for (DonHang order : orders) {
            int id_sanpham = order.getId_sanpham();
           String link_anh = sanPhamDao.getAnhSanPhamById(id_sanpham);
            order.setLink_anh(link_anh); // Set the image link to the order object
        }
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("./views/client/home/orderDetails.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
