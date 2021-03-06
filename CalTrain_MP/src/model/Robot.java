package model;

import controller.CalTrainII;
import view.MainView;

public class Robot implements Runnable {
	private static int latestId = 0;
	private boolean isOnBoard;
	private Train myTrain;
	private int start;
	private int dest;
	private int id;

	public Robot(int start, int dest) {
		latestId++;
		this.id = latestId;
		this.start = start;
		this.dest = dest;
		isOnBoard = false;
		myTrain = null;
	}

	@Override
	public void run() {

		/**
		 * This will execute a typical passenger life span.
		 * 
		 * [1] Adds itself to the passenger list of the station
		 * 
		 * [2] Calls the the wait function. Then it will patiently wait for a free
		 * train.
		 * 
		 * [3] If a free train comes it will then remove itself to the passenger list of
		 * the station and acquire a train semaphore, which is the equivalent of sitting
		 * inside the train. Then it will load itself to the passenger list of the free
		 * train. Otherwise it will continue to wait for a free train.
		 * 
		 * [4] Once inside the train, it will patiently wait till train arrives @
		 * destination. If destination station is reached, it would release the train
		 * semaphore it acquired earlier to signify that the this robot passenger has
		 * alighted from the train. Thus, it reaches the end of its (process) life span.
		 * 
		 */
		try {
			Station startStation = CalTrainII.stationList.get(start - 1);

			startStation.addRobot(this);

			String info = "[" + java.time.LocalTime.now() + "]" + " Passenger " + this.id + " is waiting @ station"
					+ this.start + ", destination " + this.dest + "\n";
			MainView.model.addRow(new Object[] { info });
			synchronized (this) {
				waitForTrain(startStation);
			}
			// System.out.println("PASSENGER " + id + " WAIT IS DONE");

			startStation.removeRobot(this);
			// System.out.println(this + " curr train is " + myTrain.getNumber());

			// System.out.println("myTrain: "+myTrain);
			// System.out.println("this: " +this);
			// myTrain.addrobot(this);

			System.out.println("Robot Passenger " + this.id + " is boarding in Train #" + myTrain.getNumber());
			MainView.model.addRow(new Object[] { "[" + java.time.LocalTime.now() + "]" + " Robot Passenger " + this.id
					+ " is boarding in Train #" + myTrain.getNumber() });

			// Wait till train arrives @ destination.
			while (true) {
				Thread.sleep(11);

				if (myTrain.getCurrStation() == dest) {

					myTrain.removeRobot(this);

					if (!(CalTrainII.mode.equalsIgnoreCase("locks")))
						myTrain.getSemTrain().release();
					// System.out.println("TRAIN #" + myTrain.getNumber() + " SEMA RELEASED");
					System.out.println(
							this + " Robot Passenger " + this.id + " is alighting @ destination station " + this.dest);
					MainView.model.addRow(new Object[] { "[" + java.time.LocalTime.now() + "]" + " Robot Passenger "
							+ this.id + " is alighting @ destination station " + this.dest });
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
				Thread.sleep(11); // Won't work without this, IDK why...
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (this) {
				if (startStation.getcurrentTrain() != null) {

					if (!(startStation.getcurrentTrain().isFull())) {
						try {
							if (CalTrainII.mode.equalsIgnoreCase("locks"))
								startStation.getcurrentTrain().getTrainLock().lock();
							else
								startStation.getcurrentTrain().getSemTrain().acquire();
							synchronized (this) {
								setMyTrain(startStation.getcurrentTrain());
								System.out.println(myTrain+" this robot: "+this);
							
								myTrain.addrobot(this);
							}
							synchronized(this) {
								if (CalTrainII.mode.equalsIgnoreCase("locks"))
									startStation.getcurrentTrain().getTrainLock().unlock();
							}
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
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

	public Train getMyTrain() {
		return myTrain;
	}

	public void setMyTrain(Train myTrain) {
		synchronized (this) {
			this.myTrain = myTrain;
		}
	}
}