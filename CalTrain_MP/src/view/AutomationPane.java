package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.CalTrainII;
import objects.Train;

public class AutomationPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private BufferedImage tunnel;

	public AutomationPane() {
		setBackground(Color.CYAN);
		setBounds(10, 11, 1152, 512);
		
		try {
			background = ImageIO.read(new File("src/res/demo1.png"));
			tunnel = ImageIO.read(new File("src/res/Tunnels.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Timer timer = new Timer(9, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	Iterator<Train> it = CalTrainII.trainList.iterator();
            	
            	while(it.hasNext()) {
            		Train t = it.next();
            		t.update();
            	}
            	repaint();
            }
            
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		Iterator<Train> it = CalTrainII.trainList.iterator();
		g.drawImage(background, 0, 0, 1152 ,512, this);
		
		g.setFont(new Font("Century Gothic", Font.PLAIN, 12)); 
		int left = 150;
		for(int i=0;i<8;i++) {
			int wait = CalTrainII.stationList.get(i).getRobotList().size();
			if (i<4) {
				g.drawString(wait+" waiting", left, 120);
				left = left + 285;
				if (i==3)
					left = left - 285;
			} else {
				g.drawString(wait+" waiting", left, 385);
				left = left - 285;
				if (i==7)
					left = left + 285;
			}
		}
//		int wait = CalTrainII.stationList.get(0).getRobotList().size();
//		g.drawString(wait+" waiting", left, 120); left = left + 285; 
//		wait = CalTrainII.stationList.get(1).getRobotList().size();
//		g.drawString(wait+" waiting", left, 120);
		
		while(it.hasNext()) {
      		Train t = it.next();
      		
      		t.paint(g);
      		
      	}
		//g.drawImage(tunnel, 0, 0, 1152 ,512, this);
		
		g2d.dispose();
	}

}
