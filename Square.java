 import java.util.Scanner;

 public class Square
 {
	int[][] square;

	 /**
	  *
	  * @param size New size for creation of a new square
	  */
	 public Square(int size)
	{
		this.square = new int[size][size];
	}

	 /**
	  *
	  * @param row Index for row to take sum of
	  * @return Returns total sum for values in that given row
	  */
	public int sumRow(int row)
	{
		int total = 0;

		for (int colNums = 0; colNums < square.length; colNums++){
			total = total + square[row][colNums];
		}

		return total;

	}

	 /**
	  *
	  * @param col Index for column to take sum of
	  * @return Returns total sum for values in that given column
	  */
	public int sumCol(int col)
	{
		int total = 0;
		for (int rowNums = 0; rowNums < square[col].length; rowNums++){
			total = total + square[rowNums][col];
		}

		return total;
	}

	 /**
	  *
	  * @return Total sum for diagonal aka Top left to bottom right
	  */
	public int sumMainDiag()
	{
		int total = 0;
		for (int row = 0; row < square.length; row++){
			for (int col = 0; col < square[row].length;){
				if (row == col){
					total = total + square[row][col];
				}

			}
		}
		return total;
	}

	 /**
	  *
	  * @return Total sum of the opposite diagonal aka top right to bottom left
	  */
	public int sumOtherDiag()
	{
		int total = 0;
		for (int otherDiag = 0; otherDiag < square.length; otherDiag++){
			total = total + square[otherDiag][square.length - 1 - otherDiag];
		}

		return total;
	}

	 /**
	  * First compares each diagonal sum, the runs for loops comparing values of sumRow and sumCol methods
	  * to verify if equal or not
	  *
	  * @return If the diagonal sums and sumRow and sumCol methods all equal, return true, else return false
	  *
	  */
	public boolean isMagic()
	{
		if (sumMainDiag() == sumOtherDiag()){
			for (int row = 0; row < square.length; row++){
				for (int col = 0; col < square[row].length; col++){
					if (sumRow(row) == sumCol(col)){
						return true;
					}
					else if (sumRow(row) != sumCol(col)){
						return false;
					}
				}
			}
		}
		return false;
	}

	 /**
	  *
	  * @param scan Name of scanner in MagicSquareLab Class that reads in a file and puts it in
	  *             a square
	  */
	public void readSquare(Scanner scan)
	{
	for (int row = 0; row < square.length; row++)
	for (int col = 0; col < square.length; col++)
	square[row][col] = scan.nextInt();
	}

	 /**
	  * Prints out the square to the console using for loops to access each value
	  */
	public void printSquare()
	{
		for (int row = 0; row < square.length; row++){
			for (int col = 0; col < square[row].length; col++){
				System.out.println(square[row][col]);
				System.out.println(" ");
			}
			System.out.println("");
		}
	}
}