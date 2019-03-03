//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
    int oddIndex = 0; 
    int evenIndex = 0;
    int distance = 0;
		
    for (int i = 0; i < ray.size(); i++){
      if((ray.get(i) % 2) != 0){
        oddIndex = i;
				
        for (int j = ray.size() - 1; j > i; j--) {
 	  if (ray.get(j) % 2 == 0){	
	    evenIndex = j;
	    break;
	  }	
	  else{
	    distance = 0;
	  }
	}
	distance = evenIndex - oddIndex;
	break;
      }
    }
		
    if(distance == 0){
      distance = -1;
    }
    return distance;
  }
}
