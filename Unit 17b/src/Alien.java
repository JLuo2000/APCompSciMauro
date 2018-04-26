//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Alien extends MovingThing 
{
	private int speed;
	private Image image;
	private int fireIntervalBase;
	private int fireInterval;
	private int health;

	public Alien()
	{
		this(0,0,0);
	}

	public Alien(int x, int y)
	{
		this(x,y,0);
	}

	public Alien(int x, int y, int s)
	{
		super(x, y);
		setSpeed(s);
		setFireInterval(10);
		health = 3;
		try
		{
			image = ImageIO.read(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\alien.JPG"));
		}
		catch(Exception e)
		{
			System.out.println("Enemy Image Not Found");
		}
	}
	public Alien(int x, int y, int s,  int fr, int h)
	{
		super(x, y);
		setSpeed(s);
		setFireInterval(fr);
		health = h;
		try
		{
			image = ImageIO.read(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\alien.JPG"));
		}
		catch(Exception e)
		{
			System.out.println("Enemy Image Not Found");
		}
	}
	
	public boolean fire() {
		boolean fire = false;
		if(fireInterval == 0) {
			setFireInterval(fireIntervalBase);
			return true;	
		}
		fireInterval--;
		return false;
	}
	
	
	public void setFireInterval(int i) {
		fireInterval = i;
		fireIntervalBase = i;
		
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}
	public void hit() {
		health--;
	}
	public int getSpeed()
	{
	   return speed;
	}
	public int getFireInterval() {
		return fireInterval;
	}
	public int gethealth() {
		return health;
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),40,40,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
