package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.MatteBorder;

import model.Main;
import objects.Passenger;
import objects.Station;
import objects.Train;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class StationFrame extends JFrame {

	/**
	 * 
	 */
	Main caltrainMain;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldSeatCapacity;
	
//	private String[] names = {"Alpha", "Bravo", "Charlie", "Delta",
//			"Echo", "Foxtrot", "Golf", "Hotel"};
//	private Train[] trains = new Train[16];
//	private Station[] stations = new Station[8];
	private int running_trains = 0;
	private int passengers_added = 0;
//	private BufferedImage imgStation;
	
	//private ObservableList<String> 
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StationFrame frame = new StationFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public StationFrame() {
		caltrainMain = new Main();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
		
		JPanel panelStation = new ThreadPanel();
		panelStation.setBounds(215, 10, 1110, 490);
		contentPane.add(panelStation);
		panelStation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("x: " +arg0.getX() +" y: "+arg0.getY() );
			}
		});
		
		JPanel panelInput = new JPanel();
		panelInput.setBackground(Color.WHITE);
		panelInput.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panelInput.setBounds(5, 10, 200, 490);
		contentPane.add(panelInput);
		panelInput.setLayout(null);
		
		JLabel lblPassenger = new JLabel("Passenger");
		lblPassenger.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPassenger.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassenger.setBounds(57, 11, 83, 23);
		panelInput.add(lblPassenger);
		
		JLabel lblTrain = new JLabel("Train");
		lblTrain.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTrain.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrain.setBounds(66, 260, 74, 23);
		panelInput.add(lblTrain);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSource.setBounds(47, 45, 46, 14);
		panelInput.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestination.setBounds(47, 101, 74, 14);
		panelInput.add(lblDestination);
		
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(Main.names);
		DefaultComboBoxModel<String> comboModel2 = new DefaultComboBoxModel<String>(Main.names);
		
		JComboBox<String> cmbSource = new JComboBox<String>(comboModel);
		cmbSource.setForeground(Color.WHITE);
		cmbSource.setBackground(Color.BLACK);
		cmbSource.setBounds(47, 70, 107, 20);
		panelInput.add(cmbSource);
		
		JComboBox<String> cmbDestination = new JComboBox<String>(comboModel2);
		cmbDestination.setForeground(Color.WHITE);
		cmbDestination.setBackground(Color.BLACK);
		cmbDestination.setBounds(47, 124, 107, 20);
		panelInput.add(cmbDestination);
		
		textFieldSeatCapacity = new JTextField();
		textFieldSeatCapacity.setBackground(Color.WHITE);
		textFieldSeatCapacity.setForeground(Color.BLACK);
		textFieldSeatCapacity.setBounds(118, 400, 57, 20);
		panelInput.add(textFieldSeatCapacity);
		textFieldSeatCapacity.setColumns(10);
		
		JLabel lblTrainCapacity = new JLabel("Seat Capacity:");
		lblTrainCapacity.setForeground(Color.WHITE);
		lblTrainCapacity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrainCapacity.setBounds(33, 402, 86, 14);
		panelInput.add(lblTrainCapacity);
		
		JLabel lblRunningTrains = new JLabel("Number of Running Trains:");
		lblRunningTrains.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRunningTrains.setBounds(20, 288, 160, 23);
		panelInput.add(lblRunningTrains);
		
		JLabel lblNumTrains = new JLabel("0 trains of 16");
		lblNumTrains.setFont(new Font("Serif", Font.BOLD, 16));
		lblNumTrains.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumTrains.setForeground(Color.BLUE);
		lblNumTrains.setBounds(53, 320, 99, 14);
		panelInput.add(lblNumTrains);

		JButton btnAddTrain = new JButton("Add New Train");
		btnAddTrain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String numOfSeats = textFieldSeatCapacity.getText();
				int num = 0;
				try {
				     num = Integer.parseInt(numOfSeats);
				     if (num <= 0) {
						JOptionPane.showMessageDialog(null, "Train must have at least 1 seat!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						// add num to train
						Main.trains[running_trains] = new Train(running_trains, num);						
						running_trains++;
						lblNumTrains.setText(running_trains +" trains of 16");
						System.out.println("Train Successfully Added!!");
					}
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Must enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
				     //Not an integer
				}
				if (running_trains == 16) {
					btnAddTrain.setVisible(false); // all 16 trains deployed so hide button
				}
				
			}
		});
		btnAddTrain.setBounds(32, 444, 143, 23);
		panelInput.add(btnAddTrain);
//		btnAddTrain.setBackground(UIManager.getColor("Button.background"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 354, 185, 125);
		panelInput.add(panel);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblDeployTrains = new JLabel("Deploy Additional Trains");
		lblDeployTrains.setForeground(Color.WHITE);
		lblDeployTrains.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeployTrains.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(lblDeployTrains);
		
		//////////////////////Not from Windows Builder////////////////////////////////////////
		// initialize stations
//		for (int i=0; i<stations.length; i++) {
//			stations[i] = new Station(names[i], i);
//		}
		
//		JPanel panelPassengers = new PassengerPanel(stations);
//		panelPassengers.setBounds(9, 11, 396, 275);
//		contentPane.add(panelPassengers);
		
		JButton btnAddPassengers = new JButton("Add New Passenger");
		btnAddPassengers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				int indexSourceStation = cmbSource.getSelectedIndex();
				int indexDestination = cmbDestination.getSelectedIndex();
				
				System.out.println("Added passenger from: " +indexSourceStation 
							+" to: " +indexDestination);
				
				for (int i=0; i<Main.stations.length;i++) {
					if (indexSourceStation == i) {
						Passenger robot = new Passenger(Main.stations[i], indexDestination);
						// adds robot in the Source Station's waiting list
						System.out.println("station: " +Main.stations[i].getStation_name());
						Main.stations[i].addPassenger(robot);
						passengerList.add(robot); // not sure
						break;
					}
				}					
				passengers_added++;
			}
		});
		btnAddPassengers.setBounds(35, 168, 139, 23);
		panelInput.add(btnAddPassengers);
		
		JButton btnTest = new JButton("displayPassengers");
		btnTest.setBounds(35, 213, 134, 23);
		panelInput.add(btnTest);
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i=0; i<Main.stations.length;i++) {
					Main.stations[i].displayPassengers();
					System.out.println();
				}
			}
		});
		
//		UIManager.setLookAndFeel(metal);
	}

}
