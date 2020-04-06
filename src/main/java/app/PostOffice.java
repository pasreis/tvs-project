package app;

import java.util.List;
import java.util.ArrayList;

public class PostOffice {
	public PostOffice(final int maxNumberOfProducts, final List<Product> products) { /* .... */ }
	// adds a new product to this post office.
	public boolean addNewProduct(final Product p) { /* .... */ return true; }
	// updates quantity and/or price of the given product
	public boolean update(final String productName, final int newPrice, final int newQuantity) { /* .... */ return true; }
	// removes a product from this post office
	public boolean removeProduct(final String productName) { /* .... */ return true;  }
	public boolean setMaxNumberOfProducts(final int newMaxQuantity) { /* .... */ return true; }
	// accessor methods
	public List<Product> getProducts() { /* .... */ return new ArrayList<Product>(); }
	public int getMaxNumberOfProducts() { /* .... */ return 1; }
//...
}