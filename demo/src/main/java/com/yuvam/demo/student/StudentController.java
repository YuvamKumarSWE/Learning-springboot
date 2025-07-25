package com.yuvam.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

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
