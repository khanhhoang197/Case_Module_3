package com.khanhhoang.demo.controller;

import com.khanhhoang.demo.dao.CountryDAO;
import com.khanhhoang.demo.dao.GenderDAO;
import com.khanhhoang.demo.dao.UserDAO;
import com.khanhhoang.demo.model.Country;
import com.khanhhoang.demo.model.Gender;
import com.khanhhoang.demo.model.User;
import com.khanhhoang.demo.utils.AppUtils;
import com.khanhhoang.demo.utils.ValidateUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private GenderDAO genderDAO = new GenderDAO();
    private CountryDAO countryDAO = new CountryDAO();

    public void init() {
        userDAO = new UserDAO();
        List<Gender> genders = genderDAO.selectAllGender();
        if (this.getServletContext().getAttribute("listGenders") == null) {
            this.getServletContext().setAttribute("listGenders", genders);
        }
        List<Country> countries = countryDAO.selectAllCountry();
        if (this.getServletContext().getAttribute("listCountry") == null) {
            this.getServletContext().setAttribute("listCountry", countries);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "update":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        UserDAO userDAO = new UserDAO();
        List<User> listUser = userDAO.selectAllUser();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("/WEB-INF/admin/table/user.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        UserDAO userDAO = new UserDAO();
        User existingUser = userDAO.selectUserByUserName(username);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/user/update.jsp");
        dispatcher.forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        int gender = Integer.parseInt(request.getParameter("gender_id"));
        LocalDate birthday = Date.valueOf(request.getParameter("birthday")).toLocalDate();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int country = Integer.parseInt(request.getParameter("country_id"));
        String img = request.getParameter("img");
        UserDAO userDAO = new UserDAO();
        User user = new User();

        List<String> errors = new ArrayList<>();
        if (username.trim().equals("")) errors.add("Tài khoản không được để trống");
        user.setFullName(username);
        if (userDAO.selectUserByUserName(username) != null) errors.add("Tài khoản đã tồn tại!");
        user.setUsername(username);

        if (password.trim().equals("")) errors.add("Mật khẩu không được để trống");
        user.setPassword(password);

        if (fullName.trim().equals("")) errors.add("Họ tên không được để trống");
        user.setFullName(fullName);

        if (genderDAO.selectAllGender() == null) errors.add("Giới tính không hợp lệ)");
        user.setGender(gender);

        if (countryDAO.selectAllCountry() == null) errors.add("Thành phố không có trong hệ thống");
        user.setCountry(country);

        try {
            birthday = AppUtils.stringToLocalDate(request.getParameter("birthday"));
            user.setBirthday(birthday);
        } catch (Exception e) {
            errors.add("Định dạng ngày sinh không hợp lệ");
        }

        if (!ValidateUtils.isPhoneValid(phone))
            errors.add("Số điện thoại không hợp lệ (Số điện thoại bao gồm 10 chữ số)");
        user.setPhone(phone);

        if (!ValidateUtils.isEmailValid(email))
            errors.add("Email không hợp lệ");
        if (userDAO.selectUserByEmail(email) != null)
            errors.add("Email đã tồn tại trong hệ thống");
        user.setEmail(email);

        if (errors.isEmpty()) {
            user.setUsername(username);
            user.setPassword(password);
            user.setFullName(fullName);
            user.setGender(gender);
            user.setBirthday(birthday);
            user.setEmail(email);
            user.setPhone(phone);
            user.setCountry(country);
            user.setImg(img);
            request.setAttribute("message", "Thêm tài khoản thành công");
            request.setAttribute("user", user);
            userDAO.insertUser(username, password, fullName, gender, birthday, email, phone, country, img);
        } else {
            request.setAttribute("user", user);
            request.setAttribute("errors", errors);
        }
        RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/product/create.jsp");
        rq.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        int gender = Integer.parseInt(request.getParameter("gender_id"));
        LocalDate birthday = Date.valueOf(request.getParameter("birthday")).toLocalDate();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int country = Integer.parseInt(request.getParameter("country_id"));
        String img = request.getParameter("img");

        List<String> errors = new ArrayList<>();
        User oldUser = userDAO.selectUserByUserName(username);
        if (oldUser == null) {
            errors.add("Tài khoản không tồn tại");
            UserDAO userDAO = new UserDAO();
            User user = new User();

            if (password.trim().equals("")) errors.add("Mật khẩu không được để trống");
            user.setPassword(password);

            if (fullName.trim().equals("")) errors.add("Họ tên không được để trống");
            user.setFullName(fullName);

            if (genderDAO.selectAllGender() == null) errors.add("Giới tính không hợp lệ)");
            user.setGender(gender);

            if (countryDAO.selectAllCountry() == null) errors.add("Thành phố không có trong hệ thống");
            user.setCountry(country);

            try {
                birthday = AppUtils.stringToLocalDate(request.getParameter("birthday"));
                user.setBirthday(birthday);
            } catch (Exception e) {
                errors.add("Định dạng ngày sinh không hợp lệ");
            }

            if (!ValidateUtils.isPhoneValid(phone))
                errors.add("Số điện thoại không hợp lệ (Số điện thoại bao gồm 10 chữ số)");
            user.setPhone(phone);

            if (!ValidateUtils.isEmailValid(email))
                errors.add("Email không hợp lệ");
            if (userDAO.selectUserByEmail(email) != null)
                errors.add("Email đã tồn tại trong hệ thống");
            user.setEmail(email);

            if (errors.isEmpty()) {
                user.setPassword(password);
                user.setFullName(fullName);
                user.setGender(gender);
                user.setBirthday(birthday);
                user.setEmail(email);
                user.setPhone(phone);
                user.setCountry(country);
                user.setImg(img);
                request.setAttribute("message", "Cập nhật thông tin tài khoản thành công");
                request.setAttribute("user", user);
                userDAO.editUser(user);
            } else {
                request.setAttribute("user", user);
                request.setAttribute("errors", errors);
            }
            RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/product/update.jsp");
            rq.forward(request, response);

        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("username");
        User user = userDAO.selectUserByUserName(name);
        if (name == null) {
            request.setAttribute("error", name + " ' " + "không tồn tại");
        } else {
            userDAO.deleteUser(name);
            request.setAttribute("message", "Xóa thành công!");
            response.sendRedirect("/user");
        }

    }


}

