package com.bookApplication2.BookApplication2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.BookOrder;


public interface OrderRepository extends JpaRepository<BookOrder, Integer> {
	
	public List<BookOrder> findAllOrderByUsername(String userName);

	

}
