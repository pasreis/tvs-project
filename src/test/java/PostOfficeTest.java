package app;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import java.util.List;
import java.util.ArrayList;

public class PostOfficeTest {
	@Test
	public void RP_Hold_08() {
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

}