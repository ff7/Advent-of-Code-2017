import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Part1 {

    private static Scanner s;
    private static Scanner line;
    private static ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    private static HashMap<String, Integer> count = new HashMap<String, Integer>();
    private static ArrayList<Integer> highestValues = new ArrayList<Integer>();
    
    public static void main(String[] args)
    {
        openFile();
        storeData();
        runProgram();  
        //listData();
        //listCount();
        getHighest();
        s.close();
    }


    public static void openFile()
    {
        try
        {
            s = new Scanner(new File("/Users/ff/Desktop/Advent of Code 2017/Advent-of-Code-2017/Day 08/input.txt"));
        }
        catch (Exception e)
        {
            System.out.println("Could not open file");
        }
    }

    public static void storeData()
    {
        while (s.hasNext())
        {
        		ArrayList<String> temp = new ArrayList<String>();
        		line = new Scanner(s.nextLine());
        		while(line.hasNextLine())
        		{
        			temp.add(line.next());
        		}
        		data.add(temp);
        }
        
        //Initialize the Map with 0
        for (int i = 0; i < data.size(); i++)
        {
        		count.put(data.get(i).get(0), 0);
        }

    }
    
    public static void runProgram()
    {
    		for (int i = 0; i < data.size(); i++)
    		{
    			if (getLogic(data.get(i).get(4), data.get(i).get(5), Integer.parseInt(data.get(i).get(6))))
    			{
    				if (data.get(i).get(1).equals("inc"))
    				{
    					int value = 0;
	    	        		for (HashMap.Entry<String, Integer> entry : count.entrySet())
	    	        		{
	    	        			if (entry.getKey().equals(data.get(i).get(0)))
	    	        				value = entry.getValue();
	    	        		}
    					count.put(data.get(i).get(0), value + Integer.parseInt(data.get(i).get(2)));
    					getAnswer();
    				}
    			
    				else if (data.get(i).get(1).equals("dec"))
    				{
    					int value = 0;
	    	        		for (HashMap.Entry<String, Integer> entry : count.entrySet())
	    	        		{
	    	        			if (entry.getKey().equals(data.get(i).get(0)))
	    	        				value = entry.getValue();
	    	        		}
	    	        		
    					count.put(data.get(i).get(0), value - Integer.parseInt(data.get(i).get(2)));
    					getAnswer();
    				}
    			}
    		}
    }
    
    public static boolean getLogic(String key, String operator, Integer value)
    {
    		if (operator.equals("=="))
    		{
    			int val = 0;
        		for (HashMap.Entry<String, Integer> entry : count.entrySet())
        		{
        			if (entry.getKey().equals(key))
        			{
        				val = entry.getValue();
        				if (val == value)
        					return true;
        			}
        		}
    		}
    		
    		else if (operator.equals("!="))
    		{
    			int val = 0;
        		for (HashMap.Entry<String, Integer> entry : count.entrySet())
        		{
        			if (entry.getKey().equals(key))
        			{
        				val = entry.getValue();
        				if (val != value)
        					return true;
        			}
        		}
    		}
    		
    		else if (operator.equals(">"))
    		{
    			int val = 0;
        		for (HashMap.Entry<String, Integer> entry : count.entrySet())
        		{
        			if (entry.getKey().equals(key))
        			{
        				val = entry.getValue();
        				if (val > value)
        					return true;
        			}
        		}
    		}
    		
    		else if (operator.equals(">="))
    		{
    			int val = 0;
        		for (HashMap.Entry<String, Integer> entry : count.entrySet())
        		{
        			if (entry.getKey().equals(key))
        			{
        				val = entry.getValue();
        				if (val >= value)
        					return true;
        			}
        		}
    		}
    		
    		else if (operator.equals("<"))
    		{
    			int val = 0;
        		for (HashMap.Entry<String, Integer> entry : count.entrySet())
        		{
        			if (entry.getKey().equals(key))
        			{
        				val = entry.getValue();
        				if (val < value)
        					return true;
        			}
        		}
    		}
    		
    		else if (operator.equals("<="))
    		{
    			int val = 0;
        		for (HashMap.Entry<String, Integer> entry : count.entrySet())
        		{
        			if (entry.getKey().equals(key))
        			{
        				val = entry.getValue();
        				if (val <= value)
        					return true;
        			}
        		}
    		}
    		
    		return false;
    }
    
    public static void getAnswer()
    {
    		int value = -9999;
    		
    		for (HashMap.Entry<String, Integer> entry : count.entrySet())
    		{
    			if (entry.getValue() > value)
    			{
    				value = entry.getValue();
    			}
    		}
    		highestValues.add(value);
    }
    
    public static void getHighest()
    {
    		int value = -9999;
    		for (int i = 0; i < highestValues.size(); i++)
    		{
    			if (highestValues.get(i) > value)
    				value = highestValues.get(i);
    		}
    		System.out.println(value);
    }
    
    // Test Functions

    public static void listData()
    {
    		for (int i = 0; i < data.size(); i++)
    		{
    			System.out.println(data.get(i));
    		}
    }
    
    public static void listCount()
    {
    		for (HashMap.Entry<String, Integer> entry : count.entrySet())
    		{
    			System.out.println(entry.getKey() + " || " + entry.getValue());
    		}
    }
}


