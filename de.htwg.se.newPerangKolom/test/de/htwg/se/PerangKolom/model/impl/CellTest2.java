package de.htwg.se.PerangKolom.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.impl.Cell2;
import de.htwg.se.PerangKolom.model.IPlayer2;
import de.htwg.se.PerangKolom.model.impl.Player2;
import de.htwg.se.PerangKolom.model.impl.Grid;



public class CellTest2 {
	
	ICell2 cell;
	IPlayer2 player;
	ICell2[][] array;

	@Before
	public void setUp() throws Exception {
		 cell = new Cell2(0, 0);
		 player = new Player2();
		 array = Grid.getInstance().getCellArray();
	}
	
	
	@Test
	public void testCell() {
		ICell2 tmp = new Cell2(3,3);
		assertNotNull(tmp);
	}

	@Test
	public void testGetPositionX() {
		assertEquals(0, new Cell2( 0, 0).getPositionX());
		assertEquals(2, new Cell2( 2, 0).getPositionX());
	}

	@Test
	public void testGetPositionY() {
		assertEquals(5, new Cell2( 0, 5).getPositionY());
		assertEquals(0, new Cell2( 2, 0).getPositionY());
	}

	@Test
	public void testIsCellFilled() {
		assertFalse(cell.isCellFilled());
		//cell.setCellFilled(true);
		cell.setBorder(Cell2.BORDER_BOTTOM,true);
		cell.setBorder(Cell2.BORDER_LEFT,true);
		cell.setBorder(Cell2.BORDER_RIGHT,true);
		cell.setBorder(Cell2.BORDER_TOP,true);
		
		assertTrue(cell.isCellFilled());
	}

//	@Test
//	public void testSetCellFilled() {
//		cell.setCellFilled(true);
//		assertTrue(cell.isCellFilled());
//		cell.setCellFilled(false);
//		assertFalse(cell.isCellFilled());
//		cell.setCellFilled(true);
//		assertTrue(cell.isCellFilled());
//	}

	
	@Test
	public void testGetCellValue() {
		
		final int LOOP_REPETITIONS = 100;
		int value = 0;
		ICell2 tmp;
		
		for ( int i = 0; i < LOOP_REPETITIONS; i++) {
		
			boolean isInRange = false;
			tmp = new Cell2(3,3);
			value = tmp.getCellValue();
			
			if ( value >= 25 && value <= 100 ) {
				isInRange = true;
			}

			assertTrue(isInRange);
		}
		
		//second Test
		cell.setCellValue(3200);
		assertEquals(3200, cell.getCellValue(), 0);
	}

	
	@Test
	public void testSetCellValue() {
		cell.setCellValue(44);
		assertEquals(44, cell.getCellValue());
	}

	
	@Test
	public void testGetCellOwner() {
		assertNull(cell.getCellOwner());
		cell.setCellOwner(player);
		assertEquals(player, cell.getCellOwner());
	}

	
	@Test
	public void testSetCellOwner() {
		cell.setCellOwner(player);
		assertEquals(player, cell.getCellOwner());
	}

	
	@Test
	public void testGetNumberOfFilledBorders() {
		assertEquals(0, cell.getNumberOfFilledBorders());
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		assertEquals(1, cell.getNumberOfFilledBorders());
		
		assertEquals(1, cell.getNumberOfFilledBorders());
		
		cell.setBorder(Cell2.BORDER_LEFT, true);
		assertEquals(2, cell.getNumberOfFilledBorders());
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		assertEquals(2, cell.getNumberOfFilledBorders());
	}

	
	@Test
	public void testSetBorder() {
		assertFalse(cell.getBorder(Cell2.BORDER_BOTTOM));
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		assertTrue(cell.getBorder(Cell2.BORDER_BOTTOM));
	}

	
	@Test
	public void testGetBorder() {
		assertFalse(cell.getBorder(Cell2.BORDER_BOTTOM));
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		assertTrue(cell.getBorder(Cell2.BORDER_BOTTOM));	
	}

	
	@Test
	public void testMakeRandomNumber() {
		
		final int LOOP_REPETITIONS = 100;
		int value = 0;
		
		for ( int i = 0; i < LOOP_REPETITIONS; i++) {
		
			value = cell.makeRandomNumber();
			boolean isInRange = false;
			
			if ( value >= 25 && value <= 100 ) {
				isInRange = true;
			}
			
			assertTrue(isInRange);
		}
	}

}
