package de.htwg.se.PerangKolom.aview.tui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import de.htwg.se.PerangKolom.controller.impl.PKController;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.CellArray;
import de.htwg.se.PerangKolom.model.impl.GameSettings;
import de.htwg.se.PerangKolom.model.impl.MessagesForUser2;
import de.htwg.se.PerangKolom.util.observer.Event;
import de.htwg.se.PerangKolom.util.observer.IObserver;

public class TextUI2 implements IObserver  {

	private static final int NOTHING_CHOSEN = 0;
	private static final int OPTION_CHOICE_CHOOSE_OPPONENT = 1;
	private static final int OPTION_CHOICE_ENTER_NAMES = 2;
	private static final int OPTION_CHOICE_CHOOSE_GRID_SIZE = 3;
	private static final int OPTION_CHOICE_SHOW_OVERVIEW = 4;
	
	private static final int SUBCHOICE_FIRST_CASE = 1;
	private static final int SUBCHOICE_SECOND_CASE = 2;
	private static final int SUBCHOICE_THIRD_CASE = 3;
	private static final int SUBCHOICE_FOURTH_CASE = 4;
	
	private PKController controller;
	//private Logger logger = Logger.getLogger("de.htwg.se.perangkolom.aview.tui.TextUI");
	private Logger logger = Logger.getLogger(this.getClass().toString());
	private String newLine = System.getProperty("line.separator");

	private boolean continueGame = true;
	//optionChoice is needed to be able to ask for extra input (to be able to leave the loop)	
	private int optionChoice = 0;
	//subChoice is needed to determine which options to choose in submethods
	private int subChoice = 0;
	private boolean finishedAfterSwitchCase = false;
	
	public TextUI2(PKController controller) {
		this.controller = controller;
		controller.addObserver(this);
	}
	
	@Override
	public void update(Event e) {
		printTUI();
	}


