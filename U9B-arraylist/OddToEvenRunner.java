//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.Arrays;
import java.util.ArrayList;

public class OddToEvenRunner
{
  public static void main( String args[] )
  {
    ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(7,1,5,3,11,5,6,7,8,9,10,12345,11));
    System.out.println(ListOddToEven.go(test));

    ArrayList<Integer> test1 = new ArrayList<Integer>(Arrays.asList(11,9,8,7,6,5,4,3,2,1,-99,7));
    System.out.println(ListOddToEven.go(test1));

    ArrayList<Integer> test2 = new ArrayList<Integer>(Arrays.asList(10,20,30,40,5,41,31,20,11,7));
    System.out.println(ListOddToEven.go(test2));

    ArrayList<Integer> test3 = new ArrayList<Integer>(Arrays.asList(32767,70,4,5,6,7));
    System.out.println(ListOddToEven.go(test3));

    ArrayList<Integer> test4 = new ArrayList<Integer>(Arrays.asList(255,255));
    System.out.println(ListOddToEven.go(test4));

    ArrayList<Integer> test5 = new ArrayList<Integer>(Arrays.asList(2,7,11,21,5,7));
    System.out.println(ListOddToEven.go(test5));

    ArrayList<Integer> test6 = new ArrayList<Integer>(Arrays.asList(7,255,11,255,100,3,2));
    System.out.println(ListOddToEven.go(test6));

    ArrayList<Integer> test7 = new ArrayList<Integer>(Arrays.asList(9,11,11,11,7,1000,3));
    System.out.println(ListOddToEven.go(test7));

    ArrayList<Integer> test8 = new ArrayList<Integer>(Arrays.asList(7,7,7,11,2,7,7,11,11,2));
    System.out.println(ListOddToEven.go(test8));

    ArrayList<Integer> test9 = new ArrayList<Integer>(Arrays.asList(2,4,6,8,8));
    System.out.println(ListOddToEven.go(test9));

  }
}
