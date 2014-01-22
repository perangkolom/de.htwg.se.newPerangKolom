package de.htwg.se.PerangKolom.model;

import de.htwg.se.PerangKolom.model.impl.CellArray;

public class AbstractCell2 implements ICell2{
	
	public static final int BORDER_TOP 		= 1;
	public static final int BORDER_RIGHT 	= 2;
	public static final int BORDER_BOTTOM 	= 3;
	public static final int BORDER_LEFT 	= 4;
	
	//these values multiplied with 25 determine the maximum/minimum value for a cell
	private static final int RANDOM_MIN 	= 1;
	private static final int RANDOM_MAX		= 4;
	
	private  boolean topBorder		= false;
	private  boolean bottomBorder 	= false;
	private  boolean leftBorder 	= false;
	private  boolean rightBorder 	= false;
	private  int positionX; 
	private  int positionY;
	private  int cellValue;
	private  int numberOfFilledBorders;
	private  boolean cellFilled;
	private  IPlayer2 cellOwner;



	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCellFilled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCellValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IPlayer2 getCellOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBorder(int borderNr, boolean fillBorder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getBorder(int borderNr) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private int makeRandomNumber() { return 0;};
	
	private void setCellValue(int value){};

}
