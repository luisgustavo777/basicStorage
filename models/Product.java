package models;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dbcon.DBConnection;

public class Product {
    
    public void createProduct(String name, BigDecimal weight) {
        
        String sql = "INSERT INTO product (name, weight) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, name);
                pstm.setBigDecimal(2, weight);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void deleteProduct(int product_id) {

        String sql = "DELETE FROM product WHERE product_id = (?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setInt(1, product_id);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void updateProduct(int product_id, String name, BigDecimal weight) {

        String sql = "UPDATE product SET name = (?), weight = (?) WHERE product_id = (?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, name);
                pstm.setBigDecimal(2, weight);
                pstm.setInt(3, product_id);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void readProduct() {

        String sql = "SELECT product_id, name, weight FROM product";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {
                
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }
}
