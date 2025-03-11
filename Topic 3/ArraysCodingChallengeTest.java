import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysCodingChallengeTest {

	@Test
	public void test_indexOf_AtIndex0() {
		int[] nums = {2,6,4,9,11,2};
		int expectedIndex = 0;
		int actualIndex = ArraysCodingChallenge.indexOf(nums, 2);
		assertEquals("The number 2 is at index 0 in array {2,6,4,9,11,2}", expectedIndex, actualIndex);
	}

	@Test
	public void test_indexOf_AtLastIndex() {
		int[] nums = {6,4,9,11,2};
		int expectedIndex = 4;
		int actualIndex = ArraysCodingChallenge.indexOf(nums, 2);
		assertEquals("The number 2 is at index 4 in array {6,4,9,11,2}", expectedIndex, actualIndex);
	}

	@Test
	public void test_indexOf_InMiddle() {
		int[] nums = {6,4,9,2,6,3,21};
		int expectedIndex = 3;
		int actualIndex = ArraysCodingChallenge.indexOf(nums, 2);
		assertEquals("The number 2 is at index 3 in array {6,4,9,2,6,3,21}", expectedIndex, actualIndex);
	}

	@Test
	public void test_indexOf_NotInList() {
		int[] nums = {6,4,9,6,3,21};
		int expectedIndex = -1;
		int actualIndex = ArraysCodingChallenge.indexOf(nums, 2);
		assertEquals("The number 2 is not in the array {6,4,9,6,3,21}", expectedIndex, actualIndex);
	}

	@Test
	public void test_indexOf_ListIsEmpty() {
		int[] nums = {};
		int expectedIndex = -1;
		int actualIndex = ArraysCodingChallenge.indexOf(nums, 2);
		assertEquals("The list is empty", expectedIndex, actualIndex);
	}

	@Test
	public void test_doubleSize() {
		String[] strs = {"this", "is", "some", "test", "data"};
		int expectedSize = 10;
		
		String[] strsUpdated = ArraysCodingChallenge.doubleSize(strs);
		int actualSize = strsUpdated.length;
		
		assertEquals("Doubled size of array {\"this\", \"is\", \"some\", \"test\", \"data\", expected new array size to be 10", expectedSize, actualSize);
		assertEquals("Doubled size of array {\"this\", \"is\", \"some\", \"test\", \"data\", expected new array to have 'This' as first element", "this", strsUpdated[0]); 		
		assertEquals("Doubled size of array {\"this\", \"is\", \"some\", \"test\", \"data\", expected new array to have 'is' as second element", "is", strsUpdated[1]); 		
		assertEquals("Doubled size of array {\"this\", \"is\", \"some\", \"test\", \"data\", expected new array to have 'some' as third element", "some", strsUpdated[2]); 		
		assertEquals("Doubled size of array {\"this\", \"is\", \"some\", \"test\", \"data\", expected new array to have 'test' as fourth element", "test", strsUpdated[3]); 		
		assertEquals("Doubled size of array {\"this\", \"is\", \"some\", \"test\", \"data\", expected new array to have 'data' as fifth element", "data", strsUpdated[4]); 		
		assertNull("Doubled size of array {\"this\", \"is\", \"some\", \"test\", \"data\", expected no string as sixth element", strsUpdated[5]); 		
	}

	@Test
	public void test_doubleSize_emptyList() {
		String[] strs = {};
		int expectedSize = 0;
		
		String[] strsUpdated = ArraysCodingChallenge.doubleSize(strs);
		int actualSize = strsUpdated.length;
		
		assertEquals("Doubled size of empty array", expectedSize, actualSize);
	}

	@Test
	public void test_doubleSize_originalSize1() {
		String[] strs = {"short"};	int expectedSize = 2;
		
		String[] strsUpdated = ArraysCodingChallenge.doubleSize(strs);
		int actualSize = strsUpdated.length;
		
		assertEquals("Doubled size of array {\"short\"}, expected new array size to be 2", expectedSize, actualSize);
		assertEquals("Doubled size of array {\"short\"}, expected new array to have 'short' as first element", "short", strsUpdated[0]); 		
		assertNull("Doubled size of array {\"short\"}, expected new array to have nothing (null) as second element", strsUpdated[1]); 		
	}

	@Test
	public void test_insert_middleOfFullArray() {
		double[] nums = {1.0,2.2,3.5,7.5,4.3};
		ArraysCodingChallenge.insert(nums, 45.1, 3);
 
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected size to remain unchanged", 5, nums.length);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 1.0 at index 0", 1.0, nums[0], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 2.2 at index 1", 2.2, nums[1], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 3.5 at index 2", 3.5, nums[2], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 45.1 at index 3", 45.1, nums[3], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into {1.0,2.2,3.5,7.5,4.3}, expected 7.5 at index 4", 7.5, nums[4], 0.00001);
	}

	@Test
	public void test_insert_middleOfEmptyArray() {
		double[] nums = new double[5];
		ArraysCodingChallenge.insert(nums, 45.1, 3);
 
		assertEquals("Inserted 45.1 at index 3 into empty array, expected size to remain unchanged", 5, nums.length);
		assertEquals("Inserted 45.1 at index 3 into empty array, expected 0.0 at index 0", 0.0, nums[0], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into empty array, expected 0.0 at index 1", 0.0, nums[1], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into empty array, expected 0.0 at index 2", 0.0, nums[2], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into empty array, expected 45.1 at index 3", 45.1, nums[3], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into empty array, expected 0.0 at index 4", 0.0, nums[4], 0.00001);
	}

	@Test
	public void test_insert_ArraySize0() {
		double[] nums = new double[0];
		ArraysCodingChallenge.insert(nums, 45.1, 3);
 
		assertEquals("Inserted 45.1 at index 3 into size zero array, expected size to remain unchanged", 0, nums.length);
	}

	@Test
	public void test_insert_InvalidIndex() {
		double[] nums = new double[3];
		ArraysCodingChallenge.insert(nums, 45.1, 3);
 
		assertEquals("Inserted 45.1 at index 3 into size three array, expected size to remain unchanged", 3, nums.length);
		assertEquals("Inserted 45.1 at index 3 into empty array of size 3, expected 0.0 at index 0", 0.0, nums[0], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into empty array of size 3, expected 0.0 at index 1", 0.0, nums[1], 0.00001);
		assertEquals("Inserted 45.1 at index 3 into empty array of size 3, expected 0.0 at index 2", 0.0, nums[2], 0.00001);
	}

}
