import java.util.ArrayList;
import java.util.Collections;

public class ArrayListCodingChallenge {
public static int indexOf(ArrayList<Integer> nums, int numToFind) {
	return nums.indexOf(numToFind);
}

public static void insert(ArrayList<Double> nums, double numToInsert, int insertAtIndex) {
	if (nums.size() > insertAtIndex) {
		nums.add(insertAtIndex, numToInsert);
	}
}
public static String lastInAlphabet(ArrayList<String> strs) {
	
	if (strs.size() != 0) {
		int index = strs.size();
		Collections.sort(strs);
		return strs.get(index - 1);
	} else {
		return "";
		}
	}
}
