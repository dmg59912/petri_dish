package petri_dish;

import java.io.*;
import java.util.Scanner;
public class main {
	
	public static void main( String [] args) throws FileNotFoundException
	{
		int count = 0;
		int col = 0; 
		int row = 0;
		File in = new File("input.txt");
		
		Scanner read = new Scanner(in);
		read.useDelimiter(""); // reads every character one by one 
		System.out.println("Tester");
		
		while(read.hasNextLine() )
		{ 
			char ch = read.next().charAt(0);
			++count;
			if(ch == '\n' && row == 0 )
			{
				++row;
				col = count- 1;
				//--count;
			}
			else if ( ch == '\n')
			{
				//--count;
				++row;
			}
			//System.out.print(ch);
		}
		
		//System.out.println("\n\nCount is " + (count) );
		System.out.println("They are " + (row ) + " rows");
		System.out.println("They are  " + (col) + " colums");
		
		
		read.close();
		
		////////////////////////////////////// create array
		char array[][]; // rows, col
		char copy[][];
		char m_copy[][];
				
		array = new char[row][col];
		copy = new char[row][col];
		m_copy = new char[row][col];
		
		create_array(array );
		copy_array(array,copy);

		System.out.println("Printing original array");
		printArray(array);
		
		System.out.println("\nPrinting copy with mirrow image");
		mirror_array(array, m_copy, col);
		printArray(m_copy);
		
		System.out.println("\nPrinting copy array with values");
		identify_shapes(array,copy);
		printArray(copy);
		
		write_to_file(array);	
		
	}
	static void copy_array( char arr[][], char b[][])
	{
		for( int row = 0;row < arr.length; ++ row)
		{
			for(int col = 0; col < arr[row].length;++col)
				  b[row][col]= arr[row][col];
		}	
	}
	
	static void rotate_array( char a[][])
	{
		
	}
	
	static void mirror_array(char arr[][], char copy_arr[][],int c )
	{
		
		for( int row = 0;row < arr.length; ++ row)	
		{
			for(int col = 0; col < arr[row].length;++col)
			{
				copy_arr[row][col] = arr[row][c-1];
				--c;
				if(c == 0)
					c= 25;
			}
		}
	}
	static void identify_shapes( char arr[][], char copy[][])
	{
		char letter = 97;
		
		for( int row = 0;row < arr.length; ++ row)
		{
			for(int col = 0; col < arr[row].length;++col)
			{
				if(row == 0)//checking our first row
				{
					if(arr[0][0] == '*')
					{
						copy[0][0] = letter;
						++letter;
					}
					else 
					{
						if(arr[0][col] == '*')
						{
							if(arr[0][col - 1] == '*' )
								copy[0][col] = copy[0][col -1];
							else if (arr[row + 1][col -1] == '*')
								copy[0][col] = (char) (letter -1);
							else
							{
								copy[0][col] = letter;
								++letter;
							}
						}
					}
				}
				else // remaining rows
				{
					if((col -1) == -1)
					{
						if(arr[row][col] == '*')
						{
							if(arr[row-1][col] == '*')
								copy[row][col] = copy[row -1][col];
						}
						else if(arr[row-1][col+1] == '*')// check top right row
							copy[row][col] = copy[row-1][col+1];
					}
					else
					{
						if(arr[row][col] == '*')
							if(arr[row][col -1] == '*') // check behind
								copy[row][col] = copy[row][col -1]; 
							else if(arr[row -1][col-1] == '*')
								copy[row][col] = copy[row-1][col-1];
							else if (arr[row-1][col] == '*')
								copy[row][col] = copy[row-1][col];
							else if (arr[row-1][col+1] == '*' && (col +1) <= arr[row].length )
								copy[row][col] = copy[row-1][col+1];
							else if (arr[row][col-1] == '*')
								copy[row][col] = copy[row][col-1];
							else if (arr[row + 1][col -1] == '*' && (row +1 ) <= arr.length) // check bottom  left
								{copy[row][col] = (char) (letter - 1);
									//++letter;
								}
							//else if (arr[row + 1][col] == '*' && (row +1 ) <= arr.length)
								//copy[row][col] = letter;
							else
							{
								copy[row][col] = letter; 
								++letter;
							}
					}
				
				}
			}
		}
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
			
			while( read.hasNextLine() && (count_x <= a.length))//count_y != y && count_x != x)
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
		System.out.println("\nNow printing the array\n");
		
		for( int row = 0;row < arr.length; ++ row)
		{
			for(int col = 0; col < arr[row].length;++col)
				System.out.print(arr[row][col]);
		System.out.println();
		}
	}

}
