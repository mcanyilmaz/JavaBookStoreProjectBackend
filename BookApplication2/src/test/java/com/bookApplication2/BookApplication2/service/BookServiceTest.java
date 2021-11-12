package com.bookApplication2.BookApplication2.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bookApplication2.BookApplication2.repository.AuthorRepository;
import com.bookApplication2.BookApplication2.repository.BookRepository;
import com.bookApplication2.BookApplication2.repository.CategoryRepository;
import com.bookApplication2.BookApplication2.requests.BookCreateRequest;

public class BookServiceTest {
	
	private BookService bookService;
	
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private CategoryRepository categoryRepository;
	
	

	@Before
	public void setUp() throws Exception {
		
		bookRepository= Mockito.mock(BookRepository.class);
		authorRepository= Mockito.mock(AuthorRepository.class);
		categoryRepository= Mockito.mock(CategoryRepository.class);
		
		bookService = new BookService(bookRepository, authorRepository, categoryRepository);
		
	
		
	}
	
	@Test
	public void whenAddBookCalledWithValidRequest_itShouldReturnValidBookCreateRequest() {
		BookCreateRequest bookCreateRequest = new BookCreateRequest();
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
