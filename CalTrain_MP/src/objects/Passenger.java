package objects;

public class Passenger {
		
//	private String passenger_name;
	private String passengerStatus;  // WAITING, RIDING
	private int departureStation;
	private Station passenger_station;
	
	public Passenger(Station station, int station_number) {
		this.setpassengerStatus("WAITING");
		this.setdepartureStation(station_number);
		this.setPassenger_station(station);
	}

	
//	public void run() {
//		
//	}
	
	//////////////////getters and setters////////////////////
	/**
	 * @return the passengerStatus
	 */
	public String getpassengerStatus() {
		return passengerStatus;
	}

	/**
	 * @param passengerStatus the passengerStatus to set
	 */
	public void setpassengerStatus(String passengerStatus) {
		this.passengerStatus = passengerStatus;
	}

	/**
	 * @return the departureStation
	 */
	public int getdepartureStation() {
		return departureStation;
	}

	/**
	 * @param departureStation the departureStation to set
	 */
	public void setdepartureStation(int departureStation) {
		this.departureStation = departureStation;
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
