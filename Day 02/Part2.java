// Com participacao especial @amadeuppereira

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Part2 {
	
	private static Scanner s;
	private static Scanner line;
	
	public static void main(String[] args) {
		openFile();
		
		int counter = 0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		
		
		while(s.hasNext())
		{
			line = new Scanner(s.nextLine());
			while(line.hasNextInt())
			{
				a.add(line.nextInt());
			}
			counter += arrayValue(a);
			a.clear();
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
	
	public static int arrayValue(ArrayList<Integer> a)
	{
		int n = 0;
		for (int i = 0; i < a.size(); i++)
		{
			for (int j = 0; j < a.size(); j++)
			{
				if ((a.get(i) % a.get(j) == 0) && i != j)
					n = (a.get(i) / a.get(j));	
			}
		}
		return n;
	}

}
