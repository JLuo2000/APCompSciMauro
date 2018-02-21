//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.lang.System;
import java.lang.reflect.Array;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class Grades
{
	//instance variables
	double[] Grades = new double[0];
	

	//constructor
	public Grades() {
		
	}
	
	public Grades(double[] x) {
		setGrades(x);
	}

	//set method
	public void setGrades(double grades[]) {
		Grades = grades;
		Arrays.sort(Grades);
	}


	private double getSum()
	{
		double sum=0.0;
		for (int i = 0; i<Grades.length; i++) {
			sum = sum + Grades[i];
		}


		return sum;
	}

	public double getAverage()
	{
		double average=0.0;
		average = getSum()/Grades.length;


		return average;
	}


	//toString method
	public String toString() {
		String output = "";
		
		for (int i = 0; i<Grades.length; i++) {
			output = output + "Grade " + (i+1) + ": :  " + Grades[i] + "\n";
		}
		
		return output + "\n" + "Average: " + getAverage() + "\n";
	}


}