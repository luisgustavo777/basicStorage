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

    private static void testPartner() {
       
        //Creating a new partner
        int partner_id = Partner.createPartner(Util.genRandomString(), Util.genRandomString(), Util.genRandomString(), Util.genRandomString(), Util.genRandomString());
         
        if (partner_id > 0) {
            System.out.println("partner successfully created!");
        } else {
            System.out.println("partner unsuccessfully created!");   
        }
        
        //Updating the partner
        boolean successfullyUpdate = Partner.updatePartner(partner_id, Util.genRandomString(), Util.genRandomString(), Util.genRandomString(), Util.genRandomString(), Util.genRandomString());
        
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

    private static void testEmployer() {
       
        //Creating a new employer
        String email = Employer.createEmployer(Util.genRandomString(), Util.genRandomString());
        
        if (email != null) {
            System.out.println("employer successfully created!");
        } else {
            System.out.println("employer unsuccessfully created!");   
        }
        
        //Updating the employer
        boolean successfullyUpdate = Employer.updateEmployer(Util.genRandomString(), email);
        
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

    private static void testProduct() {
       
        //Creating a new product
        int product_id = Product.createProduct(Util.genRandomString(), Util.genRandomDouble());

        if (product_id > 0) {
            System.out.println("product successfully created!");
        } else {
            System.out.println("product unsuccessfully created!");   
        }
        
        //Updating the product
        boolean successfullyUpdate = Product.updateProduct(product_id, Util.genRandomString(), Util.genRandomDouble());
        
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
