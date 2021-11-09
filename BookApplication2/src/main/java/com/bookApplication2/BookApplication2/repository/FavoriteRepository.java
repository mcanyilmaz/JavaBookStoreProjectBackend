package com.bookApplication2.BookApplication2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
	

	List<Favorite> getAllFavoriteByUser_id(Long id);

	void deleteFavoriteByBook_id(int id);
	
	void deleteByBookId(int id);


}
