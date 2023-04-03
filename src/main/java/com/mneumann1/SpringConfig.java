package com.mneumann1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.mneumann1.data.OrderDataAccessInterface;
import com.mneumann1.data.OrderDataService;
import com.mneumann1.data.OrderDataServiceForRepository;
import com.mneumann1.service.OrderBusinesService;
import com.mneumann1.service.OrderBusinesServiceInterface;

@Configuration
public class SpringConfig {

	@Bean(name="orderBusinessService", initMethod="init", destroyMethod="destroy")
	@RequestScope
	//@SessionScope
	public OrderBusinesServiceInterface getOrderBusines() {
		return new OrderBusinesService();
	}
	
	@Autowired
	DataSource dataSource;
	
	
	@Bean(name="ordersDAO")
	@RequestScope
	public OrderDataAccessInterface getDataService() {
		return new OrderDataServiceForRepository(dataSource);
		// return new OrderDataService();
	}
}
