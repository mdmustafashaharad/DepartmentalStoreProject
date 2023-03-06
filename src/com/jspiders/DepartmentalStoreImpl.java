package com.jspiders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import exception.InvalidProductIdException;
import exception.InvalidSortChoiceException;
import exception.InvalidUpdateChoiceException;
import exception.ProductNotFoundException;
import sortproducts.SortProductByCostAsc;
import sortproducts.SortProductByCostDesc;
import sortproducts.SortProductByIdAsc;
import sortproducts.SortProductByIdDesc;
import sortproducts.SortProductByNameAsc;
import sortproducts.SortProductByNameDesc;
import sortproducts.SortProductByQuantityAsc;
import sortproducts.SortProductByQuantityDesc;

/**
 * 
 * @author name: Mohammad_Mustafa
 * @since 2023
 *  Contact : 900651340
 *  Email : mdmustafashaharad@gmail.com
 *  
 */

public class DepartmentalStoreImpl implements DepartmentalStore {
	
// create Scanner Class for Accepting User input
	
	Scanner scan = new Scanner(System.in);
	
// Create Map for Store Products Based On key and Values
// Map make it as static because map having only one for class
	
	static Map<String,Product> map = new LinkedHashMap<String,Product>();
	
// Keyset() is method to using traverse value based on key
	
	static Set<String> keys = map.keySet();   

// Product Object adding Method
	@Override
	public void addProduct() {
		
// Accept Name , cost, quantity
		
		System.out.println("Enter Product Name");     // Name 
		String name = scan.next();

		System.out.println("Enter Product Cost");    // Cost
		int cost = scan.nextInt();

		System.out.println("Enter Product Quantity");   // Quantity
		int quantity = scan.nextInt();

// create an instance of product
		
		Product prd = new Product(name,cost,quantity);

// Add into map ->put(), -> Entry
		
		map.put(prd.getId(), prd);
		
		System.out.println("Product Id is "+prd.getId());
		System.out.println("Product Added Successfully");
		System.out.println("-----------------------------------------------------------");
	}

// One Product Removing method based On product Id
	@Override
	public void removeProduct() {
// First Write Condition for Checking map is having any product object or not
// take if-else ...In that if condition check map.size()!=0 and else is create product not found exception
		
		if (map.size() !=0) {
// Accept Product Id from user
			
			System.out.println("Enter The Product Id");

			String id = scan.next().toUpperCase();     // taking use input of id and make it to upper case
// taking another nested if- else condition ... if condition is checking for user id input object is present in map or not

			if(map.containsKey(id)) {
				
				map.remove(id);         // remove() method is use for removing object from map
				
				System.out.println("Product Removed Successfully");
				
			}	
// else part for create a exception for product id not found exception
			else {
				try {
					throw new InvalidProductIdException("Enter Currect Product Id ");  // Invoking InvalidProductIdException
				} catch(InvalidProductIdException e ) {
					System.out.println(e.getMessage());
				}
				System.out.println("-----------------------------------------------------------");
			}
		} 
// else part for product not found exception
		else {                                   
			try {
				throw new ProductNotFoundException("Products Are Not Available");  // Invoking ProductNotFoundException
			} catch(ProductNotFoundException e ) {
				System.out.println(e.getMessage());
			}
			System.out.println("-----------------------------------------------------------");
		}
	}
	
// Removing All object Method ...It will Cleared all products object
	@Override
	public void removeAllProduct() {
//Take one if-else condition for giving output to user ...because if Any products not there giving output
// directly to user exception-> Product not found exception
		
		if (map.size() !=0) {
			
			map.clear();
			System.out.println("All Products Are Deleted");
		} else {
			try {
				throw new ProductNotFoundException("Products Are Not Available");
			} catch(ProductNotFoundException e ) {
				System.out.println(e.getMessage());
			}
			System.out.println("-----------------------------------------------------------");
		}
	}

