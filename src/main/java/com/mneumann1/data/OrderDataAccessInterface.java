/**
 * 
 */
package com.mneumann1.data;

import java.util.List;

import com.mneumann1.model.OrderModel;

/**
 * @author MNEUMANN1
 *
 */
public interface OrderDataAccessInterface<T> {

	public T getById(long id);
	
	public List<T> getOrders();
	
	public List<T> searchOrders(String searchTerm);
	
	public long addOne(T newOrder);
	
	public boolean deleteOne(long id);
	
	public T updateOne(long idToUpdate, T updateOrder);
}
