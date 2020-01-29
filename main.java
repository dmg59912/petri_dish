package petri_dish;

import java.io.*;
import java.util.Scanner;
public class main {
	
	public static void main( String [] args) throws FileNotFoundException
	{
		int count = 0;
		int row = 0;
		File in = new File("input.txt");
		
		Scanner read = new Scanner(in);
		read.useDelimiter(""); // reads every character one by one 
		System.out.println("Tester");
		
		while(read.hasNextLine() )
		{ 
			char ch = read.next().charAt(0);
			++count;
			if(ch == '\n' )
				++row;
			System.out.print(ch);
		}
		
		int col = count/row;
		System.out.println("\n\nCount is " + count );
		System.out.println("They are " + row + " rows");
		System.out.println("They are  " + col + " colums");
		
		
		read.close();
		
		////////////////////////////////////// create array
		char array[][];   // rows, col
		array = new char[row][col];
		create_array(array );

		printArray(array);
		
		write_to_file(array);	
		
	}
	
	static void write_to_file(char arr[][]) 
	{
		FileWriter write;
		try {
			write = new FileWriter("out.txt");
		for( int row = 0;row < arr.length; ++ row)
		{
			for(int col = 0; col < arr[row].length;++col)
				write.write((arr[row][col]));
			write.write("\n");
		}
		
		write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void create_array( char a[][])
	{
		int count_x = 0;
		int count_y = 0;
		File in = new File("input.txt");
		try {
			Scanner read = new Scanner(in);
			read.useDelimiter("");
			
			while( read.hasNextLine())//count_y != y && count_x != x)
			{ 
				char ch = read.next().charAt(0);
				if(ch == ' ')
				{
					a[count_x][count_y] = ' ';
					//System.out.print(array[count_x][count_y]);
					++count_y;
				}
				else if( ch == '*')
				{
					a[count_x][count_y] = '*';
					//System.out.print(array[count_x][count_y]);
					++count_y;
				}
				else if(ch == '\n' )
				{
					count_y = 0;
					++count_x;
				}
			}
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	static void printArray( char arr[][])
	{
		System.out.println("Now printing the array");
		
		for( int row = 0;row < arr.length; ++ row)
		{
			for(int col = 0; col < arr[row].length;++col)
				System.out.print(arr[row][col]);
		System.out.println();
		}
	}

}

