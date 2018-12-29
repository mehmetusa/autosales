package kiosk;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import kiosk.properties;;

public class Write_file {
        static Connection c = null;
		static Statement stmt = null;
		static List<String> lines = null;
	public static void main(String[] args) throws IOException, InterruptedException {

	//update_totalcash();
	//test();
		write_used_codes();
}
	public static void update_totalcash() {
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + properties.connection + "",
					properties.database_name, properties.database_password );
			c.setAutoCommit(false);
			System.out.println("Read db and write file opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT  set_coins, set_bills "
					+ "FROM remote WHERE kiosk_id ="
					+ properties.kiosk_id + ";";

			System.out.println(sql);
		    stmt.executeQuery(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				String set_coins = resultSet.getString("set_coins");
				System.out.println(set_coins);
				String set_bills = resultSet.getString("set_bills");
				System.out.println(set_bills);
			

				lines = Arrays.asList("set_bills", set_bills,"set_coins", set_coins);
				System.out.println("xxxxxxxxx  "+set_coins+"  "+ set_bills);
				
				Path path = Paths.get("C:\\KioskFiles\\TotalCash.txt");
				List<String> line = Files.readAllLines(path, StandardCharsets.UTF_8);
		
		        line.remove(0);
		        line.add(0,set_coins);
		        line.remove(2);				
				line.add(2, set_bills);
				Files.write(path, line, StandardCharsets.UTF_8);
		//		Path path = Paths.get("C:\\KioskFiles\\TotalCash.txt");
		//		List<String> line = Files.readAllLines(path, StandardCharsets.UTF_8);
				
		//		int position = lines.size(1);
		//		String extraLine = "This is an extraline";  
		//        lines.remove(0);
		  //      lines.remove(2);
		//		lines.add(0, set_coins);
		//		lines.add(2, set_bills);

		//		Files.write(path, line, StandardCharsets.UTF_8);
				
//				try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
//				    writer.write("nnnnnnnn");
//				} catch (IOException ioe) {
//				    System.err.format("IOException: %s%n", ioe);
//				}
//				
//				File filename = new File("C:\\KioskFiles\\remote2.txt");
//				filename.delete();
//				Files.deleteIfExists(filename.toPath());
//				Thread.sleep(1000);
//				filename.createNewFile();
//				Files.write(filename.toPath(), lines, StandardOpenOption.APPEND);
//				
	//			c.commit();
				stmt.close();
				c.close();

			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("Connection failure.");

		}
		System.out.println("Read db and write file done successfully");
	}

	public static void write_used_codes() {
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + properties.connection + "",
					properties.database_name, properties.database_password );
		//	c.setAutoCommit(false);
			System.out.println("Read db and write file opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT  dispensed_1_codes, dispensed_5_codes, dispensed_10_codes, dispensed_paid_codes, dispensed_bill_codes "
					+ "FROM public.codes_"+properties.kiosk_id+";";

			System.out.println(sql);
		    stmt.executeQuery(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {

//				 System.out.println(rs.getString("dispensed_1_codes") + "\t"
//		                    + rs.getString("dispensed_5_codes") + "\t"
//		                    		 + rs.getString("dispensed_10_codes") + "\t"
//		                    				 + rs.getString("dispensed_paid_codes") + "\t"
//		                    + rs.getString("dispensed_bill_codes"));
					    String dispensed_1_codes = resultSet.getString("dispensed_1_codes");
				System.out.println(resultSet.getString(dispensed_1_codes));
					String dispensed_5_codes = resultSet.getString("dispensed_5_codes");
					System.out.println(dispensed_5_codes);
				String dispensed_10_codes = resultSet.getString("dispensed_10_codes");
					System.out.println(dispensed_10_codes);
					String dispensed_paid_codes = resultSet.getString("dispensed_paid_codes");
					System.out.println(dispensed_paid_codes);
					String dispensed_bill_codes = resultSet.getString("dispensed_bill_codes");
						System.out.println(dispensed_bill_codes);
			
			

//				lines = Arrays.asList("set_bills", set_bills,"set_coins", set_coins);
//				System.out.println("xxxxxxxxx  "+set_coins+"  "+ set_bills);
//				
//				Path path = Paths.get("C:\\KioskFiles\\TotalCash.txt");
//				List<String> line = Files.readAllLines(path, StandardCharsets.UTF_8);
//		
//		        line.remove(0);
//		        line.add(0,set_coins);
//		        line.remove(2);				
//				line.add(2, set_bills);
//				Files.write(path, line, StandardCharsets.UTF_8);
		
				stmt.close();
				c.close();

			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("Connection failure.");

		}
		System.out.println("Read db and write file done successfully");
			
			}
	
}
	 