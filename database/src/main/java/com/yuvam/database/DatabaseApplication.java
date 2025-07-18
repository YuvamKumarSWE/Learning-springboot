package com.yuvam.database;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public DatabaseApplication(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(final String... args) {
    log.info("Datasource: " + dataSource.toString());
    final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    // Fetch Date and Time
    String query = "SELECT CURRENT_DATE || ' ' || CURRENT_TIME FROM DUAL";
    String dateTime = jdbcTemplate.queryForObject(query, String.class); // Get the result as a single string
    
    log.info("Current Date and Time: " + dateTime); // Log the result
}

}