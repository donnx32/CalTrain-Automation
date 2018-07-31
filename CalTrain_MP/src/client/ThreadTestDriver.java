package client;

import java.util.ArrayList;
import java.util.Random;

import objects.Station;
import objects.Train;

public class ThreadTestDriver {
	/**
	 * A driver to simply test the train thread objects. This class spawn/deploy
	 * train every 2 seconds interval.
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		String[] names = { "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel" };
		Thread[] trainThreadArr = new Thread[16];
		Station[] stations = new Station[8];
		Random r = new Random();
		
		// Initialization of station names.
		for (int i = 0; i < names.length; i++)
			stations[i] = new Station(names[i], i);
		
		// Train Thread deployment simulation.
		for (int i = 0; i < 16; i++) {
			trainThreadArr[i] = new Thread(new Train(r.nextInt(50 + 1) + 50, stations));
			trainThreadArr[i].start();
			Thread.sleep(3500);
		}
	}
}