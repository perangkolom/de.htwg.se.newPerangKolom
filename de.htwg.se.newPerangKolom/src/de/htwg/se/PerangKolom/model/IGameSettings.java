package de.htwg.se.PerangKolom.model;

public interface IGameSettings {

	IPlayer2 getPlayer(int playerNumber);
	
	void setPlayer(IPlayer2 player, int numberOfPlayer);
	
	void setWhoseTurnItIs(IPlayer2 player);
	
	IPlayer2 getWhoseTurnItIs();
	
	void changeTurn();
	
	IPlayer2 getWinner();
	
	void setWinner(IPlayer2 player);
	
}




