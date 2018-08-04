package objects;

import model.RailManager;

public class Robot implements Runnable {
	private static int latestId = 0;
	private int id;
	private int start;
	private int dest;
	private boolean isOnBoard;

	public Robot(int start, int dest) {
		latestId++;
		this.id = latestId;
		this.start = start;
		this.dest = dest;
		isOnBoard = false;
	}

	@Override
	public void run() {
		System.out.println("HUHU!");
		Station tempStation = RailManager.stationList.get(start - 1);
		Train tempTrain;

		tempStation.addrobot(this);
		
		while((tempTrain = RailManager.stationList.get(start - 1).getcurrentTrain()) == null){
		}
		
		tempStation.getRobotList().remove(tempStation.getRobotList().size() - 1);
		tempTrain.addrobot(this);

		while (true) {
			if(tempTrain.getCurrStation() == dest) {
				tempTrain.getRobotList().remove(tempTrain.getRobotList().size() - 1);
				setOnBoard(false);
				System.out.println("FIN!");
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