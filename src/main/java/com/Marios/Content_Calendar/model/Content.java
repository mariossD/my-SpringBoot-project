package com.Marios.Content_Calendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Content(Integer id,
											@NotBlank
											String title,
											@NotEmpty
											String desc,
											Status status,
											Type contentType,
											LocalDateTime dateCreated,
											LocalDateTime  dateUpdated,
											String url) {

}
