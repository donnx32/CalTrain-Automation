package objects;

import model.CalTrainII;

public class Robot implements Runnable {
	private static int latestId = 0;
	private boolean isOnBoard;
	private int start;
	private int dest;
	private int id;

	public Robot(int start, int dest) {
		latestId++;
		this.id = latestId;
		this.start = start;
		this.dest = dest;
		isOnBoard = false;
	}

	@Override
	public void run() {
		try {
			Station startStation = CalTrainII.stationList.get(start - 1);

			startStation.addRobot(this);

			System.out.printf("Robot Passenger %d is waiting @ station %d\n", this.id, this.start);
			
			waitForTrain(startStation);
			
			startStation.removeRobot(this);

			Train myTrain = startStation.getcurrentTrain();

			myTrain.getSemTrain().acquire();
			
			synchronized (this) {
				myTrain.addrobot(this);
			}
			
			System.out.println("Robot Passenger " + this.id + " is boarding in Train #" + myTrain.getNumber());
			
			// Wait till train arrives @ destination.
			while (true) {
				Thread.sleep(1);
				//System.out.println("train curr = "+myTrain.getCurrStation());
				if(myTrain.getCurrStation() == dest) {
					synchronized (this) {
						myTrain.removeRobot(this);
					}
					
					myTrain.getSemTrain().release();
					
					System.out.println("Robot Passenger " + this.id + " is alighting @ destination staion " + this.dest);
					
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForTrain(Station startStation) {
		// Waiting for train...
		while (true) {
			
			try {
				Thread.sleep(1); // For some reason, if I remove this, it wont work.
				if(startStation.getcurrentTrain() != null && !startStation.getcurrentTrain().isFull()) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public boolean isOnBoard() {
		return isOnBoard;
	}

	public void setOnBoard(boolean isOnBoard) {
		this.isOnBoard = isOnBoard;
	}
}