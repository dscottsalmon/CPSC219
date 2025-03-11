import static org.junit.Assert.*;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

import org.junit.Test;

public class ReaderExerciseTest {
	
	private String createFile(String text, String filename){
		try {
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			output.print(text);
			output.close();
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to (re)create file " + filename);
		}
		return filename;
	}
	@Test
	public void test_counting_zero() {
		String content = "Hello\nand\nwelcome\nTo an\nExercise";
		createFile(content, "example.txt");
		int actual = 10;
		try {
			actual = FileExercises.counting("the");
		} catch (FileNotFoundException fnfe) {
			fail("unexpected FileNotFoundException: " + fnfe.getMessage());
		} catch (IOException ioe) {
			fail("unexpected IOException: " + ioe.getMessage());
		}
		
		//Expected output
		int expected = 0;
		
		assertEquals("Test with 'example.txt' file that has no 'the' in it", expected, actual);
	}

	@Test
	public void test_counting_onlyWordIsThe() {
		String content = "the";
		createFile(content, "example.txt");
		int actual = 0;
		try {
			actual = FileExercises.counting("THE");
		} catch (FileNotFoundException fnfe) {
			fail("unexpected FileNotFoundException: " + fnfe.getMessage());
		} catch (IOException ioe) {
			fail("unexpected IOException: " + ioe.getMessage());
		}
		
		//Expected output
		int expected = 1;
		
		assertEquals("Test with 'example.txt' file that has only 'THE' in it", expected, actual);
	}

	@Test
	public void test_counting_upperAndLowerCaseThe() {
		String content = "The quick brown fox jumped over the jumped over the lazy dog";
		createFile(content, "example.txt");
		int actual = 0;
		try {
			actual = FileExercises.counting("The");
		} catch (FileNotFoundException fnfe) {
			fail("unexpected FileNotFoundException: " + fnfe.getMessage());
		} catch (IOException ioe) {
			fail("unexpected IOException: " + ioe.getMessage());
		}
		
		//Expected output
		int expected = 3;
		
		assertEquals("Test with 'example.txt' file that has mixed case 'the' in it", expected, actual);
	}

	@Test
	public void test_counting_sameWordRepeated() {
		String content = "one one one one one ONE ONE ONE One One One";
		createFile(content, "example.txt");
		int actual = 0;
		try {
			actual = FileExercises.counting("one");
		} catch (FileNotFoundException fnfe) {
			fail("unexpected FileNotFoundException: " + fnfe.getMessage());
		} catch (IOException ioe) {
			fail("unexpected IOException: " + ioe.getMessage());
		}
		
		//Expected output
		int expected = 11;
		
		assertEquals("Test with 'one' as word to count", expected, actual);
	}
}
