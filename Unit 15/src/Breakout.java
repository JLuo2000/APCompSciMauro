//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle Paddle;
	private boolean[] keys;
	private BufferedImage back;
	private int Score = 0;
	private ArrayList<Block> blocks;
	public Breakout()
	{
		//TheGame game = new TheGame();
		ball = new Ball(400, 200, 10, 10, Color.BLACK, 2,1);
		Paddle = new Paddle(400,300,40,40,4);
		keys = new boolean[4];
		blocks = new ArrayList<Block>();
		Score = 0;
    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
	/*	Graphics2D twoDGraph = (Graphics2D)window;
		
		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();*/
		
		Graphics graphToBack = window;


		ball.moveAndDraw(graphToBack);
		Paddle.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			ball.setXSpeed(-ball.getXSpeed());
			
		}
		if(!(ball.getY()>=0 && ball.getY()<=550))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			Paddle.moveUpAndDraw(window);
		}
		if(keys[2] == true)
		{
			//move left paddle down and draw it on the window
			Paddle.moveDownAndDraw(window);

		}
		if(keys[1] == true)
		{
			Paddle.moveLeftAndDraw(window);
		}
		if(keys[3] == true)
		{
			Paddle.moveRightAndDraw(window);
		}
		//see if the ball hits the top or bottom wall 
		if (ball.getY() <=50 || ball.getY()>=550) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		


		collisionDetection();
		
		
		


		//see if the paddles need to be moved















		
		//twoDGraph.drawImage(back, null, 0, 0);
	}

   public void collisionDetection() {
	   if(ball.didCollideLeft(Paddle)) {
			ball.didCollideLeft( Paddle);
			ball.setX(ball.getX() + 5);
			ball.setXSpeed(-ball.getXSpeed());
			System.out.println("Hit Left");
		}
		if(ball.didCollideRight(Paddle)) {
			ball.didCollideRight(Paddle);
			ball.setX(ball.getX() - 5);
			ball.setXSpeed(-ball.getXSpeed());
			System.out.println("Hit Right");
		}
   }
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'A' : keys[1]=true; break;
			case 'S' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'A' : keys[1]=false; break;
			case 'S' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}