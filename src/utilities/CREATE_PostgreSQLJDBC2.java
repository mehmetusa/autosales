package utilities;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 * CREATE A TABLE
 * 
 */


public class CREATE_PostgreSQLJDBC2 {
   public static void main( String args[] ) {
	   //ADD_column();
	   CREATE_table();
   }
   
   
   
  static void  CREATE_table(){
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/cc",
            "postgres", "admin");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         
         String sql = "CREATE TABLE REMOTE" +
                 "(KIOSK_ID INT PRIMARY KEY     NOT NULL," +
                    " OPEN_LOCK      INT, " +
                    " CLOSE_lOCK     INT, " +
                    " DISPENSE_1     INT, " +
                    " DDISPENSE_5    INT, " +
                    " DISPENSE_10    INT, " +
                    " PAID           INT, " +
                    " MIN            INT, " +
                    " HOUR           INT, " +
                    " TIME           INT, " +
                    " DAY            INT, " +
                    " MONTH          INT, " +
                    " YEAR           INT  )";
             
//         String sql = "CREATE TABLE REMOTE" +
//            "(KIOSK_ID INT PRIMARY KEY     NOT NULL," +
//               " TOTAL_COINS           INT    NOT NULL, " +
//               " TOTAL_BILLS            INT     NOT NULL,"+
//               " DAILY_TOTAL_AMOUNT_OF_SALES    INT    NOT NULL, " +
//               " DAILY_TOTAL_AMOUNT_OF_RETURNS    INT    NOT NULL, " +
//               " DAILY_TOTAL_RECEIVED_BILLS           INT    NOT NULL, " +
//               " DAILY_TOTAL_DISPENSED_BILLS            INT     NOT NULL, " +
//               " DAILY_TOTAL_RECEIVED_COINS           INT    NOT NULL, " +
//               " DAILY_TOTAL_DISPENSED_COINS            INT     NOT NULL,"+
//               " TIME                      INT    NOT NULL ,"+
//               " DAY                          INT     NOT NULL, " +
//               " MONTH                       INT    NOT NULL,  "+
//               " YEAR                      INT    NOT NULL  )";
        stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
  
  
  
  
  static void  ADD_column(){
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/cc2",
            "postgres", "admin");
         System.out.println("2 Opened database successfully");

         stmt = c.createStatement();
         String sql = "ALTER TABLE remote"+
               //  "(KIOSK_ID INT PRIMARY KEY     NOT NULL," +
        		 "ADD COLUMN HOUR INT  NOT NULL ,"+
        		 "ADD COLUMN MIN  INT    NOT NULL ,"+
        		 "ADD COLUMN DAY  INT    NOT NULL ,"+
        		 "ADD COLUMN MONTH  INT    NOT NULL ,"+
        		 "ADD COLUMN YEAR  INT    NOT NULL ,";
          //  "(KIOSK_ID INT PRIMARY KEY     NOT NULL," +
            
         stmt.execute(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("columns updated successfully");
   }
  
  
}
