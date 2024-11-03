package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbcon.DBConnection;

public class Product {
    
    public static int createProduct(String name, double weight) {
        
        String sql = "INSERT INTO product (name, weight) VALUES (?, ?)";
        int product_id = -1;

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, name);
                pstm.setDouble(2, weight);
                
                int affectedRows = pstm.executeUpdate(); 

                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            product_id = generatedKeys.getInt(1); 
                        }
                    }
                }
             } catch (SQLException e) {
                e.printStackTrace();
             }
             return product_id;
    }

    public static boolean deleteProduct(int product_id) {

        String sql = "DELETE FROM product WHERE product_id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setInt(1, product_id);

                int rowsAffected = pstm.executeUpdate();
    
                return rowsAffected > 0;

             } catch (SQLException e) {
                e.printStackTrace();
                return false;
             }
    }

    public static boolean updateProduct(int product_id, String name, double weight) {

        String sql = "UPDATE product SET name = ?, weight = ? WHERE product_id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, name);
                pstm.setDouble(2, weight);
                pstm.setInt(3, product_id);

                int rowsAffected = pstm.executeUpdate();
            
                return rowsAffected > 0;

             } catch (SQLException e) {
                e.printStackTrace();
                return false;
             }
    }

    public static int readProduct() {

        String sql = "SELECT product_id, name, weight FROM product";
        int rowCount = 0;

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                rowCount++; 
            }

             } catch (SQLException e) {
                e.printStackTrace();
             }
             return rowCount;
    }
}
