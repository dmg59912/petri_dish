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
		int x = row;
		int y = col;
		int count_x = 0, count_y = 0;
		char array[][];   // rows, col
		array = new char[x][y];
		
		read = new Scanner(in);
		read.useDelimiter("");
		while( read.hasNextLine())//count_y != y && count_x != x)
		{ 
			char ch = read.next().charAt(0);
			if(ch == ' ')
			{
				array[count_x][count_y] = ' ';
				//System.out.print(array[count_x][count_y]);
				++count_y;
			}
			else if( ch == '*')
			{
				array[count_x][count_y] = '*';
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
		System.out.println();
	///////////////////////////////////////////// Print array\\\\\\\\\\\\\\\\\\\\\\\
		printArray(array);
		
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
