package de.htwg.se.PerangKolom.model.impl;

import de.htwg.se.PerangKolom.model.IPlayer2;

public class GameSettings {
	
	//data concerning players
	private static IPlayer2 player1;
	private static IPlayer2 player2;
	private static IPlayer2 playerWhoseTurnItIs;
	private static IPlayer2 winner = null;
	
	private static GameSettings instance;
	
	private GameSettings() {
		setPlayer(new Player2(), 1);
		setPlayer(new Player2(), 2);
		setWhoseTurnItIs(getPlayer(1));		
	}
	
	
	public static GameSettings getInstance() {
		if (instance == null) {
			instance = new GameSettings();
		}
		return instance;
	}
	
	public static IPlayer2 getPlayer(int playerNumber) {
		
		if (playerNumber == 1) {
			return player1; 
		} else {
			return player2;
		}
	}

	public static IPlayer2 getPlayer(IPlayer2 player) {
		if (player == player1) {
			return player1;
		} 	
			else if (player == player1) {
				return player2;
			} 
			else {
				return player;
		}
	}
	
	public static void setPlayer(IPlayer2 player, int numberOfPlayer) {
		if (numberOfPlayer ==1 ) {
			player1 = player; 
		} else {
			player2 = player;
		}		
	}
	
	public static IPlayer2 getWhoseTurnItIs() {
		return playerWhoseTurnItIs;
	}
	
	public static void setWhoseTurnItIs(IPlayer2 player) {
		playerWhoseTurnItIs = player;
	}
	
	public static void changeTurn() {
		
		if (playerWhoseTurnItIs == player1) {
			playerWhoseTurnItIs = player2;
		} else {
			playerWhoseTurnItIs = player1;
		}
	}

	public static IPlayer2 getWinner() {
		return winner;
	}

	public static void setWinner(IPlayer2 player) {
		winner = player;
	}
}
