/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.DashboardDao;
import dao.ThongKeDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import model.DonHang;

/**
 *
 * @author hc
 */
@WebServlet(name = "StatisticsSevrlet", urlPatterns = {"/loadstatistics"})
public class StatisticsSevrlet extends HttpServlet {

    private ThongKeDao thongkedao;

    public void init() {
        thongkedao = new ThongKeDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet statistics</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet statistics at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int totalUsers = thongkedao.getTotalUsers();
        double totalSales = thongkedao.getTotalSales();
        int newOrders = thongkedao.getNewOrders();
        int pendingIssues = thongkedao.getPendingIssues();
        int totalProducts = thongkedao.getTotalProducts();
        int receivedOders = thongkedao.getReceivedOrders();
        Map<String, Integer> monthlyOrders = thongkedao.getMonthlyOrders();
         // Map<Integer, Double> revenueByMonth = thongkedao.getRevenueByMonth();
        
        Map<String, Integer> orderStatusCounts = thongkedao.getOrderStatusCounts();

        request.setAttribute("orderStatusCounts", orderStatusCounts);

        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("totalSales", totalSales);
        request.setAttribute("newOrders", newOrders);
        request.setAttribute("pendingIssues", pendingIssues);
        request.setAttribute("totalProductss", totalProducts);
        request.setAttribute("receivedOders", receivedOders);

        request.setAttribute("monthlyOrders", monthlyOrders);
        //request.setAttribute("revenueByMonth", revenueByMonth);
        
        // request.setAttribute("orderStatusChart", orderStatusCounts);
    
     
        request.getRequestDispatcher("./views/admin/statistics/index_statistics.jsp").forward(request, response);

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
