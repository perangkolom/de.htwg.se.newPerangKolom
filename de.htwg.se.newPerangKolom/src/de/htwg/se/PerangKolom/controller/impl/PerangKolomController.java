package de.htwg.se.PerangKolom.controller.impl;

import java.util.logging.Logger;

import de.htwg.se.PerangKolom.controller.IPerangKolomController;
import de.htwg.se.PerangKolom.model.ICell;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.CellArray;
import de.htwg.se.PerangKolom.model.impl.MessagesForUser2;
import de.htwg.se.PerangKolom.util.observer.Observable;

public class PerangKolomController extends Observable implements IPerangKolomController {

	public CellArray CellArrayDummy = CellArray.getInstance();
	public Cell[][] cellArray = CellArray.getCellArray();
	private final int FOUR = 4;
	
	private String notYet = "(no code written until now. Don't forget to do so!)";
	//private Logger logger = Logger.getLogger("de.htwg.se.PerangKolom.controller.impl.IPerangKolomController");
	private Logger logger = Logger.getLogger(this.getClass().toString());

	
	public PerangKolomController() {}
	

	@Override
	public void createNewGrid(int rows, int cols) {	

		CellArray.createCellArray(rows, cols);
		logger.info("Now the controller should create a new Grid!");
		notifyObservers();
	}
		
/*
		//if a completely new game is started
		if ( ! CellArray.isGameFieldAlreadyCreated()) {
			logger.info("A new game is gets started with a game-field-size of ("+ rows +","+ cols +").\n");
			CellArray.createCellArray(rows, cols);
		}
		//if game has to be restarted (so if a gameField is already existing)
		else {
			
		}
		
		logger.info("Now the controller should create a new Grid!");
		notifyObservers();
*/

	@Override
	public void exit() {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void endThisPlayersTurn() {
		// TODO Auto-generated method stub
	}


	@Override
	public String getGridString() {
			CellArray.fillGameMatrix();
			CellArray.printGameFieldString();
		return null;
	}

	@Override
	public void fillBorder(int x, int y, int z) {
		logger.info("Now the border " + z + " of  cell("+x+","+y+") shall be filled\n");
		notifyObservers();
		
	}
	@Override
	public String getStartGameString() {
		return MessagesForUser2.startOfTheGame;
	}


	@Override
	public String showHelp() {
		return MessagesForUser2.help_inputInstructionForConsole;
	}


	@Override
	public String getShortInstructions() {
		return MessagesForUser2.shortInstruction;
	}
	
	/**************************************************************/
	
	@Override
	public void fillCell(Cell cell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCellValue(Cell cell) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfFilledBorderOfCell(Cell cell) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/************** VON DAVID's Controller METHODEN***************/
	
	public void setCellValue(int row, int column, int value){
		cellArray[row][column].setCellValue(value);
	}
	
	public int getRandNumber(int x, int y){
//		this.cell = new Cell(x, y);
		return cellArray[x][y].makeRandomNumber();
	}
	

	public void setBorderFilled(int x, int y, int borderType){
		cellArray[x][y].setBorder(borderType, true);
	}



	public Cell getCell(int x, int y) {
			Cell tmpCell = cellArray[x][y];
		return tmpCell;
	}
	
	public boolean fourBordersFilled(int x, int y){
		Cell cell = getCell(x, y);
		System.out.printf("NUMBER of Filled Borders: %d%n", cell.getNumberOfFilledBorders());

		if(cell.getNumberOfFilledBorders() == FOUR){
			return true;
		}
		return false;
	}
	

}
