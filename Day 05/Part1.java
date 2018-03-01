import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Part1 {
	
	private static Scanner s;
	private static int counter = 0;
	
	public static void main(String[] args)
	{
		ArrayList<Integer> ar = new ArrayList<Integer>();
		openFile();
		while(s.hasNextInt())
		{
			ar.add(s.nextInt());
		}
		manageJumps(ar);
		
		System.out.println(counter);
	}
	
	public static void openFile()
	{
		try
		{
			s = new Scanner(new File("/Users/ff/Desktop/Advent of Code 2017/Day 05/input.txt"));
		}
		catch(Exception e)
		{
			System.out.println("Could not open file");
		}
	}
	
	public static void manageJumps(ArrayList<Integer> ar)
	{
		int previous = 0;
		int prev_val = 0;
		int i = 0;
		
		
		while(i < ar.size() && i >= 0)
		{ 	
			previous = i;
			i += ar.get(i);
			counter++;
			prev_val = ar.set(previous, ar.get(previous)+1);	
		}
	}
}
