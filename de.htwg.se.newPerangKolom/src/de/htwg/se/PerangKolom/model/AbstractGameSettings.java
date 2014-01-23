package de.htwg.se.PerangKolom.model;

public abstract class AbstractGameSettings implements IGameSettings {
	
	//data concerning players
	private IPlayer2 player1;
	private IPlayer2 player2;
	private IPlayer2 playerWhoseTurnItIs;
	private IPlayer2 winner;
	
	
	@Override
	public IPlayer2 getPlayer(int playerNumber) {
		
		if (playerNumber == 1) {
			return player1; 
		} else {
			return player2;
		}
	}


	@Override
	public void setPlayer(IPlayer2 player, int numberOfPlayer) {
		if (numberOfPlayer ==1 ) {
			player1 = player; 
		} else {
			player2 = player;
		}		
	}
	
	
	@Override
	public IPlayer2 getWhoseTurnItIs() {
		return playerWhoseTurnItIs;
	}
	
	
	@Override
	public void setWhoseTurnItIs(IPlayer2 player) {
		playerWhoseTurnItIs = player;
	}
	
	
	@Override
	public void changeTurn() {
		
		if (playerWhoseTurnItIs == player1) {
			playerWhoseTurnItIs = player2;
		} else {
			playerWhoseTurnItIs = player1;
		}
	}
	

	@Override
	public IPlayer2 getWinner() {
		return winner;
	}


	@Override
	public void setWinner(IPlayer2 player) {
		winner = player;
	}
}
