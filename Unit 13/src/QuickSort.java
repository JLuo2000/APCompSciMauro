//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount;

	public static void quickSort(Comparable[] list)
	{
		quickSort(list, 0, list.length-1);
		


	}


	private static void quickSort(Comparable[] list, int low, int high)
	{
		if (list == null || list.length == 0) {
			return;
		}
		if(low >= high) return;
		int pivot = partition (list, low, high);
		
		int i = low; int j = high;
		
		while (i <=j) {
			while ((int) list[i] < pivot) {
				i++;
			}
			while ((int) list[j] > pivot) {
				j--;
			}
			if (i<=j) {
				int temp = (int) list[i];
				list[i] = list[j];
				list[j] = temp;
				i++;
				j--;
 			}
		}
		if (low < j)
			quickSort(list, low, j);
 
		if (high > i)
			quickSort(list, i, high);
		for (Comparable e : list) {
			System.out.println(e);
		}




	}


	private static int partition(Comparable[] list, int low, int high)
	{
		if(list.length > 0) {
			return (int) list[low + (high-low)/2];
		}
		return 0;
	}
}