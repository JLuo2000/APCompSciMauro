//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	//add the other Ball constructors
	public Ball(int x, int y)
	{
		super(x,y);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int wid, int hei)
	{
		super(x,y, wid, hei);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int wid, int hei, Color col)
	{
		super(x,y, wid, hei, col);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int wid, int hei, Color col, int xS, int yS)
	{
		super(x,y, wid, hei, col);
		xSpeed = xS;
		ySpeed = yS;
	}
	
	public void setXSpeed(int xS) {
		xSpeed = xS;
	}
	public void setYSpeed(int yS) {
		ySpeed = yS;
	}
   

   public void moveAndDraw(Graphics window)
   {
	   window.setColor(Color.WHITE);
	   window.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	   setX(getX()+ xSpeed);
       setY(getY() + ySpeed);
       window.setColor(Color.black);
       window.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Ball other = (Ball) obj;
		if (xSpeed == other.xSpeed
				&& ySpeed == other.ySpeed
				&& super.equals(other)) {
			return true;
		}

		return false;
	}   

   public int getXSpeed() {
	   return xSpeed;
   }
   public int getYSpeed() {
	   return ySpeed;
   }

   public String toString() {
	   return super.toString() + " " + xSpeed + " " + ySpeed;
   }

@Override
public boolean didCollideLeft(Object obj) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean didCollideRight(Object obj) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean didCollideTop(Object obj) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean didCollideBottom(Object obj) {
	// TODO Auto-generated method stub
	return false;
}
}