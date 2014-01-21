package de.htwg.se.PerangKolom.controller.impl;

import static org.junit.Assert.*;

import org.junit.Before;

import de.htwg.se.PerangKolom.controller.CurrentStrategy;
import de.htwg.se.PerangKolom.model.impl.Cell;

public class ComputerPlayerLogicTest {

	public CurrentStrategy strategy;
	public ComputerPlayerLogic cpl;
	public Cell cell;
	
	@Before 
	public void setUp() {
		cell = new Cell(0, 0);
		cpl = new ComputerPlayerLogic();
	}
	
	public void testChooseStrategy(){
		cpl.chooseStrategy(cell);
		
	}
	
	public void testSetStrategy(){
		CurrentStrategy strategy = new Algo_SacrificeLowestValue();
		cpl.setStrategy(strategy);
		assertEquals(new Algo_SacrificeLowestValue(), strategy);
	}

}
