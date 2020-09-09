
import java.util.*;
import java.io.*;

public class EnCoder
{
	ArrayList < String > dictionary = new ArrayList < String > ();
	
	Scanner keyboard = new Scanner ( System.in );
	
	String previous;
	String current;
	
	String line = null;
	try

		{
			FileReader fr = new FileReader ( "text.txt");
			BufferedReader br = new BufferedReader ( fr );
			
			previous = null;
			current = ( String ) br.read ();
			
			while ( br.ready () )
			{
				if (  )
				{
				}
				else
				{
					
				}

				br.close ();
				fr.close ();
			}
			
			catch ( Exception e )
			{
				System.out.println ( "Error Occured" );
			}
		}
}