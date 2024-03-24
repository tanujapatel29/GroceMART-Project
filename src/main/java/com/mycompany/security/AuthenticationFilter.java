/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if any
    }

 @Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession session = httpRequest.getSession(false);
    boolean isLoggedIn = (session != null && session.getAttribute("username") != null);

    // Allow access to the login page without authentication
    if (httpRequest.getRequestURI().endsWith("login")) {
        chain.doFilter(request, response);
        return;
    }

    // Redirect to login page if not authenticated
    if (!isLoggedIn) {
        httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        return;
    }

    // Optionally, restrict access to admin page only to users with admin role
    if (httpRequest.getRequestURI().contains("admin")) {
        // Check if the user has admin role
        // Example: if (!userHasAdminRole(session)) {
        //              httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
        //              return;
        //          }
    }

    // Continue the filter chain for authenticated users
    chain.doFilter(request, response);
}

}
