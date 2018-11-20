package kiosk;

import static utilities.ConfigReader.getProperty;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class read_database {

//	public static void main(String[] args) {
//		read_database_write_file2();
//	}

	public static void read() {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + getProperty("connection") + "",
					getProperty("database_name"), getProperty("database_password"));
			c.setAutoCommit(false);
			System.out.println("Read db and write file opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT  close_lock , open_lock, dispense_1, dispense_5, dispense_10 , paid , "
					+ "min , hour , day , month , year FROM remote WHERE kiosk_id ="
					+ getProperty("kiosk_id") + ";";

			// stmt.executeQuery(sql);
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
				String min = resultSet.getString("min");
				System.out.println(min);
				String hour = resultSet.getString("hour");
				System.out.println(hour);
				String day = resultSet.getString("day");
				System.out.println(day);
				String month = resultSet.getString("month");
				System.out.println(month);
				String year = resultSet.getString("year");
				System.out.println(year);

				List<String> lines = Arrays.asList("kiosk_id", getProperty("kiosk_id"), "close_lock", close_lock,
						"open_lock", open_lock, "dispense_1", dispense_1, "dispense_5", dispense_5, "dispense_10",
						dispense_10, "paid", paid, "min", min, "hour", hour, "day", day, "month", month, "year", year);
				File filename = new File("C:\\kioskfiles\\remote.txt");
				filename.delete();
				Files.deleteIfExists(filename.toPath());
				Thread.sleep(1000);
				filename.createNewFile();
				Files.write(filename.toPath(), lines, StandardOpenOption.APPEND);
				
				c.commit();
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
	 