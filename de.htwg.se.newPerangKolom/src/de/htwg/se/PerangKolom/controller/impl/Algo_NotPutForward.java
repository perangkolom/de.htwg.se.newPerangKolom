package de.htwg.se.PerangKolom.controller.impl;

import de.htwg.se.PerangKolom.controller.CurrentStrategy;
import de.htwg.se.PerangKolom.model.impl.Cell;

public class Algo_NotPutForward implements CurrentStrategy{

	@Override
	public void StrategyAlgorithm(Cell cell) {
		


		
		if(cell.getBorder(cell.BORDER_BOTTOM) == false){
			cell.setBorder(cell.BORDER_BOTTOM, true);
			return;
		}
		
		if(cell.getBorder(cell.BORDER_RIGHT) == false){
			cell.setBorder(cell.BORDER_RIGHT, true);
			return;
		}
		
		if(cell.getBorder(cell.BORDER_TOP) == false){
			cell.setBorder(cell.BORDER_TOP, true);
			return;
		}
		
		if(cell.getBorder(cell.BORDER_LEFT) == false){
			cell.setBorder(cell.BORDER_LEFT, true);
			return;
		}


		
	}

}
