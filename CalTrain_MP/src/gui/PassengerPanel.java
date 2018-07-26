package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class PassengerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel[] panels = new JPanel[8];
	
	public static JLabel[] labels = new JLabel[8];

	public static GridBagConstraints[] gbcs = new GridBagConstraints[8];
	
	public static JLabel wait = new JLabel("Passengers Waiting");
			
	/**
	 * Create the panel.
	 */
	public PassengerPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{128, 131, 137, 0};
		gridBagLayout.rowHeights = new int[]{84, 99, 92, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTest = new JLabel("Passengers Waiting");
		GridBagConstraints gbc_lblTest = new GridBagConstraints();
		gbc_lblTest.insets = new Insets(0, 0, 5, 5);
		gbc_lblTest.gridx = 1;
		gbc_lblTest.gridy = 1;
		add(lblTest, gbc_lblTest);

//		JLabel label = new JLabel("Station #2");
//		panel_1.add(label);
//		
//		JPanel panel_2 = new JPanel();
//		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
//		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
//		gbc_panel_2.fill = GridBagConstraints.BOTH;
//		gbc_panel_2.gridx = 0;
//		gbc_panel_2.gridy = 2;
//		add(panel_2, gbc_panel_2);
		
		
		// add panels for each station
		int x = 1;
		int y = 1;
		for(int i=0;i<panels.length;i++) {
			labels[i] = new JLabel("0");
			panels[i] = new JPanel(new GridBagLayout());
			panels[i].setBackground(Color.blue);
			
			gbcs[i] = new GridBagConstraints();
			gbcs[i].fill = GridBagConstraints.BOTH;
			
			
			switch (i) {
				case 0: 
				case 1: 
				case 2: gbcs[i].gridx = 0;
						gbcs[i].gridy = i;
						break;
				case 3: 
				case 4: gbcs[i].gridx = x;
						gbcs[i].gridy = 2;
						x++;
						break;
				case 5: 
				case 6: gbcs[i].gridx = 2;
						gbcs[i].gridy = y;
						y--;
//						JLabel testLabe = new JLabel("test");
//						labels[i].add(testLabe); 
						break; 
				case 7: gbcs[i].gridx = 1;
						gbcs[i].gridy = 0;
						break;
				default: System.out.println("Error in switch statement!");
			}
//			if (i<3) {
//				gbcs[i].gridx = 0;
//				gbcs[i].gridy = i;
//			} else if (i<5) {
//				gbcs[i].gridx = x;
//				gbcs[i].gridy = 2;
//				x++;
//			} else if (i<7) {
//				gbcs[i].gridx = 2;
//				gbcs[i].gridy = y;
//				y--;
//				JLabel testLabe = new JLabel("test");
//				labels[i].add(testLabe);
//			} else {
//				gbcs[i].gridx = 1;
//				gbcs[i].gridy = 0;
//			}
			
			labels[i].setText(Integer.toString(i));
			panels[i].add(labels[i]);
			
//			panels[i].add(new JLabel("Passengers Waiting"));
			
		}
		
		for(int i=0;i<panels.length;i++) {
			add(panels[i], gbcs[i]);
		}

	}

}
