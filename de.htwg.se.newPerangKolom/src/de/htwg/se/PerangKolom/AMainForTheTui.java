package de.htwg.se.PerangKolom;

import org.apache.log4j.PropertyConfigurator;

import de.htwg.se.PerangKolom.aview.tui.TextUI2;
import de.htwg.se.PerangKolom.controller.IPKController;
import de.htwg.se.PerangKolom.controller.impl.PKController;
import de.htwg.se.PerangKolom.model.ICell2;
import de.htwg.se.PerangKolom.model.impl.Cell2;


public class AMainForTheTui {

	
	public static void main(String[] args) {

		IPKController controller = new PKController();

		// Set up logging through log4j
		PropertyConfigurator.configure("log4j.properties");
		
		TextUI2 tui = new TextUI2(new PKController());
		
		tui.printTUI();
		
		
		
		controller.setAllBordersFilled();
		
		tui.printTUI();
			
		int testSum = 0;
		for (int i = 0; i < controller.getNumberOfRows(); i++) {
			for (int j = 0; j < controller.getNumberOfCols(); j++) {
				ICell2 cell = controller.getInstance().getCellArray()[i][j];
				if (	cell.getBorder(Cell2.BORDER_TOP) &&
						cell.getBorder(Cell2.BORDER_BOTTOM) &&
						cell.getBorder(Cell2.BORDER_LEFT) &&
						cell.getBorder(Cell2.BORDER_RIGHT)
						)
				{
					testSum ++;
					
				}
			}
		}
		if (testSum == 9) {
			System.out.println("ALL BORDERS ARE FILLED!\n");
		}
	}
}
