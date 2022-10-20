package com.khanhhoang.demo.dao;
import com.khanhhoang.demo.model.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IUserDAO {
    List<User> selectAllUser();
    User selectUserByUserName(String username);
    void insertUser(String username, String password, String fullName, int gender, LocalDate birthday, String email, String phone, int country, String img) throws SQLException;
    boolean deleteUser(String username) throws SQLException;
    boolean editUser(User user) throws SQLException;

    User selectUserByEmail(String email);

    List<User> searchUser(String searchStr);


//    boolean checkEmailExists(String email);
}
