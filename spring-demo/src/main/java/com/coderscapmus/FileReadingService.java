package com.coderscapmus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The purpose of this method to read the excep sheet and output as a list of String
 * */

@Component
public class FileReadingService {
	
	public List<String> readFile (String fileName)
	{
		
		List<String> lines = null;
		try {
			lines =  Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lines;
	}

}
