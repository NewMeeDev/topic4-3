/**
 * 
 */
package com.mneumann1.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author MNEUMANN1
 *
 */
public class OrderMapper implements RowMapper<OrderModel> {

	@Override
	public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// get the result set
		
		// create a new order object
		
		// return it
		
		OrderModel order = new OrderModel(rs.getLong("ID"), rs.getString("ORDER_NUMBER"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QTY"));
		
		return order;
	}

}
