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
import java.util.List;
import model.TaiKhoan;

/**
 *
 * @author hc
 */
@WebServlet(name="UserSevrlet", urlPatterns={"/loaduser", "/search_user"})
public class UserSevrlet extends HttpServlet {
   
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TaiKhoanSevrlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TaiKhoanSevrlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/search_user")) {
            doSearch(request, response);
        } else {
         TaiKhoanDao tk = new TaiKhoanDao();
            List<TaiKhoan> tks = tk.getAllTaiKhoan();
            request.setAttribute("tkss", tks);
            request.getRequestDispatcher("./views/admin/user/index_user.jsp").forward(request, response);
        }
        } 

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
    }
     private void doSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String searchName = request.getParameter("searchName");
            TaiKhoanDao tk = new TaiKhoanDao();
            List<TaiKhoan> tkk = tk.searchUserByName(searchName);
            request.setAttribute("tkss", tkk);
            request.getRequestDispatcher("./views/admin/user/index_user.jsp").forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
   

}
