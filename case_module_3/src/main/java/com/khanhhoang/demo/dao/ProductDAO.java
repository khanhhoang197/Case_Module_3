package com.khanhhoang.demo.dao;

import com.khanhhoang.demo.model.Product;
import com.khanhhoang.demo.utils.AppUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DatabaseQuery implements IProductDAO {

    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM products;";
    private static final String INSERT_PRODUCT = "insert into products (product_name, product_price, product_quantity ,img ,product_describes) values(?,?,?,?,?);";
    private static final String DELETE_PRODUCT = "delete from products where product_id = ?";
    private static final String UPDATE_PRODUCT = "update products set product_name = ?,product_price = ?, product_quantity = ?,img = ?,product_describes = ? where product_id = ?;";
    private static final String SEARCH_PRODUCT_BY_NAME = "select * from products where product_name like ?";
    private static final String SELECT_PRODUCT_BY_ID = "select product_name, product_price, product_quantity ,img ,product_describes from products where product_id = ?";
    private static final String CHECK_NAME_EXISTS = "SELECT * FROM products where product_name = ?";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Product> selectAllProduct() {
        List<Product> listProduct = new ArrayList<>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = getProductFromResultSet(rs);
                listProduct.add(product);
            }
            conn.close();
        } catch (SQLException ex) {
            printSQLException(ex);
        }

        return listProduct;
    }

    private Product getProductFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        int price = rs.getInt(3);
        int quantity = rs.getInt(4);
        String image = rs.getString(5);
        String describes = rs.getString(6);
        Product product = new Product(id, name, price, quantity, image, describes);

        return product;
    }

    @Override
    public Product selectProductById(int id) {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_PRODUCT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Product(
                        rs.getString("product_name"),
                        rs.getInt("product_price"),
                        rs.getInt("product_quantity"),
                        rs.getString("img"),
                        rs.getString("product_describes"));
            }
            conn.close();
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;

    }

    @Override
    public void insertProduct(String name, int price, int quantity, String image, String describes) throws SQLException {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_PRODUCT);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, image);
            ps.setString(5, describes);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_PRODUCT);
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return rowDeleted;
    }

    @Override
    public boolean editProducts(Product products) throws SQLException {
        boolean rowUpdated;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, products.getName());
            ps.setInt(2, products.getPrice());
            ps.setInt(3, products.getQuantity());
            ps.setString(4, products.getImage());
            ps.setString(5, products.getDescribes());
            ps.setInt(6, products.getId());
            System.out.println(this.getClass() + " updateProduct " + ps);
            rowUpdated = ps.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
    }


    @Override
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SEARCH_PRODUCT_BY_NAME);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public boolean checkNameExits(String name) {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(CHECK_NAME_EXISTS);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }catch (SQLException ex) {
            AppUtils.printSQLException(ex);
        }
        return false;
    }
}
