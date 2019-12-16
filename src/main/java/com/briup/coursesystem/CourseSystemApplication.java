package com.briup.coursesystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class CourseSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(CourseSystemApplication.class, args);
	}
}