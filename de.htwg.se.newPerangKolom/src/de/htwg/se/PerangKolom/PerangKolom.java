package de.htwg.se.PerangKolom;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import de.htwg.se.PerangKolom.aview.tui.TextUI;
import de.htwg.se.PerangKolom.controller.IPerangKolomController;
import de.htwg.se.PerangKolom.controller.impl.PerangKolomController;
import de.htwg.se.PerangKolom.model.impl.MessagesForUser2;


public final class PerangKolom {

	private static Scanner scanner;
	private IPerangKolomController controller;
	private static TextUI tui;
	private static PerangKolom instance = null;
	private Logger logger;
	
	private PerangKolom() {
		controller = new PerangKolomController();
		tui = new TextUI(new PerangKolomController());
		logger = Logger.getLogger("de.htwg.se.PerangKolom.PerangKolom");
	}
	
	public static PerangKolom getInstance() {
		if (instance == null) instance = new PerangKolom();
		return instance;
	}
	
	public static void main(String[] args) {
		// Set up logging through log4j
		PropertyConfigurator.configure("log4j.properties");
		
		PerangKolom.getInstance();
		
		//print the welcome-string
		PerangKolom.getInstance().logger.info(MessagesForUser2.startOfTheGame);
		
		// continue to read user input on the TUI until the user decides to quit
		boolean continueGame = true;
		scanner = new Scanner(System.in);
		while (continueGame) {
			continueGame = tui.processInputLine(scanner.next());
		}
	}
	
}

