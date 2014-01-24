package de.htwg.se.PerangKolom.aview.tui;

import org.apache.log4j.Logger;

import de.htwg.se.PerangKolom.controller.impl.PKController;
import de.htwg.se.PerangKolom.model.AbstractCell2;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.Cell2;
import de.htwg.se.PerangKolom.model.impl.Grid;

public class MethodsForTui {

	private static MethodsForTui instance;
	private Logger logger = Logger.getLogger(this.getClass().toString());
	private char[][] outputMatrix;
	private static int WIDTH 	= Grid.getNumberOfRows() * Cell2.getCellSize();
	private static int HEIGHT 	= Grid.getNumberOfCols() * Cell2.getCellSize();
	private PKController controller;
	private static char INNER_BORDER_CHAR = '+';
	private static char OUTER_BORDER_CHAR = '#';
	
	private MethodsForTui() {
		
		outputMatrix = new char[WIDTH][HEIGHT];
		controller = new PKController();
	}
	
	public static MethodsForTui getInstance() {
		if (instance == null) {
			instance = new MethodsForTui();
		} 
		return instance;
	}
	
	
	public void buildCharMatrixForEachSingleCell() {

		for (int i = 0; i < controller.getNumberOfRows(); i++) {
			for (int j = 0; j < controller.getNumberOfCols(); j++) {
				
				ICell2 cell = controller.getCell(i, j);
				char[][] charArray = controller.getCharArray(cell);
				
				if (controller.isCellFilled(cell)) {
					//fillCellCompletelyWithOwnersString(true);
				} else {
					//print chars for the...
					//...top-Border:
					printHorizontalBorders(true, controller.getBorder(Cell2.BORDER_TOP, cell), cell);
					//...bottom-Border:
					printHorizontalBorders(false, controller.getBorder(Cell2.BORDER_BOTTOM, cell), cell);
					//...left-Border:
					printVerticalBorders(true,controller.getBorder(Cell2.BORDER_LEFT, cell), cell);
					//...right-Border:
					printVerticalBorders(false, controller.getBorder(Cell2.BORDER_RIGHT, cell), cell);
				}
				insertValueIntoCharMatrix(cell);
			}
		}
	}
		
	
		
	
	private void insertValueIntoCharMatrix(ICell2 cell) {
		Integer value = (Integer) controller.getCellValue(cell);
		String valueString = value.toString();
		int lengthOfNumber = valueString.length();
	
		int halfOfCellSize = (controller.getCellSize() / 2);	
		int middle_Vertical = halfOfCellSize;
		int middle_Horizontal = halfOfCellSize ;
		
		//get the correct index to use for adding the value to cellOutputCharMatrix
		if (lengthOfNumber == 1) 
			middle_Horizontal = halfOfCellSize;
		else if (lengthOfNumber == 2) 
			middle_Horizontal = halfOfCellSize ;
			else if (lengthOfNumber == 3) 
				middle_Horizontal = halfOfCellSize - 1;
		
//				switch (lengthOfNumber) {
//			case 1:
//				middle_Horizontal = halfOfCellSize;
//				break;
//			case 2:
//				middle_Horizontal = halfOfCellSize - 1;
//			case 3:
//				middle_Horizontal = halfOfCellSize - 2;
//				break;
//		}

		
		char[] tmpCharArray = new char[lengthOfNumber];
		
		//divide valueString (which represents the integer cellValue as a String) into single chars
		for (int i = 0; i < lengthOfNumber; i++) {
			tmpCharArray[i] = valueString.charAt(i);
		}
		
		char[][] tmpMatrix = controller.getCharArray(cell);
				
		//put the value into cellOutputStringArray
		for (int i = 0; i < lengthOfNumber; i++) {
		
			tmpMatrix[middle_Vertical][middle_Horizontal + i] = tmpCharArray[i];
		}
		controller.setCharArray(tmpMatrix, cell);
	}
	
