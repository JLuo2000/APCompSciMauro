//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	   super(10,10);
	   speed =5;
	   setColor(Color.black);
   }


   public Paddle(int x, int y)
   {
	   super(x,y);
	   speed =5;
	   setColor(Color.black);
   }
   
   public Paddle(int x, int y, int sp)
   {
	   super(x,y);
	   speed =sp;
	   setColor(Color.black);
   }
   
   public Paddle(int x, int y, int wid, int hei, int sp)
   {
	   super(x,y, wid, hei);
	   speed =sp;
	   setColor(Color.black);
   }
   
   public Paddle(int x, int y, int wid, int hei, Color col, int sp)
   {
	   super(x,y, wid, hei, col);
	   speed =sp;
   }




   public void moveUpAndDraw(Graphics window)
   {
	   if (getY() >=5) {
		   window.setColor(Color.white);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
		   setY(getY() - getSpeed());
		   window.setColor(Color.BLACK);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   }
	   else {
		   window.setColor(Color.white);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
		   setY(0);
		   window.setColor(Color.BLACK);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   }

   }
   public void moveLeftAndDraw(Graphics window)
   {
	   if (getX() >=5) {
		   window.setColor(Color.white);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
		   setX(getX() - getSpeed());
		   window.setColor(Color.BLACK);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   }
	   else {
		   window.setColor(Color.white);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
		   setX(0);
		   window.setColor(Color.BLACK);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   }

   }

   public void moveDownAndDraw(Graphics window)
   {
		   window.setColor(Color.white);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
		   if (getY()>=500) {
			   setY(500);
		   }
		   else {
			   setY(getY() + getSpeed());
		   }
		   window.setColor(Color.BLACK);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   public void moveRightAndDraw(Graphics window)
   {
		   window.setColor(Color.white);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
		   if (getX()>=750) {
			   setX(750);
		   }
		   else {
			   setX(getX() + getSpeed());
		   }
		   window.setColor(Color.BLACK);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }

   public int getSpeed() {
	   return speed;
   }
   
   
   public String toString() {
	   String output = "";
	   
	   output += getX() + " " + getY() + " " + getHeight() + " " + getWidth() + " " + getColor() + " " + getSpeed();
	   
	   return output;
   }
}