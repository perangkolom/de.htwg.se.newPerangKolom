package de.htwg.se.PerangKolom.model;

public class AbstractPlayer2 implements IPlayer2 {

	private String nameOfPlayer;
	private char playersTuiChar;
	private boolean isHuman;
	private int sumOfPoints;
	

	@Override
	public void setPlayerHuman(boolean isHuman) {
		if (isHuman == true) {
			isHuman = true;
		} 
		else {
			isHuman = false;
		}	
	}	
			
	
	@Override
	public boolean isPlayerAHuman() {
		return isHuman;
	}

	
	@Override
	public int getNumberOfPoints() {
		return sumOfPoints;
	}

	
	@Override
	public void addPointsToPlayersAccount(int newPoints) {
		sumOfPoints += newPoints;
	}
	
}
