import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1
{
	public static ArrayList<ArrayList<String>> Data = new ArrayList<ArrayList<String>>();
	private static Scanner s;
	private static Scanner line;
	
	public static void main(String[] args)
	{
		openFile();
		
		saveInfo();
		String answer = checkAbove();
		System.out.println(answer);
		
		for (int i = 0; i < Data.size(); i++)
			System.out.println(Data.get(i));
		
		line.close();
		s.close();
	}
	
	
	public static void openFile()
	{
		try
		{
			s = new Scanner(new File("/Users/ff/Desktop/Advent of Code 2017/Day 07/input.txt"));
		}
		catch(Exception e)
		{
			System.out.println("Could not open file");
		}
	}
	
	public static void saveInfo()
	{
		while(s.hasNext())
		{
			line = new Scanner(s.nextLine());
			ArrayList<String> Info = new ArrayList<String>();
			while(line.hasNext())
			{
				Info.add(line.next());
			}
			Data.add(Info);
		}
	}
	
	public static String checkAbove()
	{
		String answer = " ";
		String suspect = " ";
		for (int i = 0; i < Data.size(); i++)
		{
			if (Data.get(i).size() != 2)
			{
				suspect = Data.get(i).get(0);
			}
			if (isAnswer(suspect))
				answer = suspect;
		}
		return answer;
	}
	
	public static boolean isAnswer (String suspect)
	{
		for (int i = 0; i < Data.size(); i++)
		{
			for (int j = 3; j < Data.get(i).size(); j++)
			{
				if (Data.get(i).get(j).equals(suspect + ",") || Data.get(i).get(j).equals(suspect))
					return false;
			}
		}
		return true;
	}
}
