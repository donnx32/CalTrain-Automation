package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.CalTrainII;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtFldCapacity;
	private CalTrainII c;
	private DefaultTableModel model;
	private JTable table;
	private JPanel btnDeploy;
	
	public MainView(CalTrainII c) {
		setTitle("CalTrainII Automation");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1188, 760);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.c = c;
		
		initComponents();
		generateListeners();
		
		setVisible(true);
	}
	
	public void initComponents() {
		System.out.println("Initializing main components...");
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(new AutomationPane());
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 551, 1152, 8);
		contentPane.add(separator);
		
		JPanel panelTrainDeployment = new JPanel();
		panelTrainDeployment.setBounds(20, 570, 230, 140);
		contentPane.add(panelTrainDeployment);
		panelTrainDeployment.setLayout(null);
		
		 btnDeploy = new JPanel();
		btnDeploy.setBounds(70, 102, 86, 27);
		panelTrainDeployment.add(btnDeploy);
		btnDeploy.setBackground(Color.DARK_GRAY);
		btnDeploy.setLayout(null);
		
		JLabel lblDeploy = new JLabel("Deploy");
		lblDeploy.setBounds(20, 0, 56, 20);
		btnDeploy.add(lblDeploy);
		lblDeploy.setForeground(Color.LIGHT_GRAY);
		lblDeploy.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		JLabel lblDeployment = new JLabel("Train Deployment");
		lblDeployment.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblDeployment.setBounds(49, 11, 145, 27);
		panelTrainDeployment.add(lblDeployment);
		
		txtFldCapacity = new JTextField();
		txtFldCapacity.setText("Capacity");
		txtFldCapacity.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtFldCapacity.setBounds(70, 55, 86, 28);
		panelTrainDeployment.add(txtFldCapacity);
		txtFldCapacity.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 37, 157, 8);
		panelTrainDeployment.add(separator_1);
		
		JPanel pnlRobotGenerator = new JPanel();
		pnlRobotGenerator.setLayout(null);
		pnlRobotGenerator.setBounds(271, 570, 378, 140);
		contentPane.add(pnlRobotGenerator);
		
		JPanel btnSpawn = new JPanel();
		btnSpawn.setLayout(null);
		btnSpawn.setBackground(Color.DARK_GRAY);
		btnSpawn.setBounds(142, 102, 86, 27);
		pnlRobotGenerator.add(btnSpawn);
		
		JLabel lblSpawn = new JLabel("Spawn");
		lblSpawn.setForeground(Color.LIGHT_GRAY);
		lblSpawn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblSpawn.setBounds(20, 0, 56, 20);
		btnSpawn.add(lblSpawn);
		
		JLabel lblRobotGenerator = new JLabel("Robot Generator");
		lblRobotGenerator.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblRobotGenerator.setBounds(120, 11, 145, 27);
		pnlRobotGenerator.add(lblRobotGenerator);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblStart.setBounds(72, 41, 62, 20);
		pnlRobotGenerator.add(lblStart);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(108, 36, 157, 8);
		pnlRobotGenerator.add(separator_2);
		
		JComboBox<String> cmbBoxStart = new JComboBox<String>();
		cmbBoxStart.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cmbBoxStart.setModel(new DefaultComboBoxModel<String>(new String[] {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel"}));
		cmbBoxStart.setBounds(72, 61, 100, 30);
		pnlRobotGenerator.add(cmbBoxStart);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblDestination.setBounds(196, 41, 80, 20);
		pnlRobotGenerator.add(lblDestination);
		
		JComboBox<String> cmbBoxDestination = new JComboBox<String>();
		cmbBoxDestination.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cmbBoxDestination.setModel(new DefaultComboBoxModel<String>(new String[] {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel"}));
		cmbBoxDestination.setBounds(195, 61, 100, 30);
		pnlRobotGenerator.add(cmbBoxDestination);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(260, 570, 8, 140);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(660, 570, 8, 140);
		contentPane.add(separator_4);
		
		JPanel pnlLog = new JPanel();
		pnlLog.setLayout(null);
		pnlLog.setBounds(671, 570, 476, 140);
		contentPane.add(pnlLog);
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblLog.setBounds(10, 0, 145, 27);
		pnlLog.add(lblLog);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 456, 105);
		scrollPane.getViewport().setBackground(Color.decode("#f6e6dc"));
		pnlLog.add(scrollPane);
		
		table = new JTable();		
		DefaultTableModel test = new DefaultTableModel(new Object[] { "" }, 0) {
			private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			
		};
		table.setModel(test);
		table.setRowHeight(20);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		table.setTableHeader(null);
		table.setShowGrid(false);
		model = (DefaultTableModel) table.getModel();
		
		scrollPane.setViewportView(table);
		
		System.out.println("Main components succesfully initialized...");
	}
	
	public void generateListeners() {
		System.out.println("Generating listeners...");
		
		btnDeploy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				
				c.deployTrain(123);
				model.addRow(new Object[]{"TRAIN"});
			}
		});
		
		System.out.println("Listeners succesfully generated...");
	}
	
}
