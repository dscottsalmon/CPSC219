import static org.junit.Assert.*;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class ExceptionExercisesTest {
	
	@Test
	public void test_checkNumber_NegativeNum_PositiveNum(){
		try {
			ExceptionExercises f1 = new ExceptionExercises();
			int num = f1.parseNonNegativeInt("47843");
			assertEquals("Expected string '47843' to be converted to integer 47843", 47843, num);
		} catch (NotAPositiveIntegerException napie) {
			fail("Did not expect exception since 47843 is a positive integer.");
		}
	}

	@Test
	public void test_checkNumber_NegativeNum_Zero(){
		try {
			ExceptionExercises f1 = new ExceptionExercises();
			int num = f1.parseNonNegativeInt("0");
			assertEquals("Expected string '0' to be converted to integer 0", 0, num);
		} catch (NotAPositiveIntegerException napie) {
			fail("Did not expect exception since 47843 is a positive integer.");
		}
	}
	
	@Test
	public void test_checkNumber_NegativeNum_NegativeNum(){
		try {
			ExceptionExercises f1 = new ExceptionExercises();
			int num = f1.parseNonNegativeInt("-47843");
			fail("Expected exception since '-47842' is not non-negative.  Instead got: " + num);
		} catch (NotAPositiveIntegerException napie) {
			String actualMessage = napie.getMessage();
			assertEquals("Error message in exception not as expected", "found negative sign", actualMessage);			
		}
	}

	@Test
	public void test_checkNumber_NegativeNum_LastCharNotADigit(){
		try {
			ExceptionExercises f1 = new ExceptionExercises();
			int num = f1.parseNonNegativeInt("4784a");
			fail("Expected exception since '4784a' is not an integer.  Instead got: " + num);
		} catch (NotAPositiveIntegerException napie) {
			String actualMessage = napie.getMessage();
			assertEquals("Error message in exception not as expected", "found non-digit a", actualMessage);
		}
	}

	@Test
	public void test_checkNumber_NegativeNum_DashInMiddle(){
		try {
			ExceptionExercises f1 = new ExceptionExercises();
			int num = f1.parseNonNegativeInt("47-84");
			fail("Expected exception since '47-84' is not an integer.  Instead got: " + num);
		} catch (NotAPositiveIntegerException napie) {
			String actualMessage = napie.getMessage();
			assertEquals("Error message in exception not as expected", "found non-digit -", actualMessage);
		}
	}
	
	@Test
	public void test_checkNumber_RandomNonNegative(){
		try {
			Random rand = new Random();
			int randNum = rand.nextInt(Integer.MAX_VALUE);
			ExceptionExercises f1 = new ExceptionExercises();
			int num = f1.parseNonNegativeInt(""+randNum);
			assertEquals("Tested with random number", randNum, num);
		} catch (NotAPositiveIntegerException napie) {
			fail("Did not expect exception since randomly selected number was a positive integer.");
		}
	}

	@Test
	public void test_checkNumber_RandomNegative(){
		try {
			ExceptionExercises f1 = new ExceptionExercises();
			Random rand = new Random();
			int randNum = rand.nextInt(Integer.MAX_VALUE);
			int num = f1.parseNonNegativeInt("-" + randNum);
			fail("Expected exception since negative random number is not positive.  Instead got: " + num);
		} catch (NotAPositiveIntegerException napie) {
			String actualMessage = napie.getMessage();
			assertEquals("Error message in exception not as expected", "found negative sign", actualMessage);
		}
	}
	
	@Test
	public void test_checkNumber_RandomCharacterInserted(){
		Random rand = new Random();
		int randNum1 = rand.nextInt(500);
		int randNum2 = rand.nextInt(500);
		char randChar = (char)(rand.nextInt(26) + 'a');
		String randomSequence = "" + randNum1 + randChar + randNum2;
		try {
			ExceptionExercises f1 = new ExceptionExercises();
			int num = f1.parseNonNegativeInt(randomSequence);
			fail("Expected exception since " + randomSequence + " is not a positive integer. But value returned is: " + num);
		} catch (NotAPositiveIntegerException napie) {
			String actualMessage = napie.getMessage();
			assertEquals("Error message for " +  randomSequence + " not as expected", "found non-digit " + randChar, actualMessage);
		}
	}
	


}
