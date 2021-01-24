package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());	}
	
	@Test
	public void testGetRate() {
		assertEquals(Double.valueOf(0.15), SEK.getRate());
		assertEquals(Double.valueOf(0.20), DKK.getRate());
		assertEquals(Double.valueOf(1.5), EUR.getRate());	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.16);
		assertEquals(Double.valueOf(0.16), SEK.getRate());
		DKK.setRate(0.21);
		assertEquals(Double.valueOf(0.21), DKK.getRate());
		EUR.setRate(1.6);
		assertEquals(Double.valueOf(1.6), EUR.getRate());	}
	
	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf(7),SEK.universalValue(50));
		assertEquals(Integer.valueOf(10),DKK.universalValue(50));
		assertEquals(Integer.valueOf(75),EUR.universalValue(50));
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals(Integer.valueOf(4), EUR.valueInThisCurrency(50, SEK));
		assertEquals(Integer.valueOf(66), SEK.valueInThisCurrency(50, DKK));	}

}
