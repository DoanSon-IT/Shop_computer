package controller.login;

import dao.TaiKhoanDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import model.TaiKhoan;

@WebServlet(name = "LogGinSevrlet", urlPatterns = {"/loadlogin"})
public class LogGinSevrlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tenDangNhap = request.getParameter("login-username");
        String matKhau = request.getParameter("login-password");

        TaiKhoanDao dao = new TaiKhoanDao();
        TaiKhoan user = dao.login(tenDangNhap, matKhau);

        HttpSession session = request.getSession();
        if (user != null) {
            if ("ON".equals(user.getTrang_thai())) {
                session.setAttribute("user", user);
                String message = "Logged in successfully!";
               

                if ("admin".equals(user.getVai_tro()) || "Nhân Viên".equals(user.getVai_tro())) {
                    response.sendRedirect("loaddashboard?message=" + URLEncoder.encode(message, "UTF-8"));
                } else if ("Khách Hàng".equals(user.getVai_tro())) {
                    response.sendRedirect("loadhome?message=" + URLEncoder.encode(message, "UTF-8"));
                }
            } else {
                session.setAttribute("errorMessage", "Đăng nhập thất bại! Tài khoản không hoạt động.");
                response.sendRedirect("loadlogin");
            }
        } else { 
            session.setAttribute("errorMessage", "Đăng nhập thất bại! Sai tên đăng nhập hoặc mật khẩu.");
            response.sendRedirect("loadlogin");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
