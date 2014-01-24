package de.htwg.se.PerangKolom.model.KI.impl;

import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.impl.Cell2;

public class ComputerPlayerLogic {

	public ICurrentStrategy strategy;
	
	
	public void chooseStrategy(ICell2 iCell2){
		strategy.StrategyAlgorithm(iCell2);
	}
	
	public void setStrategy(ICurrentStrategy newStrategy){
		strategy = newStrategy;
	}


}
