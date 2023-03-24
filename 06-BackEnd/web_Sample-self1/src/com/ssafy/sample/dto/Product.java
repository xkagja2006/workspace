package com.ssafy.sample.dto;

/*
 * CREATE TABLE `product`(
  `code` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `price` int NOT NULL,
  
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

public class Product {
	private String code;
	private String model;
	private int price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
