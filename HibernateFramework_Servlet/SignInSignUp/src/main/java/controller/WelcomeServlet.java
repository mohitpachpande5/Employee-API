package controller;

import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.html");
            return;
        }

        User user = (User) session.getAttribute("user");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html><head><link rel='stylesheet' href='css/style.css'></head><body>");
        out.println("<h1>Welcome " + user.getName() + "</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Role</th></tr>");
        out.println("<tr><td>" + user.getId() + "</td><td>" + user.getName() + "</td><td>" + 
                   user.getEmail() + "</td><td>" + user.getRole() + "</td></tr>");
        out.println("</table>");
        out.println("<a href='logout'>Logout</a>");
        out.println("</body></html>");
    }
}