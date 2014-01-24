package de.htwg.se.PerangKolom.model.KI;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.PerangKolom.controller.impl.PerangKolomController;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.KI.impl.KIChose;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.Cell2;
import de.htwg.se.PerangKolom.model.impl.CellArray;

public class KIChoseTest {

	IKIChose ikiChose;
	ICell2 cell;
	TreeSet<Cell> cellArraySet;

	@Before
	public void setUp() {
		ikiChose = new KIChose();
		cell = new Cell2(1, 1);
		cellArraySet = new TreeSet<Cell>();;

	}
	
	@Test
	public void testComputerLogic(){
//
//		List<Cell> CellSetBufferWithThreeBorders = new ArrayList<Cell>();
//		List<Cell> CellSetBufferLessThanTwoBorders = new ArrayList<Cell>();
//		List<Cell> CellSetBufferWithTwoBorder = new ArrayList<Cell>();
		
		/* test first case --> 3 Border filled */
//		cell = cellArray[0][0];

//		cell.setBorder(cell.BORDER_TOP, true);
//		cell.setBorder(cell.BORDER_RIGHT, true);
//		cell.setBorder(cell.BORDER_BOTTOM, true);
//		cell.setBorder(cell.BORDER_LEFT, false);


		//cell.setCellBorder_left(cell.getCellBorder_left());
		
//		b.setBorderFilled(true);
//		r.setBorderFilled(true);
//		t.setBorderFilled(true);
//		l.setBorderFilled(false);
//		assertTrue(cell.getNumberOfFilledBorders() == 3);
		
		
		/***************************/
		
//		ikiChose.ComputerLogic();
//		assertTrue(!CellSetBufferWithThreeBorders.isEmpty());
		
	}
	
	@Test
	public void testClosePossibleBorderAlgo(){
		
		List<ICell2> CellSetBufferWithThreeBorders = new ArrayList<ICell2>();

		/* case Border LEFT */
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferWithThreeBorders.add(cell);
		ikiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_LEFT));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		ikiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_LEFT));
		
		/* case Border BOTTOM */
		cell.setBorder(Cell2.BORDER_BOTTOM, false);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		ikiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_BOTTOM));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		ikiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_BOTTOM));
		
		/* case Border RIGHT */
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, false);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		ikiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_RIGHT));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		ikiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_RIGHT));
		
		/* case Border TOP */
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, false);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		ikiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_TOP));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		ikiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_TOP));
		
	}
	@Test
	public void testNotPutForwardAlgo(){
		List<ICell2> CellSetBufferLessThanTwoBorders = new ArrayList<ICell2>();
		
		cell.setBorder(Cell2.BORDER_BOTTOM, false);
		cell.setBorder(Cell2.BORDER_RIGHT, false);
		cell.setBorder(Cell2.BORDER_TOP, false);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_BOTTOM));
		
		/* case border BOTTOM */
		cell.setBorder(Cell2.BORDER_BOTTOM, false);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, false);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_BOTTOM));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, false);
		cell.setBorder(Cell2.BORDER_RIGHT, false);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_BOTTOM));
	
		cell.setBorder(Cell2.BORDER_BOTTOM, false);
		cell.setBorder(Cell2.BORDER_RIGHT, false);
		cell.setBorder(Cell2.BORDER_TOP, false);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_BOTTOM));
		
		/* case border RIGHT */
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, false);
		cell.setBorder(Cell2.BORDER_TOP, false);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_RIGHT));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, false);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_RIGHT));
		
		/* case border TOP */
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, false);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_TOP));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_TOP));

		/* case border LEFT */
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_LEFT));
		
		cell.setBorder(Cell2.BORDER_BOTTOM, true);
		cell.setBorder(Cell2.BORDER_RIGHT, true);
		cell.setBorder(Cell2.BORDER_TOP, true);
		cell.setBorder(Cell2.BORDER_LEFT, true);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		ikiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(Cell2.BORDER_LEFT));

	
	}
	@Test
	public void testSacrificeLowestValueAlgo(){
		
	}



}