	public void printTUI() {
		//logger.info(newLine + controller.getGridString());
		//logger.info(newLine + controller.getStatus());
		//logger.info(newLine + controller.getShortInstructions());
	}
	
	
	public boolean processInputLine(String line) {
		
		//IPlayer2 actualPlayer = GameSettings.getWhoseTurnItIs();
		continueGame = true;
		finishedAfterSwitchCase = false;
		
		char c = line.charAt(0);
				
		if (optionChoice == NOTHING_CHOSEN) {
			continueGame = inputCheckNormalMenu(c, line);
		} 
		else {
			inputCheckForGameOptions(c, line);
		}
		
		//if c didn't match the cases above user has to determine a border to fill
		
		if ( !finishedAfterSwitchCase) {
			determineBorderToFill(c, line);
		}
		
		
		
		if (finishedAfterSwitchCase && continueGame)
			logger.info(MessagesForUser2.shortInstruction);
		return continueGame;
	}
	
	
	private boolean inputCheckNormalMenu(char c, String line) {
		
		switch (c) {

			case 'n':		//new game
				optionChoice = OPTION_CHOICE_CHOOSE_OPPONENT;
				break;
			
			case 'q':		//quit
				continueGame = false;
				logger.info("You decided to quit the game. Nethertheless, we hope you enjoyed playing this AWESOME game!");
				break;
	
			case 'h':		//show help
				//logger.info(controller.showHelp());
				break;
				
			default:		//if none of the above cases applied 
				finishedAfterSwitchCase = false;
		}

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
		
	
	private void inputCheckForGameOptions(char c, String line) {	

		//choose Game Options
		if (optionChoice != NOTHING_CHOSEN) {
		
			switch (optionChoice) {
			
			case OPTION_CHOICE_CHOOSE_OPPONENT:
				
				initSubChoice();
				chooseKindOfOpponent(c, line);
				break;

			case OPTION_CHOICE_ENTER_NAMES:		
				
				initSubChoice();
				enterNames(c, line);
				break;
				
			case OPTION_CHOICE_CHOOSE_GRID_SIZE:
				
				initSubChoice();
				chooseSizeOfGameField(c, line);
				break;
				
			
			case OPTION_CHOICE_SHOW_OVERVIEW:  	//finally create the new grid and set optionChoice = 0 again
				initSubChoice();
				showOverviewOfGameOptions();
				break;
			}
		

		}
	}
	
	
	private void chooseKindOfOpponent(char c, String line) {
		
		final int SHALL_BE_HUMAN = 1;
		final int SHALL_BE_COMPUTER = 2;
		
		switch (subChoice) {
		
		case SUBCHOICE_FIRST_CASE:		//ask user for input
			logger.info("Do you want to compete a human player or the mighty artificial intelligence?!?\n");
			logger.info("Type 1 for human opponent or 2 to play against the computer:\n");
			subChoice = SUBCHOICE_SECOND_CASE;
			break;

		case SUBCHOICE_SECOND_CASE:		//set Player2 as human or computer

			if (c == SHALL_BE_HUMAN ) {		//if human was chosen
				//GameSettings.getInstance().getPlayer(2).setPlayerHuman(true);  //per controller aufrufen
				resetSubChoice();
				optionChoice = OPTION_CHOICE_ENTER_NAMES;
			} 
			else if (c == SHALL_BE_COMPUTER) {			//if computer was chosen	
				//über Controller aufrufen
				//player2 auf nicht human setzen
				resetSubChoice();
				optionChoice = OPTION_CHOICE_ENTER_NAMES;
				
				} else {
					logger.info("You have typed in an incorrect value. Please try again\n");
					subChoice = 1;
			}
			break;
		}
		
	}
	
	
	private void chooseSizeOfGameField(char c, String line) {
		
		
		switch (subChoice) {
		
		case SUBCHOICE_FIRST_CASE:	
		
			logger.info("Now please enter a number between 2 and 9 to determine the quadratic gamefield-size: \n");
			subChoice = SUBCHOICE_SECOND_CASE;
			break;
			
		case SUBCHOICE_SECOND_CASE:
			
			if ( line.matches("[2-9]") ) {				//if input was correct
				int size = Integer.parseInt(line);
				//controller.setGridSize(size, size);
				logger.info("Thanks. The grid will be set up with a size of (" +size+", "+size+").\n");
				resetSubChoice();
				optionChoice = OPTION_CHOICE_SHOW_OVERVIEW;
			} 
			else { 			//if input not correct				
				logger.info("Your input was not correct. Please try again.\n");
				subChoice = SUBCHOICE_FIRST_CASE;
			}
			
			
		}
		
	}
	
	
	private void enterNames(char c, String line) {
		
		final int PLAYER_ONE = 1;
		final int PLAYER_TWO = 2;
		
		IPlayer2 player1 = controller.getPlayer(PLAYER_ONE);
		IPlayer2 player2 = controller.getPlayer(PLAYER_TWO);
		
		switch (subChoice) {
			
		case SUBCHOICE_FIRST_CASE:
			
			logger.info("Now you habe to enter names for your players:\n");
			enterNameforPlayer(line, player1, PLAYER_ONE);
			subChoice = SUBCHOICE_SECOND_CASE;
			break;
			
		case SUBCHOICE_SECOND_CASE:
						
			if (player2.isPlayerAHuman()) {
				enterNameforPlayer(line, player2, PLAYER_TWO);
			}
			else {
				controller.setPlayersName("computer", player2);
			}
			
			subChoice = NOTHING_CHOSEN;
			optionChoice = OPTION_CHOICE_CHOOSE_GRID_SIZE;
		}
		
		
	}
	
	
	private void showOverviewOfGameOptions() {
		
		logger.info("Now a new game will be started with the following settings: \n");
		logger.info("An overview of the game settings will be shown here. This has to be done after the "
				+ "controller has been set up correctly! DONT FORGET IT!\n");
	}
	
	
	private void determineBorderToFill(char c, String line) {
		boolean isFine = true;
		//format to fill Border z of a given cell(x,y)
		if (line.matches("[0-9][0-9][0-9]")) {
			int[] arg = readToArray(line);
			
			//if wrong input
			if ( (arg[0] > CellArray.getNumberOfRows() || arg[0] < 1)  ||
					(arg[1] > CellArray.getNumberOfColums() || arg[1] < 1)  ||
					(arg[2] < 1 || arg [2] >	 4 ) ) {
				logger.info("The numbers you typed in where outside of the game-field's indizes. Please try again.\n");
				isFine = false;
			} 
			//if input was correct
			if (isFine) {
				int x = arg[0];
				int y = arg[1];
				int z = arg[2];
				controller.setBorder( z, true, controller.getCell(x, y));
				logger.info(MessagesForUser2.shortInstruction);
				finishedAfterSwitchCase = true;
			} else ;

		//if the input was not of the correct format
		} else {
			logger.info("Your input was not in the desired format. Please try your input again. (to show help press \'h\')");
		}
	}
	
	
	private void resetOptionChoice() {
		optionChoice = 0;
	}
	
	private void resetSubChoice() {
		subChoice = 0;
	}
	
	private void initSubChoice() {
		if (subChoice == NOTHING_CHOSEN) {
			subChoice = SUBCHOICE_FIRST_CASE;
		}
	}

	private void enterNameforPlayer(String line, IPlayer2 player, int playerNumber) {
		logger.info("Please enter a name for player nr." + playerNumber + ": \n");
		controller.getPlayer(playerNumber).setPlayersName(line);
	}
}









