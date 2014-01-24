package de.htwg.se.PerangKolom.controller;

import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.CellArray;
import de.htwg.se.PerangKolom.util.observer.IObservable;

public interface IPerangKolomController extends IObservable {
	
	
//general
		
	void createNewGrid(int rows, int cols); 
	
	void exit();

	void endThisPlayersTurn();
	
//TUI/GUI-specific
	
	String getGridString();
	
	void fillBorder(int x, int y, int z);
	
	void fillCell(Cell cell);
	
	int getCellValue(Cell cell);
	
	int getNumberOfFilledBorderOfCell(Cell cell);

	String getStartGameString();

	String showHelp();
	
	String getShortInstructions();
	
//David specific
	
	public void setCellValue(int row, int column, int value);
	
	public int getRandNumber(int x, int y);
	
	public void setBorderFilled(int x, int y, int borderType);
	
	public Cell getCell(int x, int y);
	
	public boolean fourBordersFilled(int x, int y);
	
	public void setGridSize(int numberOfColumns, int numberOfRows);
	
	public int getNumberOfRows();
	
	public int getNumberOfColumns();
	
	public CellArray getCellArray();
	
	public boolean isBorderFilled(int x, int y, int border);

	
}
