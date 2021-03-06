package com.myretail.dto;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>MyRetailDTOTest</code> contains tests for the class <code>{@link MyRetailDTO}</code>.
 *
 * @generatedBy CodePro at 2/21/16 12:15 PM
 * @author jayakrishnan.s
 * @version $Revision: 1.0 $
 */
public class MyRetailDTOTest {
	/**
	 * Run the CurrentPriceDTO getCurrent_price() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testGetCurrent_price_1()
		throws Exception {
		MyRetailDTO fixture = new MyRetailDTO();
		fixture.setCurrent_price(new CurrentPriceDTO());
		fixture.setName("");
		fixture.setId("");

		CurrentPriceDTO result = fixture.getCurrent_price();

		// add additional test code here
		assertNotNull(result);
		assertEquals("CurrentPriceDTO [value=null, currency_code=null, tcin=null]", result.toString());
		assertEquals(null, result.getValue());
		assertEquals(null, result.getCurrency_code());
		assertEquals(null, result.getTcin());
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		MyRetailDTO fixture = new MyRetailDTO();
		fixture.setCurrent_price(new CurrentPriceDTO());
		fixture.setName("");
		fixture.setId("");

		String result = fixture.getId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		MyRetailDTO fixture = new MyRetailDTO();
		fixture.setCurrent_price(new CurrentPriceDTO());
		fixture.setName("");
		fixture.setId("");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setCurrent_price(CurrentPriceDTO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testSetCurrent_price_1()
		throws Exception {
		MyRetailDTO fixture = new MyRetailDTO();
		fixture.setCurrent_price(new CurrentPriceDTO());
		fixture.setName("");
		fixture.setId("");
		CurrentPriceDTO current_price = new CurrentPriceDTO();

		fixture.setCurrent_price(current_price);

		// add additional test code here
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		MyRetailDTO fixture = new MyRetailDTO();
		fixture.setCurrent_price(new CurrentPriceDTO());
		fixture.setName("");
		fixture.setId("");
		String id = "";

		fixture.setId(id);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/21/16 12:15 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		MyRetailDTO fixture = new MyRetailDTO();
		fixture.setCurrent_price(new CurrentPriceDTO());
		fixture.setName("");
		fixture.setId("");
		String name = "";

		fixture.setName(name);

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
		MyRetailDTO fixture = new MyRetailDTO();
		fixture.setCurrent_price(new CurrentPriceDTO());
		fixture.setName("");
		fixture.setId("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("MyRetailDTO [id = , current_price = CurrentPriceDTO [value=null, currency_code=null, tcin=null], name = ]", result);
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
		new org.junit.runner.JUnitCore().run(MyRetailDTOTest.class);
	}
}