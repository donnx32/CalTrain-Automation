package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import model.CalTrainII;


public class ThreadPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
    private BufferedImage trainImage, stationImage, bubbleImage, cityImage, railroadImage;
    private BufferedImage alpha,
    					bravo,
    					charlie,
    					delta,
    					echo,
    					foxtrot,
    					golf,
    					hotel;
    private int xPos = 0;
    private int yPos = 140; // train starts at the top stations
    private double direction = 0.1;
    private int totalTrains;
    private ArrayList<Integer> xPositions = new ArrayList<Integer>();
    private ArrayList<Integer> yPositions = new ArrayList<Integer>();;
    private JLabel waitLabels[] = new JLabel[8];
    int xLbl = 170,
        yLbl = 40;

    public ThreadPanel() {
        try {
        	alpha = ImageIO.read(new File("src/res/alpha-station.png"));
        	bravo = ImageIO.read(new File("src/res/bravo-station.png"));
        	charlie = ImageIO.read(new File("src/res/charlie-station.png"));
        	delta = ImageIO.read(new File("src/res/delta-station.png"));	
        	
        	echo = ImageIO.read(new File("src/res/echo-station.png"));
        	foxtrot = ImageIO.read(new File("src/res/foxtrot-station.png"));
        	golf = ImageIO.read(new File("src/res/golf-station.png"));
        	hotel = ImageIO.read(new File("src/res/hotel-station.png"));
        	
        	cityImage = ImageIO.read(new File("src/res/city.jpg"));
        	railroadImage = ImageIO.read(new File("src/res/longrail.png"));
        	
            trainImage = ImageIO.read(new File("src/res/train-cartoon.png"));
            stationImage = ImageIO.read(new File("src/res/station.png"));
            bubbleImage = ImageIO.read(new File("src/res/chat-bubble.png"));
            for (int i=1; i<8; i++) {
            	waitLabels[i] = new JLabel("0 waiting passengers");
            }
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	totalTrains = CalTrainII.trainList.size();
                	int trainWidth = trainImage.getWidth();
                	xPositions.clear();
                	yPositions.clear();
                	for (int i=0;i<totalTrains;i++) {
                		if (CalTrainII.trainList.get(i).getApproachingStation() != null) { // checks if train is not yet initialized in array
//                			System.out.printf("train found at station %d!", i);
                			switch (CalTrainII.trainList.get(i).getApproachingStation()) 
                			{
	                			case "Alpha":  yPositions.add(140);
	                				if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("approaching")) {
	                					xPositions.add(100-trainWidth); 
	                				} else if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("@")) {
	                					xPositions.add(100); 
	                				} else 
	                					xPositions.add(100+trainWidth);
	                				break;
	                			case "Bravo": yPositions.add(140);
		                			if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("approaching")) {
		                				xPositions.add(380-trainWidth);
	                				} else if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("@")) {
	                					xPositions.add(380);
	                				} else 
	                					xPositions.add(380+trainWidth);
	                				break;
	                			case "Charlie": yPositions.add(140);
		                			if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("approaching")) {
		                				xPositions.add(655-trainWidth); 
	                				} else if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("@")) {
	                					xPositions.add(655);
	                				} else 
	                					xPositions.add(655+trainWidth);
	                				break;
	                			case "Delta": yPositions.add(140);
		                			if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("approaching")) {
		                				xPositions.add(935-trainWidth); 
	                				} else if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("@")) {
	                					xPositions.add(935);
	                				} else 
	                					xPositions.add(935+trainWidth);
	                				break;
	                				
	                			case "Echo": yPositions.add(370);
		                			if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("approaching")) {
		                				xPositions.add(100-trainWidth); 
	                				} else if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("@")) {
	                					xPositions.add(100);
	                				} else 
	                					xPositions.add(100+trainWidth);
	                				break;
	                			case "Foxtrot": yPositions.add(370);
		                			if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("approaching")) {
		                				xPositions.add(380-trainWidth); 
	                				} else if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("@")) {
	                					xPositions.add(380);
	                				} else 
	                					xPositions.add(380+trainWidth);
	                				break;
	                			case "Golf": yPositions.add(370);
		                			if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("approaching")) {
		                				xPositions.add(655-trainWidth); 
	                				} else if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("@")) {
	                					xPositions.add(655);
	                				} else 
	                					xPositions.add(655+trainWidth);	
		                			break;
	                			case "Hotel": yPositions.add(370);
		                			if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("approaching")) {
		                				xPositions.add(935-trainWidth); 
	                				} else if (CalTrainII.trainList.get(i).getStatus().equalsIgnoreCase("@")) {
	                					xPositions.add(935);
	                				} else 
	                					xPositions.add(935+trainWidth);	
		                			break;
