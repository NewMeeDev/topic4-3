package com.mneumann1.model;

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
public class OrderModel {

	Long id = 0L;
	String orderNo = "";
	String productName = "";
	float price = 0f;
	int quantity = 0;
	
}
