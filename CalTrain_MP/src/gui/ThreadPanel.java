package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	for (int i=0;i<Main.trains.length;i++) {
                		if (Main.trains[i] != null) { // checks if train is not yet initialized in array
//                			if (Main.trains[i].getCurrStation() == 0) {
	                			System.out.printf("train found at station %d!", i);
//	                		}	
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
		
        g.drawImage(trainImage, xPos, yPos, this);

//        System.out.println("height: "+getHeight() +" width: " +getWidth());
    }

}


