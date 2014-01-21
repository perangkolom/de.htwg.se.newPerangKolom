package de.htwg.se.PerangKolom.model.KI;

import static org.junit.Assert.*;

import org.junit.Before;

import de.htwg.se.PerangKolom.model.KI.ICurrentStrategy;
import de.htwg.se.PerangKolom.model.KI.impl.Algo_SacrificeLowestValue;
import de.htwg.se.PerangKolom.model.KI.impl.ComputerPlayerLogic;
import de.htwg.se.PerangKolom.model.impl.Cell;

public class ComputerPlayerLogicTest {

	public ICurrentStrategy strategy;
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
		ICurrentStrategy strategy = new Algo_SacrificeLowestValue();
		cpl.setStrategy(strategy);
		assertEquals(new Algo_SacrificeLowestValue(), strategy);
	}

}
