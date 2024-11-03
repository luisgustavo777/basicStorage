package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dbcon.DBConnection;

public class Partner {
    
    public void createPartner(String name, String address, String cpf, String cnpj, String email) {
        
        String sql = "INSERT INTO partner (name, address, cpf, cnpj, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, name);
                pstm.setString(2, address);
                pstm.setString(3, cpf);
                pstm.setString(4, cnpj);
                pstm.setString(5, email);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void deletePartner(int partner_id) {

        String sql = "DELETE FROM partner WHERE partner_id = (?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setInt(1, partner_id);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void updatePartner(int partner_id, String name, String address, String cpf, String cnpj, String email) {

        String sql = "UPDATE partner SET name = (?), address = (?), cpf = (?), cnpj = (?), email = (?) WHERE partner_id = (?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

                pstm.setString(1, name);
                pstm.setString(2, address);
                pstm.setString(3, cpf);
                pstm.setString(4, cnpj);
                pstm.setString(5, email);
                pstm.setInt(6, partner_id);
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }

    public void readPartner() {

        String sql = "SELECT partner_id, name, address, cpf, cnpj, email FROM partner";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {
                
                pstm.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
             }
    }
}
