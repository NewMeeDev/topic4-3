/**
 * 
 */
package com.mneumann1.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.mneumann1.model.OrderModel;

/**
 * @author MNEUMANN1
 *
 */
@Repository
public class OrderFakeDAO implements OrderDataAccessInterface<OrderModel> {

	
	List<OrderModel> orders = new ArrayList<OrderModel>();
	
	
	public OrderFakeDAO() {
		
		orders.add(new OrderModel(0L,  "000", "Sky diving experience", 1500.0f, 1));
		orders.add(new OrderModel(1L,  "001", "Run with the bulls in Pamplona", 120.0f,51));
		orders.add(new OrderModel(2L,  "002", "Orbit the moon with SpaceX", 5000000.0f, 2));
		orders.add(new OrderModel(3L,  "003", "Shot from a cannon", 420.0f, 1));
		orders.add(new OrderModel(4L,  "004", "Zip line the Grand Canyon", 470.0f, 1));
		orders.add(new OrderModel(5L,  "005", "The whole enchilada ride in Moab", 220.0f, 3));
		orders.add(new OrderModel(6L,  "006", "Wingsuit jumping lessons in Norway", 900.0f, 4));
		orders.add(new OrderModel(7L,  "007", "Backpacking tour to peak of Kilimandjaro", 300.0f, 4));
		orders.add(new OrderModel(8L,  "008", "Sled race in the Iditarod", 3500.0f, 2));
		orders.add(new OrderModel(9L,  "009", "SCUBA dive Jellyfish Lake in Palau", 40.0f, 2));
		orders.add(new OrderModel(10L, "010", "Lemonade by the pool and a book", 2.0f, 1));
	}
	
	
	@Override
	public OrderModel getById(long id) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getId() == id) {
				return orders.get(i);
			}
		}
		// nothing found
		return null;
	}

	
	@Override
	public List<OrderModel> getOrders() {
		return orders;
	}

	
	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
//		List<OrderModel> foundItems = new ArrayList<OrderModel>();
//		
//		for (int i = 0; i < orders.size(); i++) {
//			if (orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase())) {
//				foundItems.add(orders.get(i));
//			}
//		}
//		return foundItems;
		
		// better Version
		List<OrderModel> foundItems = orders
				.stream()
				.filter(order -> order.getProductName().toLowerCase()
				.contains(searchTerm.toLowerCase()))
				.collect(Collectors.toList());
				
		return foundItems;
		
	}

	
	@Override
	public long addOne(OrderModel newOrder) {
		boolean success = orders.add(newOrder);
		
		if (success) {
			return 1;
		} else {
			return 0;
		}
	}

	
	@Override
	public boolean deleteOne(long id) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getId() == id) {
				orders.remove(i);
				return true;
			}
		}
		// nothing found
		return false;
	}

	
	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getId() == idToUpdate) {
				orders.set(i, updateOrder);
				return orders.get(i);
			}
		}
		// nothing found
		return null;
	}

}
