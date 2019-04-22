//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10,10);
    speed = 5;
  }

  //add the other Paddle constructors

  public Paddle(int x, int y)
  {
    super(x, y);
    speed = 5;
  }

  public Paddle(int x, int y, int s)
  {
    super(x,y);	
    speed = s;
  }

  public Paddle(int x, int y, int width, int height)
  {
    super(x,y,width,height);	  
    speed = 5;
  }

  public Paddle(int x, int y, int width, int height, Color col)
  {
    super(x,y,width,height,col);	  
    speed = 5;
  }

  public Paddle(int x, int y, int width, int height, int s)
  {
    super(x, y, width, height);	  
    speed = s;
  }
  
  public Paddle(int x, int y, int width, int height, Color col, int s)
  {
    super(x, y, width, height, col);	  
    speed = s;
  }

  public void setSpeed(int s) 
  {
    speed = s;
  }

  public void moveUpAndDraw(Graphics window)
  {
    //draw a white box at old paddle location
    draw(window, Color.white);
    setY(getY() - speed);
    draw(window, super.getColor());
  }

  public void moveDownAndDraw(Graphics window)
  {
    draw(window, Color.WHITE);
    setY(getY() + speed);
    draw(window, super.getColor());
  }

  //add get methods
  public int getSpeed()
  {
    return speed;
  } 
  

  public boolean collidedTop(Block s) 
  {
    return getYTop() == s.getYBottom();
  }
  
  public boolean collidedBottom(Block s) 
  {
    return getYBottom() == s.getYTop();
  }
  
  //add a toString() method
  
  public String toString()
  {
    return super.toString() + "\n" + "speed: " + speed;
  }
  
}
