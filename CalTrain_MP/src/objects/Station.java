package objects;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Station {

	private int station_number;
	private String station_name;
	private String station_state; 			//States: USED, WAITING
	private boolean has_train;
	private int station_passenger_waiting;
	private Train train_at_station;
	private ArrayList<Passenger> passengers_at_station;
	private ArrayList<Thread> passenger_threads;
	
	// The FUN objects
	private Lock station_lock;
	private Condition station_condition;
	private Semaphore station_semaphore;
	
	
	public Station(String name, int num) {
		this.station_init(name, num);
	}
	
	
	/*
	 *  Initialize Station Object here
	 */
	public void station_init(String name, int number) {
		this.station_name = name;
		this.station_number = number;  // will this be used??
		this.setStation_state("WAITING");
		this.setStation_passenger_waiting(0);
		this.has_train = false;
		this.train_at_station = null;
		this.passenger_threads = new ArrayList<Thread>();
		this.passengers_at_station = new ArrayList<Passenger>();
	}
	
	// adds a passenger into the list of passengers waiting at the train station
	public void addPassenger(Passenger robot) {
		passengers_at_station.add(robot);
	}
	
	public void displayPassengers() {
		for (int i=0;i<passengers_at_station.size();i++) {
			System.out.println("Robot " +(i+1) +" @" +station_name); 
		}
	}
	
	///////////setters and getters///////////////////
	
	public boolean hasTrain() {
		return this.has_train;
	}
	
	public int getStation_number() {
		return station_number;
	}
	public void setStation_number(int station_number) {
		this.station_number = station_number;
	}
	public Train getTrain_at_station() {
		return train_at_station;
	}
	public void setTrain_at_station(Train train_at_station) {
		this.train_at_station = train_at_station;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}


	public String getStation_state() {
		return station_state;
	}


	public void setStation_state(String station_state) {
		this.station_state = station_state;
	}


	public int getStation_passenger_waiting() {
		return station_passenger_waiting;
	}


	public void setStation_passenger_waiting(int station_passenger_waiting) {
		this.station_passenger_waiting = station_passenger_waiting;
	}
	
	
}
