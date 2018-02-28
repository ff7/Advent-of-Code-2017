// Com participacao especial @amadeuppereira

public class Part1 {
	
	public static void main(String[] args) {
		
		int input = 368078;
		int i = 1;
		int n = 0; 
		int diff;
		
		while (n*n < input)
		{ 
			n = i*2 + 1;
			i++; 
		}
	
		int c = n /2;
		
		if (n*n - 3*(n-1) > input) //lado direito
		{
			diff = (n*n - 3*(n-1)) - input;
			diff = (n - 1 - diff);
			diff = 2*c - diff;
			
		}
		
		else if (n*n - 2*(n-1) > input) //em cima
		{
			diff = (n*n - 2*(n-1)) - input;
			diff = (n - 1 - diff);
			diff = 2*c - diff;
		}
		else if (n*n - (n-1) > input)//lado esquerdo
		{
			diff = (n*n - 1*(n-1)) - input;
			diff = (n - 1 - diff);
			diff = 2*c - diff;
		}
		else //em baixo
		{
			diff = n*n - input;
			diff = (n - 1 - diff);
			diff = c - diff + c;
		}
		
		System.out.println(diff);
		
	}


}
