package de.htwg.se.PerangKolom.model.impl;

import de.htwg.se.PerangKolom.model.AbstractCell2;

public class Cell2 extends AbstractCell2{
		
	public Cell2(final int x, final int y) {
			this.setPositionX(x);
			this.setPositionY(y);
			this.setCellValue(this.makeRandomNumber());
			this.setCharArray(new char[Cell2.getCellSize()][Cell2.getCellSize()]);
		}

}
