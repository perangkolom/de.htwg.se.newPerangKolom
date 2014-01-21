package de.htwg.se.PerangKolom.controller;


import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.util.observer.IObservable;


public interface IPerangKolomControllerBOOOOOM extends IObservable{

	/*
	 * creates new gamefield as grid, starts the game
	 */
	public void createNewGrid(int x, int y);
	
	/*
	 * resets the game, starts the game again, with same parameters
	 */
	public void reset();
	
	/*
	 * exits the game
	 */
	public void exit();
	
	/*
	 * All Computer Logic:
	 * - chose one of the three strategies
	 * - calls function 'fillBorder()'
	 */
	
	/*
	 * 
	 */
	
	public int getRandNumber(int x, int y);

	public Cell getCell(int i, int j);
}
