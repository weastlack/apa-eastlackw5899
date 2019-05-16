//A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;

//define Dealer class here

public class Dealer extends AbstractPlayer 
{        
                        
//instance variable - Deck 

  Deck deck = new Deck();


//constructors
 
  public Dealer() 
  {
    super();
  }
    
  public Dealer(ArrayList<Card> h, int w) 
  {      
    super(h, w);
  }


//method to shuffle

  public void shuffle() 
  {
    deck.shuffle();
  }


//method to deal a card

  public Card deal() 
  {
    return deck.nextCard();
  }

//hit method goes here

  public boolean hit() 
  {
    return super.getHandValue() < 15;
  }

}
