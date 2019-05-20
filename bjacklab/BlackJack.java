//A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class BlackJack
{
 
  private ArrayList<Playerable> players;
  
  public BlackJack(int numPlayers)
  {
    players = new ArrayList<Playerable>();
    players.add(new Dealer());
    for (int i = 0; i < numPlayers; i++) 
    {
      players.add(new Player());
    }
  }

  public void playGame()
  {
    Scanner keyboard = new Scanner(System.in);

    char hit = 'Y';
    char anotherGame = 'Y';

    Dealer dealer = (Dealer)players.get(0);    
   
    do{

      //shuffle deck
      dealer.shuffle();
      
      //reset hands
      dealer.resetHand();
      
      for ( Playerable player : players)
      {
        player.resetHand();
      }

      
      //deal two cards to player and dealer, one at a time, alternating between player and dealer
      for (int i = 1; i < players.size(); i++) 
      {
        for (int j = 0; j < 2; j++) 
        {      
          players.get(i).addCardToHand(dealer.deal());
        }
      }

      for (int i = 0; i < 2; i++) 
      {
        dealer.addCardToHand(dealer.deal());
      }

      
      //PLAYER LOGIC
      //print current value of hands
      for (int i = 1; i < players.size(); i++)
      {            
        Player player = (Player)(players.get(i));  
        System.out.println("\nPLAYER " + i);
        System.out.println("Cards in Hand :: " + player.toString() );
        System.out.println("Hand Value :: " + player.getHandValue());
        System.out.println("Hand Size :: " + player.getHandSize() + " cards\n");
      
         
        System.out.println("Do you want to hit? (Y/N)\n");
        hit = keyboard.next().charAt(0);

        while(hit == 'y' || hit == 'Y')
        {
          //System.out.println("Do you want to hit? (Y/N)\n");
          //hit = keyboard.next().charAt(0);
          
          //add a card to players hand and display his updated hand
          player.addCardToHand(dealer.deal());
          System.out.println("\nPLAYER " + i);
          System.out.println("Cards in Hand :: " + player.toString() );
          System.out.println("Hand Value :: " + player.getHandValue());
          System.out.println("Hand Size :: " + player.getHandSize() );
        
            
          //end game if player hand total is over 21
          if(player.getHandValue() > 21)
          {
            System.out.println("\nPlayer " + i + " busted.\n");
                       
            /* 
              //add one to dealer wins
              dealer.setWinCount(dealer.getWinCount() + 1);
              //display player loss
              System.out.println("\nDEALER ");
              System.out.println("Cards in Hand :: " + dealer.toString() );
              System.out.println("Hand Value :: " + dealer.getHandValue() );
              System.out.println("Hand Size :: " + dealer.getHandSize() + "\n");
              System.out.println("\nPlayer busted. Dealer wins.\n");
            */
            break;   //break from while loop            
            
          }
        
          if (player.getHandValue() == 21)
	  {
	    System.out.println("Blackjack!");
	    break;
          }
          else{
            //enter code to check if player wants to hit again
            System.out.println("Do you want to hit? (Y/N) ");
            hit = keyboard.next().charAt(0);
          }
        }//ends while loop
      }//ends for loop
    
      //DEALER LOGIC
      //after player decides not to hit anymore and has not busted

      while(dealer.hit() )
      {
        System.out.println("\nDEALER");
        System.out.println("\nCards in Dealer Hand :: " + dealer.toString() );
        System.out.println("Dealer Hand Value :: " + dealer.getHandValue());
        System.out.println("Dealer Hand Size :: " + dealer.getHandSize() + "\n" );
        System.out.println("Dealer hits.");
        dealer.addCardToHand(dealer.deal());
        //System.out.println("Dealer " + dealer);
      }
      
      if (dealer.getHandValue() > 21) 
      {
        System.out.println("Dealer busted!");
      }
  
      System.out.println("Players show their hands./n");

      for (int i = 1; i < players.size(); i++) 
      {
        Player player = (Player)players.get(i);
        System.out.println("\nPLAYER " + i);
        System.out.println("Cards in Hand :: " + player.toString() );
        System.out.println("Hand Value :: " + player.getHandValue());
        System.out.println("Hand Size :: " + player.getHandSize() );
      }
      
      System.out.println("\nDEALER");
      System.out.println("\nCards in Dealer Hand :: " + dealer.toString() );
      System.out.println("Dealer Hand Value :: " + dealer.getHandValue());
      System.out.println("Dealer Hand Size :: " + dealer.getHandSize() + "\n" );
          
         
      int highest = 0;
      for (int i = 0; i < players.size(); i++)
      {
        int handTotal = players.get(i).getHandValue();
        if (handTotal <= 21 && handTotal > highest) 
        { 
          highest = handTotal;      
        }
      }
      if (highest == 0) 
      {
        System.out.println("Dealer wins. Everyone (including Dealer) Busted!");
        dealer.setWinCount(dealer.getWinCount() + 1);     
      }
      else{  
        for (int i = 1; i < players.size(); i++) 
        {
          Player player = (Player)players.get(i);
          if(players.get(i).getHandValue() == highest && dealer.getHandValue() != highest) 
	  {
            System.out.println("\nPlayer " + i + " Wins.\n");
            //add one to player wins
            player.setWinCount(player.getWinCount() + 1);//
          }      
          if(dealer.getHandValue() == highest && player.getHandValue() != highest)
          {
	    //System.out.println("\nCards in Dealer Hand :: " + dealer.toString() );
            //System.out.println("Dealer Hand Value :: " + dealer.getHandValue() );
            //System.out.println("Dealer Hand Size :: " + dealer.getHandSize() + "\n");
            //System.out.println("Dealer wins. Players lose.");
            //add one to dealer wins
            dealer.setWinCount(dealer.getWinCount() + 1); 
            System.out.println("Dealer wins. Players lose.");
            break;
          }
          if (player.getHandValue() == highest && dealer.getHandValue() == highest)
          {
            //System.out.println("\nCards in Dealer Hand :: " + dealer.toString() );
            //System.out.println("Dealer Hand Value :: " + dealer.getHandValue());
            //System.out.println("Dealer Hand Size :: " + dealer.getHandSize() + "\n");
	    dealer.setWinCount(dealer.getWinCount() + 1);
            System.out.println("\nIt's a push. Dealer wins.\n");
            break;
	  }        
        }
      }
      //ask for another game
      System.out.println("\nDo you want to play another round? (Y/N) ");
      anotherGame = keyboard.next().charAt(0);

    }while(anotherGame == 'y' || anotherGame == 'Y');
  }
        
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int numPlayers = 0;
    char play = 'Y';

    System.out.println("\nWELCOME TO BLACKJACK! \n");
    System.out.println("Would you like to play? (Y/N)");
    play = keyboard.next().charAt(0);

    if (play == 'Y' || play == 'y')
    {
      System.out.print("How many players? :: ");
      numPlayers = keyboard.nextInt();
    }
    BlackJack game = new BlackJack(numPlayers);
    game.playGame();
  }
}
