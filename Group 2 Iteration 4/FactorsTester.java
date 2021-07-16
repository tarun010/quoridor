import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FactorsTester {

	@Test
	void testPerfect1()
	{	
		// TEST 1: should throw the exception because the parameter value is less than 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.perfect(0));
	}
	
	@Test
	void testPerfect2()
	{	
		// TEST 2: should succeed because 1 is a valid parameter value, but is not a perfect number
		assertFalse(FactorsUtility.perfect(1));
	}
	
	@Test
	void testPerfect3()
	{	
		// TEST 3: should succeed because 6 is a valid parameter value, and is a perfect number
		assertTrue(FactorsUtility.perfect(6));
	}
	
	@Test
	void testPerfect4()
	{	
		// TEST 4: should succeed because 7 is a valid parameter value, but is not a perfect number
		// I've coded this using assertEquals to show that there's often more than one way to write a test 
		boolean expected = false;
		assertEquals(expected, FactorsUtility.perfect(7));
	}
	
	@Test
	void testGetFactors1()
	{
		//Test 1: should throw exception since arg is less than 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.getFactors(-2));
	}
	
	@Test
	void testGetFactors2()
	{
		//Test 2: list should be empty for arg == 0
		assertEquals(new ArrayList<Integer>(), FactorsUtility.getFactors(0));
	}
	
	@Test
	void testGetFactors3()
	{
		//test 3: list should be empty for arg == 1
		assertEquals(new ArrayList<Integer>(), FactorsUtility.getFactors(1));
	}
	
	@Test
	void testGetFactors4()
	{
		//test 4: prime numbers should return list with [1]
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		assertEquals(expected, FactorsUtility.getFactors(13));
	}
	
	@Test
	void testGetFactors5()
	{
		//test 5: should return all factors of arg
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1); expected.add(2); expected.add(3); expected.add(4); expected.add(6);
		assertEquals(expected, FactorsUtility.getFactors(12));
	}
	
	@Test
	void testFactors1()
	{
		//Test 1: should throw exception since both args is less than 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-2, -1));
	}
	
	@Test
	void testFactors2()
	{
		//Test 2: should throw exception since arg1 < 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-1,12));
	}
	
	@Test
	void testFactors3()
	{
		//test 3: should throw exception since arg2 < 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(6,-3));
	}
	
	@Test
	void testFactors4()
	{
		//test 4: should return true since 27 is divisible by 3
		assertTrue(FactorsUtility.factor(27,3));
	}
	
	@Test
	void testFactors5()
	{
		//test 4: should return false since 45 is not divisible by 6
		assertFalse(FactorsUtility.factor(45,6));
	}

}
