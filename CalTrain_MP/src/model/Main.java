package model;

import objects.Station;
import objects.Train;

public class Main {
	
	private Train[] trains = new Train[16];
	private Station[] stations = new Station[8];
	private int running_trains = 0;
	
	private String[] names = {"Alpha", "Bravo", "Charlie", "Delta",
								"Echo", "Foxtrot", "Golf", "Hotel"};
	
	public Main() {
		// initialize stations
		for(int i=0; i<8; i++) {
			stations[i] = new Station(names[i], i);
		}
	}
	
	
	
	
}
