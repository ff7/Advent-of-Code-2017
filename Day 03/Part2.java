// Com participacao especial @amadeuppereira

import java.util.ArrayList;

public class Part2 {
	
	private static ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(); // {{valor,x,y},{valor,x,y}, ... , {valor,x,y}} 
	private static int input = 368078;
	private static int x = 0;
	private static int y = 0;
	private static int value = 1;
	private static int d = 1;
	
	public static void main(String[] args) 
	{
		
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(value);
		first.add(x);
		first.add(y);
		a.add(first);

		moveSpiral();
		
		System.out.println(value);
	}
	
	public static void right()
	{
		x++;
	}
	
	public static void left()
	{
		x--;
	}
	
	public static void up()
	{
		y++;
	}
	
	public static void down()
	{
		y--;
	}

	public static int sumNeighbours()
	{
		int sum = 0;
		
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).get(1) == (x + 1) && a.get(i).get(2) == y) {
				sum += a.get(i).get(0);
			}
			else if(a.get(i).get(1) == (x + 1) && a.get(i).get(2) == (y + 1)) 
			{
				sum += a.get(i).get(0);			
			}
			else if(a.get(i).get(1) == x && a.get(i).get(2) == (y + 1)) 
			{
				sum += a.get(i).get(0);		
			}
			else if(a.get(i).get(1) == (x - 1) && a.get(i).get(2) == (y + 1)) 
			{
				sum += a.get(i).get(0);			
			}
			else if(a.get(i).get(1) == (x - 1) && a.get(i).get(2) == y) 
			{
				sum += a.get(i).get(0);			
			}
			else if(a.get(i).get(1) == (x - 1) && a.get(i).get(2) == (y - 1)) 
			{
				sum += a.get(i).get(0);			
			}
			else if(a.get(i).get(1) == x && a.get(i).get(2) == (y - 1)) 
			{
				sum += a.get(i).get(0);			
			}
			else if(a.get(i).get(1) == (x + 1) && a.get(i).get(2) == (y - 1)) 
			{
				sum += a.get(i).get(0);			
			}

		}
		return sum;
	}
	
	public static void moveSpiral()
	{
		while (value <= input)
		{
			for(int i = 0; i < d; i++) {
				right();
				update();
			}
			
			if(value > input)
				break;

			for(int i = 0; i < d; i++) {
				up();
				value = sumNeighbours();
				update();
			}
			
			if(value > input)
				break;
			d++;

			for(int i = 0; i < d; i++) {
				left();
				update();
			}
			if(value > input)
				break;

			for(int i = 0; i < d; i++) 
			{
				down();
				update();
			}
			if(value > input)
				break;
			d++;
		}
	}
	
	public static void update()
	{
		value = sumNeighbours();
		ArrayList<Integer> info = new ArrayList<Integer>();
		info.add(value);
		info.add(x);
		info.add(y);
		a.add(info);
	}
}

