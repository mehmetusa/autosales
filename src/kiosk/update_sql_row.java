package kiosk;

import static utilities.ConfigReader.getProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class update_sql_row {

	update_sql_row() {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + getProperty("connection") + "",
					getProperty("database_name"), getProperty("database_password"));
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			String update_sql = "UPDATE public.kiosk_" + getProperty("kiosk_id") + " SET " + 
			"report_day="+ time.todays_date_id_for_database() + 
			", total_coins=" + read_file.rented_stroller()+ 
			", total_bills= " + read_file.returned_stroller() + 
			", daily_total_amount_of_sales="+ read_file.rented_stroller()+ 
			", daily_total_amount_of_returns="+ read_file.returned_stroller() + 
			", daily_total_received_bills="	+ time.todays_date_id_for_database() +
			", daily_total_dispensed_bills="+ time.todays_date_id_for_database() +
			", daily_total_received_coins="	+ time.todays_date_id_for_database() + 
			", daily_total_dispensed_coins="+ time.todays_date_id_for_database() + 
			",minute=" + time.get_min() +
			",hour=" + time.get_hour()+ 
			", day=" + time.get_day() + 
			", month=" + time.get_month() + 
			", year=" + time.get_year()	+ 
			" WHERE report_day =" + time.todays_date_id_for_database() +
			";";

			System.out.println(update_sql);
			stmt.executeUpdate(update_sql);
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

