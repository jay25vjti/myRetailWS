package com.myretail.entities;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CurrentPriceTest</code> contains tests for the class <code>{@link CurrentPrice}</code>.
 *
 * @generatedBy CodePro at 2/12/16 8:04 PM
 * @author jayakrishnan.s
 * @version $Revision: 1.0 $
 */
public class CurrentPriceTest {
	/**
	 * Run the CurrentPrice() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testCurrentPrice_1()
		throws Exception {

		CurrentPrice result = new CurrentPrice();

		// add additional test code here
		assertNotNull(result);
		assertEquals("CurrentPrice [id=null, tcin=null, price=null, currencyCd=null]", result.toString());
		assertEquals(null, result.getId());
		assertEquals(null, result.getCurrencyCd());
		assertEquals(null, result.getTcin());
		assertEquals(null, result.getPrice());
	}

	/**
	 * Run the CurrentPrice(String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testCurrentPrice_2()
		throws Exception {
		String tcin = "";
		String price = "";
		String currencyCd = "";

		CurrentPrice result = new CurrentPrice(tcin, price, currencyCd);

		// add additional test code here
		assertNotNull(result);
		assertEquals("CurrentPrice [id=null, tcin=, price=, currencyCd=]", result.toString());
		assertEquals(null, result.getId());
		assertEquals("", result.getCurrencyCd());
		assertEquals("", result.getTcin());
		assertEquals("", result.getPrice());
	}

	/**
	 * Run the String getCurrencyCd() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testGetCurrencyCd_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");

		String result = fixture.getCurrencyCd();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");

		String result = fixture.getId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPrice() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testGetPrice_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");

		String result = fixture.getPrice();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTcin() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testGetTcin_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");

		String result = fixture.getTcin();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setCurrencyCd(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testSetCurrencyCd_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");
		String currencyCd = "";

		fixture.setCurrencyCd(currencyCd);

		// add additional test code here
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");
		String id = "";

		fixture.setId(id);

		// add additional test code here
	}

	/**
	 * Run the void setPrice(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testSetPrice_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");
		String price = "";

		fixture.setPrice(price);

		// add additional test code here
	}

	/**
	 * Run the void setTcin(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testSetTcin_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");
		String tcin = "";

		fixture.setTcin(tcin);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		CurrentPrice fixture = new CurrentPrice("", "", "");
		fixture.setId("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("CurrentPrice [id=, tcin=, price=, currencyCd=]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/12/16 8:04 PM
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
	 * @generatedBy CodePro at 2/12/16 8:04 PM
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
	 * @generatedBy CodePro at 2/12/16 8:04 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CurrentPriceTest.class);
	}
}