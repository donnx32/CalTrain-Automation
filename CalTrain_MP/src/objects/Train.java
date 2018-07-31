package objects;

import java.util.ArrayList;

public class Train implements Runnable {
	private static int latestnumber = 0;
	private int number;
	private String status; // STANDBY, MOVING, LOADING
	private int capacity;
	private boolean isDoorOpen;
	private boolean isRunning;
	private ArrayList<Passenger> passengerList;
	private Station[] stations;
	// private int currStation;
	// Semaphores, locks, etc.
	// private Semaphore available_seats;

	public Train(int num_of_seats, Station[] stations) {
		latestnumber++;
		this.stations = stations;
		this.setnumber(latestnumber);
		this.setstatus("STANDBY");
		this.setcapacity(num_of_seats);
		this.setisDoorOpen(false);
		this.setisRunning(true);
		this.passengerList = new ArrayList<Passenger>();
	}

	public Train(int t_number, int num_of_seats) {
		this.setnumber(t_number);
		this.setstatus("STANDBY");
		this.setcapacity(num_of_seats);
		this.setisDoorOpen(false);
		this.setisRunning(true);
		this.passengerList = new ArrayList<Passenger>();
	}

	@Override
	public void run() {
		try {
			System.out.printf("Train deployed {number: %d, status: %s, capacity: %d seats}\n", number, status,
					capacity);

			for (Station s : stations) {
				System.out.println("Train #" + this.number + " is approaching " + s.getname() + " station");
				Thread.sleep(1750);
				System.out.println("Train #" + this.number + " is leaving " + s.getname() + " station");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPassenger(Passenger rider) {
		this.passengerList.add(rider);
	}

	///////////////// getters and setters////////////////////
	public int getnumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	public int getcapacity() {
		return capacity;
	}

	public void setcapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isisDoorOpen() {
		return isDoorOpen;
	}

	public void setisDoorOpen(boolean isDoorOpen) {
		this.isDoorOpen = isDoorOpen;
	}

	public boolean isisRunning() {
		return isRunning;
	}

	public void setisRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public int getcurrStation() {
		return currStation;
	}

	public void setcurrStation(int currStation) {
		this.currStation = currStation;
	}
}
