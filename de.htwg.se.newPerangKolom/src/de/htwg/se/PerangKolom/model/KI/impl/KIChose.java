package de.htwg.se.PerangKolom.model.KI.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.KI.IKIChose;
import de.htwg.se.PerangKolom.model.impl.Cell2;
import de.htwg.se.PerangKolom.model.impl.Grid;

public class KIChose implements IKIChose{
	
	private TreeSet<ICell2> cellArraySet;
	
	public KIChose(){
		this.cellArraySet = new TreeSet<ICell2>();
	}
	

	public void ComputerLogic() {

		List<ICell2> cellSetBufferWithThreeBorders = new ArrayList<ICell2>();
		List<ICell2> cellSetBufferLessThanTwoBorders = new ArrayList<ICell2>();
		List<ICell2> cellSetBufferWithTwoBorder = new ArrayList<ICell2>();
		
		/* fills CellArraySet with all Cells */
		fillSet();
		
		/**** rout all cells in different Lists ****/
		switchCellsInLists(cellSetBufferWithThreeBorders, cellSetBufferLessThanTwoBorders, cellSetBufferWithTwoBorder);
		
		
		/* CHOOSE ALGO */
		/****** IF-Clause for the 'ClosePossibleBorder' Algorithm ******/
		if(!cellSetBufferWithThreeBorders.isEmpty()){
			ClosePossibleBorderAlgo(cellSetBufferWithThreeBorders);
		/****** IF-Clause for the 'NotPutForward Algorithm ******/
		} else if(!cellSetBufferLessThanTwoBorders.isEmpty()){
			NotPutForwardAlgo(cellSetBufferLessThanTwoBorders);
		/****** IF-Clause for the 'SacrificeLowestValue' Algorithm ******/
		} else if(!cellSetBufferWithTwoBorder.isEmpty()){
			SacrificeLowestValueAlgo(cellSetBufferWithTwoBorder);
		}
	}
	
	private void fillSet(){
		/* fills the Set with all cells */
		for(int i = 0; i < Grid.getNumberOfRows(); i++){
			for(int j = 0; j < Grid.getNumberOfCols(); j++){
				ICell2[][] tmp = Grid.getInstance().getCellArray();
				cellArraySet.add(tmp[i][j]);
			}
		}
	}

	private void switchCellsInLists(List<ICell2> cellSetBufferWithThreeBorders, List<ICell2> cellSetBufferLessThanTwoBorders, List<ICell2> cellSetBufferWithTwoBorder){
		
		for(ICell2 c : cellArraySet){
				/*** 'NotPutForward' Algorithm ***/
			if(c.getNumberOfFilledBorders() < 2){
				cellSetBufferLessThanTwoBorders.add(c);
			/*** 'SacrificeLowestValue' Algorithm ***/
			}else if(c.getNumberOfFilledBorders() == 2){
				cellSetBufferWithTwoBorder.add(c);
			/*** 'ClosePossibleBorder' Algorithm ***/
			} else if(c.getNumberOfFilledBorders() == 3){
				cellSetBufferWithThreeBorders.add(c);
			} 
		}
	}
	
	/* 'ClosePossibleBorder' Algorithm */
	public void ClosePossibleBorderAlgo(List<ICell2> cellSetBufferWithThreeBorders){
		
		/* Objects */
		ICurrentStrategy strategyOne = new Algo_ClosePossibleBorder();
		ComputerPlayerLogic algorithmOne = new ComputerPlayerLogic();
		algorithmOne.setStrategy(strategyOne);
		
		ICell2 cellBuf = cellSetBufferWithThreeBorders.get(0);
		for(ICell2 c : cellSetBufferWithThreeBorders){
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
	public void NotPutForwardAlgo(List<ICell2> cellSetBufferLessThanTwoBorders){
		
		ICurrentStrategy strategyTwo = new Algo_NotPutForward();
		ComputerPlayerLogic algorithmTwo = new ComputerPlayerLogic();
		algorithmTwo.setStrategy(strategyTwo);
		
		for(ICell2 c : cellSetBufferLessThanTwoBorders){
			if(c.getNumberOfFilledBorders() == 1){
				algorithmTwo.chooseStrategy(c);
				return;
			}
			
			
			
		}
		algorithmTwo.chooseStrategy(cellSetBufferLessThanTwoBorders.get(0)); //prüfen ob cell 1 border oder 0 borders gefüllt hat, cell mit 1 border eine weitere füllen
		
	}
	
	/* 'SacrificeLowestValue' Algorithm */
	public void SacrificeLowestValueAlgo(List<ICell2> cellSetBufferWithTwoBorder){
		
		ComputerPlayerLogic algorithmThree = new ComputerPlayerLogic();
		ICurrentStrategy strategyThree = new Algo_SacrificeLowestValue();
		algorithmThree.setStrategy(strategyThree);
		
		ICell2 cellBuf = cellSetBufferWithTwoBorder.get(0);
		for(ICell2 c : cellSetBufferWithTwoBorder){
			if(c.getCellValue() <= cellBuf.getCellValue()){
				cellBuf = c;
			}
		}
		algorithmThree.chooseStrategy(cellBuf);
	}







}
