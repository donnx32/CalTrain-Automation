package model;

import java.util.ArrayList;

import objects.Robot;
import objects.Station;
import objects.Train;

public class RailManager {
	private final String[] stationNames = { "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel" };
	public static ArrayList<Station> stationList;
	private ArrayList<Thread> trainThreads;
	private ArrayList<Train> trainList;

	public RailManager() {
		stationList = new ArrayList<Station>();
		trainList = new ArrayList<Train>();
		trainThreads = new ArrayList<Thread>();

		for (int i = 0; i < stationNames.length; i++) {
			stationList.add(new Station(stationNames[i], i));
		}
	}

	public void addTrain(int capacity) {
		Train t = new Train(capacity);
		trainList.add(t);
		trainThreads.add(new Thread(t));
	}

	public void runLatestTrain() {
		trainThreads.get(trainThreads.size() - 1).start();
	}

	public Train getTrainIndex(int i) {
		return trainList.get(i);
	}
	
	public void spawnRobot(int start, int destination) {
		stationList.get(start - 1).addrobot(new Robot(start, destination));
	}
	
	public void spawnRobot(String start, String destination) {
		
	}
}