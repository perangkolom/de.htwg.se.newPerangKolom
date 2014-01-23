package de.htwg.se.PerangKolom.controller.impl;

import de.htwg.se.PerangKolom.controller.IPKController;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.Grid;
import de.htwg.se.PerangKolom.util.observer.Event;
import de.htwg.se.PerangKolom.util.observer.IObserver;
import de.htwg.se.PerangKolom.util.observer.Observable;

public class PKController extends Observable implements IPKController{

	@Override
	public Grid getInstance() {
		return Grid.getInstance();
	}

	@Override
	public ICell2[][] getCellArray() {
		return null;
	}

	@Override
	public int getNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNumberOfRows(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumberOfCols() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNumberOfCols(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ICell2 getCell(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellFilled(int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCellFilled(ICell2 cell) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCellValue(int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCellValue(ICell2 cell) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IPlayer2 getCellOwner(int row, int col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPlayer2 getCellOwner(ICell2 cell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCellOwner(IPlayer2 player, int row, int col) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCellOwner(IPlayer2 player, ICell2 cell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBorder(int borderNr, boolean fillBorder, int row, int col) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBorder(int borderNr, boolean fillBorder, ICell2 cell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getBorder(int borderNr, int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getBorder(int borderNr, ICell2 cell) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCellSize(int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCellSize(ICell2 cell) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCellSize(int size, int row, int col) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCellSize(int size, ICell2 cell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char[][] getCharArray(int row, int col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[][] getCharArray(ICell2 cell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCharArray(char[][] charArray, int row, int col) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharArray(char[][] charArray, ICell2 cell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IPlayer2 getPlayer(int playerNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayer(IPlayer2 player, int numberOfPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWhoseTurnItIs(IPlayer2 player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IPlayer2 getWhoseTurnItIs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IPlayer2 getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWinner(IPlayer2 player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerHuman(boolean isHuman, IPlayer2 player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPlayerAHuman(IPlayer2 player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfPoints(IPlayer2 player) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addPointsToPlayersAccount(int newPoints, IPlayer2 player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayersName(String name, IPlayer2 player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPlayersName(IPlayer2 player) {
		// TODO Auto-generated method stub
		return null;
	}

}