package com.bookApplication2.BookApplication2.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookApplication2.BookApplication2.model.BookOrder;
import com.bookApplication2.BookApplication2.repository.BookRepository;
import com.bookApplication2.BookApplication2.repository.OrderRepository;
import com.bookApplication2.BookApplication2.requests.OrderCreateRequest;

@SpringBootTest
public class OrderServiceTest {

	private OrderService orderService;
	
	private OrderRepository orderRepository;
	
	private BookRepository bookRepository;
	
	
	@Before
	public void setUp() throws Exception {
		orderRepository = Mockito.mock(OrderRepository.class);
		bookRepository= Mockito.mock(BookRepository.class);
		
		orderService = new OrderService(orderRepository, bookRepository);
	}
	
	@Test
	public void whenCreateOrderCalledWithValidRequest_itShouldReturnValidOrderCreateRequest() {
		OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
		
		orderCreateRequest.setBookName("Test Kitap");
		orderCreateRequest.setBookPiece(4);
		orderCreateRequest.setBookPrice(45.0);
		orderCreateRequest.setTotalPrice(50.0);
		orderCreateRequest.setAddress("abcdef");
		
		BookOrder order = new BookOrder();
 
		order.setBookName(orderCreateRequest.getBookName());
		order.setBookPiece(orderCreateRequest.getBookPiece());
		order.setBookPrice(orderCreateRequest.getBookPrice());
		order.setTotalPrice(orderCreateRequest.getTotalPrice());
		order.setAddress(orderCreateRequest.getAddress());
	
	
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		
		BookOrder result = orderService.addOrder(orderCreateRequest);
		
		
		Mockito.verify(orderRepository).save(order);
		Assert.assertEquals(result,order);
	}


}
