package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CalTrainII;	

public class MenuView {
	public MenuView() {		
		JFrame frame = new JFrame();
		frame.setTitle("CalTrainII Automation");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 248);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSemaphore = new JButton("Semaphores");
		btnSemaphore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("----- Run automation program using semaphores ---");
				frame.setVisible(false);
				CalTrainII C = new CalTrainII();
				new MainView(C);
			}
		});
		btnSemaphore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSemaphore.setBounds(249, 92, 133, 73);
		contentPane.add(btnSemaphore);
		
		JButton btnLock = new JButton("Locks");
		btnLock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLock.setBounds(56, 92, 133, 73);
		contentPane.add(btnLock);
		
		JLabel lblSelect = new JLabel("Select your method of execution: ");
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSelect.setBounds(96, 33, 249, 27);
		contentPane.add(lblSelect);
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("----- Run automation program using locks ---");
				CalTrainII C = new CalTrainII();
				new MainView(C);
			}
		});	
	}
}
