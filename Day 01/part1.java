import java.util.Scanner;
import java.io.*;

// I will solve this problem using a text file, because the input number is huge

public class part1 {
	
	private static Scanner s;
	
	public static void main(String[] args)
	{
		int counter = 0;
		String n;
		int current;
		int previous = 0;
		
		openFile();

		
		n = s.next();
		char a[] = n.toCharArray();
		
		for (int i = 0; i < a.length - 1; i++)
		{
			current = Integer.parseInt(""+a[i]);
			if (current == previous)
				counter += current;
			previous = current;
		}
		
		if (a[0] == a[a.length - 1])
		{
			counter += Integer.parseInt("" + a[0]);
		}
		
		closeFile();
		
		System.out.println("The sum is: " + counter);
			
	}
	
	public static void openFile()
	{	
		try 
		{
			s = new Scanner(new File("/Users/ff/Desktop/Advent of Code 2017/file.txt"));
		}
		catch(Exception e)
		{
			System.out.println("Could not file your file");
		}
	}
	
	public static void closeFile()
	{
		s.close();
	}
	
}
