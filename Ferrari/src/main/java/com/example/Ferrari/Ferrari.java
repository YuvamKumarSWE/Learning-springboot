package com.example.Ferrari;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Ferrari", "config", "services"})
public class Ferrari implements CommandLineRunner {

    private final Engine engine;
    
    public Ferrari(Engine engine) {
        this.engine = engine;
    }

    public static void main(String[] args) {
        SpringApplication.run(Ferrari.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ferrari Started");
        engine.drive();
    }
}
