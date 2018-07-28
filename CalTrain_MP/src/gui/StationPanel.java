package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class StationPanel extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int TIMER_DELAY = 30;
	private int trainX = 80;
	private int trainY = 100;
	Image imgStation, imgTrain;
	
	/**
	 * Create the panel.
	 */
	public StationPanel() {
		setLayout(null);
//		javax.swing.Timer timer = new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
//		      public void actionPerformed(ActionEvent arg0) {
//		    	trainX++;
////		    	trainY++;
//		    	StationPanel.this.repaint();
//		      }
//		    });
//		    timer.start();
	}
	
	public void animate() {
        Graphics g = imgStation.getGraphics();
        for (int i = 0, j = 20; i < 640; i += 5, j += 7) {
            g.setColor(Color.white);
            g.fillRect(0, 0, 640, 480);
            g.setColor(Color.red);
            g.fillOval(i, j, 20, 20);
//        while (true) {
        	
        
        	trainX++;
            this.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

	public void paint(Graphics g) {
//	      Image img = createImageWithText();
//	      Image imgStation, imgTrain;
		try {
			imgStation = ImageIO.read(new File("src/res/station.png"));
			g.drawImage(imgStation, 100, 20, this);
			g.drawImage(imgStation, 330, 20, this);
			g.drawImage(imgStation, 560, 20, this);
			
			g.drawImage(imgStation, 100, 180, this);
			g.drawImage(imgStation, 560, 180, this);
			
			g.drawImage(imgStation, 100, 370, this);
			g.drawImage(imgStation, 330, 370, this);
			g.drawImage(imgStation, 560, 370, this);
			
			imgTrain = ImageIO.read(new File("src/res/train-cartoon.png"));
			g.drawImage(imgTrain, trainX, 110, this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
	   }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("row: " +arg0.getX() +" col: "+arg0.getY() );
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
