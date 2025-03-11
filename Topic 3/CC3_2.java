
public class ArraysCodingChallenge {
public static int indexOf(int[] nums, int numToFind) {
	int index = 0;
	int valid = -1;			//this is what is returned if if statement is false below.
	while (index < nums.length) {
			if (nums[index] == numToFind) {		//if the number at that specific index is equal to number to find, loop ends and that index is returned
				return index;
			}
		index++;
	}
return valid;
}

public static String[] doubleSize (String[] strs) {
	int index = 0;
	while (index < strs.length) {		//this finds the length of strs array
		index++;
	}
	index = (index*2);					//this multiplies that length by two
	String[] moreStrings = new String[index];	//this makes new array twice as big as original
	index = 0;		//resetting counting variable
	while (index < strs.length) {
		moreStrings[index] = strs[index];		//this while loop is transferring all of the values from original array to new array
		index++;
	}
return moreStrings;
}

public static void insert(double[] nums, double numToInsert, int insertAtIndex) {

	int index = insertAtIndex;		//this makes index equal to the index we are going to insert our new number into

if (insertAtIndex < nums.length) {		//if index we want to insert our new number into is not in the array, nothing happens
	while (index < (nums.length - 1)) {		//while index is less then total length of array-1...
		nums[index + 1] = nums[index];		//then the value of every index is turned into what was on the left of it
		index++;
	}
	nums[insertAtIndex] = numToInsert;		//and this inserts our new number into the original index
}
	}

}
