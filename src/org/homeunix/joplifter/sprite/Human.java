package org.homeunix.joplifter.sprite;

import java.awt.image.BufferedImage;

import org.homeunix.joplifter.level.DestroyedException;
import org.homeunix.joplifter.level.interfaces.ILevel;

public class Human extends AAnimatedSprite {
	
	public final static String[] HUMAN_INVISIBLE = new String[] {
		"          ",
		"          ",
		"          ",
		"          ",
		"          ",
		"          ",
		"          ",
		"          ",
		"          ",
		"          ",
		"          "} ;

	public final static String[] HUMAN_RIGHT1 = new String[] {
		"    22    ",
		"    1166  ",
		"    1166  ",
		"  2211    ",
		"  1111    ",
		"  226611  ",
		"  2211    ",
		"  2211    ",
		"  1111    ",
		"    11    ",
		"    11    "} ;
	public final static String[] HUMAN_RIGHT2 = new String[] {
		"    22    ",
		"    1166  ",
		"    1166  ",
		"    11    ",
		"  1111    ",
		"111111    ",
		"  111111  ",
		"  111166  ",
		"  221166  ",
		"  1111    ",
		"  2266    "} ;
	public final static String[] HUMAN_RIGHT3 = new String[] {
		"      66  ",
		"    2211  ",
		"    2211  ",
		"22111166  ",
		"22  221111",
		"    11    ",
		"    11    ",
		"  221111  ",
		"  116611  ",
		"2211  22  ",
		"22        "} ;

	public final static String[] HUMAN_CENTER1 = new String[] {
		"  6622    ",
		"  111166  ",
		"  661166  ",
		"  1122    ",
		"  221111  ",
		"    116666",
		"    116611",
		"    1166  ",
		"    1166  ",
		"    1166  ",
		"  226611  "} ;
	public final static String[] HUMAN_CENTER2 = new String[] {
		"6   22    ",
		"11  1166  ",
		"661 1166  ",
		"211122    ",
		"  221111  ",
		"    116666",
		"    116611",
		"    1166  ",
		"    1166  ",
		"    1166  ",
		"  226611  "} ;
	
	private static BufferedImage[] humanRight = new BufferedImage[] {
		convertAsIs(HUMAN_RIGHT1),
		convertAsIs(HUMAN_RIGHT2),
		convertAsIs(HUMAN_RIGHT3)
	} ;
	
	private static BufferedImage[] humanLeft = new BufferedImage[] {
		flipHorizontal(HUMAN_RIGHT1),
		flipHorizontal(HUMAN_RIGHT2),
		flipHorizontal(HUMAN_RIGHT3),
	} ;

	private static BufferedImage[] humanCenter = new BufferedImage[] {
		convertAsIs(HUMAN_CENTER1),
		convertAsIs(HUMAN_CENTER1),
		convertAsIs(HUMAN_CENTER2),
		convertAsIs(HUMAN_CENTER2)
	} ;

	private static BufferedImage[] humanInvisible = new BufferedImage[] {
		convertAsIs(HUMAN_INVISIBLE)
	} ;

	public final static int DIR_CENTER = 6 ;
	public final static int DIR_INVISIBLE = 5 ;
	public final static int DIR_LEFT = 1 ;
	public final static int DIR_RIGHT = 2 ;
	
	private final static int IMPULSE = 50 ;
	private final static int FULL_THROTTLE = 2 ;
		
	
	private int stepsX = 0 ;
	private int impulseX = 0 ;
	
	private boolean isInHelicopter = false ;
	private boolean isSaved = false ;
	
	public Human(ILevel pLevel) {
		setX((int) Math.round(Math.random() * (ILevel.MAXWIDTH-400)) + 100) ;
		setY(pLevel.getStartY() + 8) ;
		setDirection(DIR_RIGHT) ;
		setLevel(pLevel) ;
		loadAnimation() ;
	}
	
	public Human(ILevel pLevel, House house) {
		this(pLevel) ;
		setX(house.getX()) ;
	}
	
	public int action() throws DestroyedException {
		if (isInHelicopter) {
			if (! getLevel().getHelicopter().canLeave()) {
				// Flying
				return -1 ;
			} else {
				// Enter ExitHelicopter mode
				setX(getLevel().getHelicopter().getX() + 15) ;
				stepsX = +FULL_THROTTLE ;
				impulseX = 0 ;
				isInHelicopter = false ;
				isSaved = true ;
				getLevel().decPassengers() ;
				return -1 ;
			}
		} else if (isSaved) {
			if (getLevel().getStation().canEnter(getX())) {
				// Entered station
				getLevel().incSaved() ;
				loadAnimation() ;
				throw new DestroyedException() ; 
			} else {
				// ExitHelicopter and enter station
				if (impulseX-- <= 0) {
					impulseX = (int) (5 + Math.random() * IMPULSE) ;
					if (Math.random() > 0.5) {
						stepsX = +FULL_THROTTLE ;
					} else {
						stepsX = 0 ;
						setDirection(DIR_CENTER) ;
					}
				}
				setX(getX() + stepsX) ;
				loadAnimation() ;
			}
			return -1 ;
		}
		
		
		
		
		if (--impulseX <= 0) {
			if (getLevel().isHelicopterNear(getX())) {
				// Run to helicopter
				impulseX = IMPULSE ;
				if (getX() <  getLevel().getHelicopter().getX()) {
					stepsX = +FULL_THROTTLE ;
				} else {
					stepsX = -FULL_THROTTLE ;
				}
			} else if (Math.random() > 0.5) {
				// Just run randomly
				impulseX = (int) (20 + Math.random() * IMPULSE) ;
				stepsX = Math.random() > 0.5 ? -FULL_THROTTLE : FULL_THROTTLE ;
			} else {
				// Salute
				impulseX = 20 ;
				stepsX = 0 ;
				setDirection(DIR_CENTER) ;
				loadAnimation() ;
				return -1 ;
			}
		}
		
		setX(getX() + stepsX) ;
		
		if (getX() < 50) {
			stepsX = -stepsX ;
		} else if (getX() > getLevel().getLandingCoordsX()-150) { 
			stepsX = -stepsX ;
		}
				
		if (getLevel().getHelicopter().canEnter(getX())) {
			if (getLevel().getHelicopter().isAlive()
				&& (getLevel().getPassengers() < 8)) {
				isInHelicopter = true ;
				loadAnimation() ;
				getLevel().incPassengers() ;
				return -1 ; // Entered
			}
		}
		
		loadAnimation() ;
		return -1 ;
	}
	
	public void loadAnimation() {
		if (isInHelicopter) {
			setAnimation(humanInvisible) ;
		} else if (stepsX == 0) {
			setAnimation(humanCenter) ;
		} else if (stepsX > 0) {
			setAnimation(humanRight) ;
		} else if (stepsX < 0){
			setAnimation(humanLeft) ;
		} else if (getDirection() == CRASH) {
			System.out.println("Human crashed") ;
		}
	}	
	
	public String toString() {
		return "Human" ;
	}


	public boolean isInHelicopter() {
		return isInHelicopter;
	}
}
