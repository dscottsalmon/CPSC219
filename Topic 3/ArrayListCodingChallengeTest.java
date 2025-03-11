import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayListCodingChallengeTest {

	@Test
	public void test_indexOf_AtIndex0() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(6);
		nums.add(4);
		nums.add(11);
		nums.add(2);
		int expectedIndex = 0;
		int actualIndex = ArrayListCodingChallenge.indexOf(nums, 2);
		assertEquals("The number 2 is at index 0 in list {2,6,4,9,11,2}", expectedIndex, actualIndex);
	}

	@Test
	public void test_indexOf_AtLastIndex() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(6);
		nums.add(4);
		nums.add(9);
		nums.add(11);
		nums.add(2);
		int expectedIndex = 4;
		int actualIndex = ArrayListCodingChallenge.indexOf(nums, 2);
		assertEquals("The number 2 is at index 4 in list {6,4,9,11,2}", expectedIndex, actualIndex);
	}

	@Test
	public void test_indexOf_InMiddle() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(6);
		nums.add(4);
		nums.add(9);
		nums.add(2);
		nums.add(6);
		nums.add(3);
		nums.add(21);
		int expectedIndex = 3;
		int actualIndex = ArrayListCodingChallenge.indexOf(nums, 2);
		assertEquals("The number 2 is at index 3 in list {6,4,9,2,6,3,21}", expectedIndex, actualIndex);
	}

	@Test
	public void test_indexOf_NotInList() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(6);
		nums.add(4);
		nums.add(9);
		nums.add(6);
		nums.add(3);
		nums.add(21);
		int expectedIndex = -1;
		int actualIndex = ArrayListCodingChallenge.indexOf(nums, 2);
		assertEquals("The number 2 is not in the array {6,4,9,6,3,21}", expectedIndex, actualIndex);
	}

	@Test
	public void test_indexOf_ListIsEmpty() {
		ArrayList<Integer> nums = new ArrayList<Integer>();

		int expectedIndex = -1;
		int actualIndex = ArrayListCodingChallenge.indexOf(nums, 2);
		assertEquals("The list is empty", expectedIndex, actualIndex);
	}

	@Test
	public void test_insert_middleOfFullArray() {
		ArrayList<Double> nums = new ArrayList<Double>(5);
		nums.add(1.0);
		nums.add(2.2);
		nums.add(3.5);
		nums.add(7.5);
		nums.add(4.3);
		ArrayListCodingChallenge.insert(nums, 45.1, 3);
 
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected size to have grown", 6, nums.size());
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 1.0 at index 0", 1.0, nums.get(0), 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 2.2 at index 1", 2.2, nums.get(1), 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 3.5 at index 2", 3.5, nums.get(2), 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 45.1 at index 3", 45.1, nums.get(3), 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 7.5 at index 4", 7.5, nums.get(4), 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 3.4 at index 5", 4.3, nums.get(5), 0.00001);
	}

	@Test
	public void test_insert_middleOfEmptyArray() {
		ArrayList<Double> nums = new ArrayList<Double>();
		ArrayListCodingChallenge.insert(nums, 45.1, 3);
 
		assertEquals("Inserted 45.1 at index 3 into empty list, expected content to remain unchanged and size to remain unchanged", 0, nums.size());
	}
	
	@Test
	public void test_lastInAlphabet_emptyList() {
		ArrayList<String> strs = new ArrayList<String>();
		
		String expected = "";
		String actual = ArrayListCodingChallenge.lastInAlphabet(strs);
		
		assertEquals("Expected last-in-alphabet string in empty list to be the empty string", expected, actual);
	}

	@Test
	public void test_lastInAlphabet_listLengthOne() {
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("first");
		
		String expected = "first";
		String actual = ArrayListCodingChallenge.lastInAlphabet(strs);
		
		assertEquals("Expected last-in-alphabet string in list with one string, to be that one string", expected, actual);
	}

	@Test
	public void test_lastInAlphabet_lastIsInMiddle() {
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("first");
		strs.add("second");
		strs.add("third");
		strs.add("fourth");
		strs.add("fifth");
		
		String expected = "third";
		String actual = ArrayListCodingChallenge.lastInAlphabet(strs);
		
		assertEquals("Tested with list: ['first','second','third','fourth','fifth']", expected, actual);
	}

	@Test
	public void test_lastInAlphabet_lastAtIndex0() {
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("xyz");
		strs.add("abc");
		strs.add("xxx");
		strs.add("bca");
		strs.add("aabc");
		
		String expected = "xyz";
		String actual = ArrayListCodingChallenge.lastInAlphabet(strs);
		
		assertEquals("Tested with list: ['xyz','abc','xxx','bca','aabc']", expected, actual);
	}

	@Test
	public void test_lastInAlphabet_lastAtEnd() {
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("abc");
		strs.add("def");
		strs.add("fab");
		strs.add("bca");
		strs.add("ffa");
		
		String expected = "ffa";
		String actual = ArrayListCodingChallenge.lastInAlphabet(strs);
		
		assertEquals("Tested with list: ['abc','def','xxx','bca','ffa']", expected, actual);
	}

}
