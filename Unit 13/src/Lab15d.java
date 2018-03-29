//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 13\\src\\lab15d.dat"));
		
		
		for (int i = 0; i < file.nextInt(); i++) {
			FancyWords fancy = new FancyWords(file.nextLine());
			System.out.println(fancy);
		}
		

		file.close();



	}
}