package com.Marios.Content_Calendar.repository;
import  com.Marios.Content_Calendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepo extends ListCrudRepository<Content, Integer> {
	void deleteById(Integer id);
}
