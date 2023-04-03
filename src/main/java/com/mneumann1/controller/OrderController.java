package com.mneumann1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mneumann1.model.OrderModel;
import com.mneumann1.service.OrderBusinesService;
import com.mneumann1.service.OrderBusinesServiceInterface;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	// dependency injection

	@Autowired
	OrderBusinesServiceInterface service;

	
	@GetMapping("/")
	public String showAllOrders(Model model) {
				
		List<OrderModel> orders = service.getOrders();	
		model.addAttribute("title", "Here is what I want to do this summer");
		model.addAttribute("orders", orders);
		
		return "orders.html";
	}

}
