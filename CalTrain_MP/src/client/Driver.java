package client;

import model.CalTrainII;
import view.MainView;

public class Driver {
	
	public static void main(String[] args) {
		new MainView(new CalTrainII());
	}
}
