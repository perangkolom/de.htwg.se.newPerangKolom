package de.htwg.se.PerangKolom.controller;

import de.htwg.se.PerangKolom.util.observer.IObservable;

public interface IPKController  extends IObservable {

	void createNewGrid(int rows, int cols);
	
}
