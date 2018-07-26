package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SelectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("CalTrainII Automation Program");
		lblTitle.setBounds(43, 31, 352, 27);
		contentPane.add(lblTitle);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JButton btnSemaphore = new JButton("Semaphores");
		btnSemaphore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: run program using semaphores only
				System.out.println("----- Run automation program using semaphores ---");
				setVisible(false);
				new StationFrame();
//				System.exit(1);
			}
		});
		btnSemaphore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSemaphore.setBounds(249, 138, 133, 73);
		contentPane.add(btnSemaphore);
		
		JButton btnLock = new JButton("Locks");
		btnLock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLock.setBounds(56, 138, 133, 73);
		contentPane.add(btnLock);
		
		JLabel lblSelect = new JLabel("Select your method of execution: ");
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSelect.setBounds(96, 79, 249, 27);
		contentPane.add(lblSelect);
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: run program using Locks only	
				System.out.println("----- Run automation program using locks ---");
				System.exit(1);
			}
		});
		this.setVisible(true);
		
		
		
	}
}
