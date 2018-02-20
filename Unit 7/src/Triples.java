//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		  setNum(num);
		  System.out.println(toString());
		
	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = 0;
		
		for(int i =2; i <= Math.sqrt(110); i++) {
			if(a%i == 0 && b%i == 0 && c%i == 0) {
				return 0;
			}
		}


		return 1;
	}

	public String toString()
	{
		String output="";
		int a, b, c;
		
		for (a = 1; a<=number; a++) {
			for(b = a+1; b<=number; b=b+2) {
				for (c = 1; c<=number; c=c+2) {
					if (greatestCommonFactor(a,b,c) == 1) {
						if (Math.pow(a, 2) + Math.pow(b,  2) == Math.pow(c, 2)) {
							output = output + a + " " + b + " " + c + "\n";
						}
					}
				}
			}
		}




		return output+"\n";
	}
}