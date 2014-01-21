package de.htwg.se.PerangKolom.model.impl;

import de.htwg.se.PerangKolom.model.AbstractPlayer;

public class Player extends AbstractPlayer{

	public Player(String playerName, boolean isHuman) {

		setName(playerName);
		this.setPlayerHuman(isHuman);
	}



}
