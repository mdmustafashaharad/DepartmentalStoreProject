package com.jspiders;

import java.util.Scanner;
import exception.InvalidChoiceException;

/**
 * 
 * @author Mohammad Mustafa
 * @since 2023
 * Contact : 900651340
 *  Email : mdmustafashaharad@gmail.com
 *
 */

public class Solution {
// create a display menu method because to invoking direct menu
// Make display menu static because of to invoke without create object
	
	static private void displayMenu() {
		//Menu -Driven Program -> 9 Option
		
		System.out.println("Welcome to Departmental Store\n---------------------------------");
		System.out.println("	1. Add Product \r\n"
				+ "	2. Remove Product\r\n"
				+ "	3. Remove All Products\r\n"
				+ "	4. Display Product\r\n"
				+ "	5. Display All Products\r\n"
				+ "	6. Update Product\r\n"
				+ "	7. Count Products\r\n"
				+ "	8. Sort Products\r\n"
				+ "	9. Exit");
		System.out.println("Enter Your Choice");
	}
// Main Method ...
	public static void main(String[] args) {
// Create a scanner class to accept user input
		
		Scanner scan = new Scanner(System.in);
		
// create DepartmentalStore implementation class beacuse of invoking methods 
// here upcasted for achieving abstraction
		DepartmentalStore store = new DepartmentalStoreImpl();
		
// while for again and again printing dispaly menu
		while (true) {
			displayMenu();
			int choice = scan.nextInt();                    // Accept user input
			
// switch case use to choice the user input for using methods
			
			switch(choice) {
			case 1 : {
				store.addProduct(); break;
			}
			case 2 : {
				store.removeProduct(); break;
			}
			case 3 : {
				store.removeAllProduct(); break;
			}
			case 4 : {
				store.displayProduct(); break;
			}
			case 5 : {
				store.displayAllProduct(); break;
			}
			case 6 : {
				store.updateProduct(); break;
			}
			case 7 : {
				store.countProduct(); break;
			}
			case 8 : {
				store.sortProduct(); break;
			}
			case 9 : {
				System.out.println("Thank You !");
				System.exit(0); break;
			}
// default is use to print if choice is wrong of user input ...
// Invoking Exception of Invalid choice Exception
			default : {
				try {
					throw new InvalidChoiceException("Invalid Choice , Please Enter Valid Choice\n");
				} catch(InvalidChoiceException e) {
					System.out.println(e.getMessage());
					break;
				} 
			}
			}
		}
				
	}
}
