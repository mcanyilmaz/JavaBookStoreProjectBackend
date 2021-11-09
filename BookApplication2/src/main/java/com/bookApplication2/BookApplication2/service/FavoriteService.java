package com.bookApplication2.BookApplication2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.Favorite;
import com.bookApplication2.BookApplication2.model.User;
import com.bookApplication2.BookApplication2.repository.BookRepository;
import com.bookApplication2.BookApplication2.repository.FavoriteRepository;
import com.bookApplication2.BookApplication2.repository.UserRepository;
import com.bookApplication2.BookApplication2.requests.FavoriteRequest;


@Service
public class FavoriteService {

	private FavoriteRepository favoriteRepository;
	private BookRepository bookRepository;
	private UserRepository userRepository;
	

	public FavoriteService(FavoriteRepository favoriteRepository, BookRepository bookRepository,
			UserRepository userRepository) {
		super();
		this.favoriteRepository = favoriteRepository;
		this.bookRepository = bookRepository;
		this.userRepository = userRepository;
	}

	public Favorite updateFavorite(int id, FavoriteRequest updateFavoriteRequest) {
		Favorite favoriteBook= favoriteRepository.findById(id).orElseThrow(null);
		Book book = bookRepository.findById(updateFavoriteRequest.getBookId()).orElseThrow(null);
		User user = userRepository.findById(updateFavoriteRequest.getUserId()).orElseThrow(null);
		favoriteBook.setBook(book);
		favoriteBook.setUser(user);
		
		favoriteBook.setStatus(updateFavoriteRequest.getStatus());
		return favoriteRepository.save(favoriteBook);

		
	}
	
	public Favorite addFavorite(FavoriteRequest favoriteCreateRequest) {
		
		Favorite favoriteBook = new Favorite();
		
		Book book = bookRepository.findById(favoriteCreateRequest.getBookId()).get();
		User user = userRepository.findById(favoriteCreateRequest.getUserId()).get();
		
		favoriteBook.setBook(book);
		favoriteBook.setUser(user);
		
		favoriteBook.setStatus(favoriteCreateRequest.getStatus());
		
		
		return favoriteRepository.save(favoriteBook);
	}
	
	public List<Favorite> getAllFavoriteBook(){
		return favoriteRepository.findAll();
	}
	
	public List<Favorite> getAllFavoriteBookByUserId(Long userId){
		return favoriteRepository.getAllFavoriteByUser_id(userId);
	}
	
	public void deleteByFavoriteId(int id) {
		
		favoriteRepository.deleteById(id);	
		
	}
}
