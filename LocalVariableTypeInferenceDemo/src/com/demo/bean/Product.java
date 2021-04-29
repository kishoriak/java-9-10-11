package com.demo.bean;

public class Product {
	private String name;
	private int stock,value;
	public Product() {
		super();
	}
	public Product(int stock, int value,String name) {
		super();
		this.name = name;
		this.stock = stock;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	

}
