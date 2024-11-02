/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.client;

import dao.KhachHangDao;
import dao.CartDao;
import dao.DonHangDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import model.CartItem;

/**
 *
 * @author hc
 */
@WebServlet(name="AddKhachHangServlet", urlPatterns={"/AddKhachHangServlet"})
public class AddKhachHangServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddKhachHangServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddKhachHangServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        String ho_ten = request.getParameter("ho_ten");
        String email = request.getParameter("email");
        String dia_chi = request.getParameter("dia_chi");
        int so_dien_thoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        int id_nguoidung = Integer.parseInt(request.getParameter("id_nguoidung"));
        String hinh_thuc_thanh_toan = request.getParameter("hinh_thuc_thanh_toan");
        KhachHangDao kh = new KhachHangDao();
        boolean customerExists = kh.customerExists(id_nguoidung);

        if (!customerExists) {
            kh.addCustomer(id_nguoidung,ho_ten, email, dia_chi, so_dien_thoai, id_nguoidung);
        }

        // Fetch cart items and add orders
        CartDao cartDao = new CartDao();
        List<CartItem> cartItems = cartDao.getCartItems(id_nguoidung);

        DonHangDao donHangDao = new DonHangDao();
        for (CartItem item : cartItems) {
            donHangDao.addDonHang(id_nguoidung, item.getId_sanpham(), item.getSo_luong(), new Date(), "dang_xu_ly",hinh_thuc_thanh_toan, item.getGia() * item.getSo_luong());
        }
        cartDao.clearCart(id_nguoidung);
        response.sendRedirect("CartServlet?sid=" + id_nguoidung);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   

}
