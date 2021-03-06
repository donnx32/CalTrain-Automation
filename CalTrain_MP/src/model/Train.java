package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.imageio.ImageIO;

import controller.CalTrainII;
import view.MainView;

public class Train implements Runnable {
	private static int latestnumber = 0;
	private ArrayList<Robot> robotList;
	private BufferedImage trainImage;
	private Semaphore semTrain;
	private Lock trainLock;
	private int currStation;
	private int capacity;
	private int number;
	private int x;
	private int y;
	private int v;
	private String status;
	private String approachingStation;
	private Station nStation = CalTrainII.stationList.get(0);

	public Train(int capacity) {
		x = -193;
		y = 215;
		v = 1;
		latestnumber++;
		this.setnumber(latestnumber);
		this.setcapacity(capacity);
		this.semTrain = new Semaphore(capacity, true);
		this.robotList = new ArrayList<Robot>();
		this.trainLock = new ReentrantLock();
		try {
			this.trainImage = ImageIO.read(new File("src/res/train.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.status = "wait";
	}

	@Override
	public void run() {
		System.out.printf("Train #%d {capacity : %d/%d} deployed\n", number, capacity, this.robotList.size());

		try {
			// This train object will just simply traverse all 8 stations endlessly until
			// program is terminated.
			while (true) {
				for (Station s : CalTrainII.stationList) {
					nStation = s;
					//Thread.sleep(7200); // Moving to the next station.

					displayStatus(s, "approaching");
					this.approachingStation = s.getname();
					setStatus("approaching");
					Thread.sleep(3100); // Moving to the next station.
					
					if (CalTrainII.mode.equalsIgnoreCase("locks"))
						s.getStationLock().lock();
					else
						s.getsemStation().acquire(); // Gets the permit to use the station, so that no other train can
														// enter.
					synchronized (this) {
						s.setcurrentTrain(this);
					}

					displayStatus(s, "@");
					setStatus("@");

					currStation = s.getNumber() + 1;

					Thread.sleep(3100); // Loading and Unloading of robot passengers..
					synchronized (this) {
						s.setcurrentTrain(null);
					}

					displayStatus(s, "leaving");
					setStatus("leaving");
					
					if (CalTrainII.mode.equalsIgnoreCase("locks"))
						s.getStationLock().unlock();
					else
						s.getsemStation().release(); // Releases the permit of the station, so that a new train can use
					// the station.

					
					// TODO: display the train leaving the station

					//System.out.println("Train #" + this.number + " passenger list " + this.getRobotList());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		// g.drawImage(trainImage, null, x, y);
		g.setFont(new Font("Century Gothic", Font.BOLD, 35));
		g.setColor(Color.WHITE);
		
		g.drawImage(trainImage, x, y, 100, 30, null);
		
		g.drawString(String.valueOf(number), x + 45, y + 15);
	}

	public void update() {
		int z;
		//x += v;
		/*try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if (nStation.getcurrentTrain() == this) {
			//if (status.equalsIgnoreCase("@")) {
				switch (nStation.getname()) {
				case "Alpha":
					x = 97;
					break;
				case "Bravo":
					x = 385;
					break;
				case "Charlie":
					x = 675;
					break;
				case "Delta":
					x = 965;
					break;
				case "Echo":
					x = 965;
					break;
				case "Foxtrot":
					x = 675;
					break;
				case "Golf":
					x = 385;
					break;
				case "Hotel":
					x = 97;
					break;
				}
			//}
		} else {
			//x += v;
				if (nStation.getcurrentTrain() != null) {					
					switch (nStation.getname()) {
					case "Alpha":
						x = -190;
						break;
					case "Bravo":
						x = 240;
						break;
					case "Charlie":
						x = 530;
						break;
					case "Delta":
						x = 820;
						break;
					case "Echo":
						x = 1180;
						break;
					case "Foxtrot":
						x = 820;
						break;
					case "Golf":
						x = 530;
						break;
					case "Hotel":
						x = 240;
						break;
					}
				} else {
					x += v;
				}
		}

		if (x >= 1180 && y == 215) {
			x = 1040;
			y = 478;
			v = -1;
		} else if (x <= -50 && y == 478) {
			x = -50;
			y = 215;
			v = 1;
		}
	}

	public void displayStatus(Station s, String v) {
		String info ="[" + java.time.LocalTime.now() + "]" + " Train" + number + "{capacity :" + capacity + "/" + this.robotList.size() + "} is " + v + " station " + s.getNumber() +"\n";
		
		//System.out.println(java.time.LocalTime.now());
		System.out.printf(info);
		 
		
		MainView.model.addRow(new Object[]{info});
	}

	public Semaphore getSemTrain() {
		return semTrain;
	}

	public void setSemTrain(Semaphore semTrain) {
		this.semTrain = semTrain;
	}

	public boolean isFull() {
		return robotList.size() >= capacity;
	}

	public void addrobot(Robot rider) {
		if (!isFull())
			synchronized (this) {
				this.robotList.add(rider);
			}			
		else
			System.out.println(this + " Train #" + this.getNumber() + " is currently full. Cannot load more robot.");
	}

	public void removeRobot(Robot r) {
		synchronized (this) {
			robotList.remove(r);
		}
	}

	public void removeRobot(int id) {
		for (int i = 0; i < robotList.size(); i++) {
			if (robotList.get(i).getId() == id) {
				robotList.remove(i);
				break;
			}
		}
	}

	public ArrayList<Robot> getRobotList() {
		return robotList;
	}

	public void setRobotList(ArrayList<Robot> robotList) {
		this.robotList = robotList;
	}

	public int getNumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	public int getCurrStation() {
		return currStation;
	}

	public void setCurrStation(int currStation) {
		this.currStation = currStation;
	}

	public int getcapacity() {
		return capacity;
	}

	public void setcapacity(int capacity) {
		this.capacity = capacity;
	}

	public Lock getTrainLock() {
		return trainLock;
	}

	public void setTrainLock(Lock trainLock) {
		this.trainLock = trainLock;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApproachingStation() {
		return approachingStation;
	}

	public void setApproachingStation(String approachingStation) {
		this.approachingStation = approachingStation;
	}
}