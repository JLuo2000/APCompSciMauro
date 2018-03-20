//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
	public Monster() {
		setAge(0);
		setHeight(0);
		setWeight(0);
	}


	//write an initialization constructor with an int parameter ht
	public Monster (int ht) {
		setHeight(ht);
	}


	//write an initialization constructor with int parameters ht and wt
	public Monster (int ht, int wt) {
		setHeight(ht);
		setWeight(wt);
	}



	//write an initialization constructor with int parameters ht, wt, and age
	public Monster (int ht, int wt, int age) {
		setHeight(ht);
		setWeight(wt);
		setAge(age);
	}


	//modifiers - write set methods for height, weight, and age
	public void setAge(int age) {
		myAge = age;
	}
	public void setHeight(int height) {
		myHeight = height;
	}
	public void setWeight (int weight) {
		myWeight = weight;
	}
	
	
	//accessors - write get methods for height, weight, and age
	public int getAge() {
		return myAge;
	}
	public int getHeight() {
		return myHeight;
	}
	public int getWeight() {
		return myWeight;
	}
	
	
	//creates a new copy of this Object
	public Object clone()
	{
	   return new Monster(myHeight, myWeight, myAge);
	}

	public boolean equals( Object obj )
	{
		Monster other = (Monster)obj;
		if (other.getAge() == myAge
				&&other.getHeight() == myHeight
				&& other.getWeight() == myWeight) {
			return true;
		}
			

		return false;
	}

	public int compareTo( Object obj )
	{
		
		Monster rhs = (Monster)obj;
		
		if (equals(rhs)) return 0;
		
		if (myHeight > rhs.getHeight()) return 1;
		else if (myWeight > rhs.getWeight()) return 1;
		else if (myAge > rhs.getAge()) return 1;


		return -1;
	}

	//write a toString() method
	public String toString() {
		String output = Integer.toString(myHeight) + " " + myWeight + " "+ myAge;
		return output;
	}
	
}