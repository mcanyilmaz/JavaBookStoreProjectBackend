package com.bookApplication2.BookApplication2.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookApplication2.BookApplication2.model.Author;
import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.User;
import com.bookApplication2.BookApplication2.requests.AuthorCreateRequest;
import com.bookApplication2.BookApplication2.requests.AuthorUpdateRequest;
import com.bookApplication2.BookApplication2.service.AuthorService;


@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("v1/")

public class AuthorController {
	
	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	
	/*
	@PostMapping("/addAuthor")
	public Author addAuthor(@RequestBody AuthorCreateRequest authorCreateDto)  {
		
		
		return authorService.addAuthor(authorCreateDto);
		
	}*/
	
	@PostMapping("/addAuthor")
	public Author addAuthor(@RequestParam("imageFile")MultipartFile file,@RequestParam("payload") String payload) throws IOException  {
		
		
		return authorService.addAuthor(file, payload);
		
	}
	
	
	
	
	
	@GetMapping("/getAllAuthor")
	public List<Author> getAllAuthor(){
		return authorService.getAllAuthor();
	}
	
	@DeleteMapping("/deleteAuthor/{id}")
	public void deleteAuthor(@PathVariable int id) {
		 authorService.deleteAuthor(id);
	}
	
	

	
	
	@PutMapping("/updateAuthor/")
	public Author updateAuthor(@RequestParam("imageFile")MultipartFile file, String payload) throws IOException {
		return authorService.updateAuthor(file, payload);
	}
	
	@PostMapping("findByAuthorName/")
	public Author findByAuthorName(@RequestParam String authorName) {
		return authorService.findByAuthorName(authorName);
	}
	
	@GetMapping("getByAuthorId/{id}")
	public Optional<Author> getByAuthorId(@PathVariable int id) {
		return authorService.getByAuthorId(id);
	}
	
	
	@GetMapping("pageableAuthor/")
	public Page<Author> getAllAuthorPageable(@RequestParam int id, @RequestParam int pageSize){
	
		
	
		return authorService.getAllAuthorPageable(id, pageSize);
	

	}
	
	

}
