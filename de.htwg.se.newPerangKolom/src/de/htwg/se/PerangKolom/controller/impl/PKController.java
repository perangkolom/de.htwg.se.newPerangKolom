package de.htwg.se.PerangKolom.controller.impl;

import de.htwg.se.PerangKolom.controller.IPKController;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.Grid;
import de.htwg.se.PerangKolom.util.observer.Event;
import de.htwg.se.PerangKolom.util.observer.IObserver;

public class PKController implements IPKController{

	@Override
	public void addObserver(IObserver s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(IObserver s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllObservers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers(Event e) {
		//TODO Auto-generated method stub
		
	}

	@Override
	public Grid getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICell2[][] getCellArray() {
		// TODO Auto-generated method stub
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
	public boolean isCellFilled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCellValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IPlayer2 getCellOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCellOwner(IPlayer2 player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBorder(int borderNr, boolean fillBorder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getBorder(int borderNr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCellSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCellSize(int size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char[][] getCharArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCharArray(char[][] charArray) {
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
	public void setPlayerHuman(boolean isHuman) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPlayerAHuman() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addPointsToPlayersAccount(int newPoints) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayersName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPlayersName() {
		// TODO Auto-generated method stub
		return null;
	}

}
