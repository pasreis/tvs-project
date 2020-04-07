import static org.testng.Assert.*;
import org.testng.annotations.*;

import app.PostOffice;
import app.Product;

import java.util.List;
import java.util.ArrayList;

public class PostOfficeTest {
	private int maxNumberOfProductsFullState;
	private int maxNumberOfProductsHoldingState;
	private Product p1;
	private Product p2;
	private Product p3;
	private List<Product> products;
	private PostOffice postOfficeFullState;
	private PostOffice postOfficeHoldingState;

	@BeforeMethod
	public void setup() {
		maxNumberOfProductsFullState = 3;
		maxNumberOfProductsHoldingState = 4;

		p1 = new Product("P1", "This is the product P1", 2, 4);
		p2 = new Product("P2", "This is the product P2", 3, 0);
		p3 = new Product("P3", "This is the product P3", 5, 6);

		products = new ArrayList<Product>();

		products.add(p1);
		products.add(p2);
		products.add(p3);

		postOfficeFullState = new PostOffice(maxNumberOfProductsFullState, products);
		postOfficeHoldingState = new PostOffice(maxNumberOfProductsHoldingState, products);
	}

	@Test
	public void RP_Hold_06	() {
		// Arrange

		// Act
		postOfficeHoldingState.removeProduct(p2.getName());
		boolean returnValue = postOfficeHoldingState.removeProduct(p2.getName());

		// Assert
		assertFalse(returnValue);
		assertEquals(postOfficeHoldingState.getProducts().size(), 2);
		assertEquals(postOfficeHoldingState.getMaxNumberOfProducts(), maxNumberOfProductsHoldingState);
		assertFalse(postOfficeHoldingState.getProducts().contains(p2));
	}

	@Test
	public void UP_Hold_06 () {
		// Arrange
		int newPrice = 13;
		int newQuantity = 24;
		String prodcutName = null;

		// Act
		boolean returnValue = postOfficeHoldingState.update(prodcutName, newPrice, newQuantity);

		// Assert
		assertFalse(returnValue);
		assertEquals(postOfficeHoldingState.getProducts().size(), 3);
		assertEquals(postOfficeHoldingState.getMaxNumberOfProducts(), maxNumberOfProductsHoldingState);
	}

	@Test
	public void SMNoP_Full_04 () {
		// Arrange
		int newMaxQuantity = 21;

		// Act
		boolean returnValue = postOfficeFullState.setMaxNumberOfProducts(newMaxQuantity);

		// Assert
		assertFalse(returnValue);
		assertEquals(postOfficeFullState.getMaxNumberOfProducts(), maxNumberOfProductsFullState);
		assertEquals(postOfficeFullState.getProducts().size(), 3);
	}

	@Test
	public void PO_Const_02 () {
		// Arrange
		int maxNumberOfProducts = 3;
		List<Product> products = new ArrayList<Product>();

		// Act
		PostOffice postOffice = new PostOffice(maxNumberOfProducts, products);

		// Assert
		assertEquals(postOffice.getProducts().size(), 0);
		assertEquals(postOffice.getMaxNumberOfProducts(), maxNumberOfProducts);
	}

	@Test
	public void RM_Hold_03 () {
		// Arrange
		
		// Act
		boolean returnValue = postOfficeHoldingState.removeProduct(p2.getName());

		// Assert
		assertTrue(returnValue);
		assertEquals(postOfficeHoldingState.getProducts().size(), 2);
		assertEquals(postOfficeHoldingState.getMaxNumberOfProducts(), maxNumberOfProductsHoldingState);
		assertFalse(postOfficeHoldingState.getProducts().contains(p2));
	}

	@Test
	public void UP_Full_01 () {
		// Arange
		int newPrice = 0;
		int newQuantity = 4;
		String productName = p1.getName();

		// Act
		boolean returnValue = postOfficeFullState.update(productName, newPrice, newQuantity);

		// Assert
		assertTrue(returnValue);
		assertEquals(postOfficeFullState.getProducts().size(), 3);
		assertEquals(postOfficeFullState.getMaxNumberOfProducts(), maxNumberOfProductsFullState);
		assertEquals(postOfficeFullState.getProducts().get(postOfficeFullState.getProducts().indexOf(p1)).getPrice(), newPrice);
		assertEquals(postOfficeFullState.getProducts().get(postOfficeFullState.getProducts().indexOf(p1)).getCurrentQuantity(), newQuantity);
	}
}