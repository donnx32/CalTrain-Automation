package objects;

public class Passenger {
		
//	private String passenger_name;
	private String passenger_status;  // WAITING, RIDING
	private int destination_number;
	private Station passenger_station;
	
	public Passenger(Station station, int station_number) {
		this.setPassenger_status("WAITING");
		this.setDestination_number(station_number);
		this.setPassenger_station(station);
	}

	
//	public void run() {
//		
//	}
	
	//////////////////getters and setters////////////////////
	/**
	 * @return the passenger_status
	 */
	public String getPassenger_status() {
		return passenger_status;
	}

	/**
	 * @param passenger_status the passenger_status to set
	 */
	public void setPassenger_status(String passenger_status) {
		this.passenger_status = passenger_status;
	}

	/**
	 * @return the destination_number
	 */
	public int getDestination_number() {
		return destination_number;
	}

	/**
	 * @param destination_number the destination_number to set
	 */
	public void setDestination_number(int destination_number) {
		this.destination_number = destination_number;
	}

	/**
	 * @return the passenger_station
	 */
	public Station getPassenger_station() {
		return passenger_station;
	}

	/**
	 * @param passenger_station the passenger_station to set
	 */
	public void setPassenger_station(Station passenger_station) {
		this.passenger_station = passenger_station;
	}
	
	
}
