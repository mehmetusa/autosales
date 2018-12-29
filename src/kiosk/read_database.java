package kiosk;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import kiosk.properties;;

public class read_database {

	public static void main(String[] args) throws IOException, InterruptedException {
		read_database.read();
	}

	public static void read() {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + properties.connection + "",
					properties.database_name, properties.database_password );
			c.setAutoCommit(false);
			System.out.println("Read db and write file opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT  close_lock , open_lock, dispense_1, dispense_5, dispense_10 , paid , dispense_bill "
					+ "FROM remote WHERE kiosk_id ="
					+ properties.kiosk_id + ";";

			System.out.println(sql);
		    stmt.executeQuery(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				// String kiosk_id = resultSet.getString(0);
				// System.out.println(kiosk_id);
				String close_lock = resultSet.getString("close_lock");
				System.out.println(close_lock);
				String open_lock = resultSet.getString("open_lock");
				System.out.println(open_lock);
				String dispense_1 = resultSet.getString("dispense_1");
				System.out.println(dispense_1);
				String dispense_5 = resultSet.getString("dispense_5");
				System.out.println(dispense_5);
				String dispense_10 = resultSet.getString("dispense_10");
				System.out.println(dispense_10);
				String paid = resultSet.getString("paid");
				System.out.println(paid);
				//String date = resultSet.getString("date");
			//	System.out.println(date);
				String dispense_bill = resultSet.getString("dispense_bill");
				System.out.println(dispense_bill);
//				String day = resultSet.getString("day");
//				System.out.println(day);
//				String month = resultSet.getString("month");
//				System.out.println(month);
//				String year = resultSet.getString("year");
//				System.out.println(year);

				List<String> lines = Arrays.asList("close_lock", close_lock,
						"open_lock", open_lock, "dispense_1", dispense_1, "dispense_5", dispense_5, "dispense_10",
						dispense_10, "paid", paid, "dispense_bill", dispense_bill 
						);
				File filename = new File("C:\\KioskFiles\\remote.txt");
				filename.delete();
				Files.deleteIfExists(filename.toPath());
				Thread.sleep(1000);
				filename.createNewFile();
				Files.write(filename.toPath(), lines, StandardOpenOption.APPEND);
				
				String sql_reset_zero = "UPDATE public." + properties.remote+ " SET " +
						 " close_lock =0 "+
						 ", open_lock=0"+
						 ", dispense_1=0"+
						 ", dispense_5=0"+
						 ", dispense_10=0"+
						 ", paid=0"+
						 ", dispense_bill=0"+
						"  WHERE kiosk_id ="
						+properties.kiosk_id + ";";

				System.out.println(sql_reset_zero);
				stmt.executeUpdate(sql_reset_zero);
				
				c.commit();
				stmt.close();
				c.close();

			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("Connection failure.");

		}
		System.out.println("Read db and write file done successfully");
		
		
		
		
		
		
		
		
		
		
//		try {
//			Class.forName("org.postgresql.Driver");
//			c = DriverManager.getConnection("jdbc:postgresql://" + getProperty("connection") + "",
//					getProperty("database_name"), getProperty("database_password"));
//			c.setAutoCommit(false);
//			System.out.println("Read db and write file opened database successfully");
//			stmt = c.createStatement();
//			
//			//UPDATE public.remote SET  close_lock =0,open_lock=0, dispense_1=0, dispense_5=0, dispense_10=0, paid=0  WHERE kiosk_id =3401;
//
//			//UPDATE public.remote SET close_lock=0, open_lock=0, dispense_1=0, dispense_5=0, dispense_10=0, paid=0 where kiosk_id =3401;
//			String sql = "UPDATE public." + getProperty("remote") + " SET " +
//					 " close_lock =0 "+
//					 ", open_lock=0"+
//					 ", dispense_1=0"+
//					 ", dispense_5=0"+
//					 ", dispense_10=0"+
//					 ", paid=0"+
//					"  WHERE kiosk_id ="
//					+ getProperty("kiosk_id") + ";";
//
//			System.out.println(sql);
//		    stmt.executeQuery(sql);
//							
//				c.commit();
//				stmt.close();
//				c.close();
//
//			
//		} catch (Exception e) {
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.out.println("Connection failure.");
//
//		}
//		System.out.println("Database has been executed to 0(ZERO) successfully");

	}
}
	 