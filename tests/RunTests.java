package tests;

import java.sql.Connection;
import java.sql.SQLException;
import dbcon.DBConnection;
import models.Partner;
import models.Product;
import models.Employer;

public class RunTests {
    public static void main(String[] args) {
        try {
            
            //Try to connect with database
            Connection conn = DBConnection.getConnection();
            
            if (conn != null && !conn.isClosed()) {
                System.out.println("database connection successfully established!");
                System.out.println("------------------");
                testPartner();
                System.out.println("------------------");
                testEmployer();
                System.out.println("------------------");
                testProduct();
                conn.close();
            } else {
                System.out.println("failed to connect to the database :c");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testPartner() {
       
        //Creating a new partner
        int partner_id = Partner.createPartner("Luis Gustavo", "Morro do Gama", "183.652.697-08", "55.735.142/0001-99", "contatoluisbp@gmail.com");
         
        if (partner_id > 0) {
            System.out.println("partner successfully created!");
        } else {
            System.out.println("partner unsuccessfully created!");   
        }
        
        //Updating the partner
        boolean successfullyUpdate = Partner.updatePartner(partner_id, "Jose", "Quimica", "382.570.570-61", "07.036.891/0001-85", "elenor6258@uorak.com");
        
        if (successfullyUpdate) {
            System.out.println("partner successfully updated!");
        } else {
            System.out.println("partner unsuccessfully updated :c");
        }        
        
        //Reading partners count
        int rowCount = Partner.readPartner();
        
        if (rowCount > 0) {
            System.out.println(rowCount +" partners readed!");
        } else {
            System.out.println("no partners readed :c");
        }
        
        //Deleting the partner created
        boolean successfullyDeleted = Partner.deletePartner(partner_id);
        
        if (successfullyDeleted) {
            System.out.println("partner successfully deleted!");
        } else {
            System.out.println("partner unsuccessfully deleted :c");
        }
    }

    public static void testEmployer() {
       
        //Creating a new employer
        String email = Employer.createEmployer("contatoluisbp@gmail.com", "030923");
        
        if (email != null) {
            System.out.println("employer successfully created!");
        } else {
            System.out.println("employer unsuccessfully created!");   
        }
        
        //Updating the employer
        boolean successfullyUpdate = Employer.updateEmployer("elenor6258", email);
        
        if (successfullyUpdate) {
            System.out.println("employer successfully updated!");
        } else {
            System.out.println("employer unsuccessfully updated :c");
        }        
        
        //Reading employers count
        int rowCount = Employer.readEmployer();
        
        if (rowCount > 0) {
            System.out.println(rowCount +" employers readed!");
        } else {
            System.out.println("no employers readed :c");
        }
        
        //Deleting the employer created
        boolean successfullyDeleted = Employer.deleteEmployer(email);
        
        if (successfullyDeleted) {
            System.out.println("employer successfully deleted!");
        } else {
            System.out.println("employer unsuccessfully deleted :c");
        }
    }

    public static void testProduct() {
       
        //Creating a new product
        int product_id = Product.createProduct("Garrafa de Agua", 15.5);

        if (product_id > 0) {
            System.out.println("product successfully created!");
        } else {
            System.out.println("product unsuccessfully created!");   
        }
        
        //Updating the product
        boolean successfullyUpdate = Product.updateProduct(product_id, "garrafa de suco", 5.2);
        
        if (successfullyUpdate) {
            System.out.println("product successfully updated!");
        } else {
            System.out.println("product unsuccessfully updated :c");
        }        
        
        //Reading products count
        int rowCount = Product.readProduct();
        
        if (rowCount > 0) {
            System.out.println(rowCount +" products readed!");
        } else {
            System.out.println("no products readed :c");
        }
        
        //Deleting the product created
        boolean successfullyDeleted = Product.deleteProduct(product_id);
        
        if (successfullyDeleted) {
            System.out.println("product successfully deleted!");
        } else {
         System.out.println("product unsuccessfully deleted :c");
        }
    }
}
