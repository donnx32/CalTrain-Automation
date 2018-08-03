package objects;

public class Robot {
		
//	private String robot_name;
	private String robotStatus;  // WAITING, RIDING
	private int departureStation;
	private Station robot_station;
	
	public Robot(Station station, int station_number) {
		this.setrobotStatus("WAITING");
		this.setdepartureStation(station_number);
		this.setrobot_station(station);
	}

	
//	public void run() {
//		
//	}
	
	//////////////////getters and setters////////////////////
	/**
	 * @return the robotStatus
	 */
	public String getrobotStatus() {
		return robotStatus;
	}

	/**
	 * @param robotStatus the robotStatus to set
	 */
	public void setrobotStatus(String robotStatus) {
		this.robotStatus = robotStatus;
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
	 * @return the robot_station
	 */
	public Station getrobot_station() {
		return robot_station;
	}

	/**
	 * @param robot_station the robot_station to set
	 */
	public void setrobot_station(Station robot_station) {
		this.robot_station = robot_station;
	}
	
	
}
