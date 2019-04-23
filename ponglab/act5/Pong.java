//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

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
  private SpeedUpBall ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys;
  private BufferedImage back;
  
  private int width;
  private int height;
  private static final int scoreSize = 100;
  private int gameBounds;

  private Score score;
  private Wall top;
  private Wall lt;
  private Wall rt;
  private Wall bot;

  public Pong(int w, int h)
  {
    //set up all variables related to the game
    
    width = w;
    height = h;
    gameBounds = height - scoreSize;    

    top = new Wall(0,0,800,10,Color.BLACK);
    lt = new Wall(0,0,10,590,Color.BLACK);
    rt = new Wall(800,0,10,590,Color.BLACK);
    bot = new Wall(0,590,800,10, Color.BLACK);
    
    ball = new SpeedUpBall(400,300);
        
    leftPaddle = new Paddle(20, 15, 10, 60, Color.RED, 5);	  
    rightPaddle = new Paddle(780, 300, 10, 60, Color.BLUE, 5);
    
    score = new Score(width,height,scoreSize);    
    keys = new boolean[4];
    
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
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    
    if(back == null)
    {
      back = (BufferedImage)(createImage(getWidth(),getHeight()));
    }

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();

    top.draw(graphToBack);
    lt.draw(graphToBack);
    rt.draw(graphToBack);
    bot.draw(graphToBack);
    score.draw(graphToBack);
    
    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);
    
    
    //see if ball hits left wall or right wall

    if(ball.didCollideLeft(lt) && ball.movingLeft())
    {
      score.scoreRight();
      ball.resetDraw(graphToBack,400,300);
    }

    if (ball.didCollideRight(rt) && ball.movingRight())
    {
      score.scoreLeft();
      ball.resetDraw(graphToBack,400,300);
    }
    
		
    //see if the ball hits the top or bottom wall 
    
    if(ball.didCollideTop(top) || ball.didCollideBottom(bot)) 
    {
      ball.setYSpeed(ball.getYSpeed());
      ball.changeDirectionY();
    }


    //see if the ball hits the left paddle
    
    if(ball.didCollideLeft(leftPaddle) && ball.movingLeft())
    {
      ball.setXSpeed(ball.getXSpeed());	
      ball.changeDirectionX();
    }
		
    //see if the ball hits the right paddle
		
    if(ball.didCollideRight(rightPaddle) && ball.movingRight())
    {  
      ball.setXSpeed(ball.getXSpeed());
      ball.changeDirectionX();
    }
		

    //see if the paddles need to be moved

    if (keys[0])
    {
      if(!leftPaddle.didCollideTop(top))
      {
        leftPaddle.moveUpAndDraw(graphToBack);
      }
    }

    if (keys[1])
    {
      if(!leftPaddle.didCollideBottom(bot))
      {  
        leftPaddle.moveDownAndDraw(graphToBack);
      }    
    }

    if (keys[2])
    {
      if(!rightPaddle.didCollideTop(top))
      {
        rightPaddle.moveUpAndDraw(graphToBack);
      }
    }

    if (keys[3])
    {
      if(!rightPaddle.didCollideBottom(bot))
      {
        rightPaddle.moveDownAndDraw(graphToBack);
      }
    }
		
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
      case 'W' : keys[0]=false; break;
      case 'Z' : keys[1]=false; break;
      case 'I' : keys[2]=false; break;
      case 'M' : keys[3]=false; break;
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
