package com.myretail.dto;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CurrentPriceDTOTest</code> contains tests for the class <code>{@link CurrentPriceDTO}</code>.
 *
 * @generatedBy CodePro at 2/21/16 12:15 PM
 * @author jayakrishnan.s
 * @version $Revision: 1.0 $
 */
public class CurrentPriceDTOTest {
	/**
	 * Run the String getCurrency_code() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testGetCurrency_code_1()
		throws Exception {
		CurrentPriceDTO fixture = new CurrentPriceDTO();
		fixture.setCurrency_code("");
		fixture.setTcin("");
		fixture.setValue("");

		String result = fixture.getCurrency_code();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTcin() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testGetTcin_1()
		throws Exception {
		CurrentPriceDTO fixture = new CurrentPriceDTO();
		fixture.setCurrency_code("");
		fixture.setTcin("");
		fixture.setValue("");

		String result = fixture.getTcin();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testGetValue_1()
		throws Exception {
		CurrentPriceDTO fixture = new CurrentPriceDTO();
		fixture.setCurrency_code("");
		fixture.setTcin("");
		fixture.setValue("");

		String result = fixture.getValue();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setCurrency_code(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testSetCurrency_code_1()
		throws Exception {
		CurrentPriceDTO fixture = new CurrentPriceDTO();
		fixture.setCurrency_code("");
		fixture.setTcin("");
		fixture.setValue("");
		String currency_code = "";

		fixture.setCurrency_code(currency_code);

		// add additional test code here
	}

	/**
	 * Run the void setTcin(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testSetTcin_1()
		throws Exception {
		CurrentPriceDTO fixture = new CurrentPriceDTO();
		fixture.setCurrency_code("");
		fixture.setTcin("");
		fixture.setValue("");
		String tcin = "";

		fixture.setTcin(tcin);

		// add additional test code here
	}

	/**
	 * Run the void setValue(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testSetValue_1()
		throws Exception {
		CurrentPriceDTO fixture = new CurrentPriceDTO();
		fixture.setCurrency_code("");
		fixture.setTcin("");
		fixture.setValue("");
		String value = "";

		fixture.setValue(value);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		CurrentPriceDTO fixture = new CurrentPriceDTO();
		fixture.setCurrency_code("");
		fixture.setTcin("");
		fixture.setValue("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("CurrentPriceDTO [value=, currency_code=, tcin=]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CurrentPriceDTOTest.class);
	}
}