package com.cardatabase.CarDatabase;

import com.cardatabase.CarDatabase.domain.Car;
import com.cardatabase.CarDatabase.domain.Owner;
import com.cardatabase.CarDatabase.repository.CarRepository;
import com.cardatabase.CarDatabase.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cardatabase.CarDatabase.controller"})
public class CarDatabaseApplication {

	@Autowired
	private CarRepository repository;


	@Autowired
	private OwnerRepository orepository;

//	private static final Logger logger = LoggerFactory.getLogger(CarDatabaseApplication.class);

	public static void main(String[] args) {
		// We plan to use this line for checks sakes
		SpringApplication.run(CarDatabaseApplication.class, args);
//		logger.info("Hello Spring Boot");
	}

	@Bean
	CommandLineRunner runner(){ return args -> {
	// Add owner objects and save these to db
			Owner owner1 = new Owner((long) 1, "John" , "Johnson");
			Owner owner2 = new Owner((long) 2, "Mary" , "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
	// Add car object with link to owners and save these to db.
			Car car = new Car((long) 5, "Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			repository.save(car);
			car = new Car((long) 6, "Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			repository.save(car);
			car = new Car((long) 7, "Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			repository.save(car);
		};
	}
}
