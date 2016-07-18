package org.homeunix.joplifter.tools;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.homeunix.c64.C64Theme;
import org.homeunix.joplifter.sprite.Helicopter;

public class Rotator extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3936241078272945637L;
	public final static int ratio = 1;
	private static int[][] icon ;
	private static String[] iconString = Helicopter.HELICOPTER_CENTER1 ;
	
	
	private static int[][] convertAsIs(String[] orig) {
		int[][] flipped = new int[orig.length][orig[0].length()] ;
		for (int y=0; y < orig.length; ++y) {
			for (int x=0; x < orig[y].length(); ++x) {
				flipped[y][x] = (orig[y].charAt(x) != ' ') ? 0 + Integer.valueOf("" + orig[y].charAt(x)).intValue() : 0;
			}
		}
		return flipped ;
	}
	
	
	private static int[][] flipHorizontal(String[] orig) {
		int[][] flipped = new int[orig.length][orig[0].length()] ;
		for (int y=0; y < orig.length; ++y) {
			for (int x=0; x < orig[y].length(); ++x) {
				flipped[y][orig[y].length()-x-1] = (orig[y].charAt(x) != ' ') ? 0 + Integer.valueOf("" + orig[y].charAt(x)).intValue() : 0;
			}
		}
		return flipped ;
	}
	
	private static int[][] rotate15DegreesClockwise(String[] orig) {
		int xw = orig[0].length() ;
		int yw = orig.length ;
		int added = 3 ;
		int[][] flipped = new int[orig.length+added][orig[0].length()] ;
		double degr = -0.14d ;
		
		for (int y=0; y < orig.length; ++y) {
			for (int x=0; x < orig[y].length(); ++x) {
				long sx = Math.round(x * Math.cos(degr) + y * Math.sin(degr)) ;
				long sy = Math.round(y * Math.cos(degr) - x * Math.sin(degr)) ;
				if ((sx >= 0) && (sx < xw-1)) {
					if ((sy >= 0) && (sy < yw + added)) { 
						flipped[(int) sy][(int) sx] = (orig[y].charAt(x) != ' ') ? 0 + Integer.valueOf("" + orig[y].charAt(x)).intValue() : 0;
					}
				}
			}
		}
		return flipped ;
	}
	
	private static int[][] rotate15DegreesCounterClockwise(String[] orig) {
		int xw = orig[0].length() ;
		int yw = orig.length ;
		int added = 3 ;
		int[][] flipped = new int[orig.length+added][orig[0].length()] ;
		double degr = 0.14d ;
		
		for (int y=0; y < orig.length; ++y) {
			for (int x=0; x < orig[y].length(); ++x) {
				long sx = Math.round(x * Math.cos(degr) + y * Math.sin(degr)) ;
				long sy = 1+added+Math.round(y * Math.cos(degr) - x * Math.sin(degr)) ;
				if ((sx >= 0) && (sx < xw-1)) {
					if ((sy >= 0) && (sy < yw + added)) { 
						flipped[(int) sy][(int) sx] = (orig[y].charAt(x) != ' ') ? 0 + Integer.valueOf("" + orig[y].charAt(x)).intValue() : 0;
					}
				}
			}
		}
		return flipped ;
	}
	
	
	
	public void paint (Graphics g) {
		super.paint(g) ;
		if (icon == null) return ;
		
		g.setColor(C64Theme.WHITE) ;
		
		
		for (int y=0; y < icon.length; ++y) {
			for (int x=0; x < icon[y].length; ++x) {
				
				if (icon[y][x] == 1) {
					switch (icon[y][x]) {
					case 1 : g.setColor(C64Theme.WHITE) ; break ;
					case 2 : g.setColor(C64Theme.RED) ; break ;
					case 6 : g.setColor(C64Theme.BLUE) ; break ;
					default : g.setColor(C64Theme.WHITE) ; break ;
					}
					g.fillRect(55 + x*ratio, 55+y*ratio, ratio, ratio) ;
				}
			}
		}
		
	}

	
	
	private void init() {
		setTitle("Rotator") ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		setLayout(new BorderLayout()) ;
		
		JPanel panel = new JPanel(new BorderLayout()) ;
		panel.setPreferredSize(new Dimension(120,120)) ;
		panel.setBackground(C64Theme.BLACK) ;
		panel.setOpaque(true) ;
		getContentPane().add(panel, BorderLayout.NORTH) ;
		
		JPanel panel2 = new JPanel(new BorderLayout()) ;
		
		JButton cw = new JButton("CW") ;
		cw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				icon = rotate15DegreesClockwise(iconString) ;
				print() ;
				repaint() ;
			}
		}) ;
		
		JButton ccw = new JButton("CCW") ;
		ccw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				icon = rotate15DegreesCounterClockwise(iconString) ;
				print() ;
				repaint() ;
			}
		}) ;

		JButton flip = new JButton("Flip") ;
		flip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				icon = flipHorizontal(iconString) ;
				print() ;
				repaint() ;
			}
		}) ;
		
		panel2.add(cw, BorderLayout.WEST) ;
		panel2.add(ccw, BorderLayout.CENTER) ;
		panel2.add(flip, BorderLayout.EAST) ;
		getContentPane().add(panel2, BorderLayout.SOUTH) ;
		setVisible(true) ;
		pack();
		
		
		icon = convertAsIs(iconString) ;
		print() ;
		repaint() ;
	}
	
	private void print() {
		System.out.println("\tpublic final static String[] SPRITE_X = new String[] {") ;
		for (int y=0; y < icon.length; ++y) {
			System.out.print("\t\t\"") ;
			for (int x=0; x < icon[y].length; ++x) {
					System.out.print((icon[y][x] != 0)? "1" : " ") ;
			}
			System.out.println("\"" + ((y < icon.length -1) ? "," : "} ;")) ;
		}
	}
	
	public Rotator() {
		init() ;
		
	}
	
	public static void main(String[] argv) {
		new Rotator() ;
	}
	
	
}
