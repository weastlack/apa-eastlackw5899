import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  /** Method to keep only the blue in a picture */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method to negate all pixels in a picture */
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }
  
  /** Method to change a picture to grayscale */
  
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int average = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
        pixelObj.setRed(average);
        pixelObj.setGreen(average);
        pixelObj.setBlue(average);
      }
    }
  }
    
  /** Method to fix the underwater picture */
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int red = Math.abs(pixelObj.getRed() - 21);
        int green = Math.abs(pixelObj.getGreen() - 163);
        int blue = Math.abs(pixelObj.getBlue() - 173);
        
        // (R, G, B) is (21, 163, 173)
        int difference = red + green + blue;
        if (difference > 21) {
          pixelObj.setRed(0);
          pixelObj.setGreen(0);
          pixelObj.setBlue(0);
        }
      }
    }
  }
  
  /** Method that mirrors the picture around a 
  * vertical mirror in the center of the picture
  * from right to left */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
  * vertical mirror in the center of the picture
  * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
  * horizontal mirror in the center of the picture
  * from top to bottom */
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < (height / 2); row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
  * horizontal mirror in the center of the picture
  * from top to bottom */
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < (height / 2); row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }

  public void mirrorDiagonal() // mirrors from top right to bottom left
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topRightPixel = null;
      Pixel bottomLeftPixel = null;
      int maxLength;
      if (pixels.length < pixels[0].length) 
      { 
        maxLength = pixels.length; 
      }
      else{
        maxLength = pixels[0].length; 
      }
      for (int row = 0; row < maxLength; row++)
      {
          for (int col = row; col < maxLength; col++)
          {
              topRightPixel = pixels[row][col];
              bottomLeftPixel = pixels[col][row];
              bottomLeftPixel.setColor(topRightPixel.getColor());
          }
      }
  }

  public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical)
  {
    int mirrorPoint = x2;
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    if (!vertical)
    {
      // loop through rows
      for (int row = y1; row < y2; row++)
      {
        // loop from x1 to just before the mirror point
        for (int col = x1; col < mirrorPoint; col++)
        {
          
          leftPixel = pixels[row][col];      
          rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
          rightPixel.setColor(leftPixel.getColor());
        }
      }
    }
    else
    {
      for (int row = y1; row < mirrorPoint; row++)
      {
        // loop from x1 to just before the mirror point
        for (int col = x1; col < x2; col++)
        {     
          leftPixel = pixels[row][col];      
          rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
          rightPixel.setColor(leftPixel.getColor());
        }
      }
    }
  }
  
  public void blur(int x, int y, int w, int h)
  {
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel rightPixel = null;
    Pixel topRightPixel = null;
    Pixel botRightPixel = null;
    Pixel leftPixel = null;
    Pixel topLeftPixel = null;
    Pixel botLeftPixel = null;
    
    Pixel centerPixel = null;    

    int a = x + w;
    int b = y + h;

    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = x; row <= a; row++)
    {
      if (row > 0 && row < pixels.length)
      {
        for (int col = y; col <= b; col++)
        {
          if (col > 0 && col < pixels[0].length)
          {
            topPixel = pixels[row-1][col];
            botPixel = pixels[row][col-1];
	    rightPixel = pixels[row][col+1];
	    topRightPixel = pixels[row-1][col+1];
	    botRightPixel = pixels[row+1][col+1];
            leftPixel = pixels[row][col-1];
            topLeftPixel = pixels[row-1][col-1];
            botLeftPixel = pixels[row+1][col-1];
            centerPixel = pixels[row][col]; 
       
            int redAvg = ((topLeftPixel.getRed() + topPixel.getRed() + topRightPixel.getRed() + leftPixel.getRed() + rightPixel.getRed() + botLeftPixel.getRed() + botPixel.getRed() + botRightPixel.getRed())/8);
      
            int greenAvg = ((topLeftPixel.getGreen() + topPixel.getGreen() + topRightPixel.getGreen() + leftPixel.getGreen() + rightPixel.getGreen() + botLeftPixel.getGreen() + botPixel.getGreen() + botRightPixel.getGreen())/8);
        
	    int blueAvg = ((topLeftPixel.getBlue() + topPixel.getBlue() + topRightPixel.getBlue() + leftPixel.getBlue() + rightPixel.getBlue() + botLeftPixel.getBlue() + botPixel.getBlue() + botRightPixel.getBlue())/8);	

            centerPixel.setRed(redAvg);
            centerPixel.setGreen(greenAvg);
            centerPixel.setBlue(blueAvg);
	  }
        }
      }
    }
  }
    

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
  /** Mirrors the arms of the snowman */
  public void mirrorArms()
  {
    int mirrorPoint = 193;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    //left arm
    for (int row = 158; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 103; col < 170; col++)
      {
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
    
    int mirrorPoint2 = 198;
    Pixel topPixel2 = null;
    Pixel bottomPixel2 = null;
    
    //right arm
    for (int row = 171; row < mirrorPoint2; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 239; col < 294; col++)
      {
        topPixel2 = pixels[row][col];      
        bottomPixel2 = pixels[mirrorPoint2 - row + mirrorPoint2][col];
        bottomPixel2.setColor(topPixel2.getColor());
      }
    }
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 345;
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    Pixel[][] pixels = this.getPixels2D();   
    
    //seagull
    for (int row = 235; row < 323; row++)
    {
      for (int col = 238; col < mirrorPoint; col++)
      {
        rightPixel = pixels[row][col];      
        leftPixel = pixels[row][mirrorPoint - col + mirrorPoint/3];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < endRow;
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < endCol;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    } 
  }  

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
      Picture flower1 = new Picture("flower1.jpg");
      this.copy2(flower1,10,20, 0, 100);
      this.write("mycollage.jpg");
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        if (col < pixels[0].length - 1) 
        {
          leftPixel = pixels[row][col];
          rightPixel = pixels[row][col + 1];
          rightColor = rightPixel.getColor();
          if (leftPixel.colorDistance(rightColor) > edgeDist) 
          {
            leftPixel.setColor(Color.BLACK);
            continue;
          }
        }
    
        if (row < pixels.length - 1) 
        {
          rightPixel = pixels[row+1][col];
          rightColor = rightPixel.getColor();
          if (leftPixel.colorDistance(rightColor) > edgeDist) 
          {
            leftPixel.setColor(Color.BLACK);
            continue;
          }
        }

        leftPixel.setColor(Color.WHITE);
      }
    }
  }  


  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
