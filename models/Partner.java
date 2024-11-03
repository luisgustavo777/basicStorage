package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbcon.DBConnection;

public class Partner {
    
    public static int createPartner(String name, String address, String cpf, String cnpj, String email) {
        
        String sql = "INSERT INTO partner (name, address, cpf, cnpj, email) VALUES (?, ?, ?, ?, ?)";
        int partner_id = -1;

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, name);
                pstm.setString(2, address);
                pstm.setString(3, cpf);
                pstm.setString(4, cnpj);
                pstm.setString(5, email);
                
                int affectedRows = pstm.executeUpdate();    

                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            partner_id = generatedKeys.getInt(1); 
                        }
                    }
                }
             } catch (SQLException e) {
                e.printStackTrace();
             }
             return partner_id;
    }

    public static boolean deletePartner(int partner_id) {
        String sql = "DELETE FROM partner WHERE partner_id = ?";
    
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
    
            pstm.setInt(1, partner_id);
    
            int rowsAffected = pstm.executeUpdate();
    
            return rowsAffected > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public static boolean updatePartner(int partner_id, String name, String address, String cpf, String cnpj, String email) {
        String sql = "UPDATE partner SET name = ?, address = ?, cpf = ?, cnpj = ?, email = ? WHERE partner_id = ?";
    
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
    
            pstm.setString(1, name);
            pstm.setString(2, address);
            pstm.setString(3, cpf);
            pstm.setString(4, cnpj);
            pstm.setString(5, email);
            pstm.setInt(6, partner_id);
    
            int rowsAffected = pstm.executeUpdate();
            
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public static int readPartner() {
        String sql = "SELECT partner_id, name, address, cpf, cnpj, email FROM partner";
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
