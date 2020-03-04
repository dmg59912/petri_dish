import java.util.Arrays;

public class FFT {
	public static  double theta = Math.PI*2;
	 static int []FFT ( int []A, int size, double r)
			{
	    
			
				int even[] = new int[size];
				int odd[] = new int[size];
				
				double w = r;
				
				
				if (size == 1)
					return A;
				else
				{
					
					for( int i = 0; i < size; ++i)
					{
	
						if((i % 2) == 0)
							even[i/2] = A[i];
						else
							odd[(i-1)/2] = A[i];
						
						
					}
					
					  
					  
					int []ff_even = FFT(even,size /2,r*r);
					int [] ff_odd = FFT(odd, size/2, r*r);
					int result[] = new int[size];
					
					double temp = 1;
					
					for( int i = 0; i < size/2; ++i )
					{
						result[i] = (int) (ff_even[i] + temp*ff_odd[i]);
						result[i+size/2] = (int) (ff_even[i]-temp*ff_odd[i]);
						temp = temp* r;
					}
				
					return result;
				}
				
			}
       // out put 25,28,9
    static public void main(String[] args) 
    { 
    	int count = 0;
    	int a[] = new int[] {10,52,5,22};
    	int result[] = new int[a.length];
    	result = FFT(a,a.length,Math.cos(theta/(a.length)));
    	
    	while(count < a.length )
    	{
    		System.out.println(result[count]);
    		++count;
    	}
    	
    	/*int prime,r,n;
    	prime = 18899;
    	r = 30;
    	n = 6;
    	long product = 1;
    	long sum = 0;
    	
    	for(int j  = 0; j < n; ++j)
    	{
    		for(int i = 1; i < n; ++i)
    			product = product * ((r^j) + i);
    	System.out.println(sum);
    	
    	sum = sum + product%prime;
    	}
    	System.out.println(sum);*/
  
    } 
}