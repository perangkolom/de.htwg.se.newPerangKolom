package de.htwg.se.PerangKolom.model.KI;

import java.util.List;

import de.htwg.se.PerangKolom.model.ICell2;

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
	public void ClosePossibleBorderAlgo(List<ICell2> CellSetBufferWithThreeBorders);
	
	/*
	 * 'NotPutForward' Algorithm
	 */
	public void NotPutForwardAlgo(List<ICell2> CellSetBufferLessThanTwoBorders);
	
	/*
	 * 'SacrificeLowestValue' Algorithm
	 */
	public void SacrificeLowestValueAlgo(List<ICell2> CellSetBufferWithTwoBorder);
	

}
