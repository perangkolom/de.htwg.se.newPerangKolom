package de.htwg.se.PerangKolom.model.impl;

public class MessagesForUser2  {

	public static final String startOfTheGame = "\n\n" 
				+ "You are now playing PerangKolom, the best game EVER created!\n";
		
	public static final String help_inputInstructionForConsole =
				"\n\n" +
				"Type in the following letters to control the game: \n" + 
				
				"Start New Game: n\n"
				+ "Exit Game: x\n"  

				+"To mark a border, type in a number with three digits:\n" 
				+ "The first number specifies the row the cell is positioned in\n"
				+ "the second number specifies the column that the cell is positioned in\n"
				+ "the third number specifies, which border of the chosen cell shall be filled\n"
				+ "(1 = top, 2 = bottom, 3 = left, 4 = right)\n"
				+ "An example: an input of \'452\' will fill the bottom Border of the cell positioned at (4,5).\n"; 
		
	
	public static final String shortInstruction =
				"\n\n"+
				"Commands: n-new Game, x-quit, h-help, ### (this means three numbers, e.g. 231) to fill border1 of the cell located at (2,3).\n";

}
