package com.coderscapmus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**@ComponentScan = this annotation allows it to build ComponentModal, 
 * if you don't add this annotation, it would build Component Modal and it would be able to find Beans inside of the Component Modal
 * 
 * @Qualifiers = if you are having more than 1 Bean with the same type in the same Component Modal, 
 * and you want to inject one of them with the @Autowired, then you want to use @Qualifier annotation
 * */

@Configuration
@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class FileReadingConfiguration 
{
	
	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholdConfigurer() 
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	@Bean 
	@Qualifier("ascReport")
	static CrimeReportResult crimeReportResultAsc ()
	{
		return new CrimeReportResult("asc");
	}
	
	@Bean 
	@Qualifier("descReport")
	static CrimeReportResult crimeReportResultDesc ()
	{
		return new CrimeReportResult("desc");
	}
	
	
	public static void main(String args[]){
		
		/**
		 * ApplicationContext is heart and soul of Spring Framework. 
		 * In the older version of Spring you have to interact with ApplicationContext to be able to do your job,
		 * you would have an xml file, and you will be working with it hand-in had almost everyday you're coding
		 * But in the latest versions of Spring, they abstracted from us and now 
		 * we're using Java annotation configuration.
		 * giving the class name as parameter to let ApplicationCOntext now that we're using this class to building around.
		 * 
		 *  What is this context?
		 *  We think Spring as a container. ApplicationContext provides us all the nitty gritty stuff of Spring Framework.
		 *  
		 *  The ApplicationCOntext contains a component modal, which contains all of the components/objects that make up your application and
		 *  figures out how all the objects interact with each other. 
		 *  This is where Dependency Injection and Inversion of Control comes from by using annotations.
		 *  
		 *  What is Bean?
		 *  Bean is essentially plain old java object(POJO) you created and you want to have the context be aware of, 
		 *  so you can put into the component modal. If it's inside of COmponent Modal, if It's inside of Context 
		 *  and now Spring is be aware of and it can used inside of the Spring Framework.
		 *  Bean is an Object.
		 *  
		 *  Beans exits in Component Modal and exist in Application Context
		 *  beans --> Component Modal --> Application Context -->SpringFramework
		 *  
		 *  Each of these Spring Beans are tend to be Singeltons, 
		 *  which means there is only one instance of that Object inside of the context of your application.
		 *  There is only one instantiated version of it, no duplicate, unless you tell it not to be.
		 *  
		 *  @Scope - defines the life span of a Bean
		 *  By default, whenever we create a Bean either by marking as a @Bean or @Component.. the Scope is automatically
		 *  set to default, and the default value of the Bean is "Stateless", another word it's Singelton.
		 *  Singelton is a Design Patter where by you can only have "Zero" or "One" instances of an object.
		 *  Every bean is created in Spring in Singelton Bean by default.
		 *  If you want to change the default scope you can change by addign @Scope
		 *  
		 *  Prototype - opposite of Singelton; as soon as you refer the bean in context, it will instantiate
		 *  the brand new version of the bean every single time. It's like = new CrimeReport(); every single time.
		 *  When you want to use this?
		 *  - to maintain State - Object needs to maintain some sort of state it make sense to use it
		 *  Currently we're reading the same report over and over, but in a different world if you have multiple reports
		 *  If you have multiple reports it doesn't make sense to have Singelton Bean to be used, to store multiple reports inside of an instance variable.
		 *  Because it's going to override instance variable over and over again with the same object, since it's singelton.
		 *  
		 * */
		//ApplicationContext context = new AnnotationConfigApplicationContext(FileReadingConfiguration.class);
		
		// SpringApplication.run() return ConfigurableApplicationContext, which is child of ApplicationContext
		ConfigurableApplicationContext context = SpringApplication.run(FileReadingConfiguration.class, args);
		
		//this is the similar way to instantiate FileProcessorrService as FileProcessorService fps = new FileProcessorService(); 
		//We're not instantiating a new FileProcessort service, we are getting it from Context 
		//because application context takes control of the instantiation process on your behalf.
		//bean name comes as parameter is case sensitive
		//FileProcessorService fps = (FileProcessorService) context.getBean("fileProcessorService");
		
		//FileProcessorService fps = new FileProcessorService(); 
		
		//fps.processFile();
		
		CrimeReport crimeReport = (CrimeReport) context.getBean("crimeReport");
		crimeReport.generateReport();
		
		/*for(CrimeReportDataRow row : crimeReport.getRows()) {
			System.out.println(row);
		}*/
		
		List<CrimeReport> reports = new ArrayList<>();
		
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));
		
		for(CrimeReport report : reports) {
			report.generateReport();
			System.out.println(report);
		}
		
		/*results from CrimeReport instance calling with Prototype Scope - maintaining State*/
//		com.coderscapmus.CrimeReport@145eaa29
//		com.coderscapmus.CrimeReport@15bb6bea
//		com.coderscapmus.CrimeReport@8b96fde
//		com.coderscapmus.CrimeReport@2d2e5f00
//		com.coderscapmus.CrimeReport@4c40b76e
//		com.coderscapmus.CrimeReport@2ea6137
		
		/*results from CrimeReport instance calling with Singelton Scope - Stateless*/
//		com.coderscapmus.CrimeReport@1a38c59b
//		com.coderscapmus.CrimeReport@1a38c59b
//		com.coderscapmus.CrimeReport@1a38c59b
//		com.coderscapmus.CrimeReport@1a38c59b
//		com.coderscapmus.CrimeReport@1a38c59b
//		com.coderscapmus.CrimeReport@1a38c59b
		
		
		
	}

}
