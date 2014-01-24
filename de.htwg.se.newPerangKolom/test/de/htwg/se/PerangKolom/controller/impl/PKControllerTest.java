//package de.htwg.se.PerangKolom.controller.impl;
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runners.JUnit4;
//
//import de.htwg.se.PerangKolom.controller.IPKController;
//import de.htwg.se.PerangKolom.model.ICell2;
//import de.htwg.se.PerangKolom.model.IPlayer2;
//import de.htwg.se.PerangKolom.model.impl.Cell;
//import de.htwg.se.PerangKolom.model.impl.Cell2;
//import de.htwg.se.PerangKolom.model.impl.GameSettings;
//import de.htwg.se.PerangKolom.model.impl.Grid;
//import de.htwg.se.PerangKolom.model.impl.Player2;
//
//public class PKControllerTest {
//
//	IPKController contr;
//	Grid grid;
//	ICell2[][] array;
//	ICell2 cell;
//	int ROW;
//	int COL;
//	IPlayer2 player;
//	int TOP;
//	int BOTTOM;
//	int	LEFT;
//	int RIGHT;
//	GameSettings settings;
//	int ONE;
//	int TWO;
//	
//	@Before
//	public void setUp() throws Exception {
//		contr = new PKController();
//		grid = Grid.getInstance();
//		array = grid.getCellArray();
//		ROW = 0;
//		COL = 0;
//		cell = array[ROW][COL];
//		player = new Player2();
//		TOP = Cell2.BORDER_TOP;
//		BOTTOM = Cell2.BORDER_BOTTOM;
//		LEFT = Cell2.BORDER_LEFT;
//		RIGHT = Cell2.BORDER_RIGHT;
//		settings = GameSettings.getInstance();
//		ONE = 1;
//		TWO = 2;
//	}
//	
//	@After
//	public void tearDown() {
//		grid = null;
//	}
//	
//	
//	
//
//	
//	@Test
//	public void testGetInstance() {
//		assertNotNull(contr.getInstance());
//		grid = null;
//		assertNotNull(contr.getInstance());
//		//assertEquals(grid, contr.getInstance());
//	}
//
//	@Test
//	public void testGetCellArray() {
//		assertNotNull(array);
//	}
//
//	@Test
//	public void testGetNumberOfRows() {
//		grid.setNumberOfRows(123);
//		assertEquals(123, contr.getNumberOfRows());
//	}
//
//	@Test
//	public void testSetNumberOfRows() {
//		contr.setNumberOfRows(123);
//		assertEquals(123, contr.getNumberOfRows());
//	}
//
//	@Test
//	public void testGetNumberOfCols() {
//		contr.setNumberOfCols(123);
//		assertEquals(123, contr.getNumberOfCols());
//	}
//
//	@Test
//	public void testSetNumberOfCols() {
//		contr.setNumberOfCols(123);
//		assertEquals(123, contr.getNumberOfCols());
//	}
//
//	@Test
//	public void testGetCellIntInt() {
//		assertNotNull(contr.getInstance().getCell(1, 1));
//		Cell2 cell = new Cell2(2, 2);
//		array[2][2] = cell;
//		assertEquals(cell, contr.getCell(2, 2));
//	}
//
//	@Test
//	public void testIsCellFilledCell2() {
//		
//		assertFalse(contr.isCellFilled(cell));
//		
//		cell.setBorder(BOTTOM, true);
//		cell.setBorder(LEFT, true);
//		cell.setBorder(RIGHT, true);
//		cell.setBorder(TOP, true);
//		assertTrue(contr.isCellFilled(cell));
//		
//		cell.setBorder(LEFT, false);
//		assertFalse(contr.isCellFilled(cell));
//		
//		cell.setBorder(LEFT, true);
//		assertTrue(contr.isCellFilled(cell));
//	}
//
//
//	@Test
//	public void testIsCellFilledIntInt() {
//		
//		assertFalse(contr.isCellFilled(ROW, COL));
//		
//		cell.setBorder(BOTTOM, true);
//		cell.setBorder(LEFT, true);
//		cell.setBorder(RIGHT, true);
//		cell.setBorder(TOP, true);
//		assertTrue(contr.isCellFilled(ROW, COL));
//		
//		cell.setBorder(LEFT, false);
//		assertFalse(contr.isCellFilled(ROW, COL));
//		
//		cell.setBorder(LEFT, true);
//		assertTrue(contr.isCellFilled(ROW, COL));
//	}
//
//	
//	@Test
//	public void testGetCellValueIntInt() {
//		cell.setCellValue(3200);
//		assertEquals(3200, contr.getCellValue(ROW, COL));
//		assertEquals(3200, contr.getCellValue(ROW, COL));;
//	}
//
//	
//	@Test
//	public void testGetCellValueICell2() {
//		cell.setCellValue(3200);
//		assertEquals(3200, contr.getCellValue(cell));
//		assertEquals(3200, contr.getCellValue(cell));
//	}
//
//
//	@Test
//	public void testGetCellOwnerIntInt() {
//		cell.setCellOwner(player);
//		assertEquals(player, contr.getCellOwner(ROW, COL));
//	}
//
//	
//	@Test
//	public void testGetCellOwnerICell2() {
//		cell.setCellOwner(player);
//		assertEquals(player, contr.getCellOwner(cell));
//	}
//
//	
//	@Test
//	public void testSetCellOwnerIPlayer2IntInt() {
//		contr.setCellOwner(player, ROW, COL);
//		assertEquals(player, cell.getCellOwner());
//	}
//
//	
//	@Test
//	public void testSetCellOwnerIPlayer2ICell2() {
//		contr.setCellOwner(player, cell);
//		assertEquals(player, cell.getCellOwner());
//	}
//
//	
//	@Test
//	public void testSetBorderIntBooleanIntInt() {
//		contr.setBorder(BOTTOM, true, ROW, COL);
//		assertTrue(cell.getBorder(Cell.BORDER_BOTTOM));
//		
//		contr.setBorder(BOTTOM, false, ROW, COL);
//		assertFalse(cell.getBorder(Cell.BORDER_BOTTOM));
//		
//		contr.setBorder(RIGHT, true, ROW, COL);
//		assertTrue(cell.getBorder(Cell.BORDER_RIGHT));
//		
//		contr.setBorder(RIGHT, false, ROW, COL);
//		assertFalse(cell.getBorder(Cell.BORDER_RIGHT));
//	}
//
//	
//	@Test
//	public void testSetBorderIntBooleanICell2() {
//		contr.setBorder(BOTTOM, true, cell);
//		assertTrue(cell.getBorder(Cell.BORDER_BOTTOM));
//		
//		contr.setBorder(BOTTOM, false, cell);
//		assertFalse(cell.getBorder(Cell.BORDER_BOTTOM));
//		
//		contr.setBorder(RIGHT, true, cell);
//		assertTrue(cell.getBorder(Cell.BORDER_RIGHT));
//		
//		contr.setBorder(RIGHT, false, cell);
//		assertFalse(cell.getBorder(Cell.BORDER_RIGHT));
//	}
//	
//	
//	@Test
//	public void testGetBorderIntIntInt() {
//	
//		assertFalse(contr.getBorder(TOP, ROW, COL));
//		
//		cell.setBorder(TOP, true);
//		assertTrue(contr.getBorder(TOP, ROW, COL));
//		
//		cell.setBorder(TOP, false);
//		assertFalse(contr.getBorder(TOP, ROW, COL));
//		
//		assertFalse(contr.getBorder(RIGHT, ROW, COL));
//		
//		cell.setBorder(RIGHT, true);
//		assertTrue(contr.getBorder(RIGHT, ROW, COL));
//		
//		cell.setBorder(RIGHT, false);
//		assertFalse(contr.getBorder(RIGHT, ROW, COL));
//	}
//
//	
//	@Test
//	public void testGetBorderIntICell2() {
//		
//		cell.setBorder(TOP, false);
//		assertFalse(contr.getBorder(TOP, cell));
//		
//		cell.setBorder(TOP, true);
//		assertTrue(contr.getBorder(TOP, cell));
//		
//		cell.setBorder(TOP, false);
//		assertFalse(contr.getBorder(TOP, cell));
//		
//		cell.setBorder(RIGHT, false);
//		assertFalse(contr.getBorder(RIGHT, cell));
//		
//		cell.setBorder(RIGHT, true);
//		assertTrue(contr.getBorder(RIGHT, cell));
//		
//		cell.setBorder(RIGHT, false);
//		assertFalse(contr.getBorder(RIGHT, cell));
//	}
//	
//	
//	@Test
//	public void testGetCellSizeIntInt() {
//		Grid.getInstance();
//		cell.setCellSize(5);
//		assertEquals(cell, contr.getCell(ROW, COL));
//		
//		assertEquals(5, contr.getCellSize(ROW, COL));
//		
//	}
//
//	@Test
//	public void testGetCellSizeICell2() {
//		cell.setCellSize(50);
//		assertEquals(50, contr.getCellSize(cell));
//	}
//
//	@Test
//	public void testSetCellSizeIntIntInt() {
//		contr.setCellSize(6, ROW, COL);
//		assertEquals(6, cell.getCellSize());
//	}
//
//	@Test
//	public void testSetCellSizeIntICell2() {
//		contr.setCellSize(6, cell);
//		assertEquals(6, cell.getCellSize());
//	}
//
//	@Test
//	public void testGetCharArrayIntInt() {
//		char[][] matrix = new char[3][3];
//		cell.setCharArray(matrix);
//		assertArrayEquals(matrix, contr.getCharArray(ROW, COL));
//	}
//
//	@Test
//	public void testGetCharArrayICell2() {
//		char[][] matrix = new char[3][3];
//		cell.setCharArray(matrix);
//		assertArrayEquals(matrix, contr.getCharArray(cell));
//	}
//
//	@Test
//	public void testSetCharArrayCharArrayArrayIntInt() {
//		char[][] matrix = new char[3][3];
//		contr.setCharArray(matrix, ROW, COL);
//		assertArrayEquals(matrix, cell.getCharArray());
//	}
//
//	@Test
//	public void testSetCharArrayCharArrayArrayICell2() {
//		char[][] matrix = new char[3][3];
//		contr.setCharArray(matrix, cell);
//		assertArrayEquals(matrix, cell.getCharArray());
//	}
//
//	@Test
//	public void testGetPlayer() {
//		settings.setPlayer(player, ONE);
//		assertEquals(player, contr.getPlayer(ONE));
//
//		settings.setPlayer(player, TWO);
//		assertEquals(player, contr.getPlayer(TWO));
//	}
//	
//
//	@Test
//	public void testSetPlayer() {
//		contr.setPlayer(player, ONE);
//		assertEquals(player, settings.getPlayer(ONE));
//	}
//
//	
//	@Test
//	public void testSetWhoseTurnItIs() {
//		contr.setWhoseTurnItIs(player);
//		assertEquals(player, settings.getWhoseTurnItIs());
//	}
//
//	
//	@Test
//	public void testGetWhoseTurnItIs() {
//		settings.setWhoseTurnItIs(player);
//		assertEquals(player, contr.getWhoseTurnItIs());
//	}
//
//	
//	@Test
//	public void testChangeTurn() {
//		settings.setWhoseTurnItIs(player);
//		assertEquals(player, contr.getWhoseTurnItIs());
//	}
//
//	
//	@Test
//	public void testGetWinner() {
//		settings.setWinner(player);
//		assertEquals(player, contr.getWinner());
//	}
//
//	
//	@Test
//	public void testSetWinner() {
//		contr.setWinner(player);;
//		assertEquals(player, settings.getWinner());
//	}
//
//	
//	@Test
//	public void testSetPlayerHuman() {
//		contr.setPlayerHuman(true, player);
//		assertTrue(player.isPlayerAHuman());
//		
//		contr.setPlayerHuman(false, player);
//		assertFalse(player.isPlayerAHuman());
//		
//		contr.setPlayerHuman(true, player);
//		assertTrue(player.isPlayerAHuman());
//	}
//
//	
//	@Test
//	public void testIsPlayerAHuman() {
//		player.setPlayerHuman(true);
//		assertTrue(contr.isPlayerAHuman(player));
//		
//		player.setPlayerHuman(false);
//		assertFalse(contr.isPlayerAHuman(player));
//	}
//
//	
//	@Test
//	public void testGetNumberOfPoints() {
//		player.addPointsToPlayersAccount(123);
//		assertEquals(123, contr.getNumberOfPoints(player));
//	}
//
//	
//	@Test
//	public void testAddPointsToPlayersAccount() {
//		contr.addPointsToPlayersAccount(456, player);
//		assertEquals(456, player.getNumberOfPoints());
//	}
//
//	
//	@Test
//	public void testSetPlayersName() {
//		contr.setPlayersName("birte", player);
//		assertSame("birte", player.getPlayersName());
//	}
//
//	
//	@Test
//	public void testGetPlayersName() {
//		player.setPlayersName("putin");
//		assertSame("putin", contr.getPlayersName(player));
//	}
//
//}