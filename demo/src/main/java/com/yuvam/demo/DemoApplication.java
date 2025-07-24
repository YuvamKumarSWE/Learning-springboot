package com.yuvam.demo;

import com.yuvam.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public List<Student> hello() {
		return Arrays.asList(
				new Student(
						1L,
						"John Smith",
						"john.smith@example.com",
						LocalDate.of(2000, 1, 5),
						23
				),
				new Student(
						2L,
						"Mary Johnson",
						"mary.j@example.com",
						LocalDate.of(2001, 3, 15),
						22
				)

		);
	}
}
