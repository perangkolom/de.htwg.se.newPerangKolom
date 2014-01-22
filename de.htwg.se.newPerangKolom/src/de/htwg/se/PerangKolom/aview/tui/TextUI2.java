package de.htwg.se.PerangKolom.aview.tui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import de.htwg.se.PerangKolom.controller.IPerangKolomController;
import de.htwg.se.PerangKolom.model.impl.CellArray;
import de.htwg.se.PerangKolom.model.impl.MessagesForUser2;
import de.htwg.se.PerangKolom.util.observer.Event;
import de.htwg.se.PerangKolom.util.observer.IObserver;

public class TextUI2 implements IObserver  {

	private IPerangKolomController controller;
	//private Logger logger = Logger.getLogger("de.htwg.se.perangkolom.aview.tui.TextUI");
	private Logger logger = Logger.getLogger(this.getClass().toString());
	private String newLine = System.getProperty("line.separator");
	//needed to be able to ask for extra input (to be able to leave the loop)
	private int optionChoice = 0;
	
	public TextUI2(IPerangKolomController controller) {
		this.controller = controller;
		controller.addObserver(this);
	}
	
	@Override
	public void update(Event e) {
		printTUI();
	}

	
	public void printTUI() {
		logger.info(newLine + controller.getGridString());
		//logger.info(newLine + controller.getStatus());
		//logger.info(newLine + controller.getShortInstructions());
	}
	
	
	public boolean processInputLine(String line) {
		boolean continueGame = true;
		boolean finishedAfterSwitchCase = false;
		
		char c = line.charAt(0);
		
		switch (c) {
		//new game
		case 'n':
			optionChoice = 1;
			finishedAfterSwitchCase = true;
			break;
		
		//quit
		case 'q':
			continueGame = false;
			logger.info("You decided to quit the game. Nethertheless, we hope you enjoyed playing this AWESOME game!");
			finishedAfterSwitchCase = true;
			break;
		//show help
		case 'h':
			logger.info(controller.showHelp());
			finishedAfterSwitchCase = true;
			break;
		}
		
		//choose Game Options
		if (optionChoice != 0) {
			switch (optionChoice) {
			case 1:
				
			
			
			//finally create the new grid and set optionChoice = 0 again
			case 5:
				logger.info("Please type in number to determine the size of the game-field: \n");
				if (line.matches("[0-9]")) {
					createNewGrid(c,c);
					optionChoice = 0;
				}
				
				
				
			}
			
			
			choseGridSize();
			choseOpponent();
			enterNames();
			showOverviewOfGameOptions();
		}
		
		
		
		
		//determine border to fill
		if ( !finishedAfterSwitchCase) {
			boolean isFine = true;
			//format to fill Border z of a given cell(x,y)
			if (line.matches("[0-9][0-9][0-9]")) {
				int[] arg = readToArray(line);
				if ( (arg[0] > CellArray.getNumberOfRows() || arg[0] < 1)  ||
						(arg[1] > CellArray.getNumberOfColums() || arg[1] < 1)  ||
						(arg[2] < 1 || arg [2] >	 4 ) ) {
					logger.info("The numbers you typed in where outside of the game-field's indizes. Please try again.\n");
					isFine = false;
				} 
				if (isFine) {
					controller.fillBorder(arg[0], arg[1], arg[2]);
					logger.info(MessagesForUser2.shortInstruction);

				} else ;

			//if the input was not of the correct format
			} else {
				logger.info("Your input was not in the desired format. Please try your input again. (to show help press \'h\')");
			}
				
		}
		
		if (finishedAfterSwitchCase && continueGame)
			logger.info(MessagesForUser2.shortInstruction);
		return continueGame;
	}
	
	
	private int[] readToArray(String line) {
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(line);
		int[] arg = new int[line.length()];
		for (int i = 0; i < arg.length; i++) {
			m.find();
			arg[i] = Integer.parseInt(m.group());
		}
		return arg;
	}
	
	
	private void chooseGameOptions() {
		logger.info("Before the game starts, you have to make choose your gaming options:\n");
		chooseSizeOfGameField();
		chooseKindOfOpponent();
		enterNames();
		showOverviewOfGameOptions();
	};

	
	private void chooseSizeOfGameField() {
		logger.info("Please enter );
	}
	
	private void chooseKindOfOpponent() {
		
	}

	private void enterNames() {
		
	}
	
	private void showOverviewOfGameOptions() {
		
	}
	
	
}