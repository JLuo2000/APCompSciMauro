//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LoopStats
{
	private int start, stop;

	public LoopStats()
	{
		start = 0;
		stop = 0;

	}

	public void LoopStats(int beg, int end)
	{
		setNums(beg,end);
		System.out.println(toString());

	}

	public void setNums(int beg, int end)
	{
		start = beg;
		stop = end;

	}

	public int getEvenCount()
	{
		int evenCount=0;
		for (int i = start; i<=stop; i++) {
			if (i % 2 == 0) {
				evenCount = evenCount +1;
			}
		}



		return evenCount;
	}

	public int getOddCount()
	{
		int oddCount=0;
		int range = stop - start;
		
		oddCount = range - getEvenCount();




		return oddCount;
	}

	public int getTotal()
	{
		int total=0;




		return total;
	}
	
	public String toString()
	{
		return start + " to " + stop + "\n" + "Total: " + getTotal() + "\n" + "Even count: " + getEvenCount() + "\n" + "Odd Count: " + getOddCount() + "\n";
		
		
	}
}