package de.htwg.se.PerangKolom.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.PerangKolom.model.impl.Cell;

public class CellTest {
	
	Cell cell1;
	
	@Before 
	public void setUp() {
		cell1 = new Cell(10, 20, 30);
	}
	
	

	@Test
	public void testCell() {
		assertEquals(1, new Cell(1, 2, 10).getPositionX());
		assertEquals(5, new Cell(2, 5, 11).getPositionY());
		assertEquals(12, new Cell(1, 1, 12).getCellValue());
	}
	
	
 
	@Test
	public void testGetPositionX() {
		assertEquals(5, new Cell(5, 0, 0).getPositionX());
		assertEquals(7, new Cell(7, 0, 0).getPositionX());
	}


	@Test
	public void testGetPositionY() {
		assertEquals(5, new Cell(0, 5, 0).getPositionY());
		assertEquals(7, new Cell(0, 7, 0).getPositionY());
	}

	@Test
	public void testIsCellFilled() {
		assertFalse(new Cell(5, 7, 0).isCellFilled());
		assertFalse(new Cell(78, 33, 55).isCellFilled());
	}

	@Test
	public void testSetCellFilled() {
		cell1.setCellFilled(true);
		assertTrue(cell1.isCellFilled());
	}

	@Test
	public void testGetCellValue() {
		assertEquals(5, new Cell(11,22,5).getCellValue());
	}

	@Test
	public void testGetCellOwner() {
		cell1.setCellOwner("Bobo");
		assertEquals("Bobo", cell1.getCellOwner());
	}

	@Test
	public void testSetCellOwner() {
		cell1.setCellOwner("Bobo");
		assertEquals("Bobo" , cell1.getCellOwner());
	}

	
	
//	@Test
//	public void testGetCellBorder_top() {
//		Border a = CellBorderMethod(true, true);
//		cell1.setCellBorder_top(a);
//		assertNotNull(a);
//		assertEquals(a, cell1.getCellBorder_top());
//	}
//
//	@Test
//	public void testSetCellBorder_top() {
//		Border a = CellBorderMethod(true, true);
//		cell1.setCellBorder_top(a);
//		assertNotNull(a);
//		assertEquals(a, cell1.getCellBorder_top());
//	}


}
