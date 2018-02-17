package com.sudoku.pkg;

import java.util.Random;

public class Core {
	
	private final static int NUMBER_SIZE = 9;
	private final static int PERMUTATION_NUMBER = Factorial(NUMBER_SIZE);
	private static Integer[] Numbers = new Integer[NUMBER_SIZE];
	private static Integer[][] Permutations = new Integer[PERMUTATION_NUMBER][NUMBER_SIZE];
	private static Integer[][] FullTable = new Integer[NUMBER_SIZE][NUMBER_SIZE];
	private static int Counter = 0;
	public  Integer[][] GameTable = new Integer[Core.NUMBER_SIZE][NUMBER_SIZE];
	private final int DELETE_COLUMN = 60;
	
	public Core() {
		
		Table();
		
	}
	
	private void Table() {
		
		setNumbers(Core.Numbers, Core.NUMBER_SIZE);
		doPermutations(Core.Permutations, Core.Numbers, Core.NUMBER_SIZE);
		TableBuilder(Core.Permutations, Core.FullTable, Core.NUMBER_SIZE);
		GameTable = Core.FullTable;
		
		//______DEBUG_______//
		/*for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 9; j++ ) {
				
				System.out.print(Core.FullTable[i][j] + " ");
				
				
			}
			System.out.println();
		}
		
		System.out.println();*/
		GameBuilder(Core.FullTable, DELETE_COLUMN, GameTable);
		
		//______DEBUG_______//
		/*for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 9; j++ ) {
				
				System.out.print(Core.GameTable[i][j] + " ");
				
				
			}
			System.out.println();
		}*/
		
	} // END Table method
	
	//Delete columns in Table
	private void GameBuilder(Integer[][] table, int delete, Integer[][] game) {
		
		Random rnd = new Random();
		
		for(int i = 0; i < DELETE_COLUMN; i++) {
			
			int line = rnd.nextInt(9);
			int row = rnd.nextInt(9);
			
			game[line][row] = 0; // delete
			
		} // END for(i)
		
	} // END GameBuilder method 
	
	//Generate Unique rows and lines
	private void TableBuilderHelper(int LINES, int ROWS, Random rnd, int line, 
			Boolean Unique, Integer[][] matrix, Integer[][] table, int statement) {
		
		Boolean changeLine = true;
		
		do {
			do {

				line = rnd.nextInt(LINES - 1); // gen Random number 1-fact(9) 

				outerloop:
				for (int i = 0; i < 9; i++) {

					for (int j = 0; j < ROWS; j++) {
						
							if (matrix[line][j] == table[i][j]) {
								Unique = false;
								break outerloop;

							} /* END if */ else {
								
								Unique = true;
								
							} // END if 																
					} // END for(i)
				}

			} while (!Unique);
			
			Unique = false; // set default value
			
			if(statement == 8) { // we need only 9 rows
				
				changeLine = false; // set default value
				
			} // END if
			
			//set table columns
			for(int i = 0; i < ROWS; i++) {
				
				table[statement][i] = matrix[line][i];
				
			} // END for(i)
			
			statement++;
			
		} while (changeLine);
		
	} // END TableBuilderHelper method
	
	//First row set and start fill Table + TableBuilderHelper
	private void TableBuilder(Integer[][] matrix, Integer[][] table, int SIZE) {
		
		Random rnd = new Random();
		final int LINES = PERMUTATION_NUMBER; // all lines in matrix
		final int ROWS = matrix[0].length; // all rows in matrix
		int line = rnd.nextInt(LINES - 1);
		Boolean Unique = false;
		
		//First row value get values 
		for(int i = 0; i < ROWS; i++) {
			
			table[0][i] = matrix[line][i];
			
		} // END for(i)
		
		TableBuilderHelper(LINES, ROWS, rnd, line, Unique, matrix, table, 1);						
		
	} // END TableBuilder method
	
	//Factory number to Permutations Integer[][] array size
	private static int Factorial(int number) {
		
		if(number == 0) {
			
			return 1;
			
		} /*END if*/ else {
			
			return number * Factorial(number -1);
			
		} // END else / if		
		
	} // END Factorial function
	
	//Fill Integer[] numbers with value {0 - 9}
	private static void setNumbers(Integer[] integers, int SIZE) {
		
		for(int i = 0; i < SIZE; i++) {
			
			integers[i] = i + 1;
			
		} // END for(i)	
		
	} // END setNumbers method

	//Call PermutationsGenerator method
	private static void doPermutations(Integer[][] arrays, Integer[] array, int SIZE) {
		
		PermutationsGenerator(arrays, array, 0, SIZE);
		
	} // END doPermutations method
	
	//Fastest way to make SUDOKU table, if we found all permutations of array
	
	//Find all permutations for Integer[] array 
	private static void PermutationsGenerator(Integer[][] table, Integer[] array, int index, int SIZE) {
		
		if(index >= SIZE - 1) {
			
			 
			for(int i = 0; i < SIZE; i++) {
				 
				table[Core.Counter][i] = array[i]; 				 
			 
			} // END for(i)	
			
			Core.Counter++;
		         			
			return;
			
		} // END if 
		
		for(int i = index; i < SIZE; i++) {
			
			// swap array elements 
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
			
			PermutationsGenerator(table, array, index + 1, SIZE);
			
			// swap back array elements 
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
			
		} // END for(i)	
		
	} // END PermutationsGenerator method
	
} // END Core class
