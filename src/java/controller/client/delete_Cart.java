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
import model.TaiKhoan;

/**
 *
 * @author hc
 */
@WebServlet(name="delete_Cart", urlPatterns={"/delete_Cart"})
public class delete_Cart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delete_Cart</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet delete_Cart at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
         String idCartParam = request.getParameter("id");

    // Retrieve the user from the session
    TaiKhoan user = (TaiKhoan) request.getSession().getAttribute("user");

    if (user != null) {
        // User is logged in
             String idNguoiDung = user.getId_nguoidung();

        if (idCartParam != null && !idCartParam.isEmpty()) {
            int idCart = Integer.parseInt(idCartParam);

            // Create an instance of CartDao
            CartDao cartDao = new CartDao();

            // Delete the cart item based on id_cart and id_nguoidung
            cartDao.deleteItem(idCart, idNguoiDung);

            // Redirect back to the cart page
            response.sendRedirect("CartServlet?sid=" + idNguoiDung);
        } else {
            // Handle the case where the id parameter is missing or invalid
            request.setAttribute("errorMessage", "Invalid cart item ID.");
             response.sendRedirect("CartServlet?sid=" + idNguoiDung);
        }
    }
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
