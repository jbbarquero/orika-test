package com.malsolo.orika.test.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.malsolo.orika.test.domain.Person;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
@Configuration
@ComponentScan
public class OrikaSpringTest {
	
	private static final Logger logger = LoggerFactory.getLogger(OrikaSpringTest.class);
    
    public static void main(String... args) {
    	
    	logger.info("BEGIN");
    	
    	ConfigurableApplicationContext context = 
          new AnnotationConfigApplicationContext(OrikaSpringTest.class);
        PersonService personService = context.getBean(PersonService.class);
        Person person = personService.obtainPerson();
        System.out.printf("%s\n", person.toString());
        
        context.close();
        
    	logger.info("END with person {} ", (person != null ? person.toString() : "none"));
    }

}
