package de.htwg.se.PerangKolom.model.KI;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.PerangKolom.controller.impl.PerangKolomController;
import de.htwg.se.PerangKolom.model.KI.impl.KIChose;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.CellArray;

public class KIChoseTest {

	KIChose kiChose;
	Cell cell;

	@Before
	public void setUp() {
		kiChose = new KIChose();
		cell = new Cell(1, 1);

	}
	
	@Test
	public void testClosePossibleBorderAlgo(){
		
		List<Cell> CellSetBufferWithThreeBorders = new ArrayList<Cell>();

		/* case Border LEFT */
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferWithThreeBorders.add(cell);
		kiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(cell.BORDER_LEFT));
		
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		kiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(cell.BORDER_LEFT));
		
		/* case Border BOTTOM */
		cell.setBorder(cell.BORDER_BOTTOM, false);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		kiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(cell.BORDER_BOTTOM));
		
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		kiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(cell.BORDER_BOTTOM));
		
		/* case Border RIGHT */
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, false);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		kiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(cell.BORDER_RIGHT));
		
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		kiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(cell.BORDER_RIGHT));
		
		/* case Border TOP */
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, false);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		kiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(cell.BORDER_TOP));
		
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferWithThreeBorders.add(cell);
		kiChose.ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		assertTrue(cell.getBorder(cell.BORDER_TOP));
		
	}
	@Test
	public void testNotPutForwardAlgo(){
		List<Cell> CellSetBufferLessThanTwoBorders = new ArrayList<Cell>();
		
		cell.setBorder(cell.BORDER_BOTTOM, false);
		cell.setBorder(cell.BORDER_RIGHT, false);
		cell.setBorder(cell.BORDER_TOP, false);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_BOTTOM));
		
		/* case border BOTTOM */
		cell.setBorder(cell.BORDER_BOTTOM, false);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, false);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_BOTTOM));
		
		cell.setBorder(cell.BORDER_BOTTOM, false);
		cell.setBorder(cell.BORDER_RIGHT, false);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_BOTTOM));
	
		cell.setBorder(cell.BORDER_BOTTOM, false);
		cell.setBorder(cell.BORDER_RIGHT, false);
		cell.setBorder(cell.BORDER_TOP, false);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_BOTTOM));
		
		/* case border RIGHT */
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, false);
		cell.setBorder(cell.BORDER_TOP, false);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_RIGHT));
		
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, false);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_RIGHT));
		
		/* case border TOP */
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, false);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_TOP));
		
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_TOP));

		/* case border LEFT */
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, false);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_LEFT));
		
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);
		cell.setBorder(cell.BORDER_LEFT, true);
		CellSetBufferLessThanTwoBorders.clear();
		CellSetBufferLessThanTwoBorders.add(cell);
		kiChose.NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		assertTrue(cell.getBorder(cell.BORDER_LEFT));
		
		
	
	}
	@Test
	public void testSacrificeLowestValueAlgo(){
		
	}
	@Test
	public void testComputerLogic(){

		
		/* test first case --> 3 Border filled */
//		cell = cellArray[0][0];
		cell.setBorder(cell.BORDER_BOTTOM, true);
		cell.setBorder(cell.BORDER_RIGHT, true);
		cell.setBorder(cell.BORDER_TOP, true);

		//cell.setCellBorder_left(cell.getCellBorder_left());
		
//		b.setBorderFilled(true);
//		r.setBorderFilled(true);
//		t.setBorderFilled(true);
//		l.setBorderFilled(false);
		assertTrue(cell.getNumberOfFilledBorders() == 3);
	}


}
