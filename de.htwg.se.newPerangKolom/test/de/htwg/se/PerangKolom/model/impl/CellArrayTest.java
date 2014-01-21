package de.htwg.se.PerangKolom.model.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.PerangKolom.model.impl.CellArray;

public class CellArrayTest {

	@Test
	public void testGetInstance() {
		assertNotNull(CellArray.getInstance());
	}
	
	@Test
	public void testCreateCellArray() {
		CellArray.createCellArray(2,3);
		assertNotNull(CellArray.getInstance());
		assertEquals(2, CellArray.getNumberOfRows());
		assertEquals(3, CellArray.getNumberOfColums());
		fail("die Funktion createCellArray hat folgendes Problem:"
				+ "wie berücksichtigen wir, dass die Parameter nur "
				+ "akzeptiert werden, wenn noch keine Instance vorhanden ist?");
	}
	
	@Test
	public void testGetNumberOfRows() {
		CellArray.createCellArray(2,3);
		assertEquals(2, CellArray.getNumberOfRows());
	}

	@Test
	public void testGetNumberOfColums() {
		CellArray.createCellArray(2,3);
		assertEquals(3, CellArray.getNumberOfColums());
	}

	@Test
	public void testGetSpecificCell() {
		/*fail("not yet able to give cells a specific value, thus we can't "
				+ "test for these values");
		*/
				
	}
	
	@Test
	public void testFillGameMatrix() {
		fail("how the hell can we test this?");		
	}
	
	@Test
	public void testPrintGameFieldString() {
		fail("how the hell can we test this?");
	}
}

