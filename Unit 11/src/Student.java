//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Student
{
	private String myName;
	private Grades myGrades;
	
	public Student()
	{
		setName("");
		setGrades("");
	}
	
	public Student(String name, String gradeList)
	{
		setName(name);
		setGrades(gradeList);
		
	}
	
	public void setName(String name)
	{
		myName = name;

	}	
	
	public void setGrades(String gradeList)
	{
		myGrades = new Grades(gradeList);
	
	}
	
	public void setGrade(int spot, double grade)
	{


	}

	public String getName()
	{
		return "";
	}
	
	public int getNumGrades()
	{
		return 0;
	}

	public double getSum()
	{
		return 0.0;
	}
	
	public double getAverage()
	{
		return 0.0;
	}

	public double getAverageMinusLow()
	{
		return 0.0;
	}
	
	public double getHighGrade()
	{
		return 0.0;		
	}
	
	public double getLowGrade()
	{
		return 0.0;	
	}
	
	public String toString()
	{
		return "";
	}	
}