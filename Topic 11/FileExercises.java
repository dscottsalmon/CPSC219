import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileExercises {
	
	public static int counting(String str) throws FileNotFoundException{
		
		int x = 0;
		Scanner reader = new Scanner(new File("example.txt"));
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			
			if (line.toLowerCase().equals(str.toLowerCase())) { //this is if there are no spaces and only one word
				x = 1;	
			} else if (line.contains(str)) {	//this is if there are multiple words split up by spaces
				String[]t = line.split(" ");
				for(int i = 0; i<t.length; i++) {
					if (t[i].toLowerCase().contains(str.toLowerCase())) {
						x++;
					}
				}
			}
		}
		return x;
	}
	
	public static void toUpper(String str, String ing) throws IOException {
		
		Scanner reader = new Scanner(new File(str));
		BufferedWriter writer = new BufferedWriter(new FileWriter(ing));
		PrintWriter pwriter = new PrintWriter(writer);
		
		while (reader.hasNextLine()) {
			String line = reader.nextLine().toUpperCase();
			pwriter.println(line);
				}
		pwriter.close();
	}
}
