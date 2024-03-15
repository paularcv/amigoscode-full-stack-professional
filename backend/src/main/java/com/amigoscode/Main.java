package com.amigoscode;

import com.amigoscode.customer.Customer;
import com.amigoscode.customer.CustomerRepository;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    private static void createRandomCustomer(CustomerRepository customerRepository) {
        var faker = new Faker();
        Random random = new Random();
        Name name = faker.name();
        String firstName = name.firstName();
        String lastName = name.lastName();
        int age = random.nextInt(16, 99);
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@amigoscode.com";
        Customer customer = new Customer(
                firstName + " " + lastName,
                email,
                age);
        customerRepository.save(customer);
        System.out.println(email);
    }

}
