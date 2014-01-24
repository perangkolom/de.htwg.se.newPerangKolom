package de.htwg.se.PerangKolom.model.impl;

import de.htwg.se.PerangKolom.model.ICell2;


public class Grid {

	private static Grid instance;
	private Cell2[][] cellArray;
	private static int numberOfRows = 3;
	private static int numberOfCols = 3;
	private static GameSettings gameSettings;
	
	private Grid() {
		
		cellArray = new Cell2[numberOfRows][numberOfCols];
		this.gameSettings = GameSettings.getInstance();
		
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfCols; j++) {
				cellArray[i][j] = new Cell2(i,j);
			}
		}
	}
	
	
	public static Grid getInstance() {
		if (instance == null) {
			instance = new Grid();
		} 
			return instance;
	}


	public ICell2[][] getCellArray() {
		return cellArray;
	}


	public static int getNumberOfRows() {
		return numberOfRows;
	}

 
	public static void setNumberOfRows(int x) {
		numberOfRows = x;
		
	}

 
	public static int getNumberOfCols() {
		return numberOfCols;
	}


 
	public static void setNumberOfCols(int y) {
		numberOfCols = y;
	}


	public ICell2 getCell(int x, int y) {
		return cellArray[x][y];
	}


	
}
