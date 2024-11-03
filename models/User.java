package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dbcon.DBConnection;

public class User {
    
    public void createUser(String email, String password) {
        
        String sql = "INSERT INTO user (email, password) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, email);
                pstm.setString(2, password);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void deleteUser(int user_id) {

        String sql = "DELETE FROM user WHERE user_id = (?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setInt(1, user_id);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void updateUser(int user_id, String password) {

        String sql = "UPDATE user SET password = (?) WHERE user_id = (?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, password);
                pstm.setInt(2, user_id);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void readUser() {

        String sql = "SELECT user_id, email FROM user";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {
                
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }
}
