package de.htwg.se.PerangKolom.model.KI.impl;

import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.Cell2;

public class ComputerPlayerLogic {

	public ICurrentStrategy strategy;
	
	
	public void chooseStrategy(Cell2 cell){
		strategy.StrategyAlgorithm(cell);
	}
	
	public void setStrategy(ICurrentStrategy newStrategy){
		strategy = newStrategy;
	}

}
