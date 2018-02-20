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
	private int tries = 0;
	private int answer;
	
	public GuessingGame(int stop)
	{
		upperBound = stop;
		playGame();
		//System.out.println(toString());

	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);

		String exit = "y";
		int input= 0;
		
		while (exit != "n") {
			
			answer = (int) ((Math.random()*100000000)%(upperBound) + 1);
			tries = 0;
			
			while (answer != input) {
				
				System.out.println("Enter a number between 1 and " + upperBound);
				input = keyboard.nextInt();
				if (input>=1 && input <= upperBound) {
					tries ++;
				
				
				}
				else {
					System.out.println("Out of range!");
				}
			}
			
			System.out.println(toString());
			System.out.println("Play again? y/n");
			exit = keyboard.next();
		}




	}

	public String toString()
	{
		String output="It took " + tries + " tries to guess " + answer;
		return output;
	}
}