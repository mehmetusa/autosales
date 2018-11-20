package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/*
 * INSERT OPERATION
 * 
 * 
 */
public class INSERT_PostgreSQLJDBC3 {
   public static void main(String args[]) {
      Connection c = null;
      Statement stmt = null;
      int kiosk1 = 3401;
      int kiosk2 = 3402;
      int kiosk3 = 3413;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/cc2",
            "postgres", "admin");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO REMOTE "
            + "VALUES ("+ kiosk3+ " ,0, 1,0, 1, 0,0,0,11,21,11,15,2018 )";
       //  + "VALUES ("+ kiosk2+  ", 0, 1, 1, 0,0,0, 0,0,13,11,115,0,5,121,11,15,2018 );"
        // + "VALUES ("+ kiosk3+  ", 0, 1, 1, 0,0,0, 0,0,13,11,115,0,5,121,11,15,2018 );";
         stmt.executeUpdate(sql);

      

         stmt.close();
         c.commit();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}