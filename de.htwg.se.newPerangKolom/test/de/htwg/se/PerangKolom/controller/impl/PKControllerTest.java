package de.htwg.se.PerangKolom.controller.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.PerangKolom.controller.IPKController;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.impl.Cell2;
import de.htwg.se.PerangKolom.model.impl.Grid;

public class PKControllerTest {

	IPKController contr;
	Grid grid;
	ICell2[][] array;
	ICell2 cell;
	
	@Before
	public void setUp() throws Exception {
		contr = new PKController();
		grid = Grid.getInstance();
		array = grid.getCellArray();
		cell = array[0][0];
		
	}

	@Test
	public void testGetInstance() {
		assertNotNull(contr.getInstance());
		assertEquals(grid, contr.getInstance());
	}

	@Test
	public void testGetCellArray() {
		assertNotNull(array);
		assertArrayEquals(array, contr.getCellArray());
	}

	@Test
	public void testGetNumberOfRows() {
		grid.setNumberOfRows(123);
		assertEquals(123, contr.getNumberOfRows());
	}

	@Test
	public void testSetNumberOfRows() {
		contr.setNumberOfRows(123);
		assertEquals(123, contr.getNumberOfRows());
	}

	@Test
	public void testGetNumberOfCols() {
		contr.setNumberOfCols(123);
		assertEquals(123, contr.getNumberOfCols());
	}

	@Test
	public void testSetNumberOfCols() {
		contr.setNumberOfCols(123);
		assertEquals(123, contr.getNumberOfCols());
	}

	@Test
	public void testGetCell() {
		assertNotNull(contr.getInstance().getCell(1, 1));
		ICell2[][] array = contr.getCellArray();
		Cell2 cell = new Cell2(99, 99);
		array[2][2] = cell;
		assertEquals(cell, contr.getCell(2, 2));
	}

	@Test
	public void testIsCellFilled() {
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		assertTrue(contr.isCellFilled());
		
		cell.setBorder(Cell2.BORDER_LEFT, false);
		assertFalse(contr.isCellFilled());
		
		cell.setBorder(Cell2.BORDER_LEFT, true);
		assertTrue(contr.isCellFilled());
	}

	@Test
	public void testGetCellValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCellOwner() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCellOwner() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBorder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBorder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCellSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCellSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCharArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCharArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWhoseTurnItIs() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWhoseTurnItIs() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeTurn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWinner() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWinner() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlayerHuman() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsPlayerAHuman() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberOfPoints() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPointsToPlayersAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlayersName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayersName() {
		fail("Not yet implemented");
	}

}
