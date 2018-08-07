package client;

import gui.StationFrame;
import model.CalTrainII;

public class TestingGrounds {

	public static void main(String[] args) throws InterruptedException {

		CalTrainII C = new CalTrainII("locks");
		new StationFrame();

		C.spawnRobot(1, 5);
		C.spawnRobot(1, 5);
		C.spawnRobot(1, 5);
		C.spawnRobot(2, 4);
		C.spawnRobot(2, 6);
		C.spawnRobot(2, 5);
		C.spawnRobot(2, 7);
		C.spawnRobot(3, 4);
		C.spawnRobot(2, 5);

		Thread.sleep(1000);

		C.deployTrain(6);

		Thread.sleep(5000);

		C.deployTrain(6);
		
//		Thread.sleep(3*60*1000);
//		System.exit(0);
	}
}
