//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public void sort()
	{
		String[] wordRay2 = new String[wordRay.length];
		for (int z = 0; z < wordRay.length; z++) {
			String lowest = "ZZZZZZZ";
			int index = 0;
			for (int i = 0; i < wordRay.length; i++) {
				if (wordRay[i].compareTo(lowest) < 0) {
					lowest = wordRay[i];
					index = i;
				}
			}
			wordRay[index] = "ZZZZZZZZ";
			wordRay2[z] = lowest;
			lowest = "ZZZZZZZ";
			
		}
		wordRay = wordRay2;
	}

	public String toString()
	{
		String output = "";
		for (int i = 0; i < wordRay.length; i++) {
			output += " " + wordRay[i]; 
		}
		return output + "\n\n";
	}
}
