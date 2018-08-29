package model;

import java.util.ArrayList;

import objects.Robot;
import objects.Station;
import objects.Train;
import view.MainView;

public class CalTrainII {
	private final String[] stationNames = { "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel" };
	public static ArrayList<Station> stationList;
	public static ArrayList<Train> trainList;
	private ArrayList<Thread> trainThreads;
	private ArrayList<Thread> robotThreads;
	private ArrayList<Robot> robotList;
	public static String mode; // "semaphores" || "locks" ?

	public CalTrainII() {
		robotThreads = new ArrayList<Thread>();
		robotList = new ArrayList<Robot>();
		stationList = new ArrayList<Station>();
		trainThreads = new ArrayList<Thread>();
		trainList = new ArrayList<Train>();
		mode = "";

		for (int i = 0; i < stationNames.length; i++) {
			stationList.add(new Station(stationNames[i], i));
		}
	}
	
	public CalTrainII(String m) {
		robotThreads = new ArrayList<Thread>();
		robotList = new ArrayList<Robot>();
		stationList = new ArrayList<Station>();
		trainThreads = new ArrayList<Thread>();
		trainList = new ArrayList<Train>();
		mode = m;

		for (int i = 0; i < stationNames.length; i++) {
			stationList.add(new Station(stationNames[i], i));
		}
	}
	
	public void addRobot(Robot r) {
		robotList.add(r);
	}

	public void spawnRobot(int start, int destination) {
		Robot r = new Robot(start, destination);

		/////////////////////////////////////
//		Station startStation = stationList.get(start - 1);
//		startStation.addRobot(r);
//
//		String info = "[" + java.time.LocalTime.now() + "]" + " Passenger " + r.id + " is waiting @ station" + r.start + ", destination " + r.dest + "\n";
//		MainView.model.addRow(new Object[]{info});
//		synchronized (this) {
//			waitForTrain(startStation);
//		}
//		// System.out.println("PASSENGER " + id + " WAIT IS DONE");
//
//		startStation.removeRobot(this);
//		// System.out.println(this + " curr train is " + myTrain.getNumber());
//
//		System.out.println("myTrain: "+myTrain);
//		System.out.println("this: " +this);
//		myTrain.addrobot(r);
//
//		System.out.println("Robot Passenger " + this.id + " is boarding in Train #" + myTrain.getNumber());
//		MainView.model.addRow(new Object[]{"[" + java.time.LocalTime.now() + "]" +" Robot Passenger " + this.id + " is boarding in Train #" + myTrain.getNumber()});
		

		///////////////////////////////////
			
		robotThreads.add(new Thread(r));
		this.addRobot(r);
		
		robotThreads.get(robotThreads.size() - 1).start();
	}

	public void deployTrain(int capacity) {
		Train t = new Train(capacity);
		trainList.add(t);
		trainThreads.add(new Thread(t));
		trainThreads.get(trainThreads.size() - 1).start();
	}
	
	public Train getTrainIndex(int i) {
		return trainList.get(i);
	}
}