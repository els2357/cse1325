package gui;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;

import java.io.File;

public class Canvas extends JPanel{
	private final static int border = 25;

	public Canvas() {
		
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(700,700);
    }
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.drawRect(120,120,250,150);
		g.setColor(Color.orange);
		g.drawOval(120,120,250,250);
		g.setColor(Color.black);
		g.drawString("Ethan Sprinkle", 85,95);
		Image image = new ImageIcon("gui/temp.png").getImage();
		g.drawImage(image, 200,150, 100,125, null, null);
		
	}
}

