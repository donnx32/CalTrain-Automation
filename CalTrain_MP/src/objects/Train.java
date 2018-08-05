package objects;

import java.awt.Graphics;
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
	private int x;
	private int y;

	public Train(int capacity) {
		latestnumber++;
		this.setnumber(latestnumber);
		this.setcapacity(capacity);
		this.semTrain = new Semaphore(capacity, true);
		this.robotList = new ArrayList<Robot>();
	}

	@Override
	public void run() {
		System.out.printf("Train #%d {capacity : %d/%d} deployed\n", number, capacity, this.robotList.size());

		try {
			// This train object will just simply traverse all 8 stations endlessly until
			// program is terminated.
			while (true) {
				for (Station s : CalTrainII.stationList) {
					Thread.sleep(7200); // Moving to the next station.

					displayStatus(s, "approaching");
					// TODO: display train before the station its approaching

					if (CalTrainII.mode.equalsIgnoreCase("locks"))
						s.getStationLock().lock();
					else
						s.getsemStation().acquire(); // Gets the permit to use the station, so that no other train can
														// enter.

					synchronized (this) {
						s.setcurrentTrain(this);
					}

					displayStatus(s, "@");
					// TODO: display the train at the current station

					currStation = s.getNumber() + 1;

					Thread.sleep(5000); // Loading and Unloading of robot passengers..

					synchronized (this) {
						s.setcurrentTrain(null);
					}

					if (CalTrainII.mode.equalsIgnoreCase("locks"))
						s.getStationLock().unlock();
					else
						s.getsemStation().release(); // Releases the permit of the station, so that a new train can use
					// the station.

					displayStatus(s, "leaving");
					// TODO: display the train leaving the station

					System.out.println("Train #" + this.number + " passenger list " + this.getRobotList());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void tick() {
//		repaint();
//	}

	public void displayStatus(Station s, String v) {
		System.out.printf("Train #%d {capacity : %d/%d} is %s station %d\n", number, capacity, this.robotList.size(), v,
				s.getNumber() + 1);
	}

	public Semaphore getSemTrain() {
		return semTrain;
	}

	public void setSemTrain(Semaphore semTrain) {
		this.semTrain = semTrain;
	}

	public boolean isFull() {
		return robotList.size() >= capacity;
	}

	public void addrobot(Robot rider) {
		if (!isFull())
			this.robotList.add(rider);
		else
			System.out.println(this + " Train #" + this.getNumber() + " is currently full. Cannot load more robot.");
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