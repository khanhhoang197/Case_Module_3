package com.khanhhoang.demo.dao;

import com.khanhhoang.demo.model.User;
import com.khanhhoang.demo.utils.AppUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DatabaseQuery implements IUserDAO {

    private static final String INSERT_USERS = "INSERT INTO users(username, password, fullname, gender_id, birthday, email, phone, country_id, img) values (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_USER_BY_USERNAME = "select * from users where username=?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS = "delete from users where username = ?;";
    private static final String UPDATE_USERS = "update users set password = ? , fullname = ?, gender_id = ?, birthday = ?, email = ?, phone =? , country_id = ?, img = ? where username = ?;";
    private static final String SELECT_USER_BY_EMAIL = "select * from users where email=?";
    private static final String SEARCH_USER = "{CALL search_User(?)}";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public UserDAO() {

    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = getUserFromResultSet(rs);
                userList.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userList;
    }

    @Override
    public User selectUserByUserName(String username) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);) {
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = getUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUser(String username, String password, String fullName, int gender, LocalDate birthday, String email, String phone, int country, String img) throws SQLException {
        conn = getConnection();
        ps = conn.prepareStatement(INSERT_USERS);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, fullName);
        ps.setInt(4, gender);
        ps.setString(5, AppUtils.localDateToString(birthday));
        ps.setString(6, email);
        ps.setString(7, phone);
        ps.setInt(8, country);
        ps.setString(9, img);
        ps.executeUpdate();
    }

    @Override
    public boolean deleteUser(String username) throws SQLException {
        boolean rowDeleted = false;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_USERS);
            ps.setString(1, username);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return rowDeleted;
    }


    @Override
    public boolean editUser(User user) throws SQLException {
        boolean rowUpdated;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_USERS);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getFullName());
            ps.setInt(3, user.getGender());
            ps.setString(4, AppUtils.localDateToString(user.getBirthday()));
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhone());
            ps.setInt(7, user.getCountry());
            ps.setString(8, user.getImg());
            ps.setString(9, user.getUsername());
            rowUpdated = ps.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;

    }

    @Override
    public User selectUserByEmail(String email) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);) {
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return getUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
    @Override
    public List<User> searchUser(String searchStr) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(SEARCH_USER)) {
            callableStatement.setString(1, "%" + searchStr + "%");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                User user = getUserFromResultSet(rs);
                users.add(user);
            }
        } catch (SQLException ex) {
            AppUtils.printSQLException(ex);
        }
        return users;
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {
        String username = rs.getString("username");
        String password = rs.getString("password");
        String fullName = rs.getString("fullname");
        int gender = rs.getInt("gender_id");
        LocalDate birthday = AppUtils.stringToLocalDate(rs.getString("birthday"));
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        int country = rs.getInt("country_id");
        String img = rs.getString("img");

        User user = new User(username,password,fullName, gender, birthday, email, phone, country, img );

        return user;
    }
}
