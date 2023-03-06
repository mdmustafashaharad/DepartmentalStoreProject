package com.jspiders;

/**
 * 
 * @author Mohammad Mustafa
 * @since 2023
 * Contact : 900651340
 *  Email : mdmustafashaharad@gmail.com
 *
 */

public class Product {
//private -> id(Auto-Generation ), name ,cost,quantity
	
	private String id;
	private String name;
	private int cost;
	private int quantity;
	static private int count = 100;
// public constructor
	public Product( String name, int cost, int quantity) {
		super();
		this.id = "PRODUCT"+count;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		count++;
	}
//4 public getter methods & 3 public setter  methods
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
//toString()	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", quantity=" + quantity + "]";
	}
	
}
