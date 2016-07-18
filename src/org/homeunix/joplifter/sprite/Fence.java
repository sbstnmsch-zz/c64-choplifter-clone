package org.homeunix.joplifter.sprite;

import java.awt.Graphics;

public final class Fence extends ASprite {
	
	public final static String[] FENCE = new String[] {
		"11  2266",
		"221111  ",
		"221111  ",
		"226611  ",
		"226611  "} ;
	
	public Fence(int x, int y) {
		setX(x) ;
		setY(y) ;
		setIcon(convertAsIs(FENCE)) ;
	}

	public final void paint (int v, Graphics g) {
		super.paint((int) (v+ (v * 0.2f *((getY() - 173) / 4.0f))), g) ;
	}
}
