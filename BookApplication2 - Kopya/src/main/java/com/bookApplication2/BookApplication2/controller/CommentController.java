package com.bookApplication2.BookApplication2.controller;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.Comment;
import com.bookApplication2.BookApplication2.repository.CommentRepository;
import com.bookApplication2.BookApplication2.requests.CommentCreateRequest;
import com.bookApplication2.BookApplication2.service.CommentService;


@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("v1/")
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	
	@GetMapping("/getAllComments")
	public List<Comment> getAllComments(){
		return commentService.getAllComments();
	}
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/addComment")
	public Comment addComment(@RequestBody CommentCreateRequest commentCreateRequest) {
		return commentService.addComment(commentCreateRequest);
	}
	
	@DeleteMapping("/deleteComment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable int id) {
		
		 return ResponseEntity.ok(commentService.deleteComment(id));
	}
	
	@GetMapping("/findAllBookId/{id}")
	public List<Comment> findByBookId(@PathVariable int id){
		return commentService.findByBookId(id);
	}
	
	@GetMapping("/findCommentByUserId/{id}")
	public List<Comment> findCommentByUserId(@PathVariable Long id){
		return commentRepository.findAllCommentByUser_Id(id);
	}
	
	
	@GetMapping("/findAllCommentPageable")
	public Page<Comment> findAllCommentPageable(@RequestParam int id, @RequestParam int pageSize){
		
		return commentService.findAllPageableComment(id, pageSize);
	}
	
	
	@GetMapping("getByBookIdPageable/")
	public Page<Comment> pagination3(@RequestParam int id, @RequestParam int pageSize, @RequestParam int commentList){

		
		return commentService.getByBookIdPageable(id, pageSize,commentList);
	
	}
	
	
	
	
	
}
