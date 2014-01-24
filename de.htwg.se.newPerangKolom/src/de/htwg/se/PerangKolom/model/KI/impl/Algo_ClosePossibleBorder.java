package de.htwg.se.PerangKolom.model.KI.impl;

import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.impl.Cell2;




public class Algo_ClosePossibleBorder implements ICurrentStrategy{
	
	/*
	 * Algorithm that closes the 4th Border, if 3 Borders of one cell are closed.
	 */
	public void StrategyAlgorithm(ICell2 cell) {
		
		if(cell.getBorder(Cell2.BORDER_BOTTOM) == false){
			cell.setBorder(Cell2.BORDER_BOTTOM, true);
		}
		if(cell.getBorder(Cell2.BORDER_LEFT) == false){
			cell.setBorder(Cell2.BORDER_LEFT, true);
		}
		if(cell.getBorder(Cell2.BORDER_RIGHT) == false){
			cell.setBorder(Cell2.BORDER_RIGHT, true);
		}
		if(cell.getBorder(Cell2.BORDER_TOP) == false){
			cell.setBorder(Cell2.BORDER_TOP, true);
		}
	
		
	}


}
