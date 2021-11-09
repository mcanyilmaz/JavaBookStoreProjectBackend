package com.bookApplication2.BookApplication2.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bookApplication2.BookApplication2.exception.ResourceNotFoundException;
import com.bookApplication2.BookApplication2.model.Author;
import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.Category;
import com.bookApplication2.BookApplication2.model.ImageModel;
import com.bookApplication2.BookApplication2.repository.AuthorRepository;
import com.bookApplication2.BookApplication2.repository.BookRepository;
import com.bookApplication2.BookApplication2.repository.CategoryRepository;
import com.bookApplication2.BookApplication2.requests.AuthorCreateRequest;
import com.bookApplication2.BookApplication2.requests.BookCreateRequest;
import com.bookApplication2.BookApplication2.util.ImageUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.asm.Advice.Local;

@Service

public class BookService {
	
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private CategoryRepository categoryRepository;
	
	public BookService(BookRepository bookRepository,AuthorRepository authorRepository,CategoryRepository categoryRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.categoryRepository = categoryRepository;
	}

	
	public Page<Book> pagination(int pageSize, int page){
		Pageable pageable = PageRequest.of(page, pageSize);
		return bookRepository.findAll(pageable);
	}
	
	public Page<Book> getByCategoryIdPageble(int id, int pageSize){
		
		Pageable pageable = PageRequest.of(pageSize, 4);
		
		 List<Book> books = bookRepository.findAll();
		 
	     /*   for (Book book:books){
	        
	            if(book.getImageModel() != null){
	            	book.getImageModel().setPicByte(ImageUtility.decompressBytes(book.getImageModel().getPicByte()));
	            }
	        }*/
	        
	       /* for (Book book:books){
		       book.setPicByte(ImageUtility.decompressBytes(book.getPicByte()));
	            
	        }*/
	        

	
		return bookRepository.getByCategory_id(id,pageable);
		//return bookService.pagination(pageSize, page);

	}
	
/*
	public Book addBook(BookCreateRequest bookCreateDto) throws IOException {
		
		LocalDateTime bookCreateTime = LocalDateTime.now();
			 

		Author author = authorRepository
	    		.findById(bookCreateDto.getAuthorId())
	    		.orElseThrow(()->new ResourceNotFoundException("not found "+bookCreateDto.getAuthorId()));
	    
		Category category = categoryRepository
				.findById(bookCreateDto.getCategoryId())
				.orElseThrow(()->new ResourceNotFoundException("not found"+bookCreateDto.getCategoryId()));
		
		Book newBook = new Book();
		
		Optional<Book> book = bookRepository.findByBookName(bookCreateDto.getBookName());
		
	
		
		//ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				//ImageUtility.compressBytes(file.getBytes()));
		
		
		
		if(book.isPresent()) {
			throw new ResourceNotFoundException("Bu isimde bir Kitap Zaten Mevcut " + bookCreateDto.getBookName());
		}
	
		
		newBook.setBookName(bookCreateDto.getBookName());
		newBook.setBookPrice(bookCreateDto.getBookPrice());
		newBook.setBookDetails(bookCreateDto.getBookDetails());
		newBook.setBookStock(bookCreateDto.getBookStock());
		newBook.setCreateDate(bookCreateTime);
		newBook.setBookImageName(bookCreateDto.getBookImageName());
		newBook.setAuthor(author);
		newBook.setCategory(category);
		//newBook.setName(img.getName());
		//newBook.setType(img.getType());
		//newBook.setPicByte(img.getPicByte());
		//newBook.setImageModel(img);

		return bookRepository.save(newBook);	
	}
	
	*/
	public Book addBook(MultipartFile file,String json) throws IOException {
		
	
    	BookCreateRequest bookCreateRequest = new ObjectMapper().readValue(json,BookCreateRequest.class);

    
    
		LocalDateTime bookCreateTime = LocalDateTime.now();
			 

		Author author = authorRepository
	    		.findById(bookCreateRequest.getAuthorId())
	    		.orElseThrow(()->new ResourceNotFoundException("not found "+bookCreateRequest.getAuthorId()));
	    
		Category category = categoryRepository
				.findById(bookCreateRequest.getCategoryId())
				.orElseThrow(()->new ResourceNotFoundException("not found"+bookCreateRequest.getCategoryId()));
		
		Book newBook = new Book();
		
		Optional<Book> book = bookRepository.findByBookName(bookCreateRequest.getBookName());
		
	
		
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				ImageUtility.compressBytes(file.getBytes()));
		
		
		if(book.isPresent()) {
			throw new ResourceNotFoundException("Bu isimde Bir Kitap Zaten Mevcut " + bookCreateRequest.getBookName());
		}
	
		
		newBook.setBookName(bookCreateRequest.getBookName());
		newBook.setBookPrice(bookCreateRequest.getBookPrice());
		newBook.setBookDetails(bookCreateRequest.getBookDetails());
		newBook.setBookStock(bookCreateRequest.getBookStock());
		newBook.setCreateDate(bookCreateTime);
		newBook.setBookImageName(bookCreateRequest.getBookImageName());
		newBook.setRating(0);
		newBook.setAuthor(author);
		newBook.setCategory(category);
		newBook.setName(img.getName());
		newBook.setType(img.getType());
		newBook.setPicByte(ImageUtility.decompressBytes(img.getPicByte()));	
		 
		 
		 return bookRepository.save(newBook);	
	}

	public Book updateBookRating(BookCreateRequest bookCreateRequest) {
		Book book = bookRepository.findById(bookCreateRequest.getId()).orElseThrow(null);
		
	//	System.out.println(bookCreateRequest.getRating());
		int oldRatingValue = book.getRating();
		int newRatingValue = oldRatingValue + bookCreateRequest.getRating();
	
		//System.out.println(newRatingValue);

		
		book.setRating(newRatingValue);
		
		return bookRepository.save(book);
	}

	
	
	
	public List<Book> getAllBook(){
		
		 List<Book> books = bookRepository.findAll();
	       /* for (Book book:books){
	        
	            if(book !=null){
	            	book.setPicByte(ImageUtility.decompressBytes(book.getPicByte()));
	            }
	        }*/

	        return books;
	        
		//return bookRepository.findAll();
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
	public Book updateBook(MultipartFile file, String json)throws IOException  {
		
		
		BookCreateRequest bookCreateRequest= new ObjectMapper().readValue(json,BookCreateRequest.class);

    	
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				ImageUtility.compressBytes(file.getBytes()));
		
		Book book = bookRepository.findById(bookCreateRequest.getId())
				.orElseThrow(()-> new ResourceNotFoundException("not found id" +bookCreateRequest.getId()));
		
		Author author = authorRepository
	    		.findById(bookCreateRequest.getAuthorId())
	    		.orElseThrow(()->new ResourceNotFoundException("not found "+bookCreateRequest.getAuthorId()));
	    
		Category category = categoryRepository
				.findById(bookCreateRequest.getCategoryId())
				.orElseThrow(()->new ResourceNotFoundException("not found"+bookCreateRequest.getCategoryId()));
		
		book.setBookName(bookCreateRequest.getBookName());
		book.setBookPrice(bookCreateRequest.getBookPrice());
		book.setBookStock(bookCreateRequest.getBookStock());
		book.setBookDetails(bookCreateRequest.getBookDetails());
		book.setAuthor(author);
		book.setCategory(category);;
		
		book.setName(file.getName());
		book.setType(file.getContentType());
	
		book.setPicByte(ImageUtility.decompressBytes(img.getPicByte()));	
		
		
		//Book newBook = bookRepository.findById(id)
				//.orElseThrow(()->new ResourceNotFoundException("not found "+id));
		/*
		
		Book newBook = bookRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("not found "+id));
		
		
		Author author = authorRepository
	    		.findById(bookCreateRequest.getAuthorId())
	    		.orElseThrow(()->new ResourceNotFoundException("not found "+bookCreateRequest.getAuthorId()));
	    
		Category category = categoryRepository
				.findById(bookCreateRequest.getCategoryId())
				.orElseThrow(()->new ResourceNotFoundException("not found"+bookCreateRequest.getCategoryId()));
	
			newBook.setBookName(bookCreateRequest.getBookName());
			newBook.setBookPrice(bookCreateRequest.getBookPrice());
			newBook.setBookStock(bookCreateRequest.getBookStock());
			newBook.setBookDetails(bookCreateRequest.getBookDetails());
			newBook.setAuthor(author);
			newBook.setCategory(category);;
			
*/
		return bookRepository.save(book);	
	}
	
	public Book updateBookStock(String bookName,int bookStock) {
		Book updatedBook = bookRepository.findByBookName(bookName)
				.orElseThrow(()->new ResourceNotFoundException("not found"+bookName));
		
		updatedBook.setBookStock(bookStock);
		
		return bookRepository.save(updatedBook);
	}
	
	public List<Book> findByBookName(String bookName){
		return bookRepository.findByBookNameContaining(bookName);
	}
	
	public List<Book> getByBookName(String bookName){
		return bookRepository.getByBookName(bookName);
	}
	
	public Optional<Book> findByBookId(int id) {
		return bookRepository.findById(id);
	}
	
	public List<Book> getByBookCreateDate(){
		Sort sort = Sort.by(Sort.Direction.DESC,"createDate");
		return bookRepository.findAll(sort);
		//return bookRepository.findByBookOrderByIdAsc();
	}

	public List<Book> getByCategoryId(int id){
		return bookRepository.getBycategory_id(id); 
	}
	

	
	
}
