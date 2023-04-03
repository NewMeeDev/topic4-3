package com.mneumann1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table("ORDERS")
public class OrderEntity {
	
	// OrderEntity is based on OrderModel
	// It's purpose is to connect the OrderModel to the Orders table in the database
	
	@Id
	@Column("ID")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id = 0L;
	
	@Column("ORDER_NUMBER")
	String orderNo = "";
	
	@Column("PRODUCT_NAME")
	String productName = "";
	
	@Column("PRICE")
	float price = 0f;
	
	@Column("QTY")
	int quantity = 0;
	
}
