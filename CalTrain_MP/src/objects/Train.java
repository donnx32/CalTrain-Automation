package objects;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import model.CalTrainII;

public class Train implements Runnable {
	private static int latestnumber = 0;
	private ArrayList<Robot> robotList;
	private Semaphore semTrain;
	private int currStation;
	private int capacity;
	private int number;

	public Train(int capacity) {
		latestnumber++;
		this.setnumber(latestnumber);
		this.setcapacity(capacity);
		this.semTrain = new Semaphore(capacity, true);
		this.robotList = new ArrayList<Robot>();
	}

	@Override
	public void run() {
		System.out.printf("Train #%d {capacity : %d/%d} deployed\n", number, this.robotList.size(), capacity);

		try {
			while (true) {
				for (Station s : CalTrainII.stationList) {
					Thread.sleep(4200); // Moving to the next station.

					System.out.printf("Train #%d {capacity : %d/%d} is approaching station %d\n", number,
							this.robotList.size(), capacity, s.getNumber() + 1);
					s.getsemStation().acquire();

					synchronized (this) {
						s.setcurrentTrain(this);
					}
					
					System.out.printf("Train #%d {capacity : %d/%d} is @ station %d\n", number,
							this.robotList.size(), capacity, s.getNumber() + 1);

					currStation = s.getNumber() + 1;

					Thread.sleep(2000); // Loading and Unloading of robot passengers.

					synchronized (this) {
						s.setcurrentTrain(null);
					}

					s.getsemStation().release();

					System.out.printf("Train #%d {capacity : %d/%d} is leaving station %d\n", number,
							this.robotList.size(), capacity, s.getNumber() + 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Semaphore getSemTrain() {
		return semTrain;
	}

	public void setSemTrain(Semaphore semTrain) {
		this.semTrain = semTrain;
	}

	public boolean isFull() {
		return capacity <= robotList.size();
	}

	public void addrobot(Robot rider) {
		if (!isFull())
			this.robotList.add(rider);
		else
			System.out.println("Train #" + this.getNumber() + " is currently full. Cannot load more robot.");
	}

	public void removeRobot(Robot r) {
		robotList.remove(r);
	}

	public void removeRobot(int id) {
		for (int i = 0; i < robotList.size(); i++) {
			if (robotList.get(i).getId() == id) {
				robotList.remove(i);
				break;
			}
		}
	}

	public ArrayList<Robot> getRobotList() {
		return robotList;
	}

	public void setRobotList(ArrayList<Robot> robotList) {
		this.robotList = robotList;
	}

	public int getNumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	public int getCurrStation() {
		return currStation;
	}

	public void setCurrStation(int currStation) {
		this.currStation = currStation;
	}

	public int getcapacity() {
		return capacity;
	}

	public void setcapacity(int capacity) {
		this.capacity = capacity;
	}
}