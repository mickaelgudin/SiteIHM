/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import model.Reservation;

public class Database {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/base_ihm?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public void insertReservation(Reservation reservation) {
        Connection conn = null;
        Statement stmt = null;
        try{
            String forName = "com.mysql.cj.jdbc.Driver";
            try {
                Class.forName(forName);
                System.out.println("Driver Loaded Successfully");
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver Failed To Load Successfully");
                System.out.println(ex.getMessage());
            }
            
           //STEP 3: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Connected database successfully...");

           stmt = conn.createStatement();

           String sql = "INSERT INTO Reservation(date, heure, telephone, notes) " +
                        "VALUES ('"+reservation.getDate()+"', '"+reservation.getHeure()+"', '"+reservation.getTelephone()+"', '"+reservation.getNotes()+"')";
           stmt.executeUpdate(sql);

        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 conn.close();
           }catch(SQLException se){
           }// do nothing
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
     }
}