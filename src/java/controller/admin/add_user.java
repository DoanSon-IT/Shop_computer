/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.TaiKhoanDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hc
 */
@WebServlet(name="add_user", urlPatterns={"/add_user"})
public class add_user extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addNguoiDungSevrlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addNguoiDungSevrlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       // processRequest(request, response);
       
       request.getRequestDispatcher("./views/admin/user/add_user.jsp").forward(request, response);
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        String ten_dangnhap = request.getParameter("ten_dangnhap");
        String matkhau = request.getParameter("matkhau");
        String email = request.getParameter("email");
        String vai_tro = request.getParameter("vai_tro");
        String trang_thai = request.getParameter("trang_thai");

        TaiKhoanDao ps = new TaiKhoanDao();
        ps.addTaiKhoan(ten_dangnhap, matkhau, email, vai_tro,trang_thai);

        response.sendRedirect("loaduser");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
