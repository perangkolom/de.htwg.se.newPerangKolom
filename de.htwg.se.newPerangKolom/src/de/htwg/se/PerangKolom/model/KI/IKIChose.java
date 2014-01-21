package de.htwg.se.PerangKolom.model.KI;

import java.util.List;

import de.htwg.se.PerangKolom.model.impl.Cell;

public interface IKIChose {
	
	/*
	 * All Computer Logic:
	 * - chose one of the three strategies
	 * - calls function 'fillBorder()'
	 */
	void ComputerLogic();
	
	/*
	 * 'ClosePossibleBorder' Algorithm
	 */
	public void ClosePossibleBorderAlgo(List<Cell> CellSetBufferWithThreeBorders);
	
	/*
	 * 'NotPutForward' Algorithm
	 */
	public void NotPutForwardAlgo(List<Cell> CellSetBufferLessThanTwoBorders);
	
	/*
	 * 'SacrificeLowestValue' Algorithm
	 */
	public void SacrificeLowestValueAlgo(List<Cell> CellSetBufferWithTwoBorder);
	

}
