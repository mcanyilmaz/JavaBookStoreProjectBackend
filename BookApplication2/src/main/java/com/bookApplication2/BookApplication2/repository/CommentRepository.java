package com.bookApplication2.BookApplication2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

	
	public List<Comment> findByBookId(int id);
	
	public List<Comment> findAllCommentByUser_Id(Long id);
	
	Page<Comment> getByBook_id(int bookId,Pageable pageable);

	
}
