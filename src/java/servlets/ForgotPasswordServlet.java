package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;
import utilities.CookieUtil;

public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        AccountService as = new AccountService();
        String path = getServletContext().getRealPath("/WEB-INF");
        boolean forgotPassword;

        try {
            forgotPassword = as.forgotPassword(email, path);
            if (forgotPassword == true) {
                request.setAttribute("message", "Your message has successfully sent.");      
            }
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);

    }
}