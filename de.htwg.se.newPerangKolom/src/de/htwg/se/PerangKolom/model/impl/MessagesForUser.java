package de.htwg.se.PerangKolom.model.impl;

import de.htwg.se.PerangKolom.model.AbstractMessagesForUser;

public class MessagesForUser extends AbstractMessagesForUser {

	public MessagesForUser() {

		startOfTheGame = "You are now playing PerangKolom, the best game EVER created!\n";
		
		inputInstructionForConsole = 
				"Type in the following letters to control the game: \n" + 
				
				"Start New Game: n\n"
				+ "Exit Game: x\n"  

				+"To mark a border, type in a number with three digits:\n" 
				+ "The first number specifies the row the cell is positioned in\n"
				+ "the second number specifies the column that the cell is positioned in\n"
				+ "the third number specifies, which border of the chosen cell shall be filled\n"
				+ "(1 = top, 2 = bottom, 3 = left, 4 = right)\n"
				+ "An example: an input of \'452\' will fill the bottom Border of the cell positioned at (4,5).\n"; 
		
		shortInstruction = 
				"Commands: n-new Game, x-quit, h-help, ### (this means three numbers, e.g. 231) to fill border1 of the cell located at (2,3).\n";

	}
	
	
	public String getStartGameString() {
		return startOfTheGame;
	}
	
	public String getInputInstructions() {
		return inputInstructionForConsole; 
	}
	
	public String getShortInstructions() {
		return shortInstruction; 
	}
	
		
	

}
