/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.KhachHangDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhachHang;

/**
 *
 * @author hc
 */
@WebServlet(name="update_custommer", urlPatterns={"/update_custommer"})
public class update_custommer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_custommer</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet update_custommer at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        int id_khachhang = Integer.parseInt(request.getParameter("sid"));
        KhachHangDao kh = new KhachHangDao();
        KhachHang khs = kh.getCustomerById(id_khachhang);
        request.setAttribute("customer", khs);
        request.getRequestDispatcher("./views/admin/custommer/update_custommer.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        int id_khachhang = Integer.parseInt(request.getParameter("id_khachhang"));
        String ho_ten = request.getParameter("ho_ten");
        String email = request.getParameter("email");
        String dia_chi = request.getParameter("dia_chi");
        int  so_dien_thoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        int id_nguoidung = Integer.parseInt(request.getParameter("id_nguoidung"));
        KhachHangDao kh = new KhachHangDao();
        kh.updateCustomer(id_khachhang, ho_ten, email, dia_chi, so_dien_thoai, id_nguoidung);
        response.sendRedirect("loadcustommer");
    
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
