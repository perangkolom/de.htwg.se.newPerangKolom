package de.htwg.se.PerangKolom.model;


public interface ICell2 {

	int getPositionX();
	
	void setPositionX(int x);
		
	int getPositionY();
	
	void setPositionY(int y);
	
	boolean isCellFilled();
	
	int getCellValue();
	
	void setCellValue(int value);

	IPlayer2 getCellOwner();
	
	void setCellOwner(IPlayer2 player);

	void setBorder(int borderNr, boolean fillBorder);
	
	boolean getBorder(int borderNr);
	
	String toString();
	
	int makeRandomNumber();
	
	int getCellSize();
	
	void setCellSize(int size);
	
	char[][] getCharArray();
	
	void setCharArray(char[][] charArray);
	
	int getNumberOfFilledBorders();
	
	void setBorderWithoutNeighbour(int borderNr, boolean fillBorder);
	
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