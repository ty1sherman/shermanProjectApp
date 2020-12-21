package com.tts.shermanProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.tts.shermanProject.domain.Customer;
import com.tts.shermanProject.repository.CustomerRepository;

@SpringBootApplication
public class ShermanProjectApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(ShermanProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShermanProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Michael", "Smith"));
			repository.save(new Customer("Aaron", "Moon"));
			repository.save(new Customer("Kim", "Lassiter"));
			repository.save(new Customer("Joan", "Daniels"));
			repository.save(new Customer("Eric", "Patterson"));

			// read all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// read an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// read customers by last name
			log.info("Customer found with findByLastName('Patterson'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Patterson").forEach(bauer -> {
				log.info(bauer.toString());
			});
			
			log.info("");
		};
	}
		
}
