package com.bookApplication2.BookApplication2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookApplication2.BookApplication2.model.Like;
import com.bookApplication2.BookApplication2.requests.LikeRequest;
import com.bookApplication2.BookApplication2.service.LikeService;

@RestController
@RequestMapping("v1/")

@CrossOrigin(origins="http://localhost:4200")  

public class LikeController {

	private LikeService likeService;

	public LikeController(LikeService likeService) {
		super();
		this.likeService = likeService;
	}
	
	@PostMapping("addLikeComment")
	public Like addLikeComment(@RequestBody LikeRequest likeRequest) {
		return likeService.addLike(likeRequest);
	}
	
	@GetMapping("/getAllLikeByUserId/{id}")
	public List<Like> getAllUserLikeComment(@PathVariable Long id){
		return likeService.getAllUserLikeComment(id);
	}
	
	@DeleteMapping("/deleteLikeById/")
	public void deleteLikeById(@RequestParam Long id, @RequestParam int commentId) {
		 likeService.deleteLike(id,commentId);
	}

	
}
