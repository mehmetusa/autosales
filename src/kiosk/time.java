package kiosk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class time {
	
	
	
	public static void main(String[] args) {
		System.out.println(dates());
		System.out.println(kiosklog_file_name());

	//System.out.println(todays_date_id_for_database());	
	//System.out.println(todays_date_id_for_database2());	

	}
	
	
	public static String dates(){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
	//	System.out.println(dtf2.format(now)); //2016/11/16 12:08:43
		
//		 long millis=System.currentTimeMillis();  
//	        java.sql.Date date=new java.sql.Date(millis);  
//	        System.out.println(date); 
	        
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		//String date = sdf.format(new Date()); 
	//	Date d = new Date();
		// String d = date.toGMTString();
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	//	String date = sdf.format(new Date()); 
	return dtf.format(now);	
	}
	
	
public static String todays_date_id_for_database(){
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now)); //2016/11/16 12:08:43
		
//		 long millis=System.currentTimeMillis();  
//	        java.sql.Date date=new java.sql.Date(millis);  
//	        System.out.println(date); 
	        
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		//String date = sdf.format(new Date()); 
	//	Date d = new Date();
		// String d = date.toGMTString();
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	//	String date = sdf.format(new Date()); 
	return dtf.format(now);	
	}



	
	static LocalDateTime now = LocalDateTime.now();
	static java.util.Date date=new java.util.Date();  
		
	public static String get_year(){
		int year = now.getYear();
	String y = ""+ year;	
	return y;	
	}
	 
	
	public static String get_month(){
		int month =now.getMonthValue();
		String m = ""+month;
	return m;	
	}
		
	
	
	public static String get_day(){
	  int day = now.getDayOfMonth();
	  String d = ""+ day;
	return d;	
	}
	
	
//	public static String get_hour2(){
	//	 long hour = date.toGMTString();
	//	String h =""+hour;
	//return h;	
//	}
	
public static String get_hour(){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String aa = dtf.format(now);
    	return aa;	
	}
	
	
	public static String get_min(){
		java.util.Date date=new java.util.Date();  

		int minute = date.getMinutes();
		String mi = ""+ minute;
	return mi;	
	}
	
	
	public static String eventlog_file_name(){
		
		String s0 = "C:\\KioskFiles\\EventLogs";
		String s1 = "Event";
		String s2 = "Log";
	    String s3 = time.get_day();
		String s4 = ".";
		String s5 = time.get_month();
		String s6 = ".";
		String s7 = time.get_year();
		String s8 = ".txt";
		String day_of_file = s0.concat(s1).concat(s2).concat(s3).concat(s4).concat(s5).concat(s6).concat(s7).concat(s8);
	//	System.out.println(day_of_file);
		
		return day_of_file;
	}
		
public static String kiosklog_file_name(){
	String day_of_file = null;
		try {
			String s0 = "C:\\KioskFiles\\EventLogs\\";
			String s1 = "Kiosk";
			String s2 = "Log";
			String s3 = time.get_day();
			String s4 = ".";
			String s5 = time.get_month();
			String s6 = ".";
			String s7 = time.get_year();
			String s8 = ".txt";
			day_of_file = s0.concat(s1).concat(s2).concat(s3).concat(s4).concat(s5).concat(s6).concat(s7).concat(s8);
//	System.out.println(day_of_file);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return day_of_file;
	}
	
	
		
	
	public static int todays_date_id_for_database2(){
		
		String id1 = time.get_day()+time.get_month()+ time.get_year();
	//	System.out.println(id1);
		Integer id = Integer.parseInt(id1);
		
		return id;
	}
		//SELECT * FROM Orders WHERE OrderDate='2008-11-11'
		
		
	
}
