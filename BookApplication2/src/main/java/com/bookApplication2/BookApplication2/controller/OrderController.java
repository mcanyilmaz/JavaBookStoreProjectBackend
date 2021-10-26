package com.bookApplication2.BookApplication2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookApplication2.BookApplication2.model.BookOrder;
import com.bookApplication2.BookApplication2.requests.OrderCreateRequest;
import com.bookApplication2.BookApplication2.service.OrderService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("v1/")
public class OrderController {
	
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping("newAddOrder/")
	public BookOrder newAddOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
		return orderService.newAddOrder(orderCreateRequest);
	}
	
	
	@GetMapping("getAllOrder")
	public List<BookOrder> getAllOrder(){
		return orderService.getAllOrder();
	}
	
	@GetMapping("findAllOrderByUsername/")
	public List<BookOrder> findAllOrderByUsername(@RequestParam String userName){
		return orderService.findAllOrderByUsername(userName);
	}
	
	
	@PostMapping("/addOrder")
	public BookOrder addOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
		return orderService.addOrder(orderCreateRequest);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public void deleteBookOrder(@PathVariable int id) {
		orderService.deleteBookOrder(id);
	}
	
	@PutMapping("updateOrderState/{id}")
	public BookOrder updateOrderState(@PathVariable int id, @RequestBody OrderCreateRequest orderCreateRequest) {
		return orderService.updateOrderState(id, orderCreateRequest);
	}

	
}
