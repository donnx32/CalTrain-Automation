package model;

import java.util.ArrayList;

import objects.Robot;

public class RobotManager {
	private ArrayList<Thread> robotThreads;
	private ArrayList<Robot> robotList;

	public RobotManager() {
		this.robotList = new ArrayList<Robot>();
		this.robotThreads = new ArrayList<Thread>();
	}

	public void addRobot(Robot r) {
		robotList.add(r);
	}

	public void spawnRobot(int start, int destination) {
		Robot r = new Robot(start, destination);

		robotThreads.add(new Thread(r));
		this.addRobot(r);
		
		robotThreads.get(robotThreads.size() - 1).start();
	}
	
	public void start() {
		robotThreads.get(robotThreads.size() - 1).start();
	}

	public void spawnRobot(String start, String destination) {

	}
}