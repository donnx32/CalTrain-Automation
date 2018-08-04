package objects;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Station {
	private ArrayList<Robot> robotList;
	private Train currentTrain;
	private Semaphore sem;
	private String name;
	private int number;

	public Station(String name, int num) {
		this.name = name;
		this.number = num;
		this.currentTrain = null;
		this.robotList = new ArrayList<Robot>();
		this.sem = new Semaphore(1, true);
	}

	public void addrobot(Robot robot) {
		robotList.add(robot);
	}

	public void displayrobots() {
		for (int i = 0; i < robotList.size(); i++) {
			System.out.println("Robot " + (i + 1) + " @" + name);
		}
	}
	
	public Semaphore getSem() {
		return sem;
	}

	public void setSem(Semaphore sem) {
		this.sem = sem;
	}

	public int getnumber() {
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
		return currentTrain;
	}

	public void setcurrentTrain(Train currentTrain) {
		this.currentTrain = currentTrain;

		System.out.println("Train #" + currentTrain.getNumber() + " is @ " + this.getname() + " station");
	}
	
	public ArrayList<Robot> getRobotList() {
		return robotList;
	}

	public void setRobotList(ArrayList<Robot> robotList) {
		this.robotList = robotList;
	}
}