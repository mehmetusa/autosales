package kiosk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class  read_file {
	
	static File f = new File(time.kiosklog_file_name());
	
	public static void main(String[] args) throws IOException {
	//	System.out.println(rented_stroller());
	//	returned_stroller();
	//	paid_coin();
		System.out.println(coins_in_hopper());
	//	total_bills();
		
	}
	
	
	
	public static String  inserted_coins() throws IOException {
		LinkedList<String> li = new LinkedList<String>();
		try {
		//	File f = new File(time.kiosklog_file_name());
			          // "C:\\kioskfiles\\KioskLog12.11.2018.txt");
		//	f.createNewFile();
			if(!f.exists()){return "0";	}
			Scanner scan;
			scan = new Scanner(f);
			while (scan.hasNext()) {
				li.add(scan.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(String a:li){
	//		System.out.println(a);
		}
		String[] last_line = li.getLast().split(" ");
		
		String coin = last_line[12];
    //    System.out.println(coin);		
        return coin;
	}
	
	
	
	public static String  total_bills() throws IOException {
		LinkedList<String> li = new LinkedList<String>();
		try {
		//	File f = new File(time.kiosklog_file_name());
			          // "C:\\kioskfiles\\KioskLog12.11.2018.txt");
		//	f.createNewFile();
			if(!f.exists()){return "0";	}
			Scanner scan;
			scan = new Scanner(f);
			while (scan.hasNext()) {
				li.add(scan.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(String a:li){
	//		System.out.println(a);
		}
		String[] last_line = li.getLast().split(" ");
		
		String bill = last_line[10];
  //      System.out.println(bill);		
        return bill;
	}
	
	
	
	
	
	public static String  coins_in_hopper() throws IOException {
		LinkedList<String> li = new LinkedList<String>();
		try {
		//	File f = new File(time.kiosklog_file_name());
			          // "C:\\kioskfiles\\KioskLog12.11.2018.txt");
			if(!f.exists()){return "0";	}

			Scanner scan;
			scan = new Scanner(f);
			while (scan.hasNext()) {
				li.add(scan.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] coin_line = li.getLast().split(" ");
		String co = coin_line[coin_line.length - 1];
    //    System.out.println(co);		
        return co;
	}

	
	
	
	
	
	public static String rented_stroller() throws IOException {
		Integer rented1 = 0;
		ArrayList<String> list = new ArrayList<String>();
		try {
			//File f = new File(time.kiosklog_file_name());
					//"C:\\kioskfiles\\EventLog12.11.2018.txt");
			if(!f.exists()){return "0";	}
			if(!f.canRead()){
				return "0";}
			Scanner scan;
			scan = new Scanner(f);
			while (scan.hasNext()) {
				list.add(scan.next());
			}
			scan.close();
			Object[] aaa = list.toArray();
			for (Object bb : aaa) {
				list.add(bb.toString());
			}
			for (String b : list) {
				if (b.contains("Rented")) {
					rented1++;
				}
				
			}
			// System.out.println(list.size());
		//	System.out.println("Rented strollers   " + rented1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        int rent = rented1/2;
        System.out.println(rent);
		return String.valueOf(rent);
		}
	
	
	
	
	
	
	public static int returned_stroller() throws IOException {
		int x1 = 0;
		ArrayList<String> list = new ArrayList<String>();
		try {
		//	File f = new File(time.kiosklog_file_name());
			if(!f.exists()){return 0;	}
		
			Scanner scan;
			scan = new Scanner(f);
			while (scan.hasNext()) {
				list.add(scan.next());
			}
			scan.close();
			Object[] aaa = list.toArray();
			for (Object bb : aaa) {
				list.add(bb.toString());
			}
			for (String b : list) {
				if (b.contains("Returned")) {
					x1++;	
				}}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        int x2=x1/2;
        System.out.println("Returned  strollers   " + x2);
		int returned_stroller = x2;//String.valueOf(x2);
		return returned_stroller;
		}
	
	
	
	
	
	
	
	
	
	public static int paid_coin() throws IOException {
		int x1 = 0;
		ArrayList<String> list = new ArrayList<String>();
		try {
			File f = new File(time.kiosklog_file_name());
			if(!f.exists()){return 0;	}
			Scanner scan;
			scan = new Scanner(f);
			while (scan.hasNext()) {
				list.add(scan.nextLine());
			//	System.out.println(scan.nextLine());
			}
			scan.close();
//			Object[] aaa = list.toArray();
//			for (Object bb : aaa) {
//				list.add(bb.toString());
//				
//			}
			for (String b : list) {
				if (b.contains("PaidOut")) {
					System.out.println(b.substring(39));//lastIndexOf(1));
					x1++;	
				}}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        int x2=x1/2;
        System.out.println("Returned  strollers   " + x2);
		int returned_stroller = x2;//String.valueOf(x2);
		return returned_stroller;
		}
	
	
	
	
	
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
	
	
	
}
