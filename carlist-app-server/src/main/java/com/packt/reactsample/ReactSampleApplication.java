package com.packt.reactsample;

import com.packt.reactsample.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan("domain")
@SpringBootApplication
//@Import({SecurityConfig.class})
public class ReactSampleApplication {

    // Inject repositories
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(ReactSampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ReactSampleApplication.class, args);
//        logger.info("Hello Spring!!");
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            // Add owner objects and save these to db
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            // some demo data to database
            Car car1 = new Car("Ford", "Mustang", "Red",
                    "ADF-1121", 2017, 50000, owner1);
            carRepository.save(car1);

            Car car2 = new Car("Nissan", "Leaf", "White",
                    "SSJ-3002", 2014, 29000, owner2);
            carRepository.save(car2);

            Car car3 = new Car("Toyota", "Prius", "Silver",
                    "KKO-0212", 2018, 39000, owner2);
            carRepository.save(car3);

            // username: user
            // password: user
            userRepository.save(new User("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));

            // username: admin
            // password: admin
            userRepository.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
        };
    }
}
