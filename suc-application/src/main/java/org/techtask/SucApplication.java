package org.techtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.techtask.repository")
public class SucApplication {

    public static void main(String[] args) {
        SpringApplication.run(SucApplication.class, args);
    }

}
