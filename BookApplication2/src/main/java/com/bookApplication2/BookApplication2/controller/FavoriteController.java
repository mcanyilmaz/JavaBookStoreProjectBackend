package com.bookApplication2.BookApplication2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookApplication2.BookApplication2.model.Favorite;
import com.bookApplication2.BookApplication2.requests.FavoriteRequest;
import com.bookApplication2.BookApplication2.service.FavoriteService;

@CrossOrigin(origins="http://localhost:4200")  

@RestController
@RequestMapping("v1/")
public class FavoriteController {
	
	private FavoriteService favoriteService;

	public FavoriteController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}
	
	@GetMapping("/getAllFavoriteBook")
	public List<Favorite> getAllFavoriteBook(){
		return favoriteService.getAllFavoriteBook();
	}
	
	@PostMapping("createFavoriteBook")
	public Favorite createFavoriteBook(@RequestBody FavoriteRequest createFavoriteRequest) {
		return favoriteService.addFavorite(createFavoriteRequest);
	}
	
	@PutMapping("updateFavoriteBook/{id}")
	public Favorite updateFavoriteBook(@PathVariable int id, @RequestBody FavoriteRequest updateFavoriteRequest) {
		return favoriteService.updateFavorite(id, updateFavoriteRequest);
	}
	
	 @GetMapping("/getAllFavoriteBookByUserId/{id}")
	 public List<Favorite> getAllFavoriteBookByUserId(@PathVariable long id){
		 return favoriteService.getAllFavoriteBookByUserId(id);
	 }
	 
	 @DeleteMapping("deleteByFavoriteId/{id}")
	 public void deleteFavoriteBookByBookId(@PathVariable int id) {
		 favoriteService.deleteByFavoriteId(id);
		 
	 }
	 
	 

}