	@Override
	public void displayProduct() {
//Take one if-else condition for giving output to user ...because if Any products not there giving output
// directly to user exception-> Product not found exception
		
		if (map.size() !=0) {
			
// Accept Product Id
			
			System.out.println("Enter The Product Id");
			String id = scan.next().toUpperCase();
			
			if(map.containsKey(id)) {   // containsKey() method is use to check key present or not in map
				
				Product p = map.get(id);      // get() method is use to getting object
				
				System.out.println("Prouct Id is "+p.getId());
				System.out.println("Product Id is "+p.getName());
				System.out.println("Product Cost is "+p.getCost());
				System.out.println("Product Quantity "+p.getQuantity());
				
			} else {                     
				try {    // Invoking Exception of invalid product id exception
					throw new InvalidProductIdException("Enter Currect Product Id ");   
				} catch(InvalidProductIdException e ) {
					System.out.println(e.getMessage());
				}
				System.out.println("-----------------------------------------------------------");
			}
		} else {
			try {       // Invoking Exception of product not found exception
				throw new ProductNotFoundException("Products Are Not Available");
			} catch(ProductNotFoundException e ) {
				System.out.println(e.getMessage());
			}
			System.out.println("-----------------------------------------------------------");
		}
	}

// Display All method is use to displaying All details of products
	@Override
	public void displayAllProduct() {

//Take one if-else condition for giving output to user ...because if Any products not there giving output
// directly to user exception-> Product not found exception		
		
		if (map.size() != 0) {
			
			for (String key : keys) {               // enhanced for loop
				
				System.out.println(map.get(key));
			}
			System.out.println("-----------------------------------------------------------");

		} else {
			try {
				throw new ProductNotFoundException("Products Are Not Available");
			} catch(ProductNotFoundException e ) {
				System.out.println(e.getMessage());
			}
			System.out.println("-----------------------------------------------------------");
		}
	}

// Update method is Use to Updating Product Details	
	@Override
	public void updateProduct() {
//Take one if-else condition for giving output to user ...because if Any products not there giving output
// directly to user exception-> Product not found exception		
		if ( map.size() !=0 ) {

			System.out.println("Enter The Product Id");   // Taking user input of product id to update
			String id = scan.next().toUpperCase();         // make to upperCase

			if (map.containsKey(id) ) {                   // check id is present or not in map
				
				System.out.println("		1. Update Product Name\r\n"   // print the choices to user 
						+ "		2. Update Product Cost\r\n"
						+ "		3. Update Product Quantity\r\n"
						+ "		4. Update All Product Details\n"
						+ "		5. Exit");
				System.out.println("      Enter Your Choice");
				
				int choice = scan.nextInt();                         //Taking choice from user side
				
				switch(choice) {                                  // Normally use Switch case to execute the some logics
				case 1 : {                                        // because of based on choice // Update Product Name
					System.out.println("Enter The Product Name to Update ");
					String name = scan.next();                    //  Accept user side updates
					Product p = map.get(id);
					p.setName(name);
					map.replace(id, p);
					System.out.println("Product Name is Updated ");
					break;
				}
				case 2 : {                                                   // Update Product Cost
					System.out.println("Enter The Product Cost to Update ");
					int cost = scan.nextInt();                               // Accept user side updates
					Product p = map.get(id); 
					p.setCost(cost);
					map.replace(id, p);
					System.out.println("Product Cost is Updated ");
					break;
				}
				case  3 : {                                                        // update the Product Quantity
					System.out.println("Enter The Product Quantity to Update ");   
					int quantity = scan.nextInt();                                 // Accept user side updates
					Product p = map.get(id);
					p.setQuantity(quantity);
					map.replace(id, p);
					System.out.println("Product Quantity is Updated ");
					break;
				}
				case 4 : {                                                         // update the Product All details
					System.out.println("Enter The Product Name to Update ");       //Accept all user side updates
					String name = scan.next();
					System.out.println("Enter The Product Cost to Update ");
					int cost = scan.nextInt();
					System.out.println("Enter The Product Quantity to Update ");
					int quantity = scan.nextInt();
					
					Product p = map.get(id);                                       // first we getting object based on id
					
					p.setName(name); p.setCost(cost); p.setQuantity(quantity); 
					map.replace(id, p);
					System.out.println("Product All Details Are Updated ");
					break;
				}
				case 5 : {
					System.exit(0);
					break;
				}
				default : {
					try {
						throw new InvalidUpdateChoiceException("Invalid Choice to Update , Please Enter Valid Choice\n");
					} catch(InvalidUpdateChoiceException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("-----------------------------------------------------------");
				}

				}
			} else {
				try {
					throw new InvalidProductIdException("Enter Currect Product Id\n");
				} catch(InvalidProductIdException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("-----------------------------------------------------------");
			}
		} else {
			try {
				throw new ProductNotFoundException("Products Are Not Available");
			} catch(ProductNotFoundException e ) {
				System.out.println(e.getMessage());
			}
			System.out.println("-----------------------------------------------------------");
		}
	}

	@Override
	public void countProduct() {
		if (map.size() != 0) {
			System.out.println("Total Count Products are "+map.size());
			System.out.println("-----------------------------------------------------------");

		} else {
			try {
				throw new ProductNotFoundException("Products Are Not Available");
			} catch(ProductNotFoundException e ) {
				System.out.println(e.getMessage());
			}
			System.out.println("-----------------------------------------------------------");
		}
	}

	@Override
	public void sortProduct() {
		if (map.size() != 0) {
			List<Product> l = new ArrayList<Product>();
			for (String s : keys) {
				l.add(map.get(s));
			}
			System.out.println("		1. Sort Id\r\n"
					+ "		2. Sort Name \r\n"
					+ "		3. Sort Cost\r\n"
					+ "		4. Sort Quantity\n"
					+ "		5. Exit");
			System.out.println("        Enter Your Choice");
			int choice = scan.nextInt();
			
			
			switch(choice) {
			case 1 : {
				System.out.println("    1. Ascending Id\n    2. Descending Id\n    Enter Your Choice");
				int ch = scan.nextInt();
				if (ch ==1) {
					Collections.sort(l,new SortProductByIdAsc());
					display(l);
				} else if(ch==2) {
					Collections.sort(l,new SortProductByIdDesc());
					display(l);
				} else {
					try { 
						throw new InvalidSortChoiceException("Enter Currect Sort Choice\n");
					} catch (InvalidSortChoiceException e ) {
						System.out.println(e.getMessage());
					}
				}
				
				break;
			}
			case 2 : {
				System.out.println("    1. Ascending Name\n    2. Descending Name\n    Enter Your Choice");
				int ch = scan.nextInt();
				if (ch ==1) {
					Collections.sort(l,new SortProductByNameAsc());
					display(l);
				} else if(ch==2) {
					Collections.sort(l,new SortProductByNameDesc());
					display(l);
				} else {
					try { 
						throw new InvalidSortChoiceException("Enter Currect Sort Choice\n");
					} catch (InvalidSortChoiceException e ) {
						System.out.println(e.getMessage());
					}
				}
				break;
			}
			case 3 : {
				System.out.println("    1. Ascending Cost\n    2. Descending Cost\n    Enter Your Choice");
				int ch = scan.nextInt();
				if (ch ==1) {
					Collections.sort(l,new SortProductByCostAsc());
					display(l);
				} else if(ch==2) {
					Collections.sort(l,new SortProductByCostDesc());
					display(l);
				} else {
					try { 
						throw new InvalidSortChoiceException("Enter Currect Sort Choice\n");
					} catch (InvalidSortChoiceException e ) {
						System.out.println(e.getMessage());
					}
				}
				break;
			}
			case 4 : {
				System.out.println("    1. Ascending Quantity\n    2. Descending Quantity\n    Enter Your Choice");
				int ch = scan.nextInt();
				if (ch ==1) {
					Collections.sort(l,new SortProductByQuantityAsc());
					display(l);
				} else if(ch==2) {
					Collections.sort(l,new SortProductByQuantityDesc());
					display(l);
				} else {
					try { 
						throw new InvalidSortChoiceException("Enter Currect Sort Choice\n");
					} catch (InvalidSortChoiceException e ) {
						System.out.println(e.getMessage());
					}
				}
				break;
			}
			case 5 : {
				System.out.println("Thank You !");
				System.exit(0);
			}
			default : {
				try { 
					throw new InvalidSortChoiceException("Enter Currect Sort Choice\n");
				} catch (InvalidSortChoiceException e ) {
					System.out.println(e.getMessage());
				}
			}

			}
		} else {
			try { 
				throw new ProductNotFoundException("Products Are Not Available\n");
			} catch (ProductNotFoundException e ) {
				System.out.println(e.getMessage());
			}
			System.out.println("-----------------------------------------------------------");
		}
	}

	public static void display(List<Product> list ) {
		
		for (Product p : list) {
			System.out.println(p);
		}
	}
}
