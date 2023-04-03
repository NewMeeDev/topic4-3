package com.mneumann1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mneumann1.model.OrderModel;
import com.mneumann1.service.OrderBusinesServiceInterface;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {
	
	// dependency injection

	@Autowired
	OrderBusinesServiceInterface service;
	
	
	@GetMapping("/{id}")
	public OrderModel getById(@PathVariable(name="id") Long id) {
		return service.getById(id);
	}

	
	@GetMapping("/")
	public List<OrderModel> showAllOrders() {				
		List<OrderModel> orders = service.getOrders();	
		return orders;
	}
	
	
	@GetMapping("/search/{searchTerm}")
	public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm) {				
		List<OrderModel> orders = service.searchOrders(searchTerm);	
		return orders;
	}
	
	
	@PostMapping("/")
	public long addOrder(@RequestBody OrderModel model) {
		return service.addOne(model);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteOne(@PathVariable(name="id") Long id) {
		return service.deleteOne(id);
	}
	
	
	@PutMapping("/update/{id}")
	public OrderModel updateOne(@PathVariable(name="id") Long id, @RequestBody OrderModel model) {
		return service.updateOne(id, model);
	}
	
	
	
}
