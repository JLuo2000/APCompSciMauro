//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Name
{
	private String name;

	public Name()
	{
		name = "";

	}

	public Name(String s)
	{
		
		setName(s);
		System.out.println();
		

	}

   public void setName(String s)
   {
	   name = s;

   }

	public String getFirst()
	{
		String fName = "";
		fName = name.substring(0, name.indexOf(' '));
		return fName;
	}

	public String getLast()
	{
		String lName = "";
		lName = name.substring(name.indexOf(' ')+1,name.length());
		return lName;
	}

 	public String toString()
 	{
 		return name + "\n";
	}
}