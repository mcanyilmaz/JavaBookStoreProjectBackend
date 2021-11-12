package com.bookApplication2.BookApplication2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{

	void deleteLikeByUserIdAndCommentId(Long id, int commentId);

	Like findByUserIdAndCommentId(Long id, int commentId);

	
	List<Like> getAllByUserId(Long id);
	//List<Like> findByUserId(int userId);

	//List<Like> findByPostId(int commentId);
	
	
}
