package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Main;

public class ThreadPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
    private BufferedImage trainImage, stationImage, bubbleImage, cityImage;
    private BufferedImage alpha,
    					beta,
    					charlie,
    					delta,
    					echo,
    					foxtrot,
    					golf,
    					hotel;
    private int xPos = 0;
    private int yPos = 135; // train starts at the top stations
    private int direction = 1;

    public ThreadPanel() {
        try {
        	alpha = ImageIO.read(new File("src/res/alpha-station.png"));
        	foxtrot = ImageIO.read(new File("src/res/foxtrot-station.png"));
        	
        	cityImage = ImageIO.read(new File("src/res/city.jpg"));
        	
            trainImage = ImageIO.read(new File("src/res/train-cartoon.png"));
            stationImage = ImageIO.read(new File("src/res/station.png"));
            bubbleImage = ImageIO.read(new File("src/res/chat-bubble.png"));
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	for (int i=0;i<Main.trains.length;i++) {
                		if (Main.trains[i] != null) { // checks if train is not yet initialized in array
//                			if (Main.trains[i].getTrain_station_number() == 0) {
//	                			System.out.println("train found at station 0!");
//	                		}	
                		}
                		
                	}
                	
                	
                    xPos += direction;
                    if (xPos + trainImage.getWidth() > getWidth() && yPos == 135) {
                    	xPos = 0;
                    	yPos = 385;
                    	direction *= 1;
                    } else if (xPos + trainImage.getWidth() > getWidth() && yPos == 385) {
                    	xPos = 0;
                    	yPos = 135;
                    	direction *= 1;
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
        
//        for (int i=1; i<=8; i++) {
//        	if (i<=4) {
//        		g.drawImage(stationImage, left, 50, this);
//        		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); 
//        		left+=gap;
//        	} else {
//        		g.drawImage(stationImage, left, 300, this);
//        		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this);
//        		left+=gap;
//        	}
//        	
//        	if (i == 4 ) {
//        		left = 150;
//        	}
//        }
        
//        JLabel lblStation1 = new JLabel("Alpha");
//        lblStation1.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        lblStation1.setBounds(left, 50, 83, 23);
//        this.add(lblStation1); 
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
		g.drawImage(stationImage, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left+=gap;
		g.drawImage(stationImage, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left+=gap;
		g.drawImage(stationImage, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); 

		width = cityImage.getWidth();
		g.drawImage(cityImage, 0, 260, this); 
        g.drawImage(cityImage, width, 260, this); width += cityImage.getWidth();
        g.drawImage(cityImage, width, 260, this); width += cityImage.getWidth();
        g.drawImage(cityImage, width, 260, this);
        left=80;
        yRow = 300;
		g.drawImage(stationImage, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(foxtrot, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(stationImage, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(stationImage, left, yRow, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this);
        
        g.drawImage(trainImage, xPos, yPos, this);

//        System.out.println("height: "+getHeight() +" width: " +getWidth());
    }

}


