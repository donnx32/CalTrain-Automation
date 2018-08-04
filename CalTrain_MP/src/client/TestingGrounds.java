package client;

import model.CalTrainII;
import model.RobotManager;

public class TestingGrounds {

	public static void main(String[] args) throws InterruptedException {

		CalTrainII rm = new CalTrainII();
		RobotManager R = new RobotManager();
		
		rm.addTrain(2);
		rm.runLatestTrain();
		
		R.spawnRobot(2, 3);
		R.spawnRobot(2, 4);
		R.spawnRobot(2, 5);
		
		rm.addTrain(2);
		rm.runLatestTrain();
	}
}
