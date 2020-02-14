package petri_dish;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
public class main {
	
	public static void main( String [] args) throws FileNotFoundException
	{
		ArrayList<Point>  p =  new ArrayList<Point>();
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
		char letter = 97;
				
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
		identify_shapes(copy,p);
		System.out.println(p);
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
<<<<<<< HEAD
	
	static void next_shape( char arr[][], int irow, int icol, char iletter)
=======
	static void previous_row_col(char arr[][], int row, int col, char let)
	{
		if(row == 0 && col == 0)
		{
			if(arr[row + 1][col] == '*')
			{
				arr[row +1][col] = let;
				previous_row_col(arr, row + 1, col, let );
			}
			if(arr[row +1][col +1] == '*')
			{
				arr[row +1][col + 1] = let;
				previous_row_col(arr, row + 1, col, let );
			}
			if(arr[row][col +1] == '*')
			{
				arr[row +1][col] = let;
				previous_row_col(arr, row + 1, col, let );
			}
			else
				++let;
		}
	}
	
	static void identify_shape(char arr[][], char copy[][])
	{
		char letter = 97;
		for( int row = 0;row < arr.length; ++ row)
		{
			for(int col = 0; col < arr[row].length;++col)
			{
				if(arr[0][0] == '*' )
				{
					copy[0][0] = letter;
					previous_row_col(arr, row, col, letter );
				}
				else
				{
					if( arr[row][col] == '*' )
						previous_row_col(arr, row, col, letter );
				}
			}
		}
		
	}
	/*static void identify_shapes( char arr[][], char copy[][])
>>>>>>> 1617011c7c17ef179f5846f757e3d14580aeb6b8
	{
		if( (irow -1) == -1 && ( icol + 1) <= arr[irow].length )
		{
			
		}
		//else if( (icol -1) == -1)
	//	else if((icol + 1) > arr.length ) 
		//else if((icol + 1) > arr[irow].length)
		//else if(icol 

	}
	static void identify_shapes( char arr[][], ArrayList<Point> point)
	{
			char letter = 97;
			//System.out.println("\nNow printing the array starting with letter " + letter + "\n");
			
			for( int row = 0;row < arr.length; ++ row)
			{
				for(int col = 0; col < arr[row].length;++col)
				{
					if(arr[row][col] == '*')
						point.add( new Point(row,col));
				}
			}
<<<<<<< HEAD
	}
=======
		}
	}*/
>>>>>>> 1617011c7c17ef179f5846f757e3d14580aeb6b8
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
	
	static void check_array(int a,int b)
	{
		
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