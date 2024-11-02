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
import java.util.List;
import model.KhachHang;

/**
 *
 * @author hc
 */
@WebServlet(name="CustommerServlet", urlPatterns={"/loadcustommer","/searchKH"})
public class CustommerServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustommerServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustommerServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getServletPath();
        if (action.equals("/searchKH")) {
            doSearch(request, response);
        } else {
            KhachHangDao kh = new KhachHangDao();
            List<KhachHang> khs = kh.getAllCustomers();
            request.setAttribute("customers", khs);
            request.getRequestDispatcher("./views/admin/custommer/index_custommer.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }
    private void doSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchName = request.getParameter("searchtenkh");
        KhachHangDao kh = new KhachHangDao();
        List<KhachHang> khs = kh.searchCustomersByName(searchName);
        request.setAttribute("customers", khs);
        request.getRequestDispatcher("./views/admin/custommer/index_custommer.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    
}
