package client;

import model.RailManager;
import model.RobotManager;

public class TestingGrounds {

	public static void main(String[] args) throws InterruptedException {

		RailManager rm = new RailManager();
		RobotManager R = new RobotManager();
		
		rm.addTrain(2);
		rm.runLatestTrain();
		
		rm.addTrain(2);
		rm.runLatestTrain();
	}
}
