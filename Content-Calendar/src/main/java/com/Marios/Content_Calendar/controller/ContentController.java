package com.Marios.Content_Calendar.controller;

import com.Marios.Content_Calendar.model.Content;
import com.Marios.Content_Calendar.repository.ContentCollectionRepositroy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

	private final ContentCollectionRepositroy repository;


	public ContentController(ContentCollectionRepositroy repository) {
		this.repository = repository;
	}

	//make a request and find all the pieces of content in the system

	@GetMapping
	public List<Content> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Content findById(@PathVariable Integer id){
		return repository.findById(id).
						orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found"));
	}

  @ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void create(@RequestBody Content content){
		repository.save(content);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody Content content,@PathVariable Integer id){
		if(!repository.existsById(id)){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
		}
		repository.save(content);
	}
}
