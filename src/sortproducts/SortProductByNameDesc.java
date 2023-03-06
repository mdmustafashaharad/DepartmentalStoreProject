package sortproducts;

import java.util.Comparator;

import com.jspiders.Product;

/**
 * 
 * @author Mohammad Mustafa
 * @since 2023
 * Contact : 900651340
 *  Email : mdmustafashaharad@gmail.com
 *
 */
// sorting logic by using comparator

public class SortProductByNameDesc implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p2.getName().compareTo(p1.getName());
	}

}
