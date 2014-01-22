package de.htwg.se.PerangKolom.model.impl;

import de.htwg.se.PerangKolom.model.AbstractGameSettings;

public class GameSettings extends AbstractGameSettings {
	
	private static GameSettings instance;
	
	private GameSettings() {
		
	}
	
	public static GameSettings getInstance() {
		if (instance == null) {
			instance = new GameSettings();
		}
		return instance;
	}
	
}
