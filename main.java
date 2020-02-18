package petri_dish;

import java.io.*;
import java.util.Scanner;
public class main {
	static char letter = 97;
	static int row;
	static int col;
	public static void main( String [] args) throws FileNotFoundException
	{
		int count = 0;
		col = 0; 
		row = 0;
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
		
		set_letter(array);
		System.out.println();
		printArray(array);
		
		
		write_to_file(array);	
		
	}
	
	static  boolean is_bound(int irow, int icol, char arr[][], boolean seen[][])
	{
	
		  return ((irow >= 0) && (irow < row) && 
		           (icol >= 0) && (icol < col) && arr[irow][icol] == '*' && !seen[irow][icol]); 
	}
	static void copy_array( char arr[][], char b[][])
	{
		for( int row = 0;row < arr.length; ++ row)
		{
			for(int col = 0; col < arr[row].length;++col)
				  b[row][col]= arr[row][col];
		}	
	}
	static void determine_shape(char arr[][], int irow, int icol, boolean seen[][])
	{
		int neighbor_rows [] =  new int [] {-1,-1,-1,0,0,1,1,1};
		int neighbor_cols [] = new int [] {-1,0,1,-1,1,-1,0,1};
		
		seen[irow][icol] = true;
		arr[irow][icol] = letter;
		
		for(int i = 0; i < 8;++i)
			if(is_bound(irow + neighbor_rows[i], icol + neighbor_cols[i],arr,seen))
					determine_shape(arr, irow + neighbor_rows[i], icol + neighbor_cols[i],seen );
		
	}
	
	static void set_letter( char arr[][])
	{
		boolean seen[][] = new boolean[row][col];
		for( int i = 0; i < row; ++i)
			for(int j = 0; j < col; ++j)
			{
				if(arr[i][j] == '*' && !seen[i][j])
				{
					determine_shape(arr,i,j,seen);
					++letter;
				}
			}
	}
	static void rotate_array( char a[][])
	{
		
	}
	
	static void mirror_array(char arr[][], char copy_arr[][],int c )
	{
		int initial_size = c;
		
		for( int row = 0;row < arr.length; ++ row)	
		{
			for(int col = 0; col < arr[row].length;++col)
			{
				copy_arr[row][col] = arr[row][c-1];
				--c;
				if(c == 0)
					c= initial_size;
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
		for( int row = 0;row < arr.length; ++ row)
		{
			for(int col = 0; col < arr[row].length;++col)
				System.out.print(arr[row][col]);
		System.out.println();
		}
	}

}