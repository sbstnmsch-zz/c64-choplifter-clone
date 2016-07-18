package org.homeunix.joplifter.sprite;

import java.awt.Graphics;

public final class Mountain extends ASprite {
	
	public final static String[] MOUNTAIN = new String[] {
		"            2211        11                ",
		"      11  22116666    116666662211        ",
		"  226666666666666666666666666666666666    ",
		"6666666666666666666666666666666666666666  ",
	} ;
	
	public Mountain(int x, int y) {
		setX(x) ;
		setY(y) ;
		setIcon(convertAsIs(MOUNTAIN)) ;
	}

	public void paint (int v, Graphics g) {
		super.paint((int) (v-v*0.2), g) ;
	}
	
}
