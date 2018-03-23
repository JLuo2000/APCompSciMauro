//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab21g
{
	public static void main(String args[])
	{
		//instantiate an AtCounter
		AtCounter C = new AtCounter();
		
		//test the code
		C.countAts(0, 0);
		out.println(C);
		C = new AtCounter();
		C.countAts(2, 5);
		out.println(C);
		
		C = new AtCounter();
		C.countAts(5, 0);
		out.println(C);
		
		C = new AtCounter();
		C.countAts(9, 9);
		out.println(C);
		
		C = new AtCounter();
		C.countAts(3, 9);
		out.println(C);
	}
}