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
    private BufferedImage trainImage, stationImage, bubbleImage;
    private int xPos = 0;
    private int yPos = 80+45; // train starts at the top stations
    private int direction = 1;

    public ThreadPanel() {
        try {
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
                    if (xPos + trainImage.getWidth() > getWidth() && yPos == 80+45) {
                    	xPos = 0;
                    	yPos = 330+45;
                    	direction *= 1;
                    } else if (xPos + trainImage.getWidth() > getWidth() && yPos == 330+45) {
                    	xPos = 0;
                    	yPos = 80+45;
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
        setBackground(Color.WHITE);
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
//        	int gap = 220;
//        	int x;
//        	if (i<=4) {
//        		x = gap * i ;
//        		g.drawImage(stationImage, x, 50, this);
//        	} else {
//        		x = gap * (9-i) ;
//        		g.drawImage(stationImage, x, 320, this);
//        	}
//        }
        int left = 150;
        int gap = 240;
//        JLabel lblStation1 = new JLabel("Alpha");
//        lblStation1.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        lblStation1.setBounds(left, 50, 83, 23);
//        this.add(lblStation1);      
        g.drawImage(stationImage, left, 50, this); 
        g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left+=gap;
		g.drawImage(stationImage, left, 50, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left+=gap;
		g.drawImage(stationImage, left, 50, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left+=gap;
		g.drawImage(stationImage, left, 50, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 10, this); left=150;

		g.drawImage(stationImage, left, 300, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(stationImage, left, 300, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(stationImage, left, 300, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this); left+=gap;
		g.drawImage(stationImage, left, 300, this);
		g.drawImage(bubbleImage, left+(trainImage.getWidth()/2)+10, 260, this);
        
        g.drawImage(trainImage, xPos, yPos, this);

    }

}


