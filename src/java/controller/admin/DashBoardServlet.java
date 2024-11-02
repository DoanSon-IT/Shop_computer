/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;




/**
 *
 * @author hc
 */


import dao.DashboardDao;
import model.DonHang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="DashBoardServlet", urlPatterns={"/loaddashboard"})
public class DashBoardServlet extends HttpServlet {

    private DashboardDao dashboardDao;

    @Override
    public void init() {
        dashboardDao = new DashboardDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        List<DonHang> recentOrders = dashboardDao.getRecentOrders();
        request.setAttribute("recentOrders", recentOrders);
        request.getRequestDispatcher("./views/admin/Dashboard.jsp").forward(request, response);
    }
}
