package com.khanhhoang.demo.dao;

import com.khanhhoang.demo.model.Country;
import com.khanhhoang.demo.model.Gender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends DatabaseQuery implements ICountryDAO{

    private static final String INSERT_COUNTRY = "INSERT INTO country (country_name) VALUES (?);";
    private static final String SELECT_COUNTRY_BY_ID = "select country_name from  gender where gender_id = ?";
    private static final String SELECT_ALL_COUNTRY = "select * from country";
    private static final String DELETE_COUNTRY = "delete from country where country_id = ?;";
    private static final String UPDATE_COUNTRY = "update country set country_name = ? where country_id = ?;";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Country> selectAllCountry() {
        List<Country> countries = new ArrayList<>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_ALL_COUNTRY);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("country_id");
                String name = rs.getString("country_name");

                countries.add(new Country(id, name));
            }


        }catch (SQLException ex){
            printSQLException(ex);
        }
        return countries;
    }

    @Override
    public void insertCountry(Country country) throws SQLException {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_COUNTRY);
            ps.setString(1, country.getName());
            ps.executeUpdate();
        } catch(SQLException ex){
            printSQLException(ex);
        }
    }


    @Override
    public Country selectCountry(int id) {
        Country country = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_COUNTRY_BY_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("gender_id");
                String name = rs.getString("gender_name");

                country = new Country(id, name);
            }


        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return country;
    }

    @Override
    public boolean updateCountry(Country country) throws SQLException {
        boolean rowUpdated = false;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(UPDATE_COUNTRY);
            statement.setInt(1, country.getId());
            statement.setString(2,country.getName());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteCountry(int id) throws SQLException {
        boolean rowDeleted;

        try ( Connection connection = getConnection();
              PreparedStatement statement = connection.prepareStatement(DELETE_COUNTRY);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
