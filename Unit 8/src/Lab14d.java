//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab14d
{
	public static void main( String args[] )
	{
		Grades g = new Grades(new double[] {100, 90, 85, 72.5, 95.6});
		System.out.println(g.toString());
		g.setGrades(new double [] {50.0, 100.0, 80.0});
		System.out.println(g.toString());
		g.setGrades(new double [] {93.4, -90.0, 90.0});
		System.out.println(g.toString());
		g.setGrades(new double [] {1,2,3,4,5,6,7,8,9});
		System.out.println(g.toString());
		
	}
}