package com.coderscampus.Unit8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SortingApplication {

	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Masterlist.csv.txt"));
			String line;
			while((line = reader.readLine())!= null){
				String[] values = line.split(",");
				System.out.println(values);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
