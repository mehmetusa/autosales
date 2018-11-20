package kiosk;

import static utilities.ConfigReader.getProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class write_database {

	public static void kiosk_data_update() {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + getProperty("connection") + "",
					getProperty("database_name"), getProperty("database_password"));
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql2 = "SELECT report_day FROM public.kiosk_" + getProperty("kiosk_id") + " where report_day= "
					+ time.todays_date_id_for_database() + ";";

			System.out.println("report day ========= " + sql2);
			PreparedStatement pst = c.prepareStatement(sql2);
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				int id = rs.getInt("report_day");
				System.out.println("ID = " + id);
			}
			try {
				boolean isResult = pst.execute();
				System.out.println("RESULT IS " + isResult);
				if (isResult = true) {
					System.out.println("===========inset===========");
					new insert_sql_row();
				}
				new update_sql_row();
				System.out.println("===========update===========");
			} catch (Exception e) {
				System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}

			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
		}
		System.out.println("Operation done successfully");
	}

}


//	public static void UPDATE() {
//		Connection c = null;
//		Statement stmt = null;
//
//		try {
//			Class.forName("org.postgresql.Driver");
//			c = DriverManager.getConnection("jdbc:postgresql://" + getProperty("connection") + "",
//					getProperty("database_name"), getProperty("database_password"));
//			c.setAutoCommit(false);
//			System.out.println("Opened database successfully");
//			stmt = c.createStatement();
//			String sql = "UPDATE remote set close_lock =" + read_file.test(5) + "where KIOSK_ID="
//					+ getProperty("kiosk_id") + ";";
//			stmt.executeUpdate(sql);
//
//			String sql2 = "UPDATE kiosk_" + getProperty("kiosk_id") + " VALUES (" + time.todays_date_id_for_database()
//					+ " ,0, 1," + read_file.rented_stroller() + "," + read_file.returned_stroller()
//					+ "0,0,0, 1,11,21,11,15,2018 )";
//			stmt.executeUpdate(sql2);
//
//			String sql3 = "UPDATE kiosk_" + getProperty("kiosk_id") + " set daily_total_amount_of_returns ="
//					+ read_file.returned_stroller() + "where KIOSK_ID=" + getProperty("kiosk_id") + ";";
//			stmt.executeUpdate(sql3);
//
//			c.commit();
//			stmt.close();
//			c.close();
//		} catch (Exception e) {
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(0);
//		}
//		System.out.println("Operation done successfully");
//	}



			/*
			 * 
			 * INSERT INTO table (column1, column2, …) VALUES (value1, value2,
			 * …), (value1, value2, …) ,...;
			 */

			// String create_table_row =
			// "INSERT INTO kiosk_3401" +
			// // "(report_day INT PRIMARY KEY NOT NULL," +
			// // String create_sql = "CREATE TABLE public.kiosk_3401"+
			//// "("+
			//
			// " report_day,"+ // integer NOT NULL,"+
			// " total_coins,"+ // integer NOT NULL,"+
			// " total_bills,"+ // integer NOT NULL,"+
			// " daily_total_amount_of_sales, "+ // integer NOT NULL,"+
			// " daily_total_amount_of_returns, " + // integer NOT NULL,"+
			// " daily_total_received_bills," + //integer NOT NULL,"+
			// " daily_total_dispensed_bills," + //integer NOT NULL,"+
			// " daily_total_received_coins,"+// integer NOT NULL,"+
			// " daily_total_dispensed_coins,"+// integer NOT NULL,"+
			// " hour,"+ // integer NOT NULL,"+
			// " day," +// integer NOT NULL,"+
			// " month,"+ // integer NOT NULL,"+
			// " year,"+ // integer NOT NULL,"+
			// " minute,"+// integer NOT NULL,"+
			//// " CONSTRAINT kiosk_3401_pkey PRIMARY KEY (report_day)"+
			// ");";
			//// "WITH ("+
			//// "OIDS = FALSE"+
			//// ")"+
			//// "TABLESPACE pg_default;";
			//
			//
			// System.out.println(create_table_row);
			// stmt.executeUpdate(create_table_row);
			//
//
//			String insert_sql = "INSERT INTO public.kiosk_3401("
//					+ "report_day, total_coins, total_bills, daily_total_amount_of_sales, daily_total_amount_of_returns, daily_total_received_bills, daily_total_dispensed_bills, daily_total_received_coins, daily_total_dispensed_coins, hour, day, month, year, minute)"
//					+ "  VALUES(" + time.todays_date_id_for_database() + ", 999, 3, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3,"
//					+ time.get_min() + ");";
//			 System.out.println("INSERT" +insert_sql);
//			// stmt.executeUpdate(sql3);
//
//			String update_sql = "UPDATE public.kiosk_" + getProperty("kiosk_id") + " SET " + "report_day="
//					+ time.todays_date_id_for_database() + ", total_coins=" + read_file.rented_stroller()
//					+ ", total_bills= " + read_file.returned_stroller() + ", daily_total_amount_of_sales="
//					+ time.todays_date_id_for_database() + ", daily_total_amount_of_returns="
//					+ time.todays_date_id_for_database() + ", daily_total_received_bills="
//					+ time.todays_date_id_for_database() + ", daily_total_dispensed_bills="
//					+ time.todays_date_id_for_database() + ", daily_total_received_coins="
//					+ time.todays_date_id_for_database() + ", daily_total_dispensed_coins="
//					+ time.todays_date_id_for_database() + ",minute=" + time.get_min() + ",hour=" + time.get_hour()
//					+ ", day=" + time.get_day() + ", month=" + time.get_month() + ", year=" + time.get_year()
//					+ "WHERE report_day =" + time.todays_date_id_for_database() + ";";
//
			// System.out.println(update_sql);
			// stmt.executeUpdate(sql4);

			

			// int report_day_id= li.get(0);
			// System.out.println("report day id "+ report_day_id);

			// if(report_day_id== time.todays_date_id_for_database()){

