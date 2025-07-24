package com.yuvam.postgreSQLdatabse;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Log
public class PostgreSqLdatabseApplication implements CommandLineRunner {

    private final DataSource dataSource;

    public PostgreSqLdatabseApplication(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(PostgreSqLdatabseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Database connection established successfully");
        log.info("Datasource: " + dataSource.toString());
        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        // Using queryForList() to execute the query and retrieve the results
        List<Map<String, Object>> results = jdbcTemplate.queryForList("SELECT * FROM employee");
        
        // Printing each row in the result
        for (Map<String, Object> row : results) {
            log.info("Row: " + row);
        }
    }
}