package de.htwg.se.PerangKolom.model.impl;

import static org.junit.Assert.*;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.Player2;

import org.junit.Before;
import org.junit.Test;

public class Player2Test {

	IPlayer2 player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player2();
	}

	
	@Test
	public void testPlayer2() {
		assertNotNull(player);
		assertEquals(0, player.getNumberOfPoints());
		assertNull(player.getPlayersName());
	}

	
	@Test
	public void testSetPlayerHuman() {
		player.setPlayerHuman(true);
		assertTrue(player.isPlayerAHuman());
	}

	
	@Test
	public void testIsPlayerAHuman() {
		player.setPlayerHuman(true);
		assertTrue(player.isPlayerAHuman());
		player.setPlayerHuman(false);
		assertFalse(player.isPlayerAHuman());

	}
	

	@Test
	public void testGetNumberOfPoints() {
		assertEquals(0, player.getNumberOfPoints());
		player.addPointsToPlayersAccount(999);
		assertEquals(999, player.getNumberOfPoints());
	}

	
	@Test
	public void testAddPointsToPlayersAccount() {
		player.addPointsToPlayersAccount(999);
		assertEquals(999, player.getNumberOfPoints());
		player.addPointsToPlayersAccount(100);
		assertEquals(1099, player.getNumberOfPoints());
	}

	
	@Test
	public void testSetPlayersName() {
		
	}

	
	@Test
	public void testGetPlayersName() {
		assertNull(player.getPlayersName());
		String name = "justaTestName";
		player.setPlayersName(name);
		assertEquals(name, player.getPlayersName());
		player.setPlayersName("hallo");
		assertEquals("hallo", player.getPlayersName());
	}

}
