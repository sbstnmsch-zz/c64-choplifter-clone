package org.homeunix.joplifter.sprite.interfaces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public interface ISprite {
	
	/* Paint */
	/** Paint method */
	void paint (int x, Graphics g) ;
	
	/* Getter / Setter */
	/** Getter */
	int getX() ;
	/** Setter */
	void setX(int x) ;
	/** Getter */
	int getY() ;
	/** Setter */
	void setY(int y) ;
	/** Getter */
	BufferedImage getIcon() ;
	/** Setter */
	void setIcon(BufferedImage icon) ;
}
