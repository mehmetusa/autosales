package kiosk;

import java.time.LocalDateTime;

public class time {
	
	public static void main(String[] args) {
		 System.out.println(get_year());
	System.out.println(todays_date_id_for_database());	
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
	
	
	public static String get_hour(){
		int hour = date.getHours();
		String h =""+hour;
	return h;	
	}
	
	
	public static String get_min(){
		java.util.Date date=new java.util.Date();  

		int minute = date.getMinutes();
		String mi = ""+ minute;
	return mi;	
	}
	
	
	public static String eventlog_file_name(){
		
		String s0 = "C:\\kioskfiles\\";
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
		
		
	
	public static int todays_date_id_for_database(){
		
		String id1 = time.get_day()+time.get_month()+ time.get_year();
		System.out.println(id1);
		Integer id = Integer.parseInt(id1);
		
		return id;
	}
		//SELECT * FROM Orders WHERE OrderDate='2008-11-11'
		
		
	
}
