package objects;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Station {

	private int number;
	private String name;
	private Train currentTrain;
	private ArrayList<Passenger> passengerList;

	// The FUN objects
	private Lock station_lock;
	private Condition station_condition;
	private Semaphore station_semaphore;

	public Station(String name, int num) {
		this.station_init(name, num);
	}

	/*
	 * Initialize Station Object here
	 */
	public void station_init(String name, int number) {
		this.name = name;
		this.number = number; // will this be used??
//		this.setStation_state("WAITING");
//		this.setStation_passenger_waiting(0);
		this.currentTrain = null;
		this.passengerList = new ArrayList<Passenger>();
	}

	// adds a passenger into the list of passengers waiting at the train station
	public void addPassenger(Passenger robot) {
		passengerList.add(robot);
	}

	public void displayPassengers() {
		for (int i = 0; i < passengerList.size(); i++) {
			System.out.println("Robot " + (i + 1) + " @" + name);
		}
	}

	/////////// setters and getters///////////////////

	public int getnumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	public Train getcurrentTrain() {
		return currentTrain;
	}

	public void setcurrentTrain(Train currentTrain) {
		this.currentTrain = currentTrain;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public void test() {
		System.out.println(name);
	}
}