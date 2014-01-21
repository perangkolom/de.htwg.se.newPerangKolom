package de.htwg.se.PerangKolom.controller.impl;

import java.util.logging.Logger;

import de.htwg.se.PerangKolom.controller.IPerangKolomChrisController;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.CellArray;
import de.htwg.se.PerangKolom.model.impl.MessagesForUser2;
import de.htwg.se.PerangKolom.util.observer.Observable;

public class PerangKolomChrisController extends Observable implements IPerangKolomChrisController {

	private String notYet = "(no code written until now. Don't forget to do so!)";
	//private Logger logger = Logger.getLogger("de.htwg.se.PerangKolom.controller.impl.IPerangKolomController");
	private Logger logger = Logger.getLogger(this.getClass().toString());

	
	public PerangKolomChrisController() {}
	

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

}
