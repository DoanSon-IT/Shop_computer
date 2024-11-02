/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.DonHangDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.DonHang;

/**
 *
 * @author hc
 */
@WebServlet(name="update_oder", urlPatterns={"/update_oder"})
public class update_oder extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_oder</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet update_oder at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
            int id_donhang = Integer.parseInt(request.getParameter("id"));
            DonHangDao dh = new DonHangDao();
            DonHang dhs = dh.getDonHangById(id_donhang);
            request.setAttribute("dhss", dhs);
            request.getRequestDispatcher("./views/admin/oder/update_oder.jsp").forward(request, response);
    } 

    @Override

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    int orderId = Integer.parseInt(request.getParameter("id_donhang"));
    int customerId = Integer.parseInt(request.getParameter("id_khachhang"));
    int productId = Integer.parseInt(request.getParameter("id_sanpham"));
    int quantity = Integer.parseInt(request.getParameter("so_luong"));
    Date orderDate = null;
    try {
        orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngay_dat"));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    String status = request.getParameter("trang_thai");
    String paymentMethod = request.getParameter("hinh_thuc_thanh_toan");
    float totalAmount = Float.parseFloat(request.getParameter("tong_tien"));
    
    // Update order in database
    DonHangDao donHangDao = new DonHangDao();
    donHangDao.updateDonHang(customerId, productId, quantity, orderDate, status, paymentMethod, totalAmount, orderId);
    
    // Forward the request to your JSP page
     response.sendRedirect("loadoder");
}


}
