package kiosk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class  read_file {
	public static void main(String[] args) {
	//	System.out.println(rented_stroller());
	//	returned_stroller();
	//	paid_coin();
		coins();
		
	}
	
	public static String coins() {
		Integer rented1 = 0;
		ArrayList<String> list = new ArrayList<String>();
		try {
			File f = new File(time.eventlog_file_name());
					//"C:\\kioskfiles\\EventLog12.11.2018.txt");
			Scanner scan;
			scan = new Scanner(f);
			while (scan.hasNext()) {
				list.add(scan.nextLine());
				
				//System.out.println(scan.nextLine());
			}
			scan.close();
//			Object[] aaa = list.toArray();
//			for (Object bb : aaa) {
//				list.add(bb.toString());
//			}
			for (String b : list) {
				if (b.contains("Returned Car In")) {
					rented1++;
				}
				
			}
			 System.out.println(list.size());
			System.out.println("coins   " + rented1);
			System.out.println("coins   " + list.get(31));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        int rent = rented1/2;
  //      System.out.println(rent);
		return String.valueOf(rent);
		}

	public static String rented_stroller() {
		Integer rented1 = 0;
		ArrayList<String> list = new ArrayList<String>();
		try {
			File f = new File(time.eventlog_file_name());
					//"C:\\kioskfiles\\EventLog12.11.2018.txt");
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
	
	
	public static int returned_stroller() {
		int x1 = 0;
		ArrayList<String> list = new ArrayList<String>();
		try {
			File f = new File(time.eventlog_file_name());
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
	
	
	public static int paid_coin() {
		int x1 = 0;
		ArrayList<String> list = new ArrayList<String>();
		try {
			File f = new File(time.eventlog_file_name());
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
	
	 public static String test(int i){
	        String nums = null;
			try {
				File f = new File("C:\\kioskfiles\\remote.txt");			
				Scanner scan = new Scanner(f);
				ArrayList<String> list = new ArrayList<String>();
				while(scan.hasNext()){
				     list.add(scan.next());
				}
				 nums = list.get(i);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	     
	    	return nums;
	    	} 
	
	
	
}
