//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Wyatt Eastlack
//Date -

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ListSumFirst
{
  public static int go(List<Integer> ray)
  {
    if(ray.size() <= 1){
      return -1;
    }
 
    int sum = 0;
    for(int i = 1; i < ray.size(); i++){
      if(ray.get(i) > ray.get(0)){
        sum += ray.get(i);
      }
    }
    if(sum == 0){
      return -1;
    }  
    return sum;
  }
}
