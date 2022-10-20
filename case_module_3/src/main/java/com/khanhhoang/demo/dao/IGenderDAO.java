package com.khanhhoang.demo.dao;

import com.khanhhoang.demo.model.Gender;

import java.sql.SQLException;
import java.util.List;

public interface IGenderDAO {
    List<Gender> selectAllGender();

    void insertGender(Gender gender) throws SQLException;

    Gender selectGender(int id);

    boolean updateCategory(Gender gender) throws SQLException;

    boolean deleteCategory(int id) throws SQLException;

}
