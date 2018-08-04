package model;

import java.util.concurrent.Semaphore;

import objects.Robot;
import objects.Station;
import objects.Train;

public class Main {
	
	public static Train[] trains = new Train[16]; // or is this a thread?
//	static Thread[] trainThreads = new Thread[16];
	public static Station[] stations = new Station[8];
	private int running_trains = 0;
//	static Semaphore availableSeats;
	
	public static String[] names = {"Alpha", "Bravo", "Charlie", "Delta",
								"Echo", "Foxtrot", "Golf", "Hotel"};
	
	public Main() {
		// initialize stations
		for(int i=0; i<8; i++) {
			Station st = new Station(names[i], i);
			stations[i] = st;
		}
	}
	
	public void addStationPassengers(int source, Robot robot) {
		stations[source].addRobot(robot);
	}
}