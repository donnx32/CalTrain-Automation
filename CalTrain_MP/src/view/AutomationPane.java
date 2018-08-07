package view;

import java.awt.Color;
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

	public AutomationPane() {
		setBackground(Color.CYAN);
		setBounds(10, 11, 1152, 512);
		
		try {
			background = ImageIO.read(new File("src/res/bg0.png"));
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
		while(it.hasNext()) {
      		Train t = it.next();
      		
      		t.paint(g);
      		
      	}

		
		g2d.dispose();
	}

}
