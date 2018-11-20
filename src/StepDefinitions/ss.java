//package StepDefinitions;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//
//public class ss {
//	public static void main(String[] args) {
//		
//	
//    String line;//You need to specify those
//    File infile;
//
//    // temp file
//    File outFile = new File("C:\\kioskfiles\\remote.txt");
//
//    // input
//    FileInputStream fis = null;
//    try {
//        fis = new FileInputStream("C:\\kioskfiles\\remote.txt");
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    }
//    BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//
//    // output         
//    FileOutputStream fos = null;
//    try {
//        fos = new FileOutputStream(outFile);
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    }
//    PrintWriter out = new PrintWriter(fos);
//    String thisLine = "";
//    int i =1;
//    
//    try {
//        while ((thisLine = in.readLine()) != null) {
//           if(in.contains("Done"))//the check for done 
//               out.println(line);                  
//           }
//           out.println(thisLine);
//           i++;
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    out.flush();
//    out.close();
//    try {
//        in.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    inFile.delete();
//    outFile.renameTo(inFile);
//}}
