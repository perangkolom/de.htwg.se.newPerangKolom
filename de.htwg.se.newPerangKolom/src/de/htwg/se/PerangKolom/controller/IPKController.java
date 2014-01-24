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

	boolean isCellFilled(int row, int col);
	
	boolean isCellFilled(ICell2 cell);
	
	int getCellValue(int row, int col);

	int getCellValue(ICell2 cell);
		
	IPlayer2 getCellOwner(int row, int col);

	IPlayer2 getCellOwner(ICell2 cell);

	void setCellOwner(IPlayer2 player, int row, int col);

	void setCellOwner(IPlayer2 player, ICell2 cell);
	
	void setBorder(int borderNr, boolean fillBorder, int row, int col);

	void setBorder(int borderNr, boolean fillBorder, ICell2 cell);
	
	boolean getBorder(int borderNr, int row, int col);

	boolean getBorder(int borderNr, ICell2 cell);
		
	int getCellSize(int row, int col);

	int getCellSize(ICell2 cell);

	void setCellSize(int size, int row, int col);

	void setCellSize(int size, ICell2 cell);
	
	char[][] getCharArray(int row, int col);

	char[][] getCharArray(ICell2 cell);
	
	void setCharArray(char[][] charArray, ICell2 cell);

	void setCharArray(char[][] charArray, int row, int col);

//methods for IGameSettings

	IPlayer2 getPlayer(int playerNumber);
	
	void setPlayer(IPlayer2 player, int numberOfPlayer);
	
	void setWhoseTurnItIs(IPlayer2 player);
	
	IPlayer2 getWhoseTurnItIs();
	
	void changeTurn();
	
	IPlayer2 getWinner();
	
	void setWinner(IPlayer2 player);


//methods for IPlayer2

	void setPlayerHuman(boolean isHuman, IPlayer2 player);
	
	boolean isPlayerAHuman(IPlayer2 player);
	
	int getNumberOfPoints(IPlayer2 player);
	
	void addPointsToPlayersAccount(int newPoints, IPlayer2 player);
	
	void setPlayersName(String name, IPlayer2 player);
	
	String getPlayersName(IPlayer2 player);

	
}
