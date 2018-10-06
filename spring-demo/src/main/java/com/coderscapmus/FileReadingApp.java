package com.coderscapmus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**@ComponentScan = this annotation allows it to build ComponentModal, 
 * if you don't add this annotation, it would build Component Modal and it would be able to find Beans inside of the Component Modal*/

@Configuration
@ComponentScan
public class FileReadingApp {
	
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
		 * */
		ApplicationContext context = new AnnotationConfigApplicationContext(FileReadingApp.class);
		
		//this is the similar way to instantiate FileProcessorrService as FileProcessorService fps = new FileProcessorService(); 
		//We're not instantiating a new FileProcessort service, we are getting it from Context 
		//because application context takes control of the instantiation process on your behalf.
		//bean name comes as parameter is case sensitive
		FileProcessorService fps = (FileProcessorService) context.getBean("fileProcessorService");
		
		//FileProcessorService fps = new FileProcessorService(); 
		
		fps.processFile();
		
	}

}
