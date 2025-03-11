
public class CodingChallenge2_2 {
	
	public static boolean isLowercaseChar (char achar) {
		
		boolean valid = true;
		
		if (achar > 0 || achar == 0 || achar < 0) { //this checks if achar is an integer
			valid = false;  	
		}	
		if (achar > '@' && achar < '`') {			//this checks if achar is an uppercase
			valid = false;
	  } else if (achar > '`' && achar < '{') {  	//this makes valid true if its lowercase, i used an ACII table to know the
		  valid = true;  							//character values
	  }
		
	return valid;
}	
	
	public static long ceilingOfMultiplication (int num1, double num2) {
		
		double first = (num1) * (num2);		//this multiplies the numbers
		long number = (int)(first);			//this converts the number into an integer. Decimals round down. i.e. 3.9 becomes 3
		if ( ( (first - number) > 0.5) || ((first - number) == 0.5)) { //this fixes the rounding if the decimal was .5 or higher
			number = number + 1;
		}
		return number;
	}
}
