import java.io.File;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Part2 {
	
	private static Scanner s;
	private static Scanner line;
	private static int counter = 0;
	
	public static void main(String[] args)
	{
		
		openFile();
		ArrayList<String> lista = new ArrayList<String>();
		String aux;
		
		while(s.hasNext())
		{
			
			line = new Scanner(s.nextLine());
			while(line.hasNext())
			{
				aux = line.next();
				lista.add(aux);
				
			}
			
			isRep(lista);
			lista.clear();
		}
		
		System.out.println(counter + " \n");
		s.close();
		
	}
	
	public static void openFile()
	{
		try
		{
			s = new Scanner(new File("/Users/ff/Desktop/Advent of Code 2017/Day 04/input.txt"));
		}
		catch(Exception e)
		{
			System.out.println("Could not open file");
		}
	}
	
	public static boolean isRep(ArrayList<String>vector)
	{
		for (int i = 0; i < vector.size(); i++)
		{
			for (int j = 0; j < vector.size(); j++)
			{
				if (sortS(vector.get(i)).equals(sortS(vector.get(j))) && i != j)
					return true;
			}
		}
		counter++;
		return false;
	}
	
	public static String sortS(String s)
	{
		char st[] = s.toCharArray();
		Arrays.sort(st);
		String word = new String(st);
		return word;
	}
}

