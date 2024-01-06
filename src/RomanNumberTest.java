import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RomanNumberTest {
	
	//RomanNumber(int)
	@Test
	void testRomanNumberInt() {
		String msg = "Value should match expected";
		try { //TWO ASSERTS TO CHECK EACH VALUE OF THE ONE CONSTRUCTOR (One test being done)
			assertEquals(15, (new RomanNumber(15)).getValue(), msg);
			assertEquals("\u2169\u2164", (new RomanNumber(15)).getNumber(), msg);
		}
		catch(Exception e){
			fail("RomanNumber instance was not created");
		}
	}
	
	@Test
	void testRomanNumberIntBounds() {
		String msg = "Exception should be thrown";
		assertThrows(IllegalArgumentException.class, () -> new RomanNumber(300001), msg);
	}
	
	
	//RomanNumber(String)
	@Test
	void testRomanNumberString() {
		String msg = "Value should match expected";
		try {
			assertEquals("\u2169\u2169", (new RomanNumber("\u2169\u2169")).getNumber(), msg);
			assertEquals(20, (new RomanNumber("\u2169\u2169")).getValue(), msg);
		}
		catch(Exception e){
			fail("RomanNumber instance was not created");
		}
	}
	
	@Test
	void testRomanNumberStringBounds() {
		String msg = "Exception should be thrown";
		assertThrows(IllegalArgumentException.class, () -> new RomanNumber("\u2188\u2188\u2188\u2187"), msg);
	}
	
	@Test
	void testRomanNumberStringInvalidInput() {
		String msg = "Exception should be thrown";
		assertThrows(IllegalArgumentException.class, () -> new RomanNumber("A\u2169"), msg);
	}
	
	
	//getValue(int)
	@Test
	void testGetValue() {
		String msg = "Value should match expected";
		RomanNumber test = new RomanNumber(37);
		assertEquals(37, test.getValue(), msg);
	}
	
	@Test
	void testGetValueFromStr() {
		String msg = "Value should match expected";
		RomanNumber test = new RomanNumber("\u2160\u2164");
		assertEquals(4, test.getValue(), msg);
	}
	
	
	//getNumber(String)
	@Test
	void testGetNumber() {
		String msg = "Value should match expected";
		RomanNumber test = new RomanNumber("\u2188\u2187\u216C");
		assertEquals("\u2188\u2187\u216C", test.getNumber(), msg);
	}
	
	@Test
	void testGetNumberFromInt() {
		String msg = "Value should match expected";
		RomanNumber test = new RomanNumber(501);
		assertEquals("\u216E\u2160", test.getNumber(), msg);
	}
	
	
	//parseValue(String)
	@Test
	void parseValue() {
		String msg = "Value should match expected";
		assertEquals(19, RomanNumber.parseValue("\u2169\u2160\u2169"), msg);
	}
	
	@Test
	void parseValueBounds() {
		String msg = "Exception should be thrown";
		assertThrows(IllegalArgumentException.class, () -> RomanNumber.parseValue("\u2188\u2188\u2188\u2188"), msg);
	}
	
	@Test
	void parseValueInvalidInput() {
		String msg = "Exception should be thrown";
		assertThrows(IllegalArgumentException.class, () -> RomanNumber.parseValue("\u2187\u2184\u2169"), msg);
	}
	
	//parseNumber(int)
	@Test
	void parseNumber() {
		String msg = "Value should match expected";
		assertEquals("\u2169\u2169\u2164\u2160\u2160", RomanNumber.parseNumber(27), msg);
	}
	
	@Test
	void parseNumberInvalidInput() {
		String msg = "Exception should be thrown";
		assertThrows(IllegalArgumentException.class, () -> RomanNumber.parseNumber(0), msg);
	}
	
	
	//equals(String)
	@Test
	void equalsStringTrue() {
		String msg = "Values should be equal";
		RomanNumber test = new RomanNumber(18);
		assertTrue(test.equals("\u2169\u2164\u2160\u2160\u2160"), msg);
	}
	
	@Test
	void equalsStringFalse() {
		String msg = "Values should not be equal";
		RomanNumber test = new RomanNumber(11);
		assertFalse(test.equals("\u2169"), msg);
	}
	
	
	//equals(int)
	@Test
	void equalsIntTrue() {
		String msg = "Values should be equal";
		RomanNumber test = new RomanNumber(19);
		assertTrue(test.equals(19), msg);
	}
	
	@Test
	void equalsIntFalse() {
		String msg = "Values should not be equal";
		RomanNumber test = new RomanNumber(59);
		assertFalse(test.equals(26), msg);
	}
	
	
	//add(String)
	@Test
	void testAdd() {
		String msg = "Values should add correctly";
		RomanNumber test = new RomanNumber(100);
		assertEquals("\u216F\u216D", test.add("\u216F"), msg);
	}
	
	@Test
	void testAddBounds() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(299999);
		assertThrows(IllegalArgumentException.class, () -> test.add("\u216C\u2160"), msg);
	}
	
	@Test
	void testAddInvalidInput() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(49);
		assertThrows(IllegalArgumentException.class, () -> test.add("\u2163"), msg);
	}
	
	
	//subtract(String)
	@Test
	void testSubtract() {
		String msg = "Values should subtract correctly";
		RomanNumber test = new RomanNumber(200);
		assertEquals("\u216D", test.subtract("\u216D"), msg);
	}
	
	@Test
	void testSubtractBounds() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(5);
		assertThrows(IllegalArgumentException.class, () -> test.subtract("\u216C"), msg);
	}
	
	@Test
	void testSubtractInvalidInput() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(99);
		assertThrows(IllegalArgumentException.class, () -> test.subtract("\u2164UUU"), msg);
	}
	
	
	//multiply(String)
	@Test
	void testMultiply() {
		String msg = "Values should multiply correctly";
		RomanNumber test = new RomanNumber(15);
		assertEquals("\u216D\u216D\u2169\u2169\u2164", test.multiply("\u2169\u2164"), msg);
	}
	
	@Test
	void testMultiplyBounds() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(10000);
		assertThrows(IllegalArgumentException.class, () -> test.multiply("\u2187"), msg);
	}
	
	@Test
	void testMultiplyInvalidInput() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(500);
		assertThrows(IllegalArgumentException.class, () -> test.multiply("u2187"), msg); //unicode intentionally wrong
	}
	
	
	//divide(String)
	@Test
	void testDivide() {
		String msg = "Values should divide correctly";
		RomanNumber test = new RomanNumber(300000);
		assertEquals("\u2160\u2160", test.divide("\u2188\u2187"), msg);
	}
	
	@Test
	void testDivideBounds() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(35);
		assertThrows(IllegalArgumentException.class, () -> test.divide("\u2187"), msg);
	}
	
	@Test
	void testDivideInvalidInput() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(155);
		assertThrows(IllegalArgumentException.class, () -> test.divide("\u2164\u2162"), msg);
	}
	
	
	//min(String)
	@Test
	void testMin() {
		String msg = "Minimum value should be returned";
		RomanNumber test = new RomanNumber(5000);
		assertEquals("\u2181", test.min("\u2188\u2187"), msg);
	}
	
	@Test
	void testMinIdentical() {
		String msg = "Minimum value should be returned";
		RomanNumber test = new RomanNumber(500);
		assertEquals("\u216E", test.min("\u216E"), msg);
	}
	
	@Test
	void testMinInvalidInput() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(83900);
		assertThrows(IllegalArgumentException.class, () -> test.min("\u2162"), msg);
	}
	
	
	//max(String)
	@Test
	void testMax() {
		String msg = "Minimum value should be returned";
		RomanNumber test = new RomanNumber(5000);
		assertEquals("\u2188\u2187", test.max("\u2188\u2187"), msg);
	}
	
	@Test
	void testMaxIdentical() {
		String msg = "Minimum value should be returned";
		RomanNumber test = new RomanNumber(360);
		assertEquals("\u216D\u216D\u216D\u216C\u2169", test.max("\u216D\u216D\u216D\u216C\u2169"), msg);
	}
	
	@Test
	void testMaxInvalidInput() {
		String msg = "Exception should be thrown";
		RomanNumber test = new RomanNumber(7254);
		assertThrows(IllegalArgumentException.class, () -> test.max("\u2188\u2161"), msg);
	}
	
	
	//calculate(String)
	@Test
	void testCalculate() {
		String msg = "Values should be calculated as desired";
		assertEquals("\u2188", RomanNumber.calculate("\u2187+\u2187"), msg);
	}
	
	@Test
	void testCalculateTwoOperands() {
		String msg = "Exception should be thrown";
		assertThrows(IllegalArgumentException.class, () -> RomanNumber.calculate("\u2187+\u2188*\u2182\u2181\u216E"), msg);
	}
	
	@Test
	void testCalculateInvalidNumbers() {
		String msg = "Exception should be thrown";
		assertThrows(IllegalArgumentException.class, () -> RomanNumber.calculate("\u2188/\u21866"), msg);
	}
	
	@Test
	void testCalculateSpaces() {
		String msg = "Values should be calculated as desired";
		assertEquals("\u216E", RomanNumber.calculate("\u2182\u2181\u216E - \u2182\u2181"), msg);
	}
	
	@Test
	void testCalculateWaysToMultiply() { //method unique to my code, as I made both * and x work for multiplying RomanNumbers in String form
		String msg = "Both calculation methods should be identical";
		assertEquals(RomanNumber.calculate("\u216E*\u216E"), RomanNumber.calculate("\u216Ex\u216E"), msg);
	}
	
	//calculate * and = are same
	
	
}
