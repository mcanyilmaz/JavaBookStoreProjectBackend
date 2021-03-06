package com.bookApplication2.BookApplication2.controller;

import java.io.IOException;
import java.util.List;


import java.util.Optional;

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
import com.bookApplication2.BookApplication2.model.Category;
import com.bookApplication2.BookApplication2.requests.CategoryCreateRequest;
import com.bookApplication2.BookApplication2.response.MessageResponse;
import com.bookApplication2.BookApplication2.service.CategoryService;



@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("v1/")
public class CategoryController {
	
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestParam("imageFile")MultipartFile file,@RequestParam("payload") String payload) throws IOException  {
		
		
		return categoryService.addCategory(file, payload);
		
	}
	
	
	/*@PostMapping("/addCategory")
	public ResponseEntity<?>addCategory(@RequestBody CategoryCreateRequest categoryCreateDto) {
		
		if(category.isPresent()) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Bu Kategori Zaten Kayıtlı"));
			
		}
		return new ResponseEntity<>(categoryService.addCategory(categoryCreateDto),HttpStatus.OK);
	}*/
	
	
	@GetMapping("/findByCategoryNameContaining/")
	public ResponseEntity<List<Category>> findByCategoryNameContaining(@RequestParam String categoryName){
		return new ResponseEntity<List<Category>>(categoryService.findByCategoryNameContaining(categoryName),HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<Category>> getAllCategory(){
		return new ResponseEntity<List<Category>>(categoryService.getAllCategory(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("updateCategory/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, 
			@RequestBody CategoryCreateRequest categoryCreateDto) {
		
		return new ResponseEntity<Category>(categoryService.updateCategory(id, categoryCreateDto),HttpStatus.CREATED);
	
	}
	
	@GetMapping("/findByCategoryId/{id}")
	public ResponseEntity<Optional<Category>> findByCategoryId(@PathVariable int id) {
		
		return new ResponseEntity<Optional<Category>>(categoryService.findByCategoryId(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/findByCategoryName/")
	public ResponseEntity<Optional<Category>> findByCategoryName(@RequestParam String categoryName) {
		return new ResponseEntity<Optional<Category>>( categoryService.findByCategoryName(categoryName),HttpStatus.OK);
		
	}
	
}
