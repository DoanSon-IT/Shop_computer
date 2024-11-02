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
import model.Product;

/**
 *
 * @author hc
 */
@WebServlet(name="update_product", urlPatterns={"/update_product"})
public class update_product extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_product</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet update_product at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        int ma_sanpham = Integer.parseInt(request.getParameter("id"));
        ProductDao spd = new ProductDao();
        Product sp = spd.getmaProduct(ma_sanpham);
        request.setAttribute("product", sp);
        request.getRequestDispatcher("./views/admin/product/update_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_sanpham = Integer.parseInt(request.getParameter("productId"));
        String ten_sanpham = request.getParameter("productName");
        String thuong_hieu = request.getParameter("productBrand");
        float gia = Float.parseFloat(request.getParameter("productPrice"));
        String mo_ta = request.getParameter("productDescription");
        int so_luong = Integer.parseInt(request.getParameter("productQuantity"));
        String link_anh = request.getParameter("productImage");

        ProductDao ps = new ProductDao();
        ps.updateProduct(ten_sanpham, thuong_hieu, gia, mo_ta, so_luong, link_anh, id_sanpham);
        response.sendRedirect("loadproduct");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
