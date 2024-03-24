/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servlet;

/**
 *
 * @author tanuj
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the username and password from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the credentials (replace this with your authentication logic)
        boolean isAuthenticated = authenticateUser(username, password);

        if (isAuthenticated) {
            // Authentication successful
            // Create a session for the user
            HttpSession session = request.getSession(true);
            // Store user information in the session (e.g., username)
            session.setAttribute("username", username);

            // Redirect to the admin panel or another protected page
            response.sendRedirect(request.getContextPath() + "/admin/admindash.html");
        } else {
            // Authentication failed
            // Redirect back to the login page with an error message
            response.sendRedirect(request.getContextPath() + "/login?error=true");
        }
    }

    private boolean authenticateUser(String username, String password) {
        // Implement your authentication logic here (e.g., check against a database)
        // Return true if the username and password are valid, false otherwise
        // Example:
        // return userService.authenticate(username, password);
        // Replace userService.authenticate with your actual authentication logic
        return username.equals("admin") && password.equals("password");
    }
}

