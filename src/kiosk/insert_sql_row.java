package kiosk;

import static utilities.ConfigReader.getProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert_sql_row {

	insert_sql_row() {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + getProperty("connection") + "",
					getProperty("database_name"), getProperty("database_password"));
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			String insert_sql = "INSERT INTO public.kiosk_"+ getProperty("kiosk_id")+"("
					+ "report_day, total_coins, total_bills, daily_total_amount_of_sales, daily_total_amount_of_returns, daily_total_received_bills, daily_total_dispensed_bills, daily_total_received_coins, daily_total_dispensed_coins, hour, day, month, year, minute)"
					+ "  VALUES(" + time.todays_date_id_for_database() + ", 999, 3, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3,"
					+ time.get_min() + ");";
			System.out.println("INSERT" + insert_sql);
			stmt.executeUpdate(insert_sql);

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
