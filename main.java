package petri;
import java.io.*;
import java.util.Scanner;
public class main {
	
	public static void main( String [] args) throws FileNotFoundException
	{
		File in = new File("input.txt");
		
		Scanner read = new Scanner(in);
		System.out.println("Tester");
		
		while(read.hasNext() )
		{
			char ch = read.next().charAt(0);
			System.out.print(ch);
		}
		
		
		
		read.close();
	}

}
