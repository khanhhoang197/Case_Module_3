package com.khanhhoang.demo.dao;
import com.khanhhoang.demo.model.Product;
import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> selectAllProduct();

    Product selectProductById(int id);

    void insertProduct(String name, int price, int quantity, String image, String describes) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    boolean editProducts(Product products) throws SQLException;

    List<Product> searchByName(String txtSearch);

    boolean checkNameExits(String productName);
}
