package com.csvreader;

import java.io.IOException;
import java.util.ArrayList;

public class CsvParser {
	
	public String [] parseLine(String line) throws IOException {
		if (line == null) {
            return null;
        }
		ArrayList<String> list = new ArrayList<String>();
        StringBuilder curVal = new StringBuilder();
        boolean inquotes = false;
        for (int i=0; i<line.length(); i++) {
            char ch = line.charAt(i);
            if (inquotes) {
                if (ch=='\"') {
                    inquotes = false;
                }
                else {
                    curVal.append(ch);
                }
            }
            else {
                if (ch=='\"') {
                    inquotes = true;
                    if (curVal.length()>0) {
                        curVal.append('\"');
                    }
                }
                else if (ch==',') {
                    list.add(curVal.toString());
                    curVal = new StringBuilder();
                }
                else {
                    curVal.append(ch);
                }
            }
        }
        list.add(curVal.toString());
        return list.toArray(new String[list.size()]);
	}
	
}
