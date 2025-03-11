
public class BasicJavaP1 {
	
public static long floor(double num) {
	int conversion = (int)num;
	return conversion;
	}

public static double conversion(double fahr) {
	fahr = (fahr - 32);
	double celsius = (fahr * (5.0/9.0));
	return celsius;
	}

public static boolean willRoundUp(double num) {
	double addition = ((int)num + 1);
	double intermediate = (addition - num);
	
	return (intermediate <= 0.5);
	}

public static int sumRange (int start, int end) {
	int sum = 0;
	
	if (( end - start) > 0) {		//if true then the range is counting upwards, if false then its counting downwards
		while (start != end) {		// if start == end, the loop stops
			sum = sum + start;
			start = start + 1; }
	}
	else {
		while (start != end) {		// if start == end, the loop stops
			sum = sum + start;
			start = start - 1;
		}
	}
	return sum;
}

public static int countChar(String str, char c) {
	int count = 0;				//counting variable for character count
	int x = 0;					//counting variable for loop
	int y = str.length();		//length of string to shutdown loop below
	
	while (x < y) {
		if ((str.charAt(x) == c)) {
			count = (count + 1);
		}
		x = x + 1;	
	} 
	return count;
}

public static int addDigits(int num) {
	
	int addition = 0;
	int sum = 0;
	int counter = 0;
	int multiplier = 1;
	
	while (num != 0) {
		
		addition = (num / multiplier % 10);		//these collect and add up the sum of all the digits
		sum = (sum + addition);
		
		counter = (num % multiplier);			//these break up num and subtract it from itself until num becomes 0, then the loop ends
		num = (num - counter);
		
		multiplier = (multiplier * 10);			// this is the "engine" of the loop that is required for both steps above
	}
	return sum;
	}
}