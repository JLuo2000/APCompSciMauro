//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{
		number = 0;
	}

	public void Prime(int num)
	{
		setPrime(num);
		System.out.println(toString());
	}

	public void setPrime(int num)
	{
		number = num;
		
	}

	public boolean isPrime()
	{
		if (number != 2 && number%2==0 ) {
			return false;
		}
		for(int i = 3; i<Math.sqrt(number); i++) {
			if (number%i == 0) {
				return false;
			}
		}





		return true;
	}

	public String toString()
	{
		String output="";
		if (isPrime()) {
			output = number + " is prime.";
			return output;
		}
		output = number + " is not prime";
		return output;
	}
}