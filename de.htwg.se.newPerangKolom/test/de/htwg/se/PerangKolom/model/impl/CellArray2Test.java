//package de.htwg.se.PerangKolom.model.impl;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import de.htwg.se.PerangKolom.model.ICell2;
//
//public class CellArray2Test {
//
//	Grid test1;
//	ICell2[][] array;
//	
//	@Before
//	public void setUp() throws Exception {
//		test1 = Grid.getInstance();
//		array = test1.getCellArray();
//	}
//
//	@Test
//	public void testGetInstance() {
//		assertNotNull(Grid.getInstance());
//		//assertEquals(test1, CellArray2.getInstance());
//		
//		for (int i = 0; i < Grid.getNumberOfRows(); i++) {
//			for (int j = 0; j < Grid.getNumberOfCols(); j++) {
//				assertNotNull(test1.getCellArray()[i][j]);
//			}
//		}
//	}
//
//	@Test
//	public void testGetCellArray() {
//		assertArrayEquals(array, test1.getCellArray());
//		assertNotNull(array);
//	}
//
//	@Test
//	public void testGetNumberOfRows() {
//		Grid.setNumberOfRows(5);
//		assertEquals(5, Grid.getNumberOfRows());
//	}
//
//	@Test
//	public void testSetNumberOfRows() {
//		Grid.setNumberOfRows(5);
//		assertEquals(5, Grid.getNumberOfRows());
//	}
//
//	@Test
//	public void testGetNumberOfCols() {
//		Grid.setNumberOfCols(5);
//		assertEquals(5, Grid.getNumberOfCols());
//	}
//
//	@Test
//	public void testSetNumberOfCols() {
//		Grid.setNumberOfCols(5);
//		assertEquals(5, Grid.getNumberOfCols());
//	}
//
//	@Test
//	public void testGetCell() {
//		
//		for (int i = 0; i < Grid.getNumberOfRows(); i++) {
//			for (int j = 0; j < Grid.getNumberOfCols(); j++) {
//				
//				int tmp = i*5;
//				array[i][j].setCellValue(tmp);
//				assertEquals(tmp, array[i][j].getCellValue());
//			}
//		}
//	}
//
//}
