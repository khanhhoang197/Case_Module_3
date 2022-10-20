package com.khanhhoang.demo.dao;

import com.khanhhoang.demo.model.Gender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenderDAO extends DatabaseQuery implements IGenderDAO {
    private static final String INSERT_GENDER = "INSERT INTO gender (gender_name) VALUES (?);";
    private static final String SELECT_GENDER_BY_ID = "select gender_name from  gender where gender_id = ?";
    private static final String SELECT_ALL_GENDER = "select * from gender";
    private static final String DELETE_GENDER_SQL = "delete from gender where gender_id = ?;";
    private static final String UPDATE_GENDER = "update gender set gender_name = ? where gender_id = ?;";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    @Override
    public List<Gender> selectAllGender() {
        List<Gender> genders = new ArrayList<>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_ALL_GENDER);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("gender_id");
                String name = rs.getString("gender_name");

                genders.add(new Gender(id, name));
            }


        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return genders;
    }

    @Override
    public void insertGender(Gender gender) throws SQLException {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_GENDER);
                ps.setString(1, gender.getName());
                ps.executeUpdate();
            } catch(SQLException ex){
                printSQLException(ex);
            }
        }

    @Override
    public Gender selectGender(int id) {
        Gender gender = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_GENDER_BY_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("gender_id");
                String name = rs.getString("gender_name");

                gender = new Gender(id, name);
            }


        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return gender;
    }

    @Override
    public boolean updateCategory(Gender gender) throws SQLException {
        boolean rowUpdated = false;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(UPDATE_GENDER);
            statement.setInt(1, gender.getId());
            statement.setString(2,gender.getName());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteCategory(int id) throws SQLException {
        boolean rowDeleted;

        try ( Connection connection = getConnection();
              PreparedStatement statement = connection.prepareStatement(DELETE_GENDER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
