//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class
{
	private String className;
	private Student[] studentList;
	
	public Class()
	{
		className="";
		studentList=new Student[0];
	}
	
	public Class(String name, int stuCount)
	{
		className = name;
		studentList = new Student[stuCount];
	
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList[stuNum] = s;

	}
	
	public String getClassName()
	{
	   return className;	
	}
	
	public double getClassAverage()
	{
		double classAverage=0.0;
		double sum = 0.0;
		for (Student s : studentList) {
			sum+=s.getAverage();
		}
		classAverage = sum/studentList.length;

		return classAverage;
	}
	
	public double getStudentAverage(int stuNum)
	{
		
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		for (int i = 0; i<studentList.length; i++) {
			if (studentList[i].getName() == stuName) return studentList[i].getAverage();
		}
		return 0.0;
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hName ="";
		for (Student s : studentList) {
			if(s.getAverage() > high) {
				high = s.getAverage(); 
				hName = s.getName();
			}
		}
		




		return hName;
	}

	public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String hName ="";		
		for (Student s : studentList) {
			if(s.getAverage() < low) low = s.getAverage(); hName = s.getName();
		}





		return hName;
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";
		for (Student s : studentList) {
			if(s.getAverage() <70.0) output += s.getName() + " ";
		}




		return output;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";




		return output;
	}  	
}