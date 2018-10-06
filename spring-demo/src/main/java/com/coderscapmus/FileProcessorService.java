package com.coderscapmus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @Component = saying to Spring that FileProcessorService class should be a component, and added inside of Application Context
 * @Autowired = tells to Spring FileReadingService class/bean is a dependency managed by the ApplicationContext, 
 * once you marked as @Autowired mean you marked as dependency
 * @Service = also extend from @Component
 * @Controller = also extend from @Component
 * @Repository = also extend from @Component
 * */
@Component
public class FileProcessorService {
	
	@Autowired
	FileReadingService frs;
	
	public void processFile()
	{
		/**
		 * Here is the Dependency Injection comes in; 
		 * with out instantiate this dependency here as new FileReadingService() I 'll get null pointer exception
		 * Dependency Injection is basically getting rid off to the necessity of you to instantiate your own objects.
		 * 
		 * Inversion of control is actual mechanisms that Spring uses to do Dependency Injection.
		 *  */
		//frs = new FileReadingService(); 
		
		List<String> lines = frs.readFile("crime_report.csv");
		
		for(String line : lines)
		{
			System.out.println(line);
		}
		
	}

}
