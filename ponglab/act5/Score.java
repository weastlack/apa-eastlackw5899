import java.awt.Color;
import java.awt.Graphics;

public class Score 
{
  private int leftScore;
  private int rightScore;
  private int width;
  private int height;
  private int vertOffset;
  private static final int xOffset = 100;
  
  public Score(int w, int h, int scoreH) {
    leftScore = 0;
    rightScore = 0;
    width = w;
    height = h - scoreH;
    vertOffset = scoreH/2;
  }
  
  public void resetScore() {
    leftScore = 0;
    rightScore = 0;
  }
  
  public void scoreLeft() {
    leftScore++;
  }
  
  public void scoreRight() {
    rightScore++;
  }
  
  public void draw(Graphics window) {
    window.setColor(Color.WHITE);
    window.fillRect(0, height, width, height);
    
    window.setColor(Color.RED);
    window.drawString("Player 1: " + leftScore, xOffset/4, height + vertOffset);
    window.setColor(Color.BLUE);
    window.drawString("Player 2: " + rightScore, width - xOffset, height + vertOffset);
  }
}
