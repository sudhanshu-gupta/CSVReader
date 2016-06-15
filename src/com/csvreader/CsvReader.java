package com.csvreader;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
//Comment section
public class CsvReader implements Closeable {
	private BufferedReader br;
	private CsvParser parser;
	
	private boolean hasNext = true;
	
	public CsvReader(Reader reader) {
		br = new BufferedReader(reader);
		parser = new CsvParser();
	}
	
	public String [] readNext() throws IOException {
		String [] result = null;
		String line = getNextLine();
		if(!hasNext)
			return result;
		result = parser.parseLine(line);
		return result;
	}
	
	private String getNextLine() throws IOException {
		String nextLine = br.readLine();
		if(nextLine == null || nextLine.length() == 0)
			hasNext = false;
		return hasNext ? nextLine : null;
	}
	
	public void close() throws IOException {
		br.close();
	}
}
