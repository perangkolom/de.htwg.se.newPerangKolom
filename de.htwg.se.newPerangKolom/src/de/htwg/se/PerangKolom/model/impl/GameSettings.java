package de.htwg.se.PerangKolom.model.impl;

import de.htwg.se.PerangKolom.model.AbstractGameSettings;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.Player2;

public class GameSettings extends AbstractGameSettings {
	
	private static GameSettings instance;
	
	private GameSettings() {
		setPlayer(new Player2(), 1);
		setPlayer(new Player2(), 2);
		setWhoseTurnItIs(getPlayer(1));		
	}
	
	
	public static GameSettings getInstance() {
		if (instance == null) {
			instance = new GameSettings();
		}
		return instance;
	}

}
