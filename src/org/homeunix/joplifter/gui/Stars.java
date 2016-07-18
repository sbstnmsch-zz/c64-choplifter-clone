package org.homeunix.joplifter.gui;

import java.awt.Graphics;

import org.homeunix.c64.C64Theme;

public final class Stars {

	/** All stars */
	private static int[][] stars ;
	
	/**
	 * Constructor
	 * @param count stars
	 */
	public Stars(int count) {
		stars = new int[count][2] ;
		for (int i=0; i < stars.length;++i) {
			stars[i][0] = (int) (Math.random() * C64Theme.SCREEN_WIDTH) ;
			stars[i][1] = 50 + (int) (Math.random() * (C64Theme.SCREEN_HEIGHT-80)) ;			
		}
	}
	
	// ------------------------------------------------------------------------
	
	/**
	 * Paint
	 */
	public final void paint(Graphics g) {
		for (int y = 0; y < stars.length; ++y) {
			g.setColor((Math.random()) > 0.9 ? C64Theme.WHITE : C64Theme.RED) ; 
			g.drawRect(stars[y][0], stars[y][1], 1, 0) ;
		}
	}
}
