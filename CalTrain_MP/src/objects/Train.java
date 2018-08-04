package objects;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import model.RailManager;

public class Train implements Runnable {
	private Semaphore semStation;
	private static int latestnumber = 0;
	private ArrayList<Robot> robotList;
	private int currStation;
	private int capacity;
	private int number;

	public Train(int capacity) {
		latestnumber++;
		this.setnumber(latestnumber);
		this.setcapacity(capacity);
		this.robotList = new ArrayList<Robot>();
	}

	@Override
	public void run() {
		System.out.printf("Train {number : %d, capacity : %d seats, passengers : %d} deployed\n", number, capacity,
				this.robotList.size());

		try {
			while (true) {
				for (Station s : RailManager.stationList) {
					Thread.sleep(4200); // Moving to the next station.

					System.out.println("Train #" + this.getNumber() + " is approaching " + s.getname() + " station");

					s.getSem().acquire();
					synchronized (this) {
						s.setcurrentTrain(this);
						currStation = s.getnumber() + 1;
					}

					Thread.sleep(2000); // Loading and Unloading of robot passengers.
					
					s.getSem().release();

					System.out.println("Train #" + this.getNumber() + " is leaving " + s.getname() + " station");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Semaphore getSemStation() {
		return semStation;
	}

	public void setSemStation(Semaphore semStation) {
		this.semStation = semStation;
	}

	public boolean isFull() {
		return capacity >= robotList.size();
	}

	public void addrobot(Robot rider) {
		if (!isFull())
			this.robotList.add(rider);
		else
			System.out.println("Train #" + this.getNumber() + " is currently full. Cannot add more robot.");
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