package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

public class StationFrame extends JFrame {

	private JPanel contentPane;

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
		
		JPanel panelPassengers = new PassengerPanel();
		panelPassengers.setBounds(10, 11, 428, 336);
		contentPane.add(panelPassengers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(570, 44, 2, 2);
		contentPane.add(scrollPane);
		
//		JPanel panelTrains = new JPanel();
//		contentPane.add(panelTrains);
//		
//		JPanel panelMisc = new JPanel();
//		contentPane.add(panelMisc);
	}

}
