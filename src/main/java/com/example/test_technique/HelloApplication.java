package com.example.test_technique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"com"})
public class HelloApplication {

    /**
     * Main méthode de lancement
     *
     * @param args arguments de l'application
     */
    public static void main(final String[] args) {
        SpringApplication.run(HelloApplication.class, args);
        System.out.println("******** Application Démarrée ************");
    }

}