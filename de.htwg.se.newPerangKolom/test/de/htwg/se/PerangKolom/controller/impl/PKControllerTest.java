package de.htwg.se.PerangKolom.controller.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.PerangKolom.controller.IPKController;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.Cell2;
import de.htwg.se.PerangKolom.model.impl.Grid;
import de.htwg.se.PerangKolom.model.impl.Player2;

public class PKControllerTest {

	IPKController contr;
	Grid grid;
	ICell2[][] array;
	ICell2 cell;
	int ROW;
	int COL;
	IPlayer2 player;
	
	@Before
	public void setUp() throws Exception {
		contr = new PKController();
		grid = Grid.getInstance();
		array = grid.getCellArray();
		ROW = 0;
		COL = 0;
		cell = array[ROW][COL];
		player = new Player2();
		
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
	public void testGetCellIntInt() {
		assertNotNull(contr.getInstance().getCell(1, 1));
		ICell2[][] array = contr.getCellArray();
		Cell2 cell = new Cell2(99, 99);
		array[2][2] = cell;
		assertEquals(cell, contr.getCell(2, 2));
	}

	@Test
	public void testIsCellFilledCell2() {
		
		assertFalse(contr.isCellFilled(cell));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		assertTrue(contr.isCellFilled(cell));
		
		cell.setBorder(Cell2.BORDER_LEFT, false);
		assertFalse(contr.isCellFilled(cell));
		
		cell.setBorder(Cell2.BORDER_LEFT, true);
		assertTrue(contr.isCellFilled(cell));
	}


	@Test
	public void testIsCellFilledIntInt() {
		
		assertFalse(contr.isCellFilled(ROW, COL));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		assertTrue(contr.isCellFilled(ROW, COL));
		
		cell.setBorder(Cell2.BORDER_LEFT, false);
		assertFalse(contr.isCellFilled(ROW, COL));
		
		cell.setBorder(Cell2.BORDER_LEFT, true);
		assertTrue(contr.isCellFilled(ROW, COL));
	}

	
	@Test
	public void testGetCellValueIntInt() {
		cell.setCellValue(3200);
		assertEquals(3200, contr.getCellValue(ROW, COL));
		assertEquals(3200, contr.getCellValue(ROW, COL));;
	}

	
	@Test
	public void testGetCellValueICell2() {
		cell.setCellValue(3200);
		assertEquals(3200, contr.getCellValue(cell));
		assertEquals(3200, contr.getCellValue(cell));
	}


	@Test
	public void testGetCellOwnerIntInt() {
		cell.setCellOwner(player);
		assertEquals(player, contr.getCellOwner(ROW, COL));
	}

	@Test
	public void testGetCellOwnerICell2() {
		cell.setCellOwner(player);
		assertEquals(player, contr.getCellOwner(cell));
	}

	@Test
	public void testSetCellOwnerIPlayer2IntInt() {
		contr.setCellOwner(player, ROW, COL);
		assertEquals(player, cell.getCellOwner());
	}

	
	@Test
	public void testSetCellOwnerIPlayer2ICell2() {
		contr.setCellOwner(player, cell);
		assertEquals(player, cell.getCellOwner());
	}

	@Test
	public void testSetBorderIntBooleanIntInt() {
		contr.setBorder(Cell2.BORDER_BOTTOM, true, ROW, COL);
		assertTrue(cell.getBorder(Cell.BORDER_BOTTOM));
		
		contr.setBorder(Cell2.BORDER_BOTTOM, false, ROW, COL);
		assertFalse(cell.getBorder(Cell.BORDER_BOTTOM));
		
		contr.setBorder(Cell2.BORDER_RIGHT, true, ROW, COL);
		assertTrue(cell.getBorder(Cell.BORDER_RIGHT));
		
		contr.setBorder(Cell2.BORDER_BOTTOM, false, ROW, COL);
		assertFalse(cell.getBorder(Cell.BORDER_RIGHT));
	}

	@Test
	public void testSetBorderIntBooleanICell2() {
		contr.setBorder(Cell2.BORDER_BOTTOM, true, cell);
		assertTrue(cell.getBorder(Cell.BORDER_BOTTOM));
		
		contr.setBorder(Cell2.BORDER_BOTTOM, false, cell);
		assertFalse(cell.getBorder(Cell.BORDER_BOTTOM));
		
		contr.setBorder(Cell2.BORDER_RIGHT, true, cell);
		assertTrue(cell.getBorder(Cell.BORDER_RIGHT));
		
		contr.setBorder(Cell2.BORDER_BOTTOM, false, cell);
		assertFalse(cell.getBorder(Cell.BORDER_RIGHT));
	}

	@Test
	public void testGetBorderIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBorderIntICell2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCellSizeIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCellSizeICell2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCellSizeIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCellSizeIntICell2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCharArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCharArrayICell2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCharArrayCharArrayArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCharArrayCharArrayArrayICell2() {
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
