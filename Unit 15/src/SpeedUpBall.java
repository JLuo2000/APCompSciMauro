//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   private int xSpeed;
   private int ySpeed;

   public SpeedUpBall()
   {
	   super(200,200);
		xSpeed = 3;
		ySpeed = 1;

   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);
		xSpeed = 3;
		ySpeed = 1;

   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x,y);
		xSpeed = xSpd;
		ySpeed = ySpd;

   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y, wid, ht);
	   xSpeed = xSpd;
	   ySpeed = ySpd;

   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y, wid, ht, col);
	   xSpeed = xSpd;
	   ySpeed = ySpd;



   }

   public void setXSpeed( int xSpd )
   {
	   xSpeed = xSpd;



   }

   public void setYSpeed( int ySpd )
   {

	   ySpeed = ySpd;


   }
}