	/**
	 * @param isTop is true if it's topBorder, false if it's bottomBorder  
	 */
	private void printHorizontalBorders (boolean isTop, boolean printOuterBorderToo, ICell2 cell) {
	
		//define start and stop indexes for printSingleHorizontalBorder()
		int Col_Start_Inner = 1;
		int Col_Start_Outer = 0;
		int Col_End_Inner = controller.getCellSize() - 2;
		int Col_End_Outer = controller.getCellSize() - 1;
		int rowIndexOuter;
		int rowIndexInner;
		
		if (isTop) {
			rowIndexOuter = 0;
			rowIndexInner = 1;
		} else {
			rowIndexOuter = controller.getCellSize() - 1;
			rowIndexInner = controller.getCellSize() - 2;
		}
		
		//print the inner Border:
		printSingleHorizontalBorder(rowIndexInner, Col_Start_Inner, Col_End_Inner, INNER_BORDER_CHAR, cell);
		
		//if necessary print outer Border:
		if (printOuterBorderToo) {
			printSingleHorizontalBorder(rowIndexOuter, Col_Start_Outer, Col_End_Outer, OUTER_BORDER_CHAR, cell);
		}
	}
	
	
	private void printSingleHorizontalBorder(int rowIndex, int startCol, int endCol, char borderChar, ICell2 cell) {
		
		for (int i = startCol; i<= endCol; i++) {
			controller.getCharArray(cell)[rowIndex][i] = borderChar;
		}
	}

	
	private void printVerticalBorders (boolean isLeft, boolean printOuterBorderToo, ICell2 cell) {
		
		int row_Start_Inner = 1;
		int row_Start_Outer = 0;
		int row_End_Inner = controller.getCellSize() - 2;
		int row_End_Outer = controller.getCellSize() - 1;
		int colIndexOuter;
		int colIndexInner;
		
		if (isLeft) {
			colIndexOuter = 0;
			colIndexInner = 1;
		} else {
			colIndexOuter = controller.getCellSize() - 1;
			colIndexInner = controller.getCellSize() - 2;
		}
		
		//print the inner Border:
		printSingleVerticalBorder(colIndexInner, row_Start_Inner, row_End_Inner, INNER_BORDER_CHAR, cell);
		
		//if necessary print outer Border:
		if (printOuterBorderToo) {
			printSingleVerticalBorder(colIndexOuter, row_Start_Outer, row_End_Outer, OUTER_BORDER_CHAR, cell);
		}
	}
	
	
	private void printSingleVerticalBorder(int colIndex, int startRow, int endRow, char borderChar, ICell2 cell) {	
	
		for (int i = startRow; i<= endRow; i++) {
			controller.getCharArray(cell)[i][colIndex] = borderChar;
		}
	}

	
	public void combineAllToOneBigMatrix() {
	
		buildCharMatrixForEachSingleCell();
		
		//loop to fill up the game-field with 
		for (int i = 0; i < controller.getNumberOfRows(); i++) {
			
			for (int j = 0; j < controller.getNumberOfCols(); j++) {
				ICell2 tmpCell = controller.getCellArray()[i][j]; 
			
				//copy the chars of one single Cell into the char-matrix that shall finally be printed
				copyCelltoGameFieldMatrix(i,j, tmpCell);
			}
		}
	}
	
	private void copyCelltoGameFieldMatrix(int gameFieldRow, int gameFieldColumn, ICell2 cell) {

		//offsetX shall even out the effect that filled Borders that are not at the edge of the gameField overlap each other
		//int offsetX = - (gameFieldRow - 1);
		int cellStartsAt_X = (gameFieldRow * controller.getCellSize()) ;
		int cellStartsAt_Y = (gameFieldColumn * controller.getCellSize());
		
		
		
		if (gameFieldRow > 0 ) 
			cellStartsAt_X -= gameFieldRow;
		if (gameFieldColumn > 0)
			cellStartsAt_Y -= gameFieldColumn;
		
		//for each row
		for (int i = 0; i < controller.getCellSize(); i++) {
			//for each column
			for (int j = 0; j < controller.getCellSize(); j++) {
				int coordX = cellStartsAt_X + i;
				int coordY = cellStartsAt_Y + j;
				outputMatrix[coordX][coordY] = controller.getCharArray(cell)[i][j];
			}
		}
	}
	
	/**
	 * this method prints the matrix for the whole game-field char by char. (it is the TUIs final output method for the game-field)
	 */
	public void printBigMatrix() {
		int stepsForRows = controller.getNumberOfRows() * controller.getCellSize();
		int stepsForCols = controller.getNumberOfCols() * controller.getCellSize();
	
		logger.debug("stepsForRows: " + stepsForRows + "\n");
		logger.debug("stepsForCols: " + stepsForCols + "\n");
		
		StringBuilder sbOut = new StringBuilder();
		for (int i = 0; i < stepsForRows; i++ ) {		
		
			for (int j = 0; j < stepsForCols; j++ ) {
				sbOut.append(outputMatrix[i][j]);		
			}
			sbOut.append("\n");
		}	
		logger.info("\n" + sbOut.toString());
	}

}
