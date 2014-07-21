package com.csvreader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<String []> list = new ArrayList<String []>();
		String type = scanner.nextLine();
		CsvReader reader = new CsvReader(new InputStreamReader(System.in));
		String [] headers = reader.readNext();
		String [] line = null;
		while((line = reader.readNext()) != null) {
			list.add(line);
		}
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<headers.length;j++)
				System.out.print(headers[j]+" : "+list.get(i)[j]+(j<headers.length-1?";" : ""));
			System.out.println();
		}
	}

}
