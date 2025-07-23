package com.yuvam.database;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner {

    private final DataSource dataSource;
    @Getter
    private final JdbcTemplate jdbcTemplate;

    public DatabaseApplication(final DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("📦 Datasource: " + dataSource);

        try {
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS people (id INT PRIMARY KEY, name VARCHAR(255))");
            jdbcTemplate.update("INSERT INTO people (id, name) VALUES (?, ?)", 1, "Alice");
            jdbcTemplate.update("INSERT INTO people (id, name) VALUES (?, ?)", 2, "Bob");

            String dateTime = jdbcTemplate.queryForObject(
                    "SELECT CURRENT_DATE, CURRENT_TIME",
                    (rs, rowNum) -> rs.getDate(1) + " " + rs.getTime(2)
            );
            log.info("🕒 Current Date and Time: " + dateTime);
        } catch (Exception e) {
            log.severe("❌ Error during DB setup: " + e.getMessage());
        }
    }
}

@RestController
class HelloController {

    private final JdbcTemplate jdbcTemplate;

    // Inject the JdbcTemplate bean directly (reusing the one from the main application)
    public HelloController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    public String home() {
        return "Spring Boot is running!";
    }

    @GetMapping("/people")
    public String getPeople() {
        List<String> names = jdbcTemplate.query(
                "SELECT id, name FROM people",
                (rs, rowNum) -> rs.getInt("id") + ": " + rs.getString("name")
        );

        return "People:<br>" + String.join("<br>", names);
    }
}