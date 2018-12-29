package kiosk;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class write_database {
	static List<Integer> li;

	public write_database() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// insert_sql_row();
		// update_sql_row();
		kiosk_data_update();
	}

	public static void kiosk_data_update() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + properties.connection + "",
					properties.database_name, properties.database_password );
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql2 = "SELECT report_day FROM public.kiosk_" + properties.kiosk_id + " where report_day= "
					+ time.todays_date_id_for_database() + ";";

			System.out.println("report day ========= " + sql2);
			boolean rs = stmt.executeQuery(sql2).next();
			System.out.println("ID = " + rs); // li.get(0));
			System.out.println("Todays report day = " + time.todays_date_id_for_database2());
			if (rs == false) {
				System.out.println("===========inset===========");
				insert_sql_row();
			}

			update_sql_row();
			System.out.println("===========update===========");
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
		}
		System.out.println("Operation done successfully");
	}

	public static void update_sql_row() {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + properties.connection + "",
					properties.database_name, properties.database_password );
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			String update_sql = 
					"UPDATE public.kiosk_" + properties.kiosk_id+
					" SET " + 
					"report_day="+ time.todays_date_id_for_database() + 
					", total_coins=" + read_file.coins_in_hopper() +
					", total_bills= " + read_file.total_bills() + 
					", daily_total_amount_of_sales="+ read_file.rented_stroller() + 
					", daily_total_amount_of_returns=" + read_file.returned_stroller()+ 
					", daily_total_received_bills=" + read_file.total_bills() + 
					", daily_total_dispensed_bills="+ time.todays_date_id_for_database() + 
					", daily_total_received_coins=" + read_file.inserted_coins()					+ ", daily_total_dispensed_coins=" + read_file.coins_in_hopper() + ", date= '" + time.dates()
					+ "' WHERE report_day =" + time.todays_date_id_for_database() + ";";

			System.out.println(update_sql);
			stmt.executeUpdate(update_sql);
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
		}
		System.out.println("Operation done successfully");
	}

	static void insert_sql_row() {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + properties.connection + "",
					properties.database_name, properties.database_password );
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			String insert_sql = 
					"INSERT INTO public.kiosk_" + properties.kiosk_id+ "(" + 
			        "report_day, "+ 
			        "total_coins," + 
					"total_bills, " + 
					"daily_total_amount_of_sales, "+ 
					"daily_total_amount_of_returns, " + 
					"daily_total_received_bills, "+ 
					"daily_total_dispensed_bills, " + 
					"daily_total_received_coins, " + 
					"daily_total_dispensed_coins"
					// + ",date"
					+ ")" + 
					" VALUES(" + time.todays_date_id_for_database() + 
					"," + read_file.coins_in_hopper() + ","+ 
					read_file.total_bills() + "," + 
					read_file.rented_stroller() + "," + 
					read_file.returned_stroller()+ "," + 
					read_file.total_bills() + "," + 
					read_file.coins_in_hopper() + ","+
					read_file.inserted_coins() + "," + 
					read_file.coins_in_hopper() +
					// ","+
					// "'"+time.dates()+"'" +
					" );";

			String insert_sql2 = "INSERT INTO public.kiosk_" + properties.kiosk_id + "(" + "report_day, "
					+ "total_coins," + " total_bills, " + "daily_total_amount_of_sales, "
					+ "daily_total_amount_of_returns," + " daily_total_received_bills,"
					+ " daily_total_dispensed_bills," + " daily_total_received_coins," + " daily_total_dispensed_coins,"
					+ "date)" + "  VALUES(" + time.todays_date_id_for_database() + "," + read_file.coins_in_hopper()
					+ "," + read_file.total_bills() + "," + read_file.rented_stroller() + ","
					+ read_file.returned_stroller() + "," + read_file.total_bills() + "," + read_file.coins_in_hopper()
					+ "," + read_file.inserted_coins() + "," + read_file.coins_in_hopper() + "," + "'" + time.dates()
					+ "'" + " );";

			System.out.println("INSERT  " + insert_sql);
			stmt = c.createStatement();
			stmt.executeUpdate(insert_sql);

			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}

}
