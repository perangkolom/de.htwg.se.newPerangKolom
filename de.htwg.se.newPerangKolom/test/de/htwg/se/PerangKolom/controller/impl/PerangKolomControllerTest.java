//package de.htwg.se.PerangKolom.controller.impl;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.TreeSet;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import de.htwg.se.PerangKolom.model.impl.Cell;
//import de.htwg.se.PerangKolom.model.impl.CellArray;
//
//public class PerangKolomControllerTest {
//
//	PerangKolomController controller;
//	public TreeSet<Cell> CellArraySet;
//	Cell[][] cellArray;
//	Cell cell;
//
//	@Before
//	public void setUp() {
//		controller = new PerangKolomController();
//		CellArraySet = new TreeSet<Cell>();
//		cellArray = CellArray.getInstance().getCellArray();
//		cell = new Cell(1, 1);
//
//	}
//	
//
//	@Test
//	public void testGetController() {
//		controller = new PerangKolomController();
//		assertNotNull(controller);
//	}
//
//
//	@Test
//	public void testSetCellValue() {
//		controller.setCellValue(1, 1, 50);
//		//assertTrue(cellArray[1][1].getCellValue() == 50 && cellArray[1][1].getPositionX() == 1 && cellArray[1][1].getPositionY() == 1);
//
//
//	}
//	
//}
