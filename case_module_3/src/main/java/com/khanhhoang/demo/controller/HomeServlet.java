package com.khanhhoang.demo.controller;

import com.khanhhoang.demo.dao.ProductDAO;
import com.khanhhoang.demo.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                default:
                    showListProduct(request, response);
                    break;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        }

    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.selectAllProduct();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {

    }
}
