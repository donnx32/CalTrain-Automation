package objects;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Station {
	private ArrayList<Robot> robotList;
	private Semaphore semStation;
	private Lock stationLock;
	private Train currentTrain;
	private String name;
	private int number;

	public Station(String name, int num) {
		this.name = name;
		this.number = num;
		this.currentTrain = null;
		this.robotList = new ArrayList<Robot>();
		this.stationLock = new ReentrantLock();
		this.semStation = new Semaphore(1, true);
	}

	public void addRobot(Robot robot) {
		synchronized (this) {
			robotList.add(robot);
		}
	}

	public void removeRobot(Robot r) {
		synchronized (this) {
			robotList.remove(r);
		}
	}

	public void removeRobot(int id) {
		for (int i = 0; i < robotList.size(); i++) {
			if (robotList.get(i).getId() == id) {
				robotList.remove(i);
				break;
			}
		}
	}

	public void displayrobots() {
		for (int i = 0; i < robotList.size(); i++) {
			System.out.println("Robot " + (i + 1) + " @" + name);
		}
	}

	public Semaphore getsemStation() {
		return semStation;
	}

	public void setsemStation(Semaphore semStation) {
		this.semStation = semStation;
	}

	public int getNumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Train getcurrentTrain() {
		synchronized(this) {
			return currentTrain;
		}
	}

	public void setcurrentTrain(Train currentTrain) {
		synchronized(this) {
			this.currentTrain = currentTrain;
		}
	}

	public ArrayList<Robot> getRobotList() {
		return robotList;
	}

	public void setRobotList(ArrayList<Robot> robotList) {
		this.robotList = robotList;
	}

	public Lock getStationLock() {
		return stationLock;
	}

	public void setStationLock(Lock stationLock) {
		this.stationLock = stationLock;
	}
}