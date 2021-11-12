package com.bookApplication2.BookApplication2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookApplication2.BookApplication2.model.Comment;
import com.bookApplication2.BookApplication2.model.Like;
import com.bookApplication2.BookApplication2.model.User;
import com.bookApplication2.BookApplication2.repository.CommentRepository;
import com.bookApplication2.BookApplication2.repository.LikeRepository;
import com.bookApplication2.BookApplication2.repository.UserRepository;
import com.bookApplication2.BookApplication2.requests.LikeRequest;

@Service
public class LikeService {

	
	private LikeRepository likeRepository;
	
	private UserRepository userRepository;
	
	private CommentRepository commentRepository;
	
	

	public LikeService(LikeRepository likeRepository, UserRepository userRepository,
			CommentRepository commentRepository) {
		super();
		this.likeRepository = likeRepository;
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
	}

	
	public List<Like> getAllLikeComment(){
		return likeRepository.findAll();
	}
	
	public Like addLike(LikeRequest createLikeRequest) {
		Like like = new Like();
		
		User user = userRepository.findById(createLikeRequest.getUserId()).orElseThrow(null);
		Comment comment = commentRepository.findById(createLikeRequest.getCommentId()).orElseThrow(null);
		

		comment.setTotalLike(comment.getTotalLike()+1);
		
		like.setComment(comment);
		like.setUser(user);
		
		return likeRepository.save(like);
	}
	
	public void deleteLike(Long id,int commentId) {
		Comment comment = commentRepository.findById(commentId).orElseThrow(null);
		//User user = userRepository.findById(id).orElseThrow(null);

		Like like = likeRepository.findByUserIdAndCommentId(id, commentId);

		if(comment.getTotalLike()>0) {
			comment.setTotalLike(comment.getTotalLike()-1);
		}
		//comment.setTotalLike(comment.getTotalLike()-1);

		likeRepository.deleteById(like.getId());
		//likeRepository.deleteByLikeByUserIdAndCommentId(id, commentId);
		
	}


	public List<Like> getAllUserLikeComment(Long userId) {
		return likeRepository.getAllByUserId(userId);
	}
	
	
	
}
