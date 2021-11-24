package OperatingSystems;

public class SudokuValidator {

	public static void main(String[] args) {

		int [][] board = { { 6, 2, 4, 5, 3, 9, 1, 8, 7 }, 
			                { 5, 1, 9, 7, 2, 8, 6, 3, 4 }, 
			                { 8, 3, 7, 6, 1, 4, 2, 9, 5 },
			                { 1, 4, 3, 8, 6, 5, 7, 2, 9 }, 
			                { 9, 5, 8, 2, 4, 7, 3, 6, 1 }, 
			                { 7, 6, 2, 3, 9, 1, 4, 5, 8 },
			                { 3, 7, 1, 9, 5, 6, 8, 4, 2 }, 
			                { 4, 9, 6, 1, 8, 2, 5, 7, 3 }, 
			                { 2, 8, 5, 4, 7, 3, 9, 1, 6 } };
		

	                                                           // Thread for checking each row that contains the digits 1-9
			rowsCheck checkingRow = new rowsCheck(board);
			checkingRow.start();

			
			columnsCheck checkingColumn = new columnsCheck(board);        // Thread for checking each column that contains the digits 1-9
			checkingColumn.start();

			
			int[][] subGrid = new int[3][3];                      // 3x3 array to duplicate the values from the first subGrid.
			for (int row = 0; row < 3; row++) {               
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row][column];
				}
			}		

			                                                 
			boxCheck firstSubGrid = new boxCheck(subGrid);           // 1 Thread to check the first 3x3 subGrid.
			firstSubGrid.start();

			
			
			for (int row = 0; row < 3; row++) {            	 // Duplicating the values of second subGrid to the 3x3 array.
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row][column + 3];
				}
			}

			                                                

			                                                 
			boxCheck secondBox = new boxCheck(subGrid);         // 2 Thread to check second 3x3 subGrid.
			secondBox.start();

			
			for (int row = 0; row < 3; row++) {            // Duplicating the values of third subGrid to the 3x3 array.
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row][column + 6];
				}
			}



			boxCheck thirdBox = new boxCheck(subGrid);         // 3 Thread to check third 3x3 subGrid.
			thirdBox.start();

			                                        
			for (int row = 0; row < 3; row++) {             // Duplicating the values of forth subGrid to the 3x3 array.
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row + 3][column];
				}
			}
			                                      
			boxCheck forthBox = new boxCheck(subGrid);         // 4 Thread to check forth 3x3 subGrid.
			forthBox.start();

			
			for (int row = 0; row < 3; row++) {           // Duplicating the values of fifth subGrid to the 3x3 array.
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row + 3][column + 3];
				}
			}
			
			boxCheck fifthBox = new boxCheck(subGrid);        // 5 Thread to check fifth 3x3 subGrid.
			fifthBox.start();

			
			for (int row = 0; row < 3; row++) {           // Duplicating the values of sixth subGrid to the 3x3 array.
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row + 3][column + 6];
				}
			}

			
			
			boxCheck sixthBox = new boxCheck(subGrid);       // 6 Thread to check sixth 3x3 subGrid.
			sixthBox.start();

			
			for (int row = 0; row < 3; row++) {          // Duplicating the values of seventh subGrid to the 3x3 array.
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row + 6][column];
				}
			}

			
			boxCheck seventhBox = new boxCheck(subGrid);   // 7 Thread to check seventh 3x3 subGrid.
			seventhBox.start();

			
			for (int row = 0; row < 3; row++) {       // Duplicating the values of eighth subGrid to the 3x3 array.
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row + 6][column + 3];
				}
			}

			
			boxCheck eighthBox = new boxCheck(subGrid);   // 8 Thread to check eighth 3x3 subGrid.
			eighthBox.start();

			
			for (int row = 0; row < 3; row++) {      // Duplicating the values of ninth subGrid to the 3x3 array.
				for (int column = 0; column < 3; column++) {
					subGrid[row][column] = board[row + 6][column + 6];
				}
			}

			
			boxCheck ninthBox = new boxCheck(subGrid);   // 9 Thread to check ninth 3x3 subGrid.
			ninthBox.start();
			
			
			
			
			if(checkingRow.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(checkingColumn.valid == false) {
					System.out.println("Invalid");
				
				}
			else if(firstSubGrid.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(secondBox.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(thirdBox.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(forthBox.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(fifthBox.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(sixthBox.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(seventhBox.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(eighthBox.valid == false) {
				System.out.println("Invalid");
			
			}
			
			else if(ninthBox.valid == false) {
				System.out.println("Invalid");
			
			}
			else {
				System.out.println("Valid");
			}
			
	}
	

}



	
	class rowsCheck extends Thread {                // Creating the class to check row extends thread class.
		int[][] sudoku;
		boolean valid = true;

		
		public rowsCheck(int[][] arr) {            // The constructor
			this.sudoku = arr;
		}

		
		public void run() {                       // A run method which will execute once the object of this class will be made.
			int[] temp = new int[9];
			for (int row = 0; row < 9; row++) {
				for (int column = 0; column < 9; column++) {
					if (ifExists(temp, sudoku[row][column]) == false) {
						temp[column] = sudoku[row][column];
					} 
					else {
						this.valid = false;
						break;
					}
				}
				temp = new int[9];
			}

		}

		public boolean ifExists(int[] arr, int n) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == n)
					return true;
			}
			return false;
		}

	}

	class columnsCheck extends Thread {          // Creating the class to check column extends thread class.
		int[][] sudoku;
	    boolean valid = true;

		public columnsCheck(int[][] arr) {       // The constructor
			this.sudoku = arr;
		}

		public void run() {                      // Another run method which will execute once the object of this class will be made.
			int[] temp = new int[9];
			for (int row = 0; row < 9; row++) {
				for (int column = 0; column < 9; column++) {
					if (ifExists(temp, sudoku[column][row]) == false) {
						temp[column] = sudoku[column][row];
					} else {
						this.valid = false;
						break;
					}
				}
				temp = new int[9];
			}

		}

		public boolean ifExists(int[] arr, int n) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == n)
					return true;
			}
			return false;
		}

	}

	class boxCheck extends Thread {              //Class to check each 3x3 box extends Thread
		int[][] box;
		int[] temp = new int[9];
		int i = 0;
		boolean valid = true;

		public boxCheck(int[][] arr) {
			this.box = arr;
		}

		public void run() {
			for (int row = 0; row < 3; row++) {
				for (int column = 0; column < 3; column++) {
					if (ifExists(temp, box[row][column]) == false) {
						temp[i] = box[row][column];
						i++;
					} else {
						this.valid = false;
						break;
					}
				}
			}
		}

		public boolean ifExists(int[] arr, int n) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == n)
					return true;
			
			}  return false;
		}
	}
	
