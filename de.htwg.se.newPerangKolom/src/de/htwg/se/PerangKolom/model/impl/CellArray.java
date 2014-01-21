package de.htwg.se.PerangKolom.model.impl;

import org.apache.log4j.Logger;

import de.htwg.se.PerangKolom.model.AbstractCell;
import de.htwg.se.PerangKolom.model.impl.Cell;

public final class CellArray {

	/**
	 * this array is necessary to be able to save the cells in the correct ordering
	 * there's no graphical information directly in this class
	 */
	
	private static CellArray instance;
	private static final int DEFAULT_NUMBEROFROWS = 7;
	private static final int DEFAULT_NUMBEROFCOLUMS = 7;
	private static Cell[][] cellArray = null;
	private static int numberOfRows = DEFAULT_NUMBEROFROWS;
	private static int numberOfColums = DEFAULT_NUMBEROFCOLUMS;
	private static boolean gameFieldAlreadyCreated = false;
	/**
	 * this is the final output-char-array for the TUI
	 */
	private static char[][] gameFieldString;
	private static Logger logger = Logger.getLogger("de.htwg.se.PerangKolom.model.impl.CellArray");
	
	
	private CellArray() {
		
		cellArray= new Cell[getNumberOfRows()][getNumberOfColums()];

		for (int i = 0; i < getNumberOfRows(); i++) {
		
			for (int j = 0; j < getNumberOfColums(); j++) {

				cellArray[i][j] = new Cell(i,j);		
			}
		}
		gameFieldAlreadyCreated = true;
	}

	public static boolean isGameFieldAlreadyCreated() {
		return gameFieldAlreadyCreated;
	}
	
	public static CellArray getInstance() {
		if (instance == null) 
			new CellArray();
		return instance;
	}

	public static void createCellArray(int x, int y) {
		gameFieldAlreadyCreated = false;
		cellArray = null;
		setNumberOfRows(x);
		setNumberOfColums(y);
		getInstance();	
	}
	
	public static Cell[][] getCellArray() {
		return cellArray;
	}

	private static void setNumberOfRows(int x) {
		if (cellArray == null) 
			numberOfRows = x;
	}

	private static void setNumberOfColums(int x) {
		if (cellArray == null) 
			numberOfColums = x;
	}

	public static int getNumberOfRows() {
		return numberOfRows;
	}

	public static int getNumberOfColums() {
		return numberOfColums;
	}
	
	public static Cell getSpecificCell(int row, int col) {
		return cellArray[row][col];
	}

	
	/**
	 * fills the char-matrix gameFieldString cell by cell
	 */
	public static void fillGameMatrix() {
		
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
	 * copies the chars of one single cell into matrix gameFieldString
	 * @param gameFieldRow is the row that the selected cell to be filled in lies in
	 * @param gameFieldColumn is the column that the selected cell to be filled in lies in
	 */
	private static void copyCelltoGameFieldMatrix(int gameFieldRow, int gameFieldColumn, Cell cell) {

		//offsetX shall even out the effect that filled Borders that are not at the edge of the gameField overlap each other
		//int offsetX = - (gameFieldRow - 1);
		int cellStartsAt_X = (gameFieldRow * Cell.CELL_SIZE) ;
		int cellStartsAt_Y = (gameFieldColumn * Cell.CELL_SIZE);
		
		if (gameFieldRow > 0 ) 
			cellStartsAt_X -= 1;
		if (gameFieldColumn > 0)
			cellStartsAt_Y -= 1;
		
		//for each row
		for (int i = 0; i < Cell.CELL_SIZE; i++) {
			//for each column
			for (int j = 0; j < Cell.CELL_SIZE; j++) {
				int coordX = cellStartsAt_X + i;
				int coordY = cellStartsAt_Y + j;
				gameFieldString[coordX][coordY] = cell.cellOutputStringArray[i][j];
			}
		}
		
	}
	
	
	/**
	 * this method prints the matrix for the whole game-field char by char. (it is the TUIs final output method for the game-field)
	 */
	public static void printGameFieldString() {
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
	
	
	public static void setAllBordersTrue() {
		
		for (int i = 0; i < CellArray.getNumberOfRows(); i++) {
			
			for (int j = 0; j < CellArray.getNumberOfColums(); j++) {
				CellArray.cellArray[i][j].setBorder(Cell.BORDER_BOTTOM, true);
				CellArray.cellArray[i][j].setBorder(Cell.BORDER_LEFT, true);
				CellArray.cellArray[i][j].setBorder(Cell.BORDER_RIGHT, true);
				CellArray.cellArray[i][j].setBorder(Cell.BORDER_TOP, true);
			}
		}
	}
	
}