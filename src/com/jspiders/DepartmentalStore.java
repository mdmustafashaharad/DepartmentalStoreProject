package com.jspiders;

/**
 * 
 * @author Mohammad Mustafa
 * @since 2023
 * Contact : 900651340
 *  Email : mdmustafashaharad@gmail.com
 *
 */

public interface DepartmentalStore {
	
// we are created abstract method because achieving Strong Abstraction

	void addProduct();        // public abstract void addProduct();
	void removeProduct();
	void removeAllProduct();
	void displayProduct();
	void displayAllProduct();
	void updateProduct();
	void countProduct();
	void sortProduct();
}
