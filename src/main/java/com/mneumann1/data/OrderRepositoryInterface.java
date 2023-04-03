package com.mneumann1.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mneumann1.model.OrderEntity;
import com.mneumann1.model.OrderModel;


public interface OrderRepositoryInterface extends CrudRepository<OrderEntity, Long>{
	
	// use the CrudRepository class in Spring to do the data operations on mysql
	// already implies that we will use save, findAll, findById, deleteById etc.
	
	List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);

}
