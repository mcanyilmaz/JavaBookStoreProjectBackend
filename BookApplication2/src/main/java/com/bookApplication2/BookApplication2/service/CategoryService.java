package com.bookApplication2.BookApplication2.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookApplication2.BookApplication2.exception.ResourceNotFoundException;
import com.bookApplication2.BookApplication2.model.Author;
import com.bookApplication2.BookApplication2.model.Category;
import com.bookApplication2.BookApplication2.model.ImageModel;
import com.bookApplication2.BookApplication2.repository.CategoryRepository;
import com.bookApplication2.BookApplication2.requests.AuthorCreateRequest;
import com.bookApplication2.BookApplication2.requests.CategoryCreateRequest;
import com.bookApplication2.BookApplication2.response.MessageResponse;
import com.bookApplication2.BookApplication2.util.ImageUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	
	public Category addCategory(MultipartFile file,String json) throws IOException {
		
		
		
		CategoryCreateRequest categoCreateRequest = new ObjectMapper().readValue(json,CategoryCreateRequest.class);

		
		
		Category category = new Category();
		//LocalDateTime createdDate = LocalDateTime.now();
		
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				ImageUtility.compressBytes(file.getBytes()));
		
		category.setCategoryName(categoCreateRequest.getCategoryName());
		
		
		category.setName(file.getName());
		category.setType(file.getContentType());
	
		category.setPicByte(ImageUtility.decompressBytes(img.getPicByte()));	

		
		
		return categoryRepository.save(category);
		
	}
	
	/*
	public ResponseEntity<?> addCategory(CategoryCreateRequest categoryCreateDto) {
		
		
		Category newCategory = new Category();
		
		Optional<Category> category = categoryRepository.
				findByCategoryName(categoryCreateDto.getCategoryName());
				
		if(categoryRepository.existsByCategoryName(categoryCreateDto.getCategoryName())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Bu Kategori Zaten Kayıtlı"));
		}
		
		
			newCategory.setCategoryName(categoryCreateDto.getCategoryName());
		
			categoryRepository.save(newCategory);
			
			return ResponseEntity.ok(new MessageResponse("Kategori Eklendi."));
	
	}
	*/
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public Category updateCategory(int id, CategoryCreateRequest categoryCreateDto) {
		
		Category category = categoryRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("not found id "+id));
		category.setCategoryName(categoryCreateDto.getCategoryName());
		
		return categoryRepository.save(category);
		
	}
	
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}

	
	public Optional<Category> findByCategoryId(int id) {
		return categoryRepository.findById(id);
	}
	
	public Optional<Category> findByCategoryName(String categoryCreateDto) {
		return categoryRepository.findByCategoryName(categoryCreateDto);
	}
	
}
