//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1);
		}
		return array;
	}
	public static void shiftEm(int[] array)
	{
        	int[] shiftedRay = new int[array.length];
		int index = 0;
		for (int i : array) {
			if (i == 7) {
				shiftedRay[index] = (i);
				index++;
			}
		}
		
		for (int i : array) {
			if (i != 7) {
				shiftedRay[index] = (i);
				index++;
			}
		}
		for (int i = 0; i < shiftedRay.length; i++) {
			System.out.print(shiftedRay[i] + " ");
		}
	}
}
