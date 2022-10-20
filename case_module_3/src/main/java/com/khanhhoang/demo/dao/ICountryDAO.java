package com.khanhhoang.demo.dao;

import com.khanhhoang.demo.model.Country;
import com.khanhhoang.demo.model.Gender;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDAO {
    List<Country> selectAllCountry();

    void insertCountry(Country country) throws SQLException;

    Country selectCountry(int id);

    boolean updateCountry(Country country) throws SQLException;

    boolean deleteCountry(int id) throws SQLException;
}
