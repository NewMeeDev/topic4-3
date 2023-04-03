package com.mneumann1.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mneumann1.model.OrderEntity;
import com.mneumann1.model.OrderModel;

@Primary
@Repository
public class OrderDataServiceForRepository implements OrderDataAccessInterface<OrderModel> {

	// need a data source
	@Autowired
	OrderRepositoryInterface orderRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public OrderDataServiceForRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	ModelMapper modelMapper = new ModelMapper();
	
	
	@Override
	public OrderModel getById(long id) {
		OrderEntity entity = orderRepository.findById(id).orElse(null);
		
		/*OrderModel model = new OrderModel(id, 
				entity.getOrderNo(),
				entity.getProductName(),
				entity.getPrice(),
				entity.getQuantity()
				);*/
		
		OrderModel model = modelMapper.map(entity, OrderModel.class);
		
		return model;
	}

	
	@Override
	public List<OrderModel> getOrders() {
		
		Iterable<OrderEntity> entities = orderRepository.findAll();
		List<OrderModel> orders = new ArrayList<OrderModel>();
		
		for(OrderEntity item : entities) {
			orders.add(modelMapper.map(item, OrderModel.class));	
		}
		return orders;
	}

	
	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		Iterable<OrderEntity> entities = orderRepository.findByProductNameContainingIgnoreCase(searchTerm);
		List<OrderModel> orders = new ArrayList<OrderModel>();
		
		for(OrderEntity item : entities) {
			orders.add(modelMapper.map(item, OrderModel.class));	
		}
		return orders;
	}

	
	@Override
	public long addOne(OrderModel newOrder) {
		
		OrderEntity entity = modelMapper.map(newOrder, OrderEntity.class);
		OrderEntity result = orderRepository.save(entity);
		
		if (result == null) {
			return 0;
		} else {
			return result.getId();
		}			
	}

	
	@Override
	public boolean deleteOne(long id) {
		orderRepository.deleteById(id);
		return true;
	}

	
	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		
		OrderEntity entity = modelMapper.map(updateOrder, OrderEntity.class);
		OrderEntity result = orderRepository.save(entity);
		OrderModel model = modelMapper.map(result, OrderModel.class);
		return model;
	}

	
}
