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
	private int fireInterval;
	private int health;

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
		setFire(2);
		setHealth(5);
		try
		{
			image = ImageIO.read(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\ship.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Ship image not found");
		}
	}

	public boolean fire() {
		boolean fire = false;
		if(fireInterval == 0) {
			setFire(4);
			return true;	
		}
		fireInterval--;
		return false;
	}
	
	public void setSpeed(int s)
	{
	   speed = s;
	}
	
	public void setFire(int f){
		fireInterval = f;
	}
	
	public void setHealth(int h){
		health = h;
	}
	
	public int getSpeed()
	{
	   return speed;
	}

	public int getFire() {
		return fireInterval;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),20,40,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
