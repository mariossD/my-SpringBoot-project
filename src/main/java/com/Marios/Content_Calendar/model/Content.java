package com.Marios.Content_Calendar.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Content(
		@Id
		Integer id,
		String title,
		String des,
		Status status,
		Type contentType,
		LocalDateTime dateCreated,
		LocalDateTime  dateUpdated,
		String url) {

}
