package com.Marios.Content_Calendar;

import com.Marios.Content_Calendar.model.Content;
import com.Marios.Content_Calendar.model.Status;
import com.Marios.Content_Calendar.model.Type;
import com.Marios.Content_Calendar.repository.ContentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {

   SpringApplication.run(ContentCalendarApplication.class, args);
	}
 @Bean
 CommandLineRunner runner(ContentRepo repository) {
		return args -> {
			Content content = new Content(null,
							"My third",
							"First",
							Status.IDEA,
							Type.VIDEO,
							LocalDateTime.now(),
							null,
							"");
			repository.save(content);
		};
 }
}
