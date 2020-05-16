package com.bookstore.controller.admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminLoginFilter", urlPatterns = "/admin/*")
public class AdminLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpSession session = httpRequest.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("useremail") != null;
        String loginURI = httpRequest.getContextPath() + "/admin/login";
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (loggedIn && (loginRequest || loginPage)){
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/admin/");
            dispatcher.forward(req, resp);
        } else if (loggedIn || loginRequest){
            chain.doFilter(req, resp);
        } else {
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
