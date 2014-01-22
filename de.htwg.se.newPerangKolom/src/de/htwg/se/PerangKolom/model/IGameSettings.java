package de.htwg.se.PerangKolom.model;

public interface IGameSettings {

	IPlayer2 getPlayer(int playerNr);
	
	IPlayer2 whoseTurnIsIt();
	
	void changeTurn();
	
	
	
	
	int getGridSize();
	
	void setGridSize(int size);
	
	
	
	
}




