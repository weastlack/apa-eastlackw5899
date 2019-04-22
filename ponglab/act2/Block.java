//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block()
  {
    xPos = 100;
    yPos = 150;
    width = 10;
    height = 10;
    color = Color.BLACK;
  }

  // add other Block constructors - x , y , width, height, color

  public Block(int x, int y) {
    setX(x);
    setY(y);
    setWidth(10);
    setHeight(10);
    setColor(Color.BLACK);
  }
  public Block(int x, int y, Color col) {
    setX(x);
    setY(y);
    setWidth(10);
    setHeight(10);
    setColor(col);
  }


  public Block(int x, int y, int w, int h) {
    setX(x);
    setY(y);
    setWidth(w);
    setHeight(h);
    setColor(Color.BLACK);
  }

  public Block(int x, int y, int w, int h, Color col) {
    setX(x);
    setY(y);
    setWidth(w);
    setHeight(h);
    setColor(col);
  }
  
				
  //add the other set methods

  public void setPos(int x, int y) {
    xPos = x;
    yPos = y;
  }

  public void setX(int x) {
    xPos = x;
  }
  
  public void setY(int y) {
    yPos = y;
  }

  public void setHeight(int h) {
    height = h;
  }

  public void setWidth(int w) {
    width = w;
  } 

  public void setColor(Color col)
  {
    color = col;
  }

  public void draw(Graphics window)
  {
    //uncomment after you write the set and get methods

    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
    window.setColor(col);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
        
  }
   
  public boolean equals(Object obj)
  {
    Block s = (Block) obj; 
    return (xPos == s.getX()) && (yPos == s.getY()) && (width == s.getWidth()) && (height == s.getHeight()) && (color == s.getColor());
  }   

  //add the other get methods

  public int getX()
  {		
    return xPos;
  }
	
  public int getY()
  {
    return yPos;
  }

  public int getWidth()
  {
    return width;
  }
	
  public int getHeight()
  {
    return height;
  }
	
  public Color getColor()
  {
    return color;
  }
  
  public int getXLeft() 
  {
    return xPos;
  }
  
  public int getXRight() 
  {
    return xPos + width;
  }
  
  public int getYTop() 
  {
    return yPos;
  }
  
  public int getYBottom() 
  {
    return yPos + height;
  }    

  //add a toString() method  - x , y , width, height, color
	
  public String toString()
  {
    return xPos + " " + yPos + " " + width + " " + height + " " + color;
  }

}
