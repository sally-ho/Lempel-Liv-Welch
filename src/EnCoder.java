
import java.util.*;
import java.io.*;

public class encoder
{
	public static void main(String [] args){
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		String previous;
		String current;
		int counter = 0;
		String line = null;
		String encoded;
		try{
			FileReader fr = new FileReader("text.txt");
			BufferedReader br = new BufferedReader (fr);
				
			previous = null;
				
			int a;
			while ((a = br.read()) != -1)
			{
				if (counter == 0) {
					current = String.valueOf((char)a);
				}
				if ()
				{
				}
				else
				{
					dictionary.put((previous + current), counter);
					counter++;
					encoded += " " + dictionary.get(previous);
					previous = current;
				}

				br.close ();
				fr.close ();
			}
		}
				
		catch ( Exception e ){
			System.out.println ( "Error Occured" );
		}
		try {
			FileWriter fw = new FileWriter(new File("encoded.txt"));
			BufferedWriter buffer = new BufferedWriter(fw);
			buffer.write(encoded);
			buffer.close();
		}
		catch (Exception e) {
			System.out.println("Error Occured in Writing.");
		}
	}
	
		
}