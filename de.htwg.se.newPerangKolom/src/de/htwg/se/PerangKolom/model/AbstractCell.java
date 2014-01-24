package de.htwg.se.PerangKolom.model;

import java.lang.Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.CellArray;
import de.htwg.se.PerangKolom.model.impl.Player;

public abstract class AbstractCell implements ICell{

	public static final int BORDER_TOP 	= 1;
	public static final int BORDER_RIGHT 	= 2;
	public static final int BORDER_BOTTOM 	= 3;
	public static final int BORDER_LEFT 	= 4;
	
	//these values multiplied with 25 determine the maximum/minimum value for a cell
	public static final int RANDOM_MIN 	= 1;
	public static final int RANDOM_MAX	= 4;
	
	protected boolean topBorder = false;
	protected boolean bottomBorder = false;
	protected boolean leftBorder = false;
	protected boolean rightBorder = false;
	protected int liesInRow; 
	protected int liesInCol;
	protected int cellValue;
	protected int numberOfFilledBorders;
	protected boolean cellFilled;
	protected String cellOwner; //CellColor
	protected CellArray cellArray;
	//char-Matrix with the "graphical information" for one cell for the TUI
	public char[][] cellOutputStringArray;
	//size (=width =height) of one cell
	public static int CELL_SIZE = 10;
	private static char innerBorderChar = '+';
	private static char outerBorderChar = '#';
	
	public int getPositionX() {
		return liesInCol;
	}

	public int getPositionY() {
		return liesInRow;
	}

	public boolean isCellFilled() {
		return cellFilled;
	}

	public void setCellFilled(boolean cellFilled) {
		this.cellFilled = cellFilled;

	}

	public int getCellValue() {
		return cellValue;
	}
	
	@Override
	public void setCellValue(int value) {
		this.cellValue = value;
		
	}
	
	public String getCellOwner() {
		return cellOwner;
	}

	public void setCellOwner(String cellOwner) {
		this.cellOwner = cellOwner;
	}
	
	@Override
	public int getNumberOfFilledBorders() {
		
		int sum = 0;
		
		if (bottomBorder) {
			sum++;
		}
		
		if (leftBorder) {
			sum++;
		}
		
		if (rightBorder) {
			sum++;
		}
		
		if (topBorder) {
			sum++;
		}
		
		return sum;
		
	}
	
	public void setBorder(int borderNr, boolean fillBorder) {
		
		if (borderNr == BORDER_TOP) {
			topBorder = fillBorder;
			setNeighbourBorder(BORDER_BOTTOM, fillBorder);
			return;
		}
		
		if (borderNr == BORDER_BOTTOM) {
			bottomBorder = fillBorder;
			setNeighbourBorder(BORDER_TOP, fillBorder);
			return;
		}
		
		if (borderNr == BORDER_LEFT) {
			leftBorder = fillBorder;
			setNeighbourBorder(BORDER_RIGHT, fillBorder);
			return;
		}
	
		if (borderNr == BORDER_RIGHT) {
			rightBorder = fillBorder;
			setNeighbourBorder(BORDER_LEFT, fillBorder);
			return;
		}
	}
	
	
	private void setNeighbourBorder(int borderNr, boolean fillBorder) {

		if (borderNr == BORDER_TOP) {
			int neighbour_row = liesInRow - 1;
			//if it's not indexOutOfBounds
			if ( neighbour_row >= 0) {
				CellArray.getSpecificCell(neighbour_row, liesInCol).bottomBorder = fillBorder;
			} else 
				return;
		}
		
		if (borderNr == BORDER_BOTTOM) {
			int neighbour_row = liesInRow + 1;
			//if it's not indexOutOfBounds
			if ( neighbour_row < (CellArray.getNumberOfRows()) ) {
				CellArray.getSpecificCell(neighbour_row, liesInCol).topBorder = fillBorder;
			} else 
				return;
		}
		
		if (borderNr == BORDER_LEFT) {
			int neighbour_col = liesInCol - 1 ;
			//if it's not indexOutOfBounds
			if (neighbour_col >= 0) {
				CellArray.getSpecificCell(liesInRow, neighbour_col).rightBorder = fillBorder;
			} else
				return;
		}
	
		if (borderNr == BORDER_RIGHT) {
			int neighbour_col = liesInCol + 1 ;
			//if it's not indexOutOfBounds
			if (neighbour_col < CellArray.getNumberOfColums()) {
				CellArray.getSpecificCell(liesInRow, neighbour_col).leftBorder = fillBorder; 
			} else 
				return;
		}	
	}
	
	
	@Override
	public boolean getBorder(int borderNr) {

		if (borderNr < 1 || borderNr > 4)
			throw new IndexOutOfBoundsException();
		
		if (borderNr == BORDER_TOP) 
			return topBorder;
		
		if (borderNr == BORDER_BOTTOM) 
			return bottomBorder;
		
		if (borderNr == BORDER_LEFT) 
			return leftBorder;
		
		if (borderNr == BORDER_RIGHT) 
			return rightBorder;
		
		//dummy return to make the compiler happy
		return false;
	}
	


