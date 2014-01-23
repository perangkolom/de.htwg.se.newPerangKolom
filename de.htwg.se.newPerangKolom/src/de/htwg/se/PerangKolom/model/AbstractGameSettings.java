package de.htwg.se.PerangKolom.model;

public abstract class AbstractGameSettings implements IGameSettings {
	
	//data concerning players
	private static IPlayer2 player1;
	private static IPlayer2 player2;
	private static IPlayer2 playerWhoseTurnItIs = player1;
	private static IPlayer2 winner;
	
	
	//data concerning grid
	private static int cellSize;
	private static int gridSize;
	
	
	@Override
	public IPlayer2 getPlayer(int playerNr) {
		if (playerNr == 1) {
			return player1;
		} 
		else {
			return player2;
		}
	}


	@Override
	public int getGridSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setGridSize(int size) {
		// TODO Auto-generated method stub
		
	}
	
	


}
