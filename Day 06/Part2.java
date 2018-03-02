import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Part2
{
	private static Scanner s;
	private static ArrayList<ArrayList<Integer>> historico = new ArrayList<ArrayList<Integer>>() ;
	private static int counter = 0;
	private static ArrayList<Integer> ar = new ArrayList<Integer>();
	private static int count = 0;
	
	public static void main(String[] args)
	{
		openFile();
		
		while(s.hasNextInt())
		{
			ar.add(s.nextInt());
		}
		
		historico.add(ar);
		distribute();
		System.out.println(counter+1);
	}
	
	public static void openFile()
	{
		try
		{
			s = new Scanner(new File("/Users/ff/Desktop/Advent of Code 2017/Day 06/input.txt"));
		}
		catch(Exception e)
		{
			System.out.println("Could not open file");
		}
	}
	
	public static void distribute()
	{
		ArrayList<Integer> next = new ArrayList<Integer>(ar);
		ArrayList<Integer> next1;
		ArrayList<Integer> first;
		while(true)
		{		
			next = sortA(next);
			
			if (isRep(next))
			{
				first= new ArrayList<Integer>(next);
				counter = 0;
				while(true)
				{
					next = sortA(next);
					if (!isFirst(next, first))
					{
						counter++;
					}
					else
					{
						count = 1;
						break;
					}
				}
				break;
				
			}
			else
			{
				counter++;
				next1 = new ArrayList<Integer>(next);
				historico.add(next1); 
			}
		}
	}
	
	public static boolean isRep(ArrayList<Integer> next)
	{
 
		for (int i = 0; i < historico.size();i++)
		{
			if ((historico.get(i).equals(next)) )
			{
				return true;				
			}
		}
		counter++;
		return false;
	}
	
	public static ArrayList<Integer> sortA(ArrayList<Integer>a)
	{
		int max = 0;
		int index = 0;
		
		for (int i = 0; i < a.size(); i++)
		{
			if (a.get(i) > max)
			{ 
				max = a.get(i);
				index = i;
			}
		}
		int i;
		if (index + 1 == a.size())
		{
			i = 0;
		}
		i = index ;
		a.set(index, 0);
		while(max > 0)
		{
			if( (i) == (a.size() - 1) )
				i = 0;
			else 
				i++;
			a.set(i, a.get(i) + 1);
			max--; 
		}
		return a;
	}
	
	public static boolean isFirst(ArrayList<Integer> next, ArrayList<Integer> first)
	{
		if (next.equals(first))
			return true;
		return false;
	}

}