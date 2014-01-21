package de.htwg.se.PerangKolom.util.observer;

import de.htwg.se.PerangKolom.util.observer.Event;
import de.htwg.se.PerangKolom.util.observer.IObserver;

public interface IObservable {
	 void addObserver(IObserver s);
	 void removeObserver(IObserver s);
	 void removeAllObservers();
	 void notifyObservers();
	 void notifyObservers(Event e);
}
