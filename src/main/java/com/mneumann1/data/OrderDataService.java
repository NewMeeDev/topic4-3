/**
 * 
 */
package com.mneumann1.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mneumann1.model.OrderMapper;
import com.mneumann1.model.OrderModel;

/**
 * @author MNEUMANN1
 *
 */
//@Primary
@Repository
public class OrderDataService implements OrderDataAccessInterface<OrderModel> {

	// see application.properties file to get the detail on the mysql connection
	@Autowired
	DataSource dataSource;
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public OrderModel getById(long id) {
		List<OrderModel> result = jdbcTemplate.query ("SELECT * FROM ORDERS WHERE ID = ?", new OrderMapper(), id);
		
		if (result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
	}

	
	@Override
	public List<OrderModel> getOrders() {
		List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS", new OrderMapper());
		return results;
	}

	
	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE PRODUCT_NAME LIKE ?", new OrderMapper(), "%" + searchTerm + "%");
		return results;
	}

	
	@Override
	public long addOne(OrderModel newOrder) {
//		return jdbcTemplate.update("INSERT INTO ORDERS (ORDER_NUMBER, PRODUCT_NAME, PRICE, QTY) VALUES (?, ?, ?, ?)", 
//				newOrder.getOrderNo(), 
//				newOrder.getProductName(), 
//				newOrder.getPrice(), 
//				newOrder.getQuantity()
//				);
		
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleInsert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");
		
		// create a map of the column names
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("ORDER_NUMBER", newOrder.getOrderNo());
		parameters.put("PRODUCT_NAME", newOrder.getProductName());
		parameters.put("PRICE", newOrder.getPrice());
		parameters.put("QTY", newOrder.getQuantity());
		
		long result = simpleInsert.execute(parameters);
		return result;
	}

	
	@Override
	public boolean deleteOne(long id) {
		int result = jdbcTemplate.update("DELETE FROM ORDERS WHERE ID = ?", id);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		int result = jdbcTemplate.update("UPDATE ORDERS SET ORDER_NUMBER = ?, PRODUCT_NAME = ?, PRICE = ?, QTY = ? WHERE ID = ?", 
				updateOrder.getOrderNo(), 
				updateOrder.getProductName(), 
				updateOrder.getPrice(), 
				updateOrder.getQuantity(), idToUpdate);
		
		if (result > 0) {
			return updateOrder;
		} else {
			return null;
		}
	}

}
