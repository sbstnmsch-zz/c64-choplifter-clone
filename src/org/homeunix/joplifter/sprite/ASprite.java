package org.homeunix.joplifter.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.homeunix.c64.C64Theme;
import org.homeunix.joplifter.sprite.interfaces.ISprite;

public abstract class ASprite implements ISprite {

	private int x ;
	private int y ;
	private BufferedImage icon ;
	
	public final BufferedImage getIcon() {
		return icon ;
	}

	public final void setIcon(BufferedImage icon) {
		this.icon = icon ;
	}

	public final int getX() {
		return x ;
	}

	public final int getY() {
		return y ;
	}

	public final void setX(int x) {
		this.x = x ;
	}

	public final void setY(int y) {
		this.y = y ;
	}




	public void paint (int v, Graphics g) {
		int vx = -v + getX();
		BufferedImage lIcon = getIcon() ;

		// Only paint if icon and if in view
		if (vx + 40 < 0) return ;
		if (vx > C64Theme.SCREEN_WIDTH) return ;
		if (lIcon == null) return ;
		
		g.drawImage(lIcon, vx, getY(), null) ;
	}



	private final static int intValue(char c) {
		try {
			if (c == 32) return -1 ;
			return Integer.valueOf("" + c).intValue() ;
		} catch (NumberFormatException nfe) {
			return c - 55; // Hexhack
		}
	}

	
	public final static BufferedImage createImage(int[][] pIcon) {
		int w = pIcon[0].length ;
		int h = pIcon.length ;
		
		BufferedImage bufImage = new BufferedImage(w, h, 
				BufferedImage.TYPE_INT_ARGB); 
		
		for (int y=0; y < pIcon.length; ++y) {
			for (int x=0; x < pIcon[y].length; ++x) {
				switch (pIcon[y][x]) {
				case -1 : break ;
				case 0 : bufImage.setRGB(x, y, C64Theme.BLACK.getRGB()); break ;
				case 1 : bufImage.setRGB(x, y, C64Theme.WHITE.getRGB()); break ;
				case 2 : bufImage.setRGB(x, y, C64Theme.RED.getRGB()) ; break ;
				case 4 : bufImage.setRGB(x, y, C64Theme.PURPLE.getRGB()) ; break ;
				case 6 : bufImage.setRGB(x, y, C64Theme.BLUE.getRGB()) ; break ;
				case 7 : bufImage.setRGB(x, y, C64Theme.YELLOW.getRGB()) ; break ;
				case 8 : bufImage.setRGB(x, y, C64Theme.ORANGE.getRGB()) ; break ;
				case 9 : bufImage.setRGB(x, y, C64Theme.BROWN.getRGB()) ; break ;
				case 14 : bufImage.setRGB(x, y, C64Theme.LIGHT_PURPLE.getRGB()) ; break ;
				}
			}
		}
		bufImage.flush() ;
		return bufImage ;
	}
	
	

	public final static BufferedImage convertAsIs(String[] orig) {
		int[][] flipped = new int[orig.length][orig[0].length()] ;
		for (int y=0; y < orig.length; ++y) {
			for (int x=0; x < orig[y].length(); ++x) {
				flipped[y][x] = intValue(orig[y].charAt(x));
			}
		}
		return createImage(flipped) ;
	}

	public final static BufferedImage flipHorizontal(String[] orig) {
		int[][] flipped = new int[orig.length][orig[0].length()] ;
		for (int y=0; y < orig.length; ++y) {
			for (int x=0; x < orig[y].length(); ++x) {
				flipped[y][orig[y].length()-x-1] = intValue(orig[y].charAt(x)) ;
			}
		}
		return createImage(flipped) ;
	}
}
