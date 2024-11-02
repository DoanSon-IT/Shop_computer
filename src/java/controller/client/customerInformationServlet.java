/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.client;

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
@WebServlet(name="customerInformationServlet", urlPatterns={"/customerInformationServlet"})
public class customerInformationServlet extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customerInformationServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customerInformationServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        int id_khachhang = -1;
        try {
            id_khachhang = Integer.parseInt(request.getParameter("sid"));
        } catch (NumberFormatException e) {
            // Nếu không thể parse được id_khachhang, chuyển hướng về trang đăng nhập
            response.sendRedirect("loadlogin");
            return;
        }
       
        KhachHangDao khachHangDao = new KhachHangDao();
        KhachHang khachHang = khachHangDao.getCustomerById(id_khachhang);
        request.setAttribute("khachHang", khachHang);
        request.getRequestDispatcher("./views/client/home/customerDetails.jsp").forward(request, response);
        
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
