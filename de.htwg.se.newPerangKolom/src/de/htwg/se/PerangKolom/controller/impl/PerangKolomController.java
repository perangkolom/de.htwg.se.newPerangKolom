package de.htwg.se.PerangKolom.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import de.htwg.se.PerangKolom.controller.IPerangKolomController;
import de.htwg.se.PerangKolom.model.ICell;
import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.KI.impl.Algo_ClosePossibleBorder;
import de.htwg.se.PerangKolom.model.KI.impl.Algo_NotPutForward;
import de.htwg.se.PerangKolom.model.KI.impl.Algo_SacrificeLowestValue;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.CellArray;
import de.htwg.se.PerangKolom.util.observer.Observable;

public class PerangKolomController extends Observable implements IPerangKolomController{

	public CellArray CellArrayDummy = CellArray.getInstance();
	public Cell[][] cellArray = CellArray.getCellArray();

//	public ICell cell;
	
	public void setCellValue(int row, int column, int value){
		cellArray[row][column].setCellValue(value);
	}
	
	
	@Override
	public void createNewGrid(int x, int y) {
		CellArray.createCellArray(x, y);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}
	
	public int getRandNumber(int x, int y){
//		this.cell = new Cell(x, y);
		return cellArray[x][y].makeRandomNumber();
	}
	

	public void setBorderFilled(int x, int y, int borderType){
		cellArray[x][y].setBorder(borderType, true);
	}



	public Cell getCell(int x, int y) {
			Cell tmpCell = cellArray[x][y];
		return tmpCell;
	}

//	@Override
//	public void fillBorder(Border border) {
//		border.setBorderFilled(true);
//	}

	


	
}