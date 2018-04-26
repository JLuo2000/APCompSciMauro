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

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	private int shield;
	public Ship()
	{
		this(0,0,0);
	}

	public Ship(int x, int y)
	{
		this(x,y,0);
	}

	public Ship(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17\\src\\ship.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}


	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void setShield(int shi) {
		shield = shi;
	}
	
	public int getShield() {
		return shield;
	}
	
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),40,80,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
