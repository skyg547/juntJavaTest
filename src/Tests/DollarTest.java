package Tests;

import main.Dollar;
import org.junit.Assert;
import org.junit.Test;

public class DollarTest {
	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		Dollar product = five.times(2);
		Assert.assertEquals(10, product.amount);
		product = five.times(3);
		Assert.assertEquals(15, product.amount);

	}

	@Test
	public void testEquality() {
		Assert.assertEquals(new Dollar(5), new Dollar(5));
	}
}
