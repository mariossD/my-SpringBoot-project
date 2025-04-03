package com.Marios.Content_Calendar.controller;

import com.Marios.Content_Calendar.model.Content;
import com.Marios.Content_Calendar.repository.ContentRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

	private final ContentRepo repository;


	//private final ContentJdbcTemplate repository;


	public ContentController(ContentRepo repository) {
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
	public void create(@Valid @RequestBody Content content){
		repository.save(content);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void update(@RequestBody Content content,@PathVariable Integer id){
		if(!repository.existsById(id)){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
		}
		repository.save(content);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id){
		if(!repository.existsById(id)){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
		}
		repository.deleteById(id);
	}
}
