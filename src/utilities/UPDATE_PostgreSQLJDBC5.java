package utilities;

import static utilities.ConfigReader.getProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * 
 * UPDATE Operation
 */

import  StepDefinitions.*;
import kiosk.read_file;
import kiosk.time;

public class UPDATE_PostgreSQLJDBC5 {
   public static void main( String args[] ) {
	   UPDATE_PostgreSQLJDBC5 a = new UPDATE_PostgreSQLJDBC5();
	   a.UPDATE();
   }
   
   public static void UPDATE(){
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/cc2",
            "postgres", "admin");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "UPDATE kiosk_"+ getProperty("kiosk_id") +  " VALUES (1,2,3,4,5,6,7,8,9,9,8,7,6"
         		//+ "" + "'0' ,'0', '1','"+read_file.rented_stroller()+"','"+
        		 //read_file.returned_stroller()  +"','0','0','0', '1','11','21','11','15','2018'"
        		 		+ " )  WHERE kiosk_id = " +time.todays_date_id_for_database() + ";";
        //"UPDATE kiosk_3401 set total_coins ="+ readfiles2.test(5) +  "where KIOSK_ID=19112018;";
        System.out.println(sql);
         stmt.executeUpdate(sql);
         c.commit();

//         ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
//         while ( rs.next() ) {
//            int id = rs.getInt("id");
//            String  name = rs.getString("name");
//            int age  = rs.getInt("age");
//            String  address = rs.getString("address");
//            float salary = rs.getFloat("salary");
//            System.out.println( "ID = " + id );
//            System.out.println( "NAME = " + name );
//            System.out.println( "AGE = " + age );
//            System.out.println( "ADDRESS = " + address );
//            System.out.println( "SALARY = " + salary );
//            System.out.println();
//         }
 //        rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
   }
}
