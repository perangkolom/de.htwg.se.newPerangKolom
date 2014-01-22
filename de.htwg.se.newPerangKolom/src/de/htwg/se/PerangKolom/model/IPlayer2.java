package de.htwg.se.PerangKolom.model;

public interface IPlayer2 {
	
	boolean isPlayerAHuman();
	
	IPlayer2 whoseTurnIsIt();
	
	void changeWhoseTurnItIs();
	
	public int getNumberOfPoints();
	
	public int addPointsToPlayersAccount();	
	
	
	 
}
