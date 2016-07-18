package org.homeunix.joplifter.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.homeunix.c64.C64Theme;
import org.homeunix.joplifter.sprite.ASprite;

public final class Output extends ASprite {
		
	/** For double buffering */
	private BufferedImage bufImage;

	/**
	 * Constructor
	 * Creates a buffered image from text
	 * 
	 * @param text
	 * @param c
	 * @param x
	 * @param y
	 */
	public Output(String text, int x, int y) {
		setX(x) ;
		setY(y) ;
		
		bufImage = createImage(C64Theme.getText(text)) ;
	}
	
	// ------------------------------------------------------------------------
	
	/**
	 * Paint
	 */
	public final void paint(Graphics g) {
		if (bufImage != null) {
			g.drawImage(bufImage, getX(), getY(), null);
			return ;
		}
	}
}
