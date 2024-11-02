package controller.login;

import dao.TaiKhoanDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "dangkyServlet", urlPatterns = {"/dangkyServlet"})
public class dangkyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ten_dangnhap = request.getParameter("register-username");
        String matkhau = request.getParameter("register-password");
        String confirmMatkhau = request.getParameter("confirm-password");
        String email = request.getParameter("register-email");
        String vai_tro = "Khách Hàng";
        String trang_thai = "ON";

        TaiKhoanDao ps = new TaiKhoanDao();
        String errorMessage = null;

        // Server-side validation
        if (ten_dangnhap == null || ten_dangnhap.length() < 6) {
            errorMessage = "Tên đăng nhập phải có ít nhất 6 ký tự.";
        } else if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            errorMessage = "Địa chỉ email không hợp lệ.";
        } else if (matkhau == null || matkhau.length() < 6) {
            errorMessage = "Mật khẩu phải có ít nhất 6 ký tự.";
        } else if (!matkhau.equals(confirmMatkhau)) {
            errorMessage = "Mật khẩu nhập lại không khớp.";
        } else if (ps.usernameExists(ten_dangnhap)) {
            errorMessage = "Tên đăng nhập đã tồn tại.";
        } else if (ps.emailExists(email)) {
            errorMessage = "Email đã được đăng ký.";
        }

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("./views/register.jsp").forward(request, response);
        } else {
            // Hash the password (consider using a library like BCrypt)
            String hashedPassword = hashPassword(matkhau);
            ps.addTaiKhoan(ten_dangnhap, hashedPassword, email, vai_tro, trang_thai);

            request.setAttribute("successMessage", "Đăng ký thành công. Vui lòng đăng nhập.");
            request.getRequestDispatcher("./views/register.jsp").forward(request, response);
        }
    }

    private String hashPassword(String password) {
        // Implement password hashing, e.g., using BCrypt
        return password; // Placeholder, replace with actual hashing
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
