package de.htwg.se.PerangKolom.model.impl;

import de.htwg.se.PerangKolom.model.impl.CellArray;

public class GameData {

	private static GameData gameDataInstance;
	private static final int NUMBER_OF_PLAYERS = 2;
	private Player player1;
	private Player player2;
	private static boolean isGameRunningCurrently;
	private final static char CHAR_PLAYER_1 = '1';
	private final static char CHAR_PLAYER_2 = '2';
	private static Player actualPlayer;
	
/*	private GameData() {
		if (cellArrayInstance == null)
			//...
		cellArrayInstance = get;
	}	*/

	private GameData() {
		
	}
	
	public static GameData getInstance() {
		if (gameDataInstance == null) {
			gameDataInstance = new GameData();
		}
		return gameDataInstance;
	}
	
	
	
	public Player getPlayerWhoMakesThisTurn() {
		return actualPlayer;
	}
	
	
	public char getPlayerChar(Player player) {
		if (player == player1) {
			return CHAR_PLAYER_1;
		} else {
			return CHAR_PLAYER_2;
		}
	}
	
	
}
