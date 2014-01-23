package de.htwg.se.PerangKolom.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.PerangKolom.model.IPlayer2;

public class GameSettingsTest {

	GameSettings settings;
	IPlayer2 p1;
	IPlayer2 p2;
	
	
	@Before
	public void setUp() throws Exception {
		settings = GameSettings.getInstance();
		
		p1 = new Player2();
		p1.setPlayersName("mrOne");
		settings.setPlayer(p1, 1);
		
		p2= new Player2();
		p2.setPlayersName("mrTwo");
		settings.setPlayer(p2, 2);
	}

	
	@Test
	public void testGetInstance() {
		assertNotNull(settings);
		assertNotNull(settings.getPlayer(1));
		assertNotNull(settings.getPlayer(2));
	}


	@Test
	public void testGetPlayer() {
		assertEquals(p1, settings.getPlayer(1));
		assertEquals(p2, settings.getPlayer(2));
	}
	

	@Test
	public void testGetWhoseTurnIsIt() {
		settings.setWhoseTurnItIs(p1);
		assertEquals(p1, settings.getWhoseTurnItIs());
		settings.changeTurn();
		assertEquals(p2, settings.getWhoseTurnItIs());
	}

	
	@Test
	public void testSetWhoseTurnItIs() {
		settings.setWhoseTurnItIs(p1);
		assertEquals(p1, settings.getWhoseTurnItIs());
		settings.changeTurn();
		settings.setWhoseTurnItIs(p1);
		assertEquals(p1, settings.getWhoseTurnItIs());
		settings.setWhoseTurnItIs(p2);
		assertEquals(p2, settings.getWhoseTurnItIs());
	}

	
	@Test
	public void testChangeTurn() {
		settings.setWhoseTurnItIs(p1);
		assertEquals(p1, settings.getWhoseTurnItIs());
		settings.changeTurn();
		assertEquals(p2, settings.getWhoseTurnItIs());
		settings.changeTurn();
		assertEquals(p1, settings.getWhoseTurnItIs());
	}


	@Test
	public void testGetWinner() {
		settings.setWinner(p1);
		assertEquals(p1, settings.getWinner());
		settings.setWinner(p2);
		assertEquals(p2, settings.getWinner());
	}

	@Test
	public void testSetWinner() {
		settings.setWinner(p1);
		assertEquals(p1, settings.getWinner());
		settings.setWinner(p2);
		assertEquals(p2, settings.getWinner());
	}

}
