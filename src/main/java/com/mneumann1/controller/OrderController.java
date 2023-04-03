package com.mneumann1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mneumann1.model.OrderModel;
import com.mneumann1.model.SearchModel;
import com.mneumann1.service.OrderBusinesService;
import com.mneumann1.service.OrderBusinesServiceInterface;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	// dependency injection

	@Autowired
	OrderBusinesServiceInterface service;

	
	@GetMapping("/")
	public String showAllOrders(Model model) {
				
		List<OrderModel> orders = service.getOrders();	
		model.addAttribute("title", "All orders:");
		model.addAttribute("orders", orders);
		
		return "orders.html";
	}

	
	@GetMapping("/showNewOrderForm")
	public String showNewForm(Model model) {
		model.addAttribute("order", new OrderModel());
		return "addNewOrderForm.html";
	}
	
	
	@PostMapping("/addNew")
	public String addNew(@Valid OrderModel newOrder, BindingResult bindingResult, Model model) {
		
		newOrder.setId(null);
		
		// add to the database
		service.addOne(newOrder);
		
		// get all orders from database
		List<OrderModel> orders = service.getOrders();
		
		// show all orders page
		model.addAttribute("orders", orders);
		
		return "orders.html";
	}
	
	
	@GetMapping("/showSearchForm")
	public String showSearchForm(Model model) {
		model.addAttribute("searchModel", new SearchModel());
		return "searchForm.html";
	}
	
	
	@PostMapping("/search")
	public String search(@Valid SearchModel searchmodel, BindingResult bindingResult, Model model) {
		List<OrderModel> orders = service.searchOrders(searchmodel.getSearchTerm());
		model.addAttribute("orders", orders);
		return "orders.html";
	}
	
	
	@GetMapping("/admin")
	public String showAdminPage(Model model) {
				
		List<OrderModel> orders = service.getOrders();	
		model.addAttribute("title", "Manage orders:");
		model.addAttribute("orders", orders);
		
		return "ordersAdmin.html";
	}
	
	
	@PostMapping("/editForm")
	public String displayEditForm(OrderModel orderModel, Model model) {
		
		// display new order form
		model.addAttribute("title", "Edit order:");
		model.addAttribute("orderModel", orderModel);
		
		return "editForm.html";
	}
	
	
	@PostMapping("/doUpdate")
	public String updateOrder(@Valid OrderModel order, BindingResult bindingResult, Model model) {
				
		// add the new order
		service.updateOne(order.getId(), order);
				
		// get updated list of all orders
		List<OrderModel> orders = service.getOrders();	

		// display all orders
		model.addAttribute("orders", orders);
		
		return "ordersAdmin.html";
	}
	
	
	@PostMapping("/delete")
	public String deleteOrder(@Valid OrderModel orderModel, BindingResult bindingResult, Model model) {
	
		// delete the order
		service.deleteOne(orderModel.getId());
	
		// get updated list of all orders
		List<OrderModel> orders = service.getOrders();
				
		// display all orders
		model.addAttribute("orders", orders);
		
		return "ordersAdmin.html";
	}
}
