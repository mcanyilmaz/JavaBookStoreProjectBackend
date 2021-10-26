package com.bookApplication2.BookApplication2.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.bookApplication2.BookApplication2.exception.ResourceNotFoundException;
import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.BookOrder;
import com.bookApplication2.BookApplication2.repository.BookRepository;
import com.bookApplication2.BookApplication2.repository.OrderRepository;
import com.bookApplication2.BookApplication2.requests.OrderCreateRequest;

@Service
public class OrderService {
	
	private OrderRepository orderRepository;
	
	private BookRepository bookRepository;

	public OrderService(OrderRepository orderRepository,BookRepository bookRepository) {
		super();
		this.orderRepository = orderRepository;
		this.bookRepository = bookRepository;
	}
	
	
	public BookOrder newAddOrder(OrderCreateRequest orderCreateRequest){
		BookOrder order = new BookOrder();
		
		
		LocalDateTime createTime = LocalDateTime.now();
		Random random = new Random();
		int orderNumber = Math.abs(random.nextInt());
	
		
		order.setBookName(orderCreateRequest.getBookName());
		order.setBookPiece(orderCreateRequest.getBookPiece());
		order.setBookPrice(orderCreateRequest.getBookPrice());
		order.setTotalPrice(orderCreateRequest.getTotalPrice());
		order.setCreateTime(createTime);
		order.setOrderNumber(orderNumber);
		
		
			
		
		
		
		order.setAddress(orderCreateRequest.getAddress());
		order.setUsername(orderCreateRequest.getUsername());
		order.setBookList(orderCreateRequest.getBookList());
		return orderRepository.save(order);
	}
	
	
	
	
	public List<BookOrder> getAllOrder(){
		return orderRepository.findAll();
	}
	
	public BookOrder addOrder(OrderCreateRequest orderCreateRequest) {
	
		BookOrder order = new BookOrder();
		
		Book newBook = bookRepository.findById(orderCreateRequest.getBookId())
				.orElseThrow(()->new ResourceNotFoundException("not found"+orderCreateRequest.getBookId()));

		int stock =newBook.getBookStock();
		newBook.setBookStock(stock-orderCreateRequest.getBookPiece());
		
		LocalDateTime createTime = LocalDateTime.now();
		Random random = new Random();
		int orderNumber = Math.abs(random.nextInt());
	
		
		order.setBookName(orderCreateRequest.getBookName());
		order.setBookPiece(orderCreateRequest.getBookPiece());
		order.setBookPrice(orderCreateRequest.getBookPrice());
		order.setTotalPrice(orderCreateRequest.getTotalPrice());
		order.setAddress(orderCreateRequest.getAddress());
		order.setUsername(orderCreateRequest.getUsername());
		order.setCreateTime(createTime);
		order.setOrderNumber(orderNumber);
		//Her Sipariş ilk oluşturulduğu anda Hazırlanıyor statüsünde olarak db'ye yazıldı.
		//order.setState("Hazırlanıyor");
		
		return orderRepository.save(order);
		
	}
	
	public void deleteBookOrder(int id) {
		orderRepository.deleteById(id);
		
	}
	
	public List<BookOrder> findAllOrderByUsername(String userName) {
		return orderRepository.findAllOrderByUsername(userName);
	}
	
	public BookOrder updateOrderState(int id,OrderCreateRequest orderCreateRequest) {
		BookOrder bookOrder = orderRepository.findById(id).orElseThrow(null);
		bookOrder.setState(orderCreateRequest.getState());
		
		return orderRepository.save(bookOrder);
	}
	
	
}
