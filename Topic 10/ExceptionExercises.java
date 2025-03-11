
public class ExceptionExercises {
	
	public int parseNonNegativeInt(String str) throws NotAPositiveIntegerException {
		
		if (str.charAt(0) == '-') {
			throw new NotAPositiveIntegerException("found negative sign");
		} 
	
		for (int i = 0; i<str.length(); i++) {
			boolean valid = Character.isDigit(str.charAt(i));
			if (valid == false) {
				throw new NotAPositiveIntegerException("found non-digit " + str.charAt(i));
			}
		}
		
		int x = Integer.parseInt(str);
		return x;
	}
}
