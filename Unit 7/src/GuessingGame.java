//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound;

	public GuessingGame(int stop)
	{
		upperBound = stop;

	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		double answer = Math.random()%(upperBound+1);
		int tries = 1;
		int input = keyboard.nextInt();
		
		while (answer != input) {
			input = keyboard.nextInt();
			
			
		}
		





	}

	public String toString()
	{
		String output="";
		return output;
	}
}