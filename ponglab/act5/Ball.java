//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.System.*;

public class Ball extends Block
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
  
  public Ball(Color col)
  {
    super(200,200,col);
    setXSpeed(3);
    setYSpeed(1);
  }	

  public Ball(int x, int y)
  {
    super(x,y);	  
    xSpeed = 3;
    ySpeed = 1;
  }
  
  public Ball(int x, int y, int w, int h)
  {
    super(x,y,w,h);
    xSpeed = 3;
    ySpeed = 1;
  }
    
  public Ball(int x, int y, int w, int h, Color col)
  {
    super(x,y,w,h,col);  
    setXSpeed(3);
    setYSpeed(1);
  }
  
  public Ball(int x, int y, int w, int h, int xSpd, int ySpd)
  {
    super(x,y,w,h);
    setXSpeed(xSpd);
    setYSpeed(ySpd);
  }
  
  public Ball(int x, int y, int w, int h, Color col, int xSpd, int ySpd)
  {
    super(x,y,w,h,col);	  
    setXSpeed(xSpd);  
    setYSpeed(ySpd);
  }	

	   
  //add the set methods

  public void setXSpeed(int x)
  {
    xSpeed = x;
  }
  
  public void setYSpeed(int y)
  {
    ySpeed = y;
  }  
  

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window, Color.WHITE);
    
    setX(getX() + xSpeed);

    //setY
    setY(getY() + ySpeed);
    
    //draw the ball at its new location
    draw(window);
  }
  
  public void resetDraw(Graphics window, int xPos, int yPos) 
  {
    window.setColor(Color.WHITE);
    window.fillOval(getX(), getY(), getWidth(), getHeight());
    setPos(xPos, yPos);
    window.setColor(getColor());
    window.fillOval(getX(), getY(), getWidth(), getHeight());
  }
   
  public boolean equals(Object obj)
  {
    Ball s = (Ball) obj;

    if( s.getXSpeed() == xSpeed)
    {
      if(s.getYSpeed() == ySpeed)
      {
        if(super.equals(obj))
        {
          return true;
        }
      }
    }
    return false;
  }
  //add the get methods

  public int getXSpeed()
  {
    return xSpeed;
  }
  
  public int getYSpeed()
  {
    return ySpeed;
  }
  
  public boolean movingLeft() 
  {
    return xSpeed < 0;
  }
  
  public boolean movingRight() 
  {
    return xSpeed > 0;
  }
  
  public boolean collidedLeft(Block s) 
  {
    return ((getXLeft() + getXSpeed()) < s.getXRight() && getXLeft() >= s.getXRight()) && (getYTop() <= s.getYBottom()) && (getYBottom() >= s.getYTop());
  }
  
  public boolean collidedRight(Block s) 
  {
    return ((getXRight() - getXSpeed()) > s.getXLeft() && getXRight() <= s.getXRight()) && (getYTop() <= s.getYBottom()) && (getYBottom() >= s.getYTop());
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
    return super.toString() + " " + xSpeed + " " + ySpeed;
  }
}
