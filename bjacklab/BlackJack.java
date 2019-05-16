

//A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
  //add in Player instance variable
  private Player player;
  
  //add in Dealer instance variable
  private Dealer dealer;

  
  public BlackJack()
  {
    player = new Player();
    dealer = new Dealer();
  }

  public void playGame()
  {
    Scanner keyboard = new Scanner(System.in);
    char play;
    char hit;
    char anotherGame;
    
    System.out.println("\nWELCOME TO BLACKJACK! \n");
    System.out.println("Would you like to play? (Y/N)");
    play = keyboard.next().charAt(0);
    
    if (play == 'Y' || play == 'y'){
    
    do{
      //reset hands
      dealer.resetHand();
      player.resetHand();
      //shuffle deck
      dealer.shuffle();
      //deal two cards to player and dealer, one at a time, alternating between player and dealer
      player.addCardToHand(dealer.deal());
      dealer.addCardToHand(dealer.deal());
      player.addCardToHand(dealer.deal());
      dealer.addCardToHand(dealer.deal());
      
      //get initial value of hands
      int playerTotal = player.getHandValue();
      int dealerTotal = dealer.getHandValue();
    
      //print current value of hands            
      System.out.println("\nPLAYER ");
      System.out.println("Cards in Hand :: " + player.toString() );
      System.out.println("Hand Value :: " + playerTotal );
      System.out.println("Hand Size :: " + player.getHandSize() + "\n");
      
      /*
      System.out.println("\nDEALER ");
      System.out.println("Cards in Hand :: " + dealer.toString() );
      System.out.println("Hand Value :: " + dealerTotal );
      System.out.println("Hand Size :: " + dealer.getHandSize() + "\n");
      */

      System.out.println("Do you want to hit? (Y/N) ");
      hit = keyboard.next().charAt(0);
      
      if (playerTotal == 21 && dealerTotal != 21)
        {
          System.out.println("Blackjack! Player Wins.\n");
          break;
        }
 
          
      while(hit == 'y' || hit == 'Y'){

        //add a card to players hand and display his updated hand
        player.addCardToHand(dealer.deal());
        playerTotal = player.getHandValue();
        System.out.println("\nPLAYER ");
        System.out.println("Cards in Hand :: " + player.toString() );
        System.out.println("Hand Value :: " + playerTotal );
        System.out.println("Hand Size :: " + player.getHandSize() );

        //end game if player hand total is over 21
        if(playerTotal>21){
          //add one to dealer wins
          dealer.setWinCount(dealer.getWinCount() + 1);
          //display player loss
          System.out.println("\nDEALER ");
          System.out.println("Cards in Hand :: " + dealer.toString() );
          System.out.println("Hand Value :: " + dealerTotal );
          System.out.println("Hand Size :: " + dealer.getHandSize() + "\n");
          System.out.println("\nPlayer busted. Dealer wins.\n");
          break;   //break from while loop
        }
        
        if (playerTotal == 21)
	{
	  System.out.println("Blackjack!");
          break;
	}
        else{
          //enter code to check if player wants to hit again
          System.out.println("Do you want to hit? (Y/N) ");
          hit = keyboard.next().charAt(0);
        }
      }
        
      //if player busts end do/while loop
      if(playerTotal>21){
        //ask for another game
        System.out.println("Do you want to play another round? (Y/N) ");
        anotherGame = keyboard.next().charAt(0);
      } 
      
      else {
        //after player decides not to hit anymore and has not busted
        while(dealerTotal<playerTotal){
          System.out.println("\nDealer hits.");
          dealer.addCardToHand(dealer.deal());
          dealerTotal = dealer.getHandValue();
          //System.out.println("\nCards in Dealer Hand :: " + dealer.toString() );
          //System.out.println("Dealer Hand Value :: " + dealerTotal );
          //System.out.println("Dealer Hand Size :: " + dealer.getHandSize() + "\n" );
          if(dealerTotal>21){
            System.out.println("\nDealer busts. Player Wins.\n");
            //add one to player wins
            player.setWinCount(player.getWinCount() + 1);//
            break;
          }
        }
        if(dealerTotal>playerTotal && dealerTotal <= 21){
	  System.out.println("\nCards in Dealer Hand :: " + dealer.toString() );
          System.out.println("Dealer Hand Value :: " + dealerTotal );
          System.out.println("Dealer Hand Size :: " + dealer.getHandSize() + "\n");
          System.out.println("Dealer wins. Player loses.");
          //add one to dealer wins
          dealer.setWinCount(dealer.getWinCount() + 1); //new
        }

        /*
	if(playerTotal < 21 && dealerTotal < 21 && playerTotal == dealerTotal)
        {
          System.out.println("\nIt's a push. Dealer wins.\n");
	  dealer.setWinCount(dealer.getWinCount() + 1);
          //break;
        }
        */

        /*        
        if (playerTotal == 21 && dealerTotal != 21)
        {
          System.out.println("Blackjack!\n");
          //break;
	}
        */

        if (playerTotal == dealerTotal)
        {
	  /*
	  dealer.setWinCount(dealer.getWinCount() + 1);
          System.out.println("\nCards in Dealer Hand :: " + dealer.toString() );
          System.out.println("Dealer Hand Value :: " + dealerTotal );
          System.out.println("Dealer Hand Size :: " + dealer.getHandSize() + "\n");
          */
	  System.out.println("\nIt's a push. Dealer wins.\n");
          dealer.setWinCount(dealer.getWinCount() + 1);
	  //break;
	}        

        if(dealerTotal == 21 && playerTotal != 21)
        {
          System.out.println("Blackjack!\n");
        }

        //ask for another game
        System.out.println("Do you want to play another round? (Y/N) ");
        anotherGame = keyboard.next().charAt(0);
      }  

    }while(anotherGame == 'y' || anotherGame == 'Y');
   }
  }
        
  public static void main(String[] args)
  {
    BlackJack game = new BlackJack();
    game.playGame();
  }
}
