package br.com.hbsis.eventmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
If you structure your code as suggested above (locating your application class in a root package),
 you can add @ComponentScan without any arguments. All of your application components (@Component, @Service, @Repository, @Controller etc.) are automatically registered as Spring Beans.
 */
@SpringBootApplication //same as @Configuration @EnableAutoConfiguration @ComponentScan
public class EventManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagerApplication.class, args);
	}

}
