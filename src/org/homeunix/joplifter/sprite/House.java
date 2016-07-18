package org.homeunix.joplifter.sprite;

import java.awt.image.BufferedImage;

import org.homeunix.joplifter.level.interfaces.ILevel;


public final class House extends AAnimatedSprite {
	
	public final static String[] HOUSE = new String[] {
		"2222      11111166          ",
		"2222    116666661166        ",
		"2222  1166660000661166      ",
		"  2211666666000066661166    ",
		"  116666666600006666661166  ",
		"1166666666666600666666661166",
		"6666666666660000666666666666",
		"6666666666660000666666666666",
		"6666666611111111666666666666",
		"6666661166116611666666666666",
		"6666116666116611666666666666",
		"1111111111111111111111111166",
		"1111111111111111111111111166",
	} ;
	
	public final static String[] HOUSE_CRASH = new String[] {
		"2222      11111166          ",
		"2222    116666661166        ",
		"2222  116666    661166      ",
		"  2211666666    66661166    ",
		"  1166666666    6666661166  ",
		"11666666  66    11  66661166",
		"66666611          2266666666",
		"666666                666666",
		"66661166  226622  6611666666",
		"666666  2222  222266  666666",
		"6666112222222222662222666666",
		"1111111111111111111111111166",
		"1111111111111111111111111166",
	} ;
	
	private static BufferedImage[] house = new BufferedImage[] {
		convertAsIs(HOUSE)
	} ;
	
	private static BufferedImage[] houseBurning = new BufferedImage[] {
		convertAsIs(HOUSE_CRASH)
	} ;
	
	public final static int CLOSED = 1 ;
	
	public House(int x, int y, ILevel pLevel) {
		setX(x) ;
		setY(y) ;
		setDirection(CLOSED) ;
		setLevel(pLevel) ;
		loadAnimation() ;
	}
	
	public void loadAnimation() {
		switch (getDirection()) {
		case CLOSED:
			setAnimation(house) ;
			break ;
		case CRASH:
			setAnimation(houseBurning) ;
			break ;
		}
	}
	
	public int action() {
		if (getDirection() == CLOSED) return -1 ;
		
		return -1 ;
	}
	
	
	public boolean isNear(int x, int y) {
		return (Math.abs((double) (x - getX())) < 10) 
			&& Math.abs((double) (y - getY())) < 12;
	}
	
	public void remove() {
		// House will not be removed
		setDirection(CRASH) ;
		loadAnimation() ;
		for (int i=0; i < 10; ++i) 
			getLevel().add(new Human(getLevel(), this)) ;
	}
	
	
	public String toString() {
		return "House" ;
	}
}