//	                			default: xPositions.add(0-trainWidth); yPositions.add(140); 
              
                			}
                			
                		}
                		
                	}
                
                    xPos += direction;
                    if (xPos + trainImage.getWidth() > getWidth() && yPos == 140) {
                    	xPos = 0;
                    	yPos = 370;
                    	direction *= 0.1;
                    } else if (xPos + trainImage.getWidth() > getWidth() && yPos == 370) {
                    	xPos = 0;
                    	yPos = 140;
                    	direction *= 0.1;
                    }
                    repaint();
                }

            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setBackground(Color.cyan);
        int h = trainImage.getHeight();
        int w = trainImage.getWidth();
        System.out.println("height: " +h +" width: " +w);
    }

//    @Override
//    public Dimension getPreferredSize() {
//        return trainImage == null ? super.getPreferredSize() : new Dimension(trainImage.getWidth() * 4, trainImage.getHeight());
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        for (int i=1; i<8; i++) {
        	int waiting = CalTrainII.stationList.get(i).getNumber();
        	waitLabels[i].setText(Integer.toString(waiting));
        	waitLabels[i].setFont(new Font("Segoe UI", Font.BOLD, 16));
        	waitLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
        	
//        	if (i<4) {
        		waitLabels[i].setBounds(xLbl, yLbl, 74, 23);
        		xLbl += 280;
        		if (i==3) {
        			xLbl = 150;
        			yLbl = 280;
        		}
        		if (i==7) {
        			xLbl = 170;
        			yLbl = 30;
        		}
        	add(waitLabels[i]);
//        	JLabel lblTrain = new JLabel("Train");
//    		lblTrain.setFont(new Font("Segoe UI", Font.BOLD, 16));
//    		lblTrain.setHorizontalAlignment(SwingConstants.CENTER);
//    		lblTrain.setBounds(66, 260, 74, 23);
//    		add(lblTrain);
        }
        
        int width = cityImage.getWidth();
        g.drawImage(cityImage, 0, 31, this); 
        g.drawImage(cityImage, width, 31, this); width += cityImage.getWidth();
        g.drawImage(cityImage, width, 31, this); width += cityImage.getWidth();
        g.drawImage(cityImage, width, 31, this);
        
        int left = 100;
        int gap = 280;
        int yRow = 70;
        g.drawImage(alpha, left, yRow, this); 
        g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left+=gap;
		g.drawImage(bravo, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left+=gap;
		g.drawImage(charlie, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left+=gap;
		g.drawImage(delta, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); 

		g.drawImage(railroadImage, 0, 165, this);
		
		width = cityImage.getWidth();
		g.drawImage(cityImage, 0, 260, this); 
        g.drawImage(cityImage, width, 260, this); width += cityImage.getWidth();
        g.drawImage(cityImage, width, 260, this); width += cityImage.getWidth();
        g.drawImage(cityImage, width, 260, this);
        left=80;
        yRow = 300;
		g.drawImage(echo, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(foxtrot, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(golf, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(hotel, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this);
        
		g.drawImage(railroadImage, 0, 395, this);
		
		for (int i=0; i<xPositions.size(); i++) {
			g.drawImage(trainImage, xPositions.get(i), yPositions.get(i), this);
		}
        

//        System.out.println("height: "+getHeight() +" width: " +getWidth());
    }

}


