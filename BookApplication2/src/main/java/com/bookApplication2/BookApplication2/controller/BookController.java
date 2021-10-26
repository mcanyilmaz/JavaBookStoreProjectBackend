package com.bookApplication2.BookApplication2.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.repository.BookRepository;
import com.bookApplication2.BookApplication2.requests.BookCreateRequest;
import com.bookApplication2.BookApplication2.service.BookService;


@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("v1/")

public class BookController {
	
	private BookService bookService;
	private BookRepository bookRepository;

	public BookController(BookService bookService,BookRepository bookRepository) {
		super();
		this.bookService = bookService;
		this.bookRepository = bookRepository;
	}
	
	@GetMapping("/findTop10ByOrderByRating/")
	public List<Book> getTop10BookByRating(){
		return bookRepository.findTop10ByOrderByRatingDesc();
	}

	@GetMapping("/findTop8ByOrderByBookNameDesc")
	public List<Book> get5Data (){
		return bookRepository.findTop8ByOrderByBookNameDesc();
	}
	
	@GetMapping("/findTop5ByOrderByBookStock")
	public List<Book> findTop5ByOrderByBookStock (){
		return bookRepository.findTop5ByOrderByBookStock();
	}
	
	
	
	@GetMapping("pageableBook/{id}")
	public Page<Book> pagination(@RequestParam int pageSize, @RequestParam int page){
	
		return bookService.pagination(pageSize, page);
	}
	
	@GetMapping("/getByCategoryId/{id}")
	public List<Book> getByCategoryId(@PathVariable int id){
		return bookService.getByCategoryId(id);
	}
	
	
	@GetMapping("pageableBook2/")
	public Page<Book> pagination2(@RequestParam int pageSize){
	
		Pageable pageable = PageRequest.of(pageSize,4);
		
		return bookRepository.findAll(pageable);
		//return bookService.pagination(pageSize, page);

	}
	
	@GetMapping("pageableBook3/")
	public Page<Book> pagination3(@RequestParam int id, @RequestParam int pageSize){
	
		//Pageable pageable = PageRequest.of(pageSize,4);
		
		//return bookRepository.getByCategory_id(id, pageSize, pageable);
		return bookService.getByCategoryIdPageble(id, pageSize);
		//return bookService.pagination(pageSize, page);

	}
	
	


	/*@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody BookCreateRequest bookCreateDto) throws IOException {
		
		return new ResponseEntity<Book>(bookService.addBook(bookCreateDto),HttpStatus.CREATED);
		
		//return bookService.addBook(bookCreateDto);
		
	}*/
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook2(@RequestParam("imageFile")MultipartFile file,@RequestParam("payload") String payload ) throws IOException {
		
		return new ResponseEntity<Book>(bookService.addBook(file,payload),HttpStatus.CREATED);
		
		//return bookService.addBook(bookCreateDto);
		
	}
	
	
	/*
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody BookCreateRequest bookCreateDto,@RequestParam("imageFile") MultipartFile file) throws IOException {
		
		return new ResponseEntity<Book>(bookService.addBook(bookCreateDto,file),HttpStatus.CREATED);
		
		//return bookService.addBook(bookCreateDto);
		
	}*/
	
	@PostMapping("updateBookRating/")
	public Book updateBookRating(@RequestBody BookCreateRequest bookCreateRequest) {
		return bookService.updateBookRating(bookCreateRequest);
	}
	
	
	@GetMapping("/getAllBook")
	public List<Book> getAllBook(){
		
		return  bookService.getAllBook();
		//return bookService.getAllBook();
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		// bookService.deleteBook(id);
	}
	
	@PutMapping("/updateBook/")
	public ResponseEntity<Book> updateBook(@RequestParam("imageFile")MultipartFile file, String payload) throws IOException {
		return new ResponseEntity<Book>(bookService.updateBook(file, payload),HttpStatus.OK);
		//return bookService.updateBook(id, book);
	}
	
	@GetMapping("/findByBookName/")
	public ResponseEntity<List<Book>> findByBookName(@RequestParam String bookName) {
		return new ResponseEntity<List<Book>>(bookService.findByBookName(bookName),HttpStatus.OK);
		//return bookService.findByBookName(bookName);
	}
	
	@GetMapping("/getByBookName/")
	public List<Book> getByBookName(@RequestParam String bookName) {
		return bookService.getByBookName(bookName);
		
		//return bookService.findByBookName(bookName);
	}
	
	@GetMapping("/findByBookId/{id}")
	public Optional<Book> findByBookId(@PathVariable int id) {
		return bookService.findByBookId(id);
	
	}
	
	@GetMapping("/getByBookCreateDate")
	public List<Book> getByBookCreateDate(){
		return bookService.getByBookCreateDate();
	}
	
	@PutMapping("/updatedBookStock/{bookStock}")
	public Book updatedBookStock(@PathVariable int bookStock,@RequestParam String bookName) {
		return bookService.updateBookStock(bookName,bookStock);
	}

	
}
