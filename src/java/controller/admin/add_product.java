/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hc
 */
@WebServlet(name="add_product", urlPatterns={"/add_product"})
public class add_product extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet add_product</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add_product at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        request.getRequestDispatcher("./views/admin/product/add_product.jsp").forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//            int id_sanpham = Integer.parseInt(request.getParameter("productId"));
            String ten_sanpham = request.getParameter("productName");
            String thuong_hieu = request.getParameter("productBrand");
            float gia = Float.parseFloat(request.getParameter("productPrice"));
            String mo_ta = request.getParameter("productDescription");
            int  so_luong = Integer.parseInt(request.getParameter("productQuantity"));
            String link_anh = request.getParameter("productImage");
    
            ProductDao ps = new ProductDao();
            ps.addProduct(ten_sanpham, thuong_hieu, gia, mo_ta, so_luong, link_anh);
            response.sendRedirect("loadproduct");
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
