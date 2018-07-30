package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ThreadPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
    private BufferedImage trainImage, stationImage;
    private int xPos = 0;
    private int direction = 1;

    public ThreadPanel() {
        try {
            trainImage = ImageIO.read(new File("src/res/train-cartoon.png"));
            stationImage = ImageIO.read(new File("src/res/station.png"));
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xPos += direction;
                    if (xPos + trainImage.getWidth() > getWidth()) {
                        xPos = getWidth() - trainImage.getWidth();
                        direction *= -1;
                    } else if (xPos < 0) {
                        xPos = 0;
                        direction *= -1;
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
        g.drawImage(stationImage, left, 50, this); left+=gap;
		g.drawImage(stationImage, left, 50, this); left+=gap;
		g.drawImage(stationImage, left, 50, this); left+=gap;
		g.drawImage(stationImage, left, 50, this); left=150;

		g.drawImage(stationImage, left, 300, this); left+=gap;
		g.drawImage(stationImage, left, 300, this); left+=gap;
		g.drawImage(stationImage, left, 300, this); left+=gap;
		g.drawImage(stationImage, left, 300, this);
        
        int y = getHeight() - trainImage.getHeight();
        y = 330 + trainImage.getHeight();
        int y2 = 80 + trainImage.getHeight();
//        int h = getHeight();
//        int w = getWidth();
//        System.out.println("height: " +h +" width: " +w);
//        int t = trainImage.getHeight();
//        System.out.println("train height: " +t);
        g.drawImage(trainImage, xPos, y2, this);
        g.drawImage(trainImage, xPos, y, this);

    }

}


