package de.htwg.se.PerangKolom.controller;

import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.Grid;
import de.htwg.se.PerangKolom.util.observer.IObservable;

public interface IPKController extends IObservable {

//methods for grid.java
	
	Grid getInstance();
	
	ICell2[][] getCellArray();
	
	int getNumberOfRows();
	
	void setNumberOfRows(int x);
	
	int getNumberOfCols();
	
	void setNumberOfCols(int y);
	
	ICell2 getCell(int x, int y);
	

	
//methods for ICell2

	boolean isCellFilled();
	
	int getCellValue();
		
	IPlayer2 getCellOwner();
	
	void setCellOwner(IPlayer2 player);
	
	void setBorder(int borderNr, boolean fillBorder);
	
	boolean getBorder(int borderNr);
	
	String toString();
		
	int getCellSize();
	
	void setCellSize(int size);
	
	char[][] getCharArray();
	
	void setCharArray(char[][] charArray);


//methods for IGameSettings

	IPlayer2 getPlayer(int playerNumber);
	
	void setPlayer(IPlayer2 player, int numberOfPlayer);
	
	void setWhoseTurnItIs(IPlayer2 player);
	
	IPlayer2 getWhoseTurnItIs();
	
	void changeTurn();
	
	IPlayer2 getWinner();
	
	void setWinner(IPlayer2 player);


//methods for IPlayer2

	void setPlayerHuman(boolean isHuman);
	
	boolean isPlayerAHuman();
	
	int getNumberOfPoints();
	
	void addPointsToPlayersAccount(int newPoints);	
	
	void setPlayersName(String name);
	
	String getPlayersName();
	
}
