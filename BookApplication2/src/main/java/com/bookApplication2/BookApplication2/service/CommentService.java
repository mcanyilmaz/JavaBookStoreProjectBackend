package com.bookApplication2.BookApplication2.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookApplication2.BookApplication2.exception.ResourceNotFoundException;
import com.bookApplication2.BookApplication2.model.Author;
import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.Comment;
import com.bookApplication2.BookApplication2.model.User;
import com.bookApplication2.BookApplication2.repository.BookRepository;
import com.bookApplication2.BookApplication2.repository.CommentRepository;
import com.bookApplication2.BookApplication2.repository.UserRepository;
import com.bookApplication2.BookApplication2.requests.CommentCreateRequest;
import com.bookApplication2.BookApplication2.response.MessageResponse;

@Service

public class CommentService {
	
	private CommentRepository commentRepository;
	
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;

	public CommentService(CommentRepository commentRepository, BookRepository bookRepository) {
		super();
		this.commentRepository = commentRepository;
		this.bookRepository = bookRepository;
	}
	
	
	public Comment addComment(CommentCreateRequest commentCreateRequest) {
		
		Comment comment = new Comment();
		
		LocalDateTime createdDate = LocalDateTime.now();

		Book book = bookRepository.findById(commentCreateRequest.getBookId())
				.orElseThrow(()-> new ResourceNotFoundException("not found id " + commentCreateRequest.getBookId()));
		
		User user = userRepository.findById(commentCreateRequest.getUserId())
				.orElseThrow(()-> new ResourceNotFoundException("not found id " + commentCreateRequest.getUserId()));

		
		comment.setComment(commentCreateRequest.getComment());
		
		comment.setCreateTime(createdDate);
		
		
		comment.setBook(book);

		comment.setUser(user);
		
		return commentRepository.save(comment);
	}
	
	public List<Comment> getAllComments(){
		return commentRepository.findAll();
	}
	
	
	
	public ResponseEntity<?> deleteComment(int id) {
		 commentRepository.deleteById(id);
		 return ResponseEntity.ok(new MessageResponse("Silme Başarılı ! "));

	}
	
	public List<Comment> findByBookId(int id){
		return commentRepository.findByBookId(id);
	}
	
	public Page<Comment> findAllPageableComment(int pageSize, int page) {
		
		Pageable pageable = PageRequest.of(page, pageSize);
		
		return commentRepository.findAll(pageable);

	}
	
	
	public Page<Comment> getByBookIdPageable(int bookId, int pageSize,int commentList ){
		
		Pageable pageable = PageRequest.of(pageSize, commentList);
		
	
		return commentRepository.getByBook_id(bookId,pageable);
		
	}


	
	

}
