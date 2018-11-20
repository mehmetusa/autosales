package StepDefinitions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;



public class abc {
	Path path = Paths.get("C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt");



	public static void main(String[] args) throws IOException {
		write3();
		write();
		write2();
	}
	public void abc() throws IOException {
		System.out.println("OPEN LOCKS");
		String line1 = Files.readAllLines(Paths.get("C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test2.txt")).get(0);
        System.out.println(line1);

        System.out.println("CLOSE LOCKS");
        String line2 = Files.readAllLines(Paths.get("C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test2.txt")).get(1);
        System.out.println(line2);


        System.out.println("GIVE 1");
        String line3 = Files.readAllLines(Paths.get("C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test2.txt")).get(2);
        System.out.println(line3);


        System.out.println("GIVE 5");
        String line4 = Files.readAllLines(Paths.get("C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test2.txt")).get(3);
        System.out.println(line4);
        System.out.println("GIVE 10");
        String line5 = Files.readAllLines(Paths.get("C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test2.txt")).get(4);
      
        //   String line3 = Files.write("C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test.txt", 3);
		
        System.out.println(line5);

	}
	
	static void write3(){
		
		 try {
//	            System.out.println("Enter data to search");
//	            Scanner sc = new Scanner(System.in);
            String word = "Kiosk";//sc.next();
	            String file = "C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt";
	            String file2 = "C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test2.txt";

	            BufferedReader br = new BufferedReader(new FileReader(file)); //"C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test.txt"));
	             
	            String string;
				while((string = br.readLine()) != null){
	                String starr[] = string.split(" ");
	                for (String s2 : starr) {
	                	System.out.println();
	                
	         //       for (String string2 : starr) {
//	                    if(s2.matches(word)){
//	                        System.out.println("Found record for " +word);
//	                        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file2));
//	                        bWriter.write(word +"\n");
//	                        bWriter.flush();
//	                        System.out.println("Data Saved.");
//	                        bWriter.close();
//
//	                    } else {
//	                        System.out.println("Searching...");
//	                    }
	                }	         //System.out.println(starr[2]);

	            }   System.out.println("Done");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	public static void write2() throws IOException{
		String name2 = "China";
		 String file = "C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt";
		final Scanner scanner = new Scanner("C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt");
		while (scanner.hasNextLine()) {
		   final String str= scanner.nextLine();
		   if(str.contains(name2)) { 
		       // Found the input word
		       System.out.println("I found " +name2+ " in file " );
		       break;
		   }}
		}
		public static void write() throws IOException{	
		Path path = Paths.get("C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt");
//	       //     String line2 = Files.readAllLines(path, StandardCharsets.UTF_8).get(2);
//	             List<String> line3 = Files.readAllLines(path);
//	          // while(line3 != null){
//	            for(String sss : line3){
//	            //	System.out.println(sss);
//	            	String[] aaa = sss.split(" ");
//	            	for(String bbb : aaa){
//		            	System.out.println(bbb);
//	             if(bbb.equals("China")){
//	            	 
//	            	 System.out.println("i found China! ");
//	             }
//	             else {
//	            	 System.out.println("noooooooo");
//	             }
//	           }
		try {
		//	Path path = Paths.get("C:\\eclipseworkplace\\Coveros_Test2\\src\\main\\java\\StepDefinitions\\test.txt");
       //     String line2 = Files.readAllLines(path, StandardCharsets.UTF_8).get(2);
       //      List<String> line3 = Files.readAllLines(path);
       //    for(String c: line3){
      //       if(line3.equals("China")){
//            	 
//            	 System.out.println("i found China! ");
//             }
//           }
            //int position = lines.size() / 2;
			//String extraLine = "This is an extraline";  
	//		line2.replaceAll(line2,"");
			Scanner sc  =new Scanner(System.in);
			System.out.println("please enter a name");
			String name = sc.nextLine();
			System.out.println("name ------------ " +name);
			//String line = Files.write(, bytes, options)		
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            

			lines.add(2, name);
			Files.write(path, lines, StandardCharsets.UTF_8);
			sc.close();
		} catch (Exception e) {
System.out.println("could not be written");
e.printStackTrace();
		}
		
	            }
		
//		kkkkkkkkkkkk
//				File fout = new File("C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test.txt");
//		FileOutputStream fos = new FileOutputStream(fout);
//	 
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//		bw.write("aliveli");
//		FileWriter f = new FileWriter("C:/eclipseworkplace/Coveros_Test2/src/main/java/StepDefinitions/test.txt");
//		f.write(name);
	}