	public void fillCharArray() {
	
		if (this.cellFilled) {
			fillCellCompletelyWithOwnersString(true);
		} else {
			//print chars for the...
			//...top-Border:
			printHorizontalBorders(true, getBorder(BORDER_TOP));
			//...bottom-Border:
			printHorizontalBorders(false, getBorder(BORDER_BOTTOM));
			//...left-Border:
			printVerticalBorders(true, getBorder(BORDER_LEFT));
			//...right-Border:
			printVerticalBorders(false, getBorder(BORDER_RIGHT));
		}
		
		insertValueIntoCharMatrix();
	}
	
	
	private void insertValueIntoCharMatrix() {
		Integer value = (Integer) getCellValue();
		String valueString = value.toString();
		int lengthOfNumber = valueString.length();
	
		int halfOfCellSize = (Cell.CELL_SIZE / 2);	
		int middle_Vertical = halfOfCellSize;
		int middle_Horizontal = halfOfCellSize ;
		
		//get the correct index to use for adding the value to cellOutputCharMatrix
		if (lengthOfNumber == 1) 
			middle_Horizontal = halfOfCellSize;
		else if (lengthOfNumber == 2) 
			middle_Horizontal = halfOfCellSize ;
			else if (lengthOfNumber == 3) 
				middle_Horizontal = halfOfCellSize - 1;
		
		
		/*		switch (lengthOfNumber) {
			case 1:
				middle_Horizontal = halfOfCellSize;
				break;
			case 2:
				middle_Horizontal = halfOfCellSize - 1;
			case 3:
				middle_Horizontal = halfOfCellSize - 2;
				break;
		}
*/
		
		char[] tmpCharArray = new char[lengthOfNumber];
		//divide valueString (which represents the integer cellValue as a String) into single chars
		for (int i = 0; i < lengthOfNumber; i++) {
			tmpCharArray[i] = valueString.charAt(i);
		}
		
		//put the value into cellOutputStringArray
		for (int i = 0; i < lengthOfNumber; i++) {
			cellOutputStringArray[middle_Vertical][middle_Horizontal + i] = tmpCharArray[i];
		}
	}
	
	/**
	 * @param isTop is true if it's topBorder, false if it's bottomBorder  
	 */
	private void printHorizontalBorders (boolean isTop, boolean printOuterBorderToo) {
	
		//define start and stop indexes for printSingleHorizontalBorder()
		int Col_Start_Inner = 1;
		int Col_Start_Outer = 0;
		int Col_End_Inner = Cell.CELL_SIZE - 2;
		int Col_End_Outer = Cell.CELL_SIZE - 1;
		int rowIndexOuter;
		int rowIndexInner;
		
		if (isTop) {
			rowIndexOuter = 0;
			rowIndexInner = 1;
		} else {
			rowIndexOuter = Cell.CELL_SIZE - 1;
			rowIndexInner = Cell.CELL_SIZE - 2;
		}
		
		//print the inner Border:
		printSingleHorizontalBorder(rowIndexInner, Col_Start_Inner, Col_End_Inner, innerBorderChar);
		
		//if necessary print outer Border:
		if (printOuterBorderToo) {
			printSingleHorizontalBorder(rowIndexOuter, Col_Start_Outer, Col_End_Outer, outerBorderChar);
		}
	}
	
	
	private void printSingleHorizontalBorder(int rowIndex, int startCol, int endCol, char borderChar) {
		
		for (int i = startCol; i<= endCol; i++) {
			cellOutputStringArray[rowIndex][i] = borderChar;
		}
	}

	
	private void printVerticalBorders (boolean isLeft, boolean printOuterBorderToo) {
		
		int row_Start_Inner = 1;
		int row_Start_Outer = 0;
		int row_End_Inner = Cell.CELL_SIZE - 2;
		int row_End_Outer = Cell.CELL_SIZE - 1;
		int colIndexOuter;
		int colIndexInner;
		
		if (isLeft) {
			colIndexOuter = 0;
			colIndexInner = 1;
		} else {
			colIndexOuter = Cell.CELL_SIZE - 1;
			colIndexInner = Cell.CELL_SIZE - 2;
		}
		
		//print the inner Border:
		printSingleVerticalBorder(colIndexInner, row_Start_Inner, row_End_Inner, innerBorderChar);
		
		//if necessary print outer Border:
		if (printOuterBorderToo) {
			printSingleVerticalBorder(colIndexOuter, row_Start_Outer, row_End_Outer, outerBorderChar);
		}
	}
	
	
	private void printSingleVerticalBorder(int colIndex, int startRow, int endRow, char borderChar) {	
	
		for (int i = startRow; i<= endRow; i++) {
			cellOutputStringArray[i][colIndex] = borderChar;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cell("+this.getPositionX() + ", " + getPositionY() + ")" +
		" has the value: " + getCellValue() + " and is ");
		
		if (this.isCellFilled()) {
			sb.append("already filled by player " + cellOwner + "\n");
		} else {
			sb.append("not yet filled.\n");
		}
		return sb.toString();
	}

	@Override
	public int makeRandomNumber() {
		
		double random = Math.random();
		double tmp = (random * RANDOM_MAX);
		if (tmp < RANDOM_MIN) 
			tmp = RANDOM_MIN;
		int result = (int) Math.ceil(tmp);
		
		result = result * 25;
		return result;		
	}


	public void fillCellCompletelyWithOwnersString(boolean isPlayerOne) {
		
		for (int i = 0; i < CELL_SIZE; i++) {
			
			for (int j = 0; j < CELL_SIZE; j++) {
				cellOutputStringArray[i][j] = Player.getPlayerChar(isPlayerOne);
			}
		}
		insertValueIntoCharMatrix();
		
		
	}

	public boolean isBorderFilled(int border){
		return getBorder(border);
	}


}
