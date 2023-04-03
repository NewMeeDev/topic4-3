/**
 * 
 */
package com.mneumann1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mneumann1.data.OrderDataAccessInterface;
import com.mneumann1.model.OrderModel;

/**
 * @author MNEUMANN1
 *
 */
//@Service
//@Primary // if defined 2 or more OrderBusinesServices of the OrderBusinesServiceInterface --> the one with @Primary will be called
public class OrderBusinesService implements OrderBusinesServiceInterface {

	@Autowired
	OrderDataAccessInterface<OrderModel> ordersDAO;
	
	@Override
	public void test() {
		System.out.println("OrderBusinesService is working");
	}

	
	@Override
	public List<OrderModel> getOrders() {	
		return ordersDAO.getOrders();
	}

	
	@Override
	public void init() {
		System.out.println("Init method of the Orders Business Service");	
	}

	
	@Override
	public void destroy() {
		System.out.println("Destroy method of the Orders Business Service");
	}

	
	@Override
	public OrderModel getById(long id) {
		return ordersDAO.getById(id);
	}

	
	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		return ordersDAO.searchOrders(searchTerm);
	}

	
	@Override
	public long addOne(OrderModel newOrder) {
		return ordersDAO.addOne(newOrder);
	}

	
	@Override
	public boolean deleteOne(long id) {
		return ordersDAO.deleteOne(id);
	}

	
	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		return ordersDAO.updateOne(idToUpdate, updateOrder);
	}

}
