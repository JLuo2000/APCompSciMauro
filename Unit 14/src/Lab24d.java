//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner (new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 14\\src\\lab24d.dat"));
		int games = Integer.parseInt(file.nextLine());
		for (int i = 1; i<=games; i++) {
			TicTacToe x = new TicTacToe(file.nextLine());
			System.out.println(x);
		}







	}
}



