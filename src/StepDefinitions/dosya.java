package StepDefinitions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class dosya {
	public static void main(String[] args) {
		
	
		try {
			List<String> list = Files.readAllLines(Paths.get("C:\\kioskfiles\\remote.txt"), StandardCharsets.UTF_8);
			String[] a = list.toArray(new String[list.size()]);
			System.out.println(a[2]);
			String aaa = a[2];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}}	