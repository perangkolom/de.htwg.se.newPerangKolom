package de.htwg.se.PerangKolom.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.PerangKolom.model.ICell2;

public class CellArray2Test {

	CellArray2 test1;
	ICell2[][] array;
	
	@Before
	public void setUp() throws Exception {
		test1 = CellArray2.getInstance();
		array = test1.getCellArray();
	}

	@Test
	public void testGetInstance() {
		assertNotNull(CellArray2.getInstance());
		//assertEquals(test1, CellArray2.getInstance());
		
		for (int i = 0; i < CellArray2.getNumberOfRows(); i++) {
			for (int j = 0; j < CellArray2.getNumberOfCols(); j++) {
				assertNotNull(test1.getCellArray()[i][j]);
			}
		}
	}

	@Test
	public void testGetCellArray() {
		assertArrayEquals(array, test1.getCellArray());
		assertNotNull(array);
	}

	@Test
	public void testGetNumberOfRows() {
		CellArray2.setNumberOfRows(5);
		assertEquals(5, CellArray2.getNumberOfRows());
	}

	@Test
	public void testSetNumberOfRows() {
		CellArray2.setNumberOfRows(5);
		assertEquals(5, CellArray2.getNumberOfRows());
	}

	@Test
	public void testGetNumberOfCols() {
		CellArray2.setNumberOfCols(5);
		assertEquals(5, CellArray2.getNumberOfCols());
	}

	@Test
	public void testSetNumberOfCols() {
		CellArray2.setNumberOfCols(5);
		assertEquals(5, CellArray2.getNumberOfCols());
	}

	@Test
	public void testGetCell() {
		
		for (int i = 0; i < test1.getNumberOfRows(); i++) {
			for (int j = 0; j < test1.getNumberOfCols(); j++) {
				
				int tmp = i*5;
				array[i][j].setCellValue(tmp);
				assertEquals(tmp, array[i][j].getCellValue());
			}
		}
	}

}
