package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import objects.Passenger;
import objects.Station;
import objects.Train;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSeatCapacity;
	
	private String[] names = {"Alpha", "Bravo", "Charlie", "Delta",
			"Echo", "Foxtrot", "Golf", "Hotel"};
	private Train[] trains = new Train[16];
	private Station[] stations = new Station[8];
	private int running_trains = 0;
	
	private int passengers_added = 0;
	
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
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
		
		JPanel panelStation = new JPanel();
		panelStation.setBounds(425, 11, 426, 283);
		contentPane.add(panelStation);
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panelInput.setBounds(0, 305, 381, 241);
		contentPane.add(panelInput);
		panelInput.setLayout(null);
		
		JLabel lblPassenger = new JLabel("Passenger");
		lblPassenger.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPassenger.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassenger.setBounds(49, 11, 83, 23);
		panelInput.add(lblPassenger);
		
		JLabel lblTrain = new JLabel("Train");
		lblTrain.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTrain.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrain.setBounds(249, 11, 74, 23);
		panelInput.add(lblTrain);
		
		JButton btnAddTrain = new JButton("Add New Train");
		btnAddTrain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String numOfSeats = textFieldSeatCapacity.getText();
				int num = 0;
				try {
				     num = Integer.parseInt(numOfSeats);
				     System.out.println("An integer");
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Must enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
				     //Not an integer
				}
				if (num == 0) {
					JOptionPane.showMessageDialog(null, "Train must have at least 1 seat!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					// add num to train
					trains[running_trains] = new Train(running_trains, num);
					running_trains++;
				}
				
			}
		});
		btnAddTrain.setBounds(208, 195, 143, 23);
		panelInput.add(btnAddTrain);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSource.setBounds(36, 72, 46, 14);
		panelInput.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestination.setBounds(36, 128, 74, 14);
		panelInput.add(lblDestination);
		
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(names);
		DefaultComboBoxModel<String> comboModel2 = new DefaultComboBoxModel<String>(names);
		
		JComboBox<String> cmbSource = new JComboBox<String>(comboModel);
		cmbSource.setBounds(36, 97, 107, 20);
		panelInput.add(cmbSource);
		
		JComboBox<String> cmbDestination = new JComboBox<String>(comboModel2);
		cmbDestination.setBounds(36, 151, 107, 20);
		panelInput.add(cmbDestination);
		
		textFieldSeatCapacity = new JTextField();
		textFieldSeatCapacity.setBounds(294, 151, 57, 20);
		panelInput.add(textFieldSeatCapacity);
		textFieldSeatCapacity.setColumns(10);
		
		JLabel lblTrainCapacity = new JLabel("Seat Capacity:");
		lblTrainCapacity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrainCapacity.setBounds(209, 153, 86, 14);
		panelInput.add(lblTrainCapacity);
		
		JLabel lblRunningTrains = new JLabel("Number of Running Trains:");
		lblRunningTrains.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRunningTrains.setBounds(202, 45, 149, 23);
		panelInput.add(lblRunningTrains);
		
		JLabel lblNumTrains = new JLabel("0 trains of 16");
		lblNumTrains.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumTrains.setForeground(Color.BLUE);
		lblNumTrains.setBounds(237, 72, 80, 14);
		panelInput.add(lblNumTrains);
		
		JPanel panel = new JPanel();
		panel.setBounds(186, 105, 185, 125);
		panelInput.add(panel);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblDeployTrains = new JLabel("Deploy Trains");
		lblDeployTrains.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeployTrains.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(lblDeployTrains);
		
		//////////////////////Not from Windows Builder////////////////////////////////////////
		// initialize stations
		for (int i=0; i<stations.length; i++) {
			stations[i] = new Station(names[i], i);
		}
		
		JPanel panelPassengers = new PassengerPanel(stations);
		panelPassengers.setBounds(10, 11, 405, 283);
		contentPane.add(panelPassengers);
		
		JButton btnAddPassengers = new JButton("Add New Passenger");
		btnAddPassengers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				int indexSourceStation = cmbSource.getSelectedIndex();
				int indexDestination = cmbDestination.getSelectedIndex();
				
				System.out.println(indexDestination);
				
				for (int i=0; i<stations.length;i++) {
					if (indexSourceStation == i) {
						Passenger robot = new Passenger(stations[i], indexDestination);
						// adds robot in the Source Station's waiting list
						stations[i].addPassenger(robot);
						passengerList.add(robot); // not sure
						break;
					}
				}
					
				passengers_added++;
			}
		});
		btnAddPassengers.setBounds(24, 195, 139, 23);
		panelInput.add(btnAddPassengers);
		
		JButton btnTest = new JButton("test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i=0; i<stations.length;i++) {
					stations[i].displayPassengers();
				}
			}
		});
		btnTest.setBounds(43, 45, 89, 23);
		panelInput.add(btnTest);
		
	}
}