//			boolean isResult = pst.execute();
//			System.out.println("RESULT IS " +  isResult);
			//try {
			//	if (isResult = true) {
					
		//		}

		//		else {

//					try {
//						new insert_sql(); 
//
//						System.out.println("===========inset===========");
//					} catch (Exception e) {
//						System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//						e.printStackTrace();
//					}
	//			}
//			} catch (Exception e) {
//				System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//				e.printStackTrace();
//			}

			


// ResultSet rs = stmt.executeQuery( "SELECT kiosk_id FROM kiosk_3401;" );
// while ( rs.next() ) {
//
// System.out.println(rs.getString(1));
// int id = rs.getInt("kiosk_id");
// System.out.println("nnnnnnnnnnnnnn "+id);
// li.add(id);
// }
// for(int a: li){
// if(a==time.todays_date_id_for_database()){
// System.out.println("mmmmmmmmmm "+a);
// // int lines = rs.findColumn("kiosk_id");
// String sql = "UPDATE kiosk_3401 set time = "+ read_file.test(5) + " where
// kiosk_id = 19112018";
// System.out.println(sql);
// stmt.executeUpdate(sql);
//
// }else {
// System.out.println( "ID = vvvvvvvvv" );}
//
// }

// String sql2 = "UPDATE kiosk_"+ getProperty("kiosk_id") + " VALUES ("+
// time.todays_date_id_for_database() +
// " ,0, 1,"+read_file.rented_stroller()+","+ read_file.returned_stroller()
// +",0,0, 1,11,21,11,15,2018 ) where kiosk_id=
// "+time.todays_date_id_for_database() + ";";
// System.out.println(sql2.toString());
// stmt.executeUpdate(sql2);

// String sql = "SELECT EXISTS (SELECT kiosk_"+ getProperty("kiosk_id")+ "FROM
// cc2 WHERE KIOSK_ID="+ time.todays_date_id_for_database()+ ") BEGIN" +
// "UPDATE kiosk_"+ getProperty("kiosk_id") + " VALUES ("+
// time.todays_date_id_for_database() + " ,0,
// 1,"+read_file.rented_stroller()+","+
// read_file.returned_stroller() +"0,0,0, 1,11,21,11,15,2018 );"
// + " END ELSE BEGIN " +
// "INSERT INTO kiosk_"+ getProperty("kiosk_id") + " VALUES ("+
// time.todays_date_id_for_database() + " ,0,
// 1,"+read_file.rented_stroller()+","+
// read_file.returned_stroller() +"0,0,0, 1,11,21,11,15,2018 ); END";
//
// BEGIN
//
// IF EXISTS(SELECT 1 FROM table_1 WHERE label_id = _labelid limit 1) THEN
//
// result := 'true';
//
// ELSEIF EXISTS(SELECT 1 FROM table_2 WHERE label_id = _labelid limit 1) THEN
//
// result := 'true';
//
// ELSEIF EXISTS(SELECT 1 from table_3 WHERE label_id = _labelid limit 1) THEN
//
// result := 'true';
//
// ELSE
//
// result := 'false';
// END IF;
//
// RETURN;
// END

//
// String sql = "BEGIN IF (SELECT * FROM kiosk_"+ getProperty("kiosk_id")+ "
// WHERE EXISTS (" +time.todays_date_id_for_database() + ") THEN "
// + "UPDATE kiosk_"+ getProperty("kiosk_id") + " VALUES("+
// time.todays_date_id_for_database() + " ,0,
// 1,"+read_file.rented_stroller()+","+
// read_file.returned_stroller() +"0,0,0, 1,11,21,11,15,2018 ) WHERE kiosk_id =
// " +time.todays_date_id_for_database() + ";"
// + " ELSE " +
// "INSERT INTO kiosk_"+ getProperty("kiosk_id") + " VALUES("+
// time.todays_date_id_for_database() + " ,0,
// 1,"+read_file.rented_stroller()+","+
// read_file.returned_stroller() +"0,0,0, 1,11,21,11,15,2018 ); RETURN; END";
// System.out.println(sql);
// stmt.executeUpdate(sql);
// String sql1 = "UPDATE remote set close_lock ="+ read_file.test(5) + "where
// KIOSK_ID=" + getProperty("kiosk_id") + ";";

/*
 * 
 * INSERT INTO table(column1, column2, …) VALUES (value1, value2, …);
 * 
 * 
 * 
 * 
 * IF EXISTS (SELECT * FROM Bookings WHERE FLightID = @Id) BEGIN --UPDATE HERE
 * END ELSE BEGIN -- INSERT HERE END
 * 
 * 
 * 
 * 
 * 
 * SELECT EXISTS(SELECT 1 FROM address WHERE address_id = 100);
 */

//
// String sql5 = "INSERT INTO REMOTE "
// + "VALUES ("+ kiosk3+ " ,0, 1,0, 1, 0,0,0,11,21,11,15,2018 )";
// // + "VALUES ("+ kiosk2+ ", 0, 1, 1, 0,0,0, 0,0,13,11,115,0,5,121,11,15,2018
// );"
// // + "VALUES ("+ kiosk3+ ", 0, 1, 1, 0,0,0, 0,0,13,11,115,0,5,121,11,15,2018
// );";
// stmt.executeUpdate(sql);

// String sql3 = "UPDATE kiosk_"+ getProperty("kiosk_id") + " set
// daily_total_amount_of_returns ="+ read_file.returned_stroller() + "where
// KIOSK_ID=" + getProperty("kiosk_id") + ";";
// stmt.executeUpdate(sql3);
