// Com participacao especial @amadeuppereira

import java.util.Scanner;
import java.io.*;

public class Part1 {
	
	private static Scanner s;
	private static Scanner line;
	
	public static void main(String[] args) {
		openFile();
		
		int counter = 0;
		int max = 0;
		int min = 99999;
		int n;
		
		
		
		while(s.hasNext())
		{
			line = new Scanner(s.nextLine());
			while(line.hasNextInt())
			{
				n = line.nextInt();
				if (n > max)
					max = n;
				else if (n < min)
					min = n;
			}
			counter += (max - min);
			max = 0;
			min = 99999;
		}
		
		System.out.println(counter);
		
		s.close();
	}
		
	public static void openFile()
	{
		try
		{
			s = new Scanner(new File("/Users/ff/Desktop/Advent of Code 2017/Day 02/input.txt"));
		}
		catch(Exception e)
		{
			System.out.println("Could not find file" );
		}
	}

}
