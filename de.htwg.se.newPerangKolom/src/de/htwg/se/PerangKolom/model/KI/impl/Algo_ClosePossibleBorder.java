package de.htwg.se.PerangKolom.model.KI.impl;

import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.impl.Cell;




public class Algo_ClosePossibleBorder implements ICurrentStrategy{
	
	/*
	 * Algorithm that closes the 4th Border, if 3 Borders of one cell are closed.
	 */
	public void StrategyAlgorithm(Cell cell) {
		
		if(cell.getBorderState(cell.BORDER_BOTTOM) == false){
			cell.setBorder(cell.BORDER_BOTTOM, true);
		}
		if(cell.getBorderState(cell.BORDER_LEFT) == false){
			cell.setBorder(cell.BORDER_LEFT, true);
		}
		if(cell.getBorderState(cell.BORDER_RIGHT) == false){
			cell.setBorder(cell.BORDER_RIGHT, true);
		}
		if(cell.getBorderState(cell.BORDER_TOP) == false){
			cell.setBorder(cell.BORDER_TOP, true);
		}
	
		
	}


}
