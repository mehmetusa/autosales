package StepDefinitions;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readfiles2 {
	
	public static void main(String[] args) {
		System.out.println(test(5));
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
		//	 System.out.println(nums);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
     
    	return nums;
    	}   
    
}