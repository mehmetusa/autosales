package kiosk;


import java.io.IOException;
import java.util.Calendar;


class Carry_Carts_Remote {
	public static void main(String args[]) throws IOException, InterruptedException 
	{      
		Carry_Carts_Remote object = new Carry_Carts_Remote();
	//	Carry_Carts_Remote object2 = new Carry_Carts_Remote();
      object.action();
				
			//	object2.report();
		   
		
	}
 
	private synchronized void action() throws IOException, InterruptedException {
		while (true) {
			System.out.println("action class are running program ==> " + Calendar.getInstance().getTime());
			
			try {
			this.wait(3000);
		//	read_database.read();
			
            write_database.kiosk_data_update();

			} catch (InterruptedException e) {e.printStackTrace();}
		}
 
	}
	
	
	private synchronized void report() throws IOException, InterruptedException {
		while (true) {
			System.out.println("report class are running program ==> " + Calendar.getInstance().getTime());
			
			try {
			this.wait(3000); 
      //      write_database.UPDATE(); 
			}
catch (InterruptedException e) {e.printStackTrace();}
		}
 
	
		}}
	
	
//
//	 public static String test(int i){
//	        String nums = null;
//			try {
//				File f = new File("C:\\kioskfiles\\remote.txt");			
//				Scanner scan = new Scanner(f);
//				ArrayList<String> list = new ArrayList<String>();
//				while(scan.hasNext()){
//				     list.add(scan.next());
//				}
//				 nums = list.get(i);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//	     
//	    	return nums;
//	    	}  
//    	
//	 public void UPDATE2(){
//	      Connection c = null;
//	      Statement stmt = null;
//	      
//	         try {
//	         Class.forName("org.postgresql.Driver");
//	         c = DriverManager.getConnection("jdbc:postgresql://" +getProperty("connection")+ "", 
//	         getProperty("database_name") , getProperty("database_password"));
//	         c.setAutoCommit(false);
//	         System.out.println("Opened database successfully");
//	         stmt = c.createStatement();
//	         
//	         
//	         String sql = "UPDATE remote set close_lock ="+ test(5) +  "where KIOSK_ID=" + getProperty("kiosk_id") + ";";
//	         stmt.executeUpdate(sql);
//	         
//	         String sql2 = "UPDATE kiosk_"+ getProperty("kiosk_id") + " set daily_total_amount_of_sales ="+ read_file_write_database.rented_stroller() + "where kiosk_id=" + getProperty("kiosk_id") + ";";
//	         stmt.executeUpdate(sql2);
//	         
//	         String sql3 = "UPDATE kiosk_"+ getProperty("kiosk_id") + " set daily_total_amount_of_returns ="+ read_file_write_database.returned_stroller() +  "where KIOSK_ID=" + getProperty("kiosk_id") + ";";
//	         stmt.executeUpdate(sql3);
//	         
//	         
//	         
//	         c.commit();
//	         stmt.close();
//	         c.close();
//	      } catch ( Exception e ) {
//	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//	         System.exit(0);
//	      }
//	      System.out.println("Operation done successfully");
//	   }
//    	
//    	 public void UPDATE(){
//    	      Connection c = null;
//    	      Statement stmt = null;
//    	      
//    	         try {
//    	         Class.forName("org.postgresql.Driver");
//    	         c = DriverManager.getConnection("jdbc:postgresql://" +getProperty("connection")+ "", 
//    	         getProperty("database_name") , getProperty("database_password"));
//    	         c.setAutoCommit(false);
//    	         System.out.println("Opened database successfully");
//    	         stmt = c.createStatement();
//    	         
//    	         
//    	         String sql = "UPDATE remote set close_lock ="+ test(5) +  "where KIOSK_ID=" + getProperty("kiosk_id") + ";";
//    	         stmt.executeUpdate(sql);
//    	         
//    	         String sql2 = "UPDATE kiosk_"+ getProperty("kiosk_id") + " set daily_total_amount_of_sales ="+ read_file_write_database.rented_stroller() + "where kiosk_id=" + getProperty("kiosk_id") + ";";
//    	         stmt.executeUpdate(sql2);
//    	         
//    	         String sql3 = "UPDATE kiosk_"+ getProperty("kiosk_id") + " set daily_total_amount_of_returns ="+ read_file_write_database.returned_stroller() +  "where KIOSK_ID=" + getProperty("kiosk_id") + ";";
//    	         stmt.executeUpdate(sql3);
//    	         
//    	         
//    	         
//    	         c.commit();
//    	         stmt.close();
//    	         c.close();
//    	      } catch ( Exception e ) {
//    	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//    	         System.exit(0);
//    	      }
//    	      System.out.println("Operation done successfully");
//    	   }
    	
    
