package de.htwg.se.PerangKolom.model;

import de.htwg.se.PerangKolom.model.impl.Grid;

public class AbstractCell2 implements ICell2{
	
	//assignment of numbers to borders
	public static final int BORDER_TOP 		= 1;
	public static final int BORDER_RIGHT 	= 2;
	public static final int BORDER_BOTTOM 	= 3;
	public static final int BORDER_LEFT 	= 4;
	
	private static final int INDEX_LOWEST 	= 0;
	
	//these values multiplied with 25 determine the maximum/minimum value for a cell
	private static final int RANDOM_MIN 	= 1;
	private static final int RANDOM_MAX		= 4;

	private boolean topBorder		= false;
	private boolean bottomBorder 	= false;
	private boolean leftBorder 		= false;
	private boolean rightBorder 	= false;
	
	private int positionX; 
	private int positionY;
	private int cellValue;
	private static int cellSize = 0;
	private IPlayer2 cellOwner 		= null;
	
	private char[][] charArray;
	


	@Override
	public int getPositionX() {
		return positionX;
	}
	

	@Override
	public void setPositionX(int x) {
		this.positionX = x;
	}


	@Override
	public int getPositionY() {
		return positionY;
	}

	
	@Override
	public void setPositionY(int y) {
		this.positionY = y;
	};

	
	@Override
	public boolean isCellFilled() {
		
		if (getNumberOfFilledBorders() == 4) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public int getCellValue() {
		return cellValue;
	}
	
	
	@Override
	public void setCellValue(int value) {
		cellValue = value;
		
	}

	@Override
	public IPlayer2 getCellOwner() {
		return cellOwner;
	}

	@Override
	public void setBorder(int borderNr, boolean fillBorder) {
		
		if (borderNr == BORDER_TOP) {
			topBorder = fillBorder;
			setNeighbourBorder(BORDER_TOP, fillBorder);
			return;
		} 
		
		if (borderNr == BORDER_BOTTOM) {
			bottomBorder = fillBorder;
			setNeighbourBorder(BORDER_BOTTOM, fillBorder);
			return;
		}
		
		if (borderNr == BORDER_LEFT) {
			leftBorder = fillBorder;
			setNeighbourBorder(BORDER_LEFT, fillBorder);
			return;
		}
	
		if (borderNr == BORDER_RIGHT) {
			rightBorder = fillBorder;
			setNeighbourBorder(BORDER_RIGHT, fillBorder);
			return;
		}	
	}
	
	
	private void setNeighbourBorder(int borderNr, boolean fillBorder) {

		//if so leave return without doing anything
		if (isNeighbourOutOfBounds(borderNr)) {
			return;
		}
		
		if (borderNr == BORDER_TOP) {
			int neighbour_row = positionX - 1;
			ICell2 tmpCell = Grid.getInstance().getCell(neighbour_row, positionY);
			tmpCell.setBorderWithoutNeighbour(BORDER_BOTTOM, fillBorder);
		}
		
		if (borderNr == BORDER_BOTTOM) {
			int neighbour_row = positionX + 1;
			ICell2 tmpCell = Grid.getInstance().getCell(neighbour_row, positionY);
			tmpCell.setBorderWithoutNeighbour(BORDER_TOP, fillBorder);
		}
		
		if (borderNr == BORDER_LEFT) {
			int neighbour_col = positionY - 1 ;
			ICell2 tmpCell = Grid.getInstance().getCell(positionX, neighbour_col);
			tmpCell.setBorderWithoutNeighbour(BORDER_RIGHT, fillBorder);
		}
	
		if (borderNr == BORDER_RIGHT) {
			int neighbour_col = positionY + 1 ;
			ICell2 tmpCell = Grid.getInstance().getCell(positionX, neighbour_col);
			tmpCell.setBorderWithoutNeighbour(BORDER_RIGHT, fillBorder);
		}
	
	}

	
	private boolean isNeighbourOutOfBounds(int borderNr) {
		
		if (borderNr == BORDER_TOP) {
			if ( (positionX - 1) < INDEX_LOWEST ) {
				return true;
			} else {
				return false;
			}
		}
		
		if (borderNr == BORDER_BOTTOM) {	
			if ( (positionX + 1) >= Grid.getNumberOfRows() ) {
				return true;
			} else {
				return false;
			}
				
		}
		
		if (borderNr == BORDER_LEFT) {
			if ( (positionY - 1) < INDEX_LOWEST ) {
				return true;
			} else {
				return false;
			}
		}
		
		if (borderNr == BORDER_RIGHT) {
			if ( (positionY + 1) >= Grid.getNumberOfCols() ) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}

	
	public void setBorderWithoutNeighbour(int borderNr, boolean fillBorder) {
		
		if (borderNr == BORDER_TOP) {
			topBorder = fillBorder;
			return;
		} 
		
		if (borderNr == BORDER_BOTTOM) {
			bottomBorder = fillBorder;
			return;
		}
		
		if (borderNr == BORDER_LEFT) {
			leftBorder = fillBorder;
			return;
		}
	
		if (borderNr == BORDER_RIGHT) {
			rightBorder = fillBorder;
			return;
		}	
	}
	
	
	@Override
	public boolean getBorder(int borderNr) {

		if (borderNr < 1 || borderNr > 4)
			throw new IndexOutOfBoundsException();
		
		if (borderNr == BORDER_TOP) 
			return topBorder;
		
		if (borderNr == BORDER_BOTTOM) 
			return bottomBorder;
		
		if (borderNr == BORDER_LEFT) 
			return leftBorder;
		
		if (borderNr == BORDER_RIGHT) 
			return rightBorder;
		
		//dummy return to make the compiler happy
		return false;
	}
		

	@Override
	public int makeRandomNumber() {
		
		double random = Math.random();
		double tmp = (random * RANDOM_MAX);
		if (tmp < RANDOM_MIN) 
			tmp = RANDOM_MIN;
		int result = (int) Math.ceil(tmp);
		
		result = result * 25;
		return result;	
	}


	public static int getCellSize() {
		return cellSize;
	}


	public static void setCellSize(int size) {
		cellSize = size;
	}


	@Override
	public char[][] getCharArray() {
		return this.charArray;
	}


	@Override
	public void setCharArray(char[][] charArray) {
		this.charArray = charArray;
	}


	@Override
	public void setCellOwner(IPlayer2 player) {
		this.cellOwner = player;
	}

	@Override
	public int getNumberOfFilledBorders() {
		
		int sum = 0;
		
		if (bottomBorder) {
			sum++;
		}
		
		if (leftBorder) {
			sum++;
		}
		
		if (rightBorder) {
			sum++;
		}
		
		if (topBorder) {
			sum++;
		}
		
		return sum;
		
	}
	
	/********* DAVID ***********/
	
	public boolean isBorderFilled(int border){
		return getBorder(border);
	}
}
