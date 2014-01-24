package de.htwg.se.PerangKolom.model;

public interface ICell {
	
	public int getPositionX();
	
	public int getPositionY();
	
	public boolean isCellFilled();
	
	public void setCellFilled(boolean cellFilled);
	
	public int getCellValue();
	
	public void setCellValue(int value);

	public String getCellOwner();

	public void setCellOwner(String cellOwner);

	public void setBorder(int borderNr, boolean fillBorder);
	
	public boolean getBorder(int borderNr);
	
	public void fillCharArray();
	
	public String toString();
	
	public int makeRandomNumber();
	
	public void fillCellCompletelyWithOwnersString(boolean isPlayerOne);

	public boolean isBorderFilled(int border);

	public int getNumberOfFilledBorders();


	
	
}
