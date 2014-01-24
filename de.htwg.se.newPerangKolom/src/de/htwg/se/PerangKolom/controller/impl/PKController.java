package de.htwg.se.PerangKolom.controller.impl;

import de.htwg.se.PerangKolom.controller.IPKController;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.GameSettings;
import de.htwg.se.PerangKolom.model.impl.Grid;
import de.htwg.se.PerangKolom.util.observer.Observable;

public class PKController extends Observable implements IPKController {

	@Override
	public Grid getInstance() {
		return Grid.getInstance();
	}

	@Override
	public ICell2[][] getCellArray() {
		return Grid.getInstance().getCellArray();
	}

	@Override
	public int getNumberOfRows() {
		return Grid.getNumberOfRows();
	}

	@Override
	public void setNumberOfRows(int x) {
		Grid.setNumberOfRows(x);
	}

	@Override
	public int getNumberOfCols() {
		return Grid.getNumberOfCols();
	}

	@Override
	public void setNumberOfCols(int y) {
		Grid.setNumberOfCols(y);
		
	}

	@Override
	public ICell2 getCell(int x, int y) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		return array[x][y]; 
	}
	
	@Override
	public boolean isCellFilled(int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		return array[row][col].isCellFilled();
	}

	@Override
	public boolean isCellFilled(ICell2 cell) {
		return cell.isCellFilled();
	}

	@Override
	public int getCellValue(int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		return array[row][col].getCellValue();
		
	}

	@Override
	public int getCellValue(ICell2 cell) {
		return cell.getCellValue();
	}

	@Override
	public IPlayer2 getCellOwner(int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		return array[row][col].getCellOwner();
	}

	@Override
	public IPlayer2 getCellOwner(ICell2 cell) {
		return cell.getCellOwner();
	}

	@Override
	public void setCellOwner(IPlayer2 player, int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		array[row][col].setCellOwner(player);
	}

	@Override
	public void setCellOwner(IPlayer2 player, ICell2 cell) {
		cell.setCellOwner(player);
	}

	@Override
	public void setBorder(int borderNr, boolean fillBorder, int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		array[row][col].setBorder(borderNr, fillBorder);
	}

	@Override
	public void setBorder(int borderNr, boolean fillBorder, ICell2 cell) {
		cell.setBorder(borderNr, fillBorder);
	}
 
	@Override
	public boolean getBorder(int borderNr, int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		return array[row][col].getBorder(borderNr);
	}

	@Override
	public boolean getBorder(int borderNr, ICell2 cell) {
		return cell.getBorder(borderNr);
	}

	@Override
	public int getCellSize(int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		return array[row][col].getCellSize();
	}

	@Override
	public int getCellSize(ICell2 cell) {
		return cell.getCellSize();
	}

	@Override
	public void setCellSize(int size, int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		array[row][col].setCellSize(size);
	}

	@Override
	public void setCellSize(int size, ICell2 cell) {
		cell.setCellSize(size);
	}

	@Override
	public char[][] getCharArray(int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		return array[row][col].getCharArray();
	}

	@Override
	public char[][] getCharArray(ICell2 cell) {
		return cell.getCharArray();
	}

	@Override
	public void setCharArray(char[][] charArray, int row, int col) {
		ICell2[][] array = Grid.getInstance().getCellArray();
		array[row][col].setCharArray(charArray);
	}

	@Override
	public void setCharArray(char[][] charArray, ICell2 cell) {
		cell.setCharArray(charArray);
	}

	@Override
	public IPlayer2 getPlayer(int playerNumber) {
		return GameSettings.getPlayer(playerNumber);
	}

	@Override
	public void setPlayer(IPlayer2 player, int numberOfPlayer) {
		GameSettings.setPlayer(player, numberOfPlayer);
	}

	@Override
	public void setWhoseTurnItIs(IPlayer2 player) {
		GameSettings.setWhoseTurnItIs(player);
	}

	@Override
	public IPlayer2 getWhoseTurnItIs() {
		return GameSettings.getWhoseTurnItIs();
	}

	@Override
	public void changeTurn() {
		GameSettings.changeTurn();
	}

	@Override
	public IPlayer2 getWinner() {
		return GameSettings.getWinner();
	}

	@Override
	public void setWinner(IPlayer2 player) {
		GameSettings.setWinner(player);
	}

	@Override
	public void setPlayerHuman(boolean isHuman, IPlayer2 player) {
		IPlayer2 tmp = GameSettings.getPlayer(player);
		tmp.setPlayerHuman(isHuman);
	}

	@Override
	public boolean isPlayerAHuman(IPlayer2 player) {
		return player.isPlayerAHuman();
	}

	@Override
	public int getNumberOfPoints(IPlayer2 player) {
		return player.getNumberOfPoints();
	}

	@Override
	public void addPointsToPlayersAccount(int newPoints, IPlayer2 player) {
		player.addPointsToPlayersAccount(newPoints);
	}

	@Override
	public void setPlayersName(String name, IPlayer2 player) {
		player.setPlayersName(name);
	}

	@Override
	public String getPlayersName(IPlayer2 player) {
		return player.getPlayersName();
	}

}

