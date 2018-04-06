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
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int lScore = 0;
	private int rScore = 0;
	public Pong()
	{
		//TheGame game = new TheGame();
		ball = new Ball(400, 200, 30, 30, Color.BLACK, -3,1);
		leftPaddle = new Paddle(100,100,30,50,8);
		rightPaddle = new Paddle(700,100,30,50,8);
		keys = new boolean[4];
		lScore = 0;
		rScore = 0;
    
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
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			ball.setXSpeed(-ball.getXSpeed());
			if (ball.getX()<10) {
				rScore++;
				
			}
			if (ball.getX()>780) {
				lScore++;
			}
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(500, 370, 100, 50);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Left: " + lScore + " \n" + "Right: " + rScore, 500, 400);
		}
		if(!(ball.getY()>=10 && ball.getY()<=550))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(window);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(window);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(window);
		}
		//see if the ball hits the top or bottom wall 
		if (ball.getY() <=50 || ball.getY()>=550) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		


		//see if the ball hits the left paddle
		if(ball.didCollideLeft(leftPaddle)) {
			ball.didCollideLeft(leftPaddle);
			ball.setX(ball.getX() + 1);
			ball.setXSpeed(-ball.getXSpeed());
			System.out.println("hit left");
		}
		
		
		//see if the ball hits the right paddle
		if(ball.didCollideRight(rightPaddle)) {
			ball.didCollideRight(rightPaddle);
			ball.setX(ball.getX() - 1);
			ball.setXSpeed(-ball.getXSpeed());
			System.out.println("hit right");
		}
		
		


		//see if the paddles need to be moved















		
		//twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'K' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'K' : keys[3]=false; break;
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