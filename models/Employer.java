package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbcon.DBConnection;

public class Employer {
    
    public static String createEmployer(String email, String password) {
        
        String sql = "INSERT INTO employer (email, pw) VALUES (?, ?)";
    
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
    
            pstm.setString(1, email);
            pstm.setString(2, password);
            
            int affectedRows = pstm.executeUpdate(); 
    
            if (affectedRows > 0) {  
                return email;  
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public static boolean deleteEmployer(String email) {

        String sql = "DELETE FROM employer WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, email);

                int rowsAffected = pstm.executeUpdate();
    
                return rowsAffected > 0;

             } catch (SQLException e) {
                e.printStackTrace();
                return false;
             }
    }

    public static boolean updateEmployer(String password, String email) {

        String sql = "UPDATE employer SET pw = ? WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, password);
                pstm.setString(2, email);
                
                int rowsAffected = pstm.executeUpdate();

                return rowsAffected > 0;

             } catch (SQLException e) {
                e.printStackTrace();
                return false;
             }
    }

    public static int readEmployer() {

        String sql = "SELECT employer_id, email FROM employer";
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
