package de.htwg.se.PerangKolom.model.KI.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.KI.IKIChose;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.CellArray;

public class KIChose implements IKIChose{
	
	private TreeSet<Cell> cellArraySet;
	
	public KIChose(){
		this.cellArraySet = new TreeSet<Cell>();
	}
	

	public void ComputerLogic() {

		List<Cell> CellSetBufferWithThreeBorders = new ArrayList<Cell>();
		List<Cell> CellSetBufferLessThanTwoBorders = new ArrayList<Cell>();
		List<Cell> CellSetBufferWithTwoBorder = new ArrayList<Cell>();
		
		/* fills CellArraySet with all Cells */
		fillSet();
		
		/**** rout all cells in different Lists ****/
		switchCellsInLists(CellSetBufferWithThreeBorders, CellSetBufferLessThanTwoBorders, CellSetBufferWithTwoBorder);
		
		
		/* CHOOSE ALGO */
		/****** IF-Clause for the 'ClosePossibleBorder' Algorithm ******/
		if(!CellSetBufferWithThreeBorders.isEmpty()){
			ClosePossibleBorderAlgo(CellSetBufferWithThreeBorders);
		/****** IF-Clause for the 'NotPutForward Algorithm ******/
		} else if(!CellSetBufferLessThanTwoBorders.isEmpty()){
			NotPutForwardAlgo(CellSetBufferLessThanTwoBorders);
		/****** IF-Clause for the 'SacrificeLowestValue' Algorithm ******/
		} else if(!CellSetBufferWithTwoBorder.isEmpty()){
			SacrificeLowestValueAlgo(CellSetBufferWithTwoBorder);
		}
	}
	
	private void fillSet(){
		/* fills the Set with all cells */
		for(int i = 0; i < CellArray.getNumberOfRows(); i++){
			for(int j = 0; j < CellArray.getNumberOfColums(); j++){
				Cell[][] tmp = CellArray.getCellArray();
				cellArraySet.add(tmp[i][j]);
			}
		}
	}

	private void switchCellsInLists(List<Cell> CellSetBufferWithThreeBorders, List<Cell> CellSetBufferLessThanTwoBorders, List<Cell> CellSetBufferWithTwoBorder){
		
		for(Cell c : cellArraySet){
				/*** 'NotPutForward' Algorithm ***/
			if(c.getNumberOfFilledBorders() < 2){
				CellSetBufferLessThanTwoBorders.add(c);
			/*** 'SacrificeLowestValue' Algorithm ***/
			}else if(c.getNumberOfFilledBorders() == 2){
				CellSetBufferWithTwoBorder.add(c);
			/*** 'ClosePossibleBorder' Algorithm ***/
			} else if(c.getNumberOfFilledBorders() == 3){
				CellSetBufferWithThreeBorders.add(c);
			} 
		}
	}
	
	/* 'ClosePossibleBorder' Algorithm */
	public void ClosePossibleBorderAlgo(List<Cell> CellSetBufferWithThreeBorders){
		
		/* Objects */
		ICurrentStrategy strategyOne = new Algo_ClosePossibleBorder();
		ComputerPlayerLogic algorithmOne = new ComputerPlayerLogic();
		algorithmOne.setStrategy(strategyOne);
		
		Cell cellBuf = CellSetBufferWithThreeBorders.get(0);
		for(Cell c : CellSetBufferWithThreeBorders){
			if(c.getCellValue() >= cellBuf.getCellValue()){
				cellBuf = c;
			}
		}
		algorithmOne.chooseStrategy(cellBuf);
		// if computer chooses this algorithm and closes the 4th border, 
		// it is still his turn
//		ComputerLogic();
		
	}
	
	/* 'NotPutForward' Algorithm */
	public void NotPutForwardAlgo(List<Cell> CellSetBufferLessThanTwoBorders){
		
		ICurrentStrategy strategyTwo = new Algo_NotPutForward();
		ComputerPlayerLogic algorithmTwo = new ComputerPlayerLogic();
		algorithmTwo.setStrategy(strategyTwo);
		
		for(Cell c : CellSetBufferLessThanTwoBorders){
			if(c.getNumberOfFilledBorders() == 1){
				algorithmTwo.chooseStrategy(c);
				return;
			}
			
			
			
		}
		algorithmTwo.chooseStrategy(CellSetBufferLessThanTwoBorders.get(0)); //prüfen ob cell 1 border oder 0 borders gefüllt hat, cell mit 1 border eine weitere füllen
		
	}
	
	/* 'SacrificeLowestValue' Algorithm */
	public void SacrificeLowestValueAlgo(List<Cell> CellSetBufferWithTwoBorder){
		
		ComputerPlayerLogic algorithmThree = new ComputerPlayerLogic();
		ICurrentStrategy strategyThree = new Algo_SacrificeLowestValue();
		algorithmThree.setStrategy(strategyThree);
		
		Cell cellBuf = CellSetBufferWithTwoBorder.get(0);
		for(Cell c : CellSetBufferWithTwoBorder){
			if(c.getCellValue() <= cellBuf.getCellValue()){
				cellBuf = c;
			}
		}
		algorithmThree.chooseStrategy(cellBuf);
	}

}
