package de.htwg.se.PerangKolom.model;


public interface ICell2 {

	public int getPositionX();
	
	public int getPositionY();
	
	public boolean isCellFilled();

	public int getCellValue();

	public IPlayer2 getCellOwner();

	public void setBorder(int borderNr, boolean fillBorder);
	
	public boolean getBorder(int borderNr);
	
	public String toString();
	

}

/*

für die TUI:
	
	public void fillCellWithOwnerChar(boolean isPlayerOne);
	public void fillCharArray();
	
	//size (=width =height) of one cell	
	public static int CELL_SIZE = 10;
	private static char innerBorderChar = '+';
	private static char outerBorderChar = '#';

	private final static char CHAR_PLAYER_1 = '1';
	private final static char CHAR_PLAYER_2 = '2';
	
	
	
*/