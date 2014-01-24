package de.htwg.se.PerangKolom.aview.tui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import de.htwg.se.PerangKolom.PerangKolom;
import de.htwg.se.PerangKolom.controller.impl.PKController;
import de.htwg.se.PerangKolom.model.IPlayer2;
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
	
	static final int SHALL_BE_HUMAN = 1;
	static final int SHALL_BE_COMPUTER = 2;
	private boolean showInstruction = false;
	
	private MethodsForTui gridMaker;
	private PKController controller;
	//private Logger logger = Logger.getLogger("de.htwg.se.perangkolom.aview.tui.TextUI");
	private Logger logger = Logger.getLogger(this.getClass().toString());
	private String newLine = System.getProperty("line.separator");

	private boolean continueGame = true;
	//optionChoice is needed to be able to ask for extra input (to be able to leave the loop)	
	private int optionChoice = NOTHING_CHOSEN;
	//subChoice is needed to determine which options to choose in submethods
	private int subChoice = NOTHING_CHOSEN;
	private boolean finishedAfterSwitchCase = false;
	private boolean tempSave = false;
	
	public TextUI2(PKController controller) {
		this.controller = controller;
		controller.addObserver(this);
		gridMaker = MethodsForTui.getInstance();
	}
	
	@Override
	public void update(Event e) {
		printTUI();
	}


	public void printTUI() {
		
		gridMaker.buildCharMatrixForEachSingleCell();
		gridMaker.combineAllToOneBigMatrix();
		gridMaker.printBigMatrix();
		//logger.info(newLine + controller.getGridString());
		//logger.info(newLine + controller.getStatus());
		//logger.info(newLine + controller.getShortInstructions());
	}
	
	
	public boolean processInputLine(String line) {
		
//		loopCounter++;
//		System.out.println("loopcounter: "+ loopCounter+ "\n");
				
		continueGame = true;
		finishedAfterSwitchCase = false;
		
		char c = line.charAt(0);
				
		if (optionChoice != NOTHING_CHOSEN) {
			inputCheckForGameOptions(c, line);
		} 
		else {
			continueGame = inputCheckNormalMenu(c, line);
		}
		
		//if c didn't match the cases above user has to determine a border to fill
		
		if ( !finishedAfterSwitchCase) {
			determineBorderToFill(c, line);
		}
		
		
		
		if (showInstruction) {
			logger.info(MessagesForUser2.shortInstruction);
		}
		
		return continueGame;
	}
	
	
	private boolean inputCheckNormalMenu(char c, String line) {
		
		switch (c) {
			
			case 'a':		//only once at start (initialization round) 
				
				logger.info(MessagesForUser2.startOfTheGame);
				logger.info(MessagesForUser2.help_inputInstructionForConsole);
				logger.info("\nPlease type n to start a new game... \n");
				finishedAfterSwitchCase = true;
				break;
		
			case 'n':		//new game
				optionChoice = OPTION_CHOICE_CHOOSE_OPPONENT;
				finishedAfterSwitchCase = true;
				logger.info("\nSo, you want to play a new Game... \n");
				
				logger.info("\nDo you want to compete a human player or the mighty artificial intelligence?!?\n");
				logger.info("\nType \'1\' for human opponent or \'2\' to play against the computer:\n");
				break;
		 
			case 'q':		//quit
				continueGame = false;
				finishedAfterSwitchCase = true;
				logger.info("You decided to quit the game. Nethertheless, we hope you enjoyed playing this AWESOME game!");
				break;
	
			case 'h':		//show help
				//logger.info(controller.showHelp());
				finishedAfterSwitchCase = true;
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
				finishedAfterSwitchCase = true;
				break;

			case OPTION_CHOICE_ENTER_NAMES:		

				initSubChoice();
				enterNames(c, line);
				finishedAfterSwitchCase = true;
				break;
				
			case OPTION_CHOICE_CHOOSE_GRID_SIZE:
	
				initSubChoice();
				chooseSizeOfGameField(c, line);
				finishedAfterSwitchCase = true;
				optionChoice = NOTHING_CHOSEN;
				logger.info("\nNow we hope you enjoy playing the game which starts NOW...\n");
				break;
				
			
			case OPTION_CHOICE_SHOW_OVERVIEW:  	//finally create the new grid and set optionChoice = 0 again
				//initSubChoice();
				//showOverviewOfGameOptions();

				resetOptionChoice();
				resetSubChoice();
				logger.info("\nNow we hope you enjoy playing the game which starts NOW...\n");
				showInstruction = true;
				finishedAfterSwitchCase = true;
				break;
			}
		

		}
	}
	
	
	private void chooseKindOfOpponent(char c, String line) {

		switch (subChoice) {
		
		case SUBCHOICE_FIRST_CASE:		//set Player2 as human or computer
			
			int size = Integer.parseInt(line);
			
			//if human was chosen
			if ( size == 1 ) {		
				controller.getPlayer(2).setPlayerHuman(true);
				resetSubChoice();
				optionChoice = OPTION_CHOICE_ENTER_NAMES;
				logger.info("\nPlease enter a name for player nr. 1: \n");

			//if computer was chosen
			} else if (size == SHALL_BE_COMPUTER) {				
				controller.getPlayer(2).setPlayerHuman(false);
				resetSubChoice();
				optionChoice = OPTION_CHOICE_ENTER_NAMES;
				logger.info("\nPlease enter a name for player nr. 1: \n");
				controller.setPlayersName("computer", controller.getPlayer(2));
				
				} else {
					logger.info("\nYou have typed in an incorrect value. Please try again\n");
					subChoice = 1;
			}
			break;
		}
		finishedAfterSwitchCase = true;
//		logger.info("\nNow you have to enter names for your players:\n");
	}
	
	
	private void chooseSizeOfGameField(char c, String line) {
		
		switch (subChoice) {
		
		case SUBCHOICE_FIRST_CASE:
			int size = 0;
					
			if ( line.matches("[2-9]") ) {				//if input was correct
				size = Integer.parseInt(line);
				//controller.setGridSize(size, size);
				logger.info("\nThanks. The grid will be set up with a size of (" +size+", "+size+").\n");
				resetSubChoice();
				resetOptionChoice();
//				optionChoice = OPTION_CHOICE_SHOW_OVERVIEW;
			}
			if (size == 3) {
				controller.setNumberOfRows(3);
				controller.setNumberOfCols(3);
				} else if (size == 7 ) {
					controller.setInstanceNull();
					controller.setNumberOfRows(7);
					controller.setNumberOfCols(7);
					controller.getInstance();
					
				
					
					
			} 
			else { 			//if input not correct				
				logger.info("\nYour input was not correct. Please try again.\n");
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
			
//			logger.info("\nNow you have to enter names for your players:\n");
			enterNameforPlayer(line, player1, PLAYER_ONE);
			if (controller.getPlayer(PLAYER_TWO).isPlayerAHuman()) {
				logger.info("\nPlease enter a name for player nr. 2: \n");
				tempSave = true;

			}
			subChoice = SUBCHOICE_SECOND_CASE;			
			break;
			
		case SUBCHOICE_SECOND_CASE:
						
			if (controller.isPlayerAHuman(player2)) {
				enterNameforPlayer(line, player2, PLAYER_TWO);
			}
			else {
				controller.setPlayersName("computer", player2);
				controller.setPlayerHuman(false, player2);
			}
			
			subChoice = NOTHING_CHOSEN;
			optionChoice = OPTION_CHOICE_CHOOSE_GRID_SIZE;
			logger.info("\nNow please enter \'3\' or \'7\' to determine the quadratic gamefield-size: \n");
			tempSave = false;	//gets resetted
		}
		
//		logger.info("\nNow please enter a number between 2 and 9 to determine the quadratic gamefield-size: \n");
		
	}
	
	
	private void showOverviewOfGameOptions() {
		
		logger.info("\nNow a new game will be started with the following settings: \n");
	
	}
	
	
	private void determineBorderToFill(char c, String line) {
		boolean isFine = true;
		//format to fill Border z of a given cell(x,y)
		if (line.matches("[1-9][1-9][1-4]")) {
			int[] arg = readToArray(line);
			
			//if wrong input
			if ( (arg[0] > controller.getNumberOfRows() || arg[0] < 1)  ||
					(arg[1] > controller.getNumberOfCols() || arg[1] < 1)  ||
					(arg[2] < 1 || arg [2] >	 4 ) ) {
				logger.info("\nThe numbers you typed in where outside of the game-field's indizes. Please try again.\n");
				isFine = false;
			} 
			//if input was correct
			if (isFine) {
				int x = arg[0];
				int y = arg[1];
				int z = arg[2];
				controller.setBorder( z, true, controller.getCell(x-1, y-1));
				logger.info(MessagesForUser2.shortInstruction);
				finishedAfterSwitchCase = true;
			} else ;

		//if the input was not of the correct format
		} else {
			logger.info("\nYour input was not in the desired format. Please try your input again. (to show help press \'h\')");
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
		if (playerNumber == 2 && tempSave == false) {
			logger.info("\nPlease enter a name for player nr." + playerNumber + ": \n");
		}
		controller.getPlayer(playerNumber).setPlayersName(line);
	}
	
	
}