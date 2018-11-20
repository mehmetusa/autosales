package kiosk;

import static utilities.ConfigReader.getProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class create_sql_table {
	
	public static void main(String[] args) {
		create_table();
	}
	
	
	  
	  static void  CREATE_remote_table(){
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
	             
//	         String sql = "CREATE TABLE REMOTE" +
//	            "(KIOSK_ID INT PRIMARY KEY     NOT NULL," +
//	               " TOTAL_COINS           INT    NOT NULL, " +
//	               " TOTAL_BILLS            INT     NOT NULL,"+
//	               " DAILY_TOTAL_AMOUNT_OF_SALES    INT    NOT NULL, " +
//	               " DAILY_TOTAL_AMOUNT_OF_RETURNS    INT    NOT NULL, " +
//	               " DAILY_TOTAL_RECEIVED_BILLS           INT    NOT NULL, " +
//	               " DAILY_TOTAL_DISPENSED_BILLS            INT     NOT NULL, " +
//	               " DAILY_TOTAL_RECEIVED_COINS           INT    NOT NULL, " +
//	               " DAILY_TOTAL_DISPENSED_COINS            INT     NOT NULL,"+
//	               " TIME                      INT    NOT NULL ,"+
//	               " DAY                          INT     NOT NULL, " +
//	               " MONTH                       INT    NOT NULL,  "+
//	               " YEAR                      INT    NOT NULL  )";
	        stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	   }
	  

	static void create_table() {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + getProperty("connection") + "",
					getProperty("database_name"), getProperty("database_password"));
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			 String create_table = " CREATE TABLE public.kiosk_3403"+
					 "("+
					 " report_day integer NOT NULL,"+
					 " total_coins integer NOT NULL,"+
					 " total_bills integer NOT NULL,"+
					 " daily_total_amount_of_sales integer NOT NULL,"+
					 " daily_total_amount_of_returns integer NOT NULL, "+
					 " daily_total_received_bills integer NOT NULL, "+
					 " daily_total_dispensed_bills integer NOT NULL, "+
					 " daily_total_received_coins integer NOT NULL, "+
					 " daily_total_dispensed_coins integer NOT NULL, "+
					 " minute integer NOT NULL, "+
					 " hour integer NOT NULL, "+
					 " day integer NOT NULL, "+
					 " month integer NOT NULL, "+
					 " year integer NOT NULL, "+
					 " CONSTRAINT kiosk_3403_pkey PRIMARY KEY (report_day) "+
					 ")"+
					 " WITH ( "+
					 " OIDS = FALSE "+
					 " ) "+
					 " TABLESPACE pg_default; " ;
					//
					// " ALTER TABLE public.kiosk_3406 "+
					// " OWNER to postgres; ";
					 System.out.println(create_table);
					 stmt.executeUpdate(create_table);

			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		//	System.exit(0);
		}
		System.out.println("Operation done successfully");
	}

}
