package de.htwg.se.PerangKolom.aview.tui;

import org.apache.log4j.Logger;

import de.htwg.se.PerangKolom.model.AbstractCell2;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.Cell2;
import de.htwg.se.PerangKolom.model.impl.CellArray;
import de.htwg.se.PerangKolom.model.impl.Grid;

public class MethodsForTui {

	private static MethodsForTui instance;
	private Logger logger = Logger.getLogger(this.getClass().toString());
	
	
	private MethodsForTui() {
		
	}
	
	public static MethodsForTui getInstance() {
		if (instance == null) {
			instance = new MethodsForTui();
		} 
		return instance;
	}
	
	
	public void buildCharMatrixForEachSingleCell() {

		for (int i = 0; i < Grid.getNumberOfRows(); i++) {
			for (int j = 0; j < Grid.getNumberOfCols(); j++) {
				
				ICell2 tmpCell = Grid.getInstance().getCell(i, j);
				
				if (tmpCell.isCellFilled()) {
					//fillCellCompletelyWithOwnersString(true);
				} else {
					//print chars for the...
					//...top-Border:
					printHorizontalBorders(true, tmpCell.getBorder(Cell2.BORDER_TOP));
					//...bottom-Border:
					printHorizontalBorders(false, tmpCell.getBorder(Cell2.BORDER_BOTTOM));
					//...left-Border:
					printVerticalBorders(true, tmpCell.getBorder(Cell2.BORDER_LEFT));
					//...right-Border:
					printVerticalBorders(false, tmpCell.getBorder(Cell2.BORDER_RIGHT));
				}
				insertValueIntoCharMatrix(tmpCell);
			}
		}
	}
		
	
	private void insertValueIntoCharMatrix(ICell2 cell) {
		Integer value = (Integer) cell.getCellValue();
		String valueString = value.toString();
		int lengthOfNumber = valueString.length();
	
		int halfOfCellSize = (cell.getCellSize() / 2);	
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

	
	public void combineAllToOneBigMatrix() {
		if (gameFieldString == null) {
			gameFieldString = new char[CellArray.getNumberOfColums() * Cell.CELL_SIZE][CellArray.getNumberOfColums()  * Cell.CELL_SIZE];
		}
	
		//loop to fill up the game-field with 
		for (int i = 0; i < CellArray.getNumberOfRows(); i++) {
			
			for (int j = 0; j < CellArray.getNumberOfColums(); j++) {
				Cell tmpCell = CellArray.cellArray[i][j]; 
				tmpCell.fillCharArray();
					
				//copy the chars of one single Cell into the char-matrix that shall finally be printed
				copyCelltoGameFieldMatrix(i,j, tmpCell);
			}
		}
	}
	
	
	/**
	 * this method prints the matrix for the whole game-field char by char. (it is the TUIs final output method for the game-field)
	 */
	public void printBigMatrix() {
		int stepsForRows = CellArray.getNumberOfRows() * Cell.CELL_SIZE;
		int stepsForCols = CellArray.getNumberOfColums() * Cell.CELL_SIZE;
	
		logger.debug("stepsForRows: " + stepsForRows + "\n");
		logger.debug("stepsForCols: " + stepsForCols + "\n");
		
		StringBuilder sbOut = new StringBuilder();
		for (int i = 0; i < stepsForRows; i++ ) {		
		
			for (int j = 0; j < stepsForCols; j++ ) {
				sbOut.append(gameFieldString[i][j]);		
			}
			sbOut.append("\n");
		}	
		logger.info("\n" + sbOut.toString());
	}

}
