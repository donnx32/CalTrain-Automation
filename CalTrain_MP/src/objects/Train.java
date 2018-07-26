package objects;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Train {
	
	private int train_number;
	private String train_name; 
	private String train_status;  		//STANDBY, MOVING, LOADING
	private int train_total_seats;
	private int train_passengers_in_train;
	private boolean train_isDoorOpen;
	private boolean train_isRunning;
	private ArrayList<Passenger> passengers_inside;
	private ArrayList<Passenger> passengers_droppedOff;
	private int train_station_number;
	// Semaphores, locks, etc.
	private Semaphore available_seats;
	
	public Train(String name, int t_number, int num_of_seats) {
		this.setTrain_number(t_number);
		this.setTrain_name(name);
		this.setTrain_status("STANDBY");
		this.setTrain_total_seats(num_of_seats);
		this.setTrain_passengers_in_train(0);
		this.setTrain_isDoorOpen(false);
		this.setTrain_isRunning(true);
		this.passengers_inside = new ArrayList<Passenger>();
		this.passengers_droppedOff = new ArrayList<Passenger>();
	}
	
	public Train(int t_number, int num_of_seats) {
		this.setTrain_number(t_number);
		this.setTrain_status("STANDBY");
		this.setTrain_total_seats(num_of_seats);
		this.setTrain_passengers_in_train(0);
		this.setTrain_isDoorOpen(false);
		this.setTrain_isRunning(true);
		this.passengers_inside = new ArrayList<Passenger>();
		this.passengers_droppedOff = new ArrayList<Passenger>();
	}
	
	public void addPassenger(Passenger rider) {
		this.passengers_inside.add(rider);
	}

	public void removePassenger() {
		passengers_droppedOff.clear();
		for (Passenger p: passengers_inside) {
//			if (p.get)
			//TODO
		}
	}
	
	/////////////////getters and setters////////////////////
	public int getTrain_number() {
		return train_number;
	}

	public void setTrain_number(int train_number) {
		this.train_number = train_number;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public String getTrain_status() {
		return train_status;
	}

	public void setTrain_status(String train_status) {
		this.train_status = train_status;
	}

	public int getTrain_total_seats() {
		return train_total_seats;
	}

	public void setTrain_total_seats(int train_total_seats) {
		this.train_total_seats = train_total_seats;
	}

	public int getTrain_passengers_in_train() {
		return train_passengers_in_train;
	}

	public void setTrain_passengers_in_train(int train_passengers_in_train) {
		this.train_passengers_in_train = train_passengers_in_train;
	}

	public boolean isTrain_isDoorOpen() {
		return train_isDoorOpen;
	}

	public void setTrain_isDoorOpen(boolean train_isDoorOpen) {
		this.train_isDoorOpen = train_isDoorOpen;
	}

	public boolean isTrain_isRunning() {
		return train_isRunning;
	}

	public void setTrain_isRunning(boolean train_isRunning) {
		this.train_isRunning = train_isRunning;
	}

	public int getTrain_station_number() {
		return train_station_number;
	}

	public void setTrain_station_number(int train_station_number) {
		this.train_station_number = train_station_number;
	}
	
	
	
	
}
