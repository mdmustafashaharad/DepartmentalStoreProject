package sortproducts;

/**
 * 
 * @author Mohammad Mustafa
 * @since 2023
 * Contact : 900651340
 *  Email : mdmustafashaharad@gmail.com
 *
 */

import java.util.Comparator;

import com.jspiders.Product;

public class SortProductByCostAsc implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getCost() - p2.getCost();
	} 
	
}