/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.client;

import dao.CartDao;
import model.CartItem;
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
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_sanpham = Integer.parseInt(request.getParameter("id_sanpham"));
        float gia = Float.parseFloat(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String linkAnh = request.getParameter("linkAnh");

        // Check if idNguoiDung parameter is present
        String idNguoiDungParam = request.getParameter("idNguoiDung");

        if (idNguoiDungParam == null || idNguoiDungParam.isEmpty()) {
            // idNguoiDung is null, user needs to log in
            request.setAttribute("errorMessage", "You must be logged in to add items to the cart.");
            response.sendRedirect("loadlogin");
        } else {
            // idNguoiDung is not null, proceed with adding the item to the cart
            int idNguoiDung = Integer.parseInt(idNguoiDungParam);

            // Create an instance of CartDao
            CartDao cartDao = new CartDao();

            // Check if the item already exists in the cart
            CartItem existingItem = cartDao.getItemByUserAndProduct(idNguoiDung, id_sanpham);
            if (existingItem != null) {
                // Item exists, update the quantity
                int newQuantity = existingItem.getSo_luong() + soLuong;
                cartDao.updateCartItemQuantity(existingItem.getId_cart(), newQuantity);
                response.sendRedirect("loadhome");
            } else {
                // Item does not exist, add new item to the cart
                cartDao.addToCart(id_sanpham, gia, soLuong, idNguoiDung, linkAnh);
                response.sendRedirect("loadhome");
            }

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
