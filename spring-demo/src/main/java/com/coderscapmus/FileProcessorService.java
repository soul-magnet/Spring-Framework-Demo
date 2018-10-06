package com.coderscapmus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
	
	public List<CrimeReportDataRow> processFile( String filename)
	{
		/**
		 * Here is the Dependency Injection comes in; 
		 * with out instantiate this dependency here as new FileReadingService() I 'll get null pointer exception
		 * Dependency Injection is basically getting rid off to the necessity of you to instantiate your own objects.
		 * 
		 * Inversion of control is actual mechanisms that Spring uses to do Dependency Injection.
		 *  */
		//frs = new FileReadingService(); 
		
		List<CrimeReportDataRow> rows = new ArrayList<>();
		
		List<String> lines = frs.readFile(filename);
		
		for(String line : lines)
		{
			
			String[] data = line.split(",");
			
			if(data.length == 0 || StringUtils.isEmpty(data[0])) {
				continue;
			}
			
			rows.add(new CrimeReportDataRow(data));
			
			//System.out.println(line);
		}
		
		return rows;
	}

}
