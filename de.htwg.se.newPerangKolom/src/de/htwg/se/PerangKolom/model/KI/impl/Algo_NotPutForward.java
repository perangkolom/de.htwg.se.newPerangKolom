package de.htwg.se.PerangKolom.model.KI.impl;

import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.impl.Cell2;

public class Algo_NotPutForward implements ICurrentStrategy{

	@Override
	public void StrategyAlgorithm(ICell2 cell) {
		


		
		if(cell.getBorder(Cell2.BORDER_BOTTOM) == false){
			cell.setBorder(Cell2.BORDER_BOTTOM, true);
			return;
		}
		if(cell.getBorder(Cell2.BORDER_RIGHT) == false){
			cell.setBorder(Cell2.BORDER_RIGHT, true);
			return;
		}
		if(cell.getBorder(Cell2.BORDER_TOP) == false){
			cell.setBorder(Cell2.BORDER_TOP, true);
			return;
		}
		if(cell.getBorder(Cell2.BORDER_LEFT) == false){
			cell.setBorder(Cell2.BORDER_LEFT, true);
			return;
		}


		
	}

}
