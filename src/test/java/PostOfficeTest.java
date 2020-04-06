package app;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import app.Product;

import java.util.List;
import java.util.ArrayList;

public class PostOfficeTest {
	@Test
	public void RP_Hold_06	() {
		// Arrange
		int maxNumberOfProducts = 4;

		Product p1 = new Product("P1", "This is the product P1", 2, 4);
		Product p2 = new Product("P2", "This is the product P2", 3, 0);
		Product p3 = new Product("P3", "This is the product P3", 5, 6);

		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);

		PostOffice postOffice = new PostOffice(maxNumberOfProducts, products);

		// Act
		postOffice.removeProduct("P2");
		boolean returnValue = postOffice.removeProduct("P2");

		// Assert
		assertFalse(returnValue);
		assertEquals(postOffice.getProducts().size(), 2);
		assertEquals(postOffice.getMaxNumberOfProducts(), maxNumberOfProducts);
		assertFalse(postOffice.getProducts().contains(p2));

	}

	@Test
	public void UP_Hold_06 () {
		// Arrange
		int newPrice = 13;
		int newQuantity = 24;
		String prodcutName = null;

		final int maxNumberOfProducts = 4;

		Product p1 = new Product("P1", "This is the product P1", 2, 4);
		Product p2 = new Product("P2", "This is the product P2", 3, 0);
		Product p3 = new Product("P3", "This is the product P3", 5, 6);

		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);

		PostOffice postOffice = new PostOffice(maxNumberOfProducts, products);

		// Act
		boolean returnValue = postOffice.update(prodcutName, newPrice, newQuantity);

		// Assert
		assertFalse(returnValue);
		assertEquals(postOffice.getProducts().size(), 3);
		assertEquals(postOffice.getMaxNumberOfProducts(), maxNumberOfProducts);
	}

	@Test
	public void SMNoP_Full_04 () {
		// Arrange
		int newMaxQuantity = 21;

		final int maxNumberOfProducts = 3;

		Product p1 = new Product("P1", "This is the product P1", 2, 4);
		Product p2 = new Product("P2", "This is the product P2", 3, 0);
		Product p3 = new Product("P3", "This is the product P3", 5, 6);

		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);

		PostOffice postOffice = new PostOffice(maxNumberOfProducts, products);

		// Act
		boolean returnValue = postOffice.setMaxNumberOfProducts(newMaxQuantity);

		// Assert
		assertFalse(returnValue);
		assertEquals(postOffice.getMaxNumberOfProducts(), maxNumberOfProducts);
		assertEquals(postOffice.getProducts().size(), 3);
	}

	@Test
	public void PO_Const_02 () {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void RM_Hold_03 () {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void UP_Full_01 () {
		// Arange

		// Act

		// Assert
	}
}