//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

   //constructors
   public BlinkyBall()
   {
		super();
   }

   public BlinkyBall(int x, int y)
   {
	   super(x, y);


   }

   public BlinkyBall(int x, int y, int wid, int ht)
   {
	   super(x, y, wid, ht);


   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x, y, wid, ht);
	   super.setXSpeed(xSpd);
	   super.setYSpeed(ySpd);

   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x, y, wid, ht, col);
	   super.setXSpeed(xSpd);
	   super.setYSpeed(ySpd);



   }

   public Color randomColor()
   {
   		int r = (int) (Math.random()*255);		//use Math.random()
 		int g = (int) (Math.random()*255);
 		int b = (int) (Math.random()*255);
 		return new Color(r,g,b);
   }

   public void moveAndDraw(Graphics window)
   {
	   window.setColor(Color.WHITE);
	   window.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	   setX(getX()+ getXSpeed());
       setY(getY() + getYSpeed());
       window.setColor(randomColor());
       window.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());



   }
}