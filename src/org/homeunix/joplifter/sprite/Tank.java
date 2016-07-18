package org.homeunix.joplifter.sprite;

import java.awt.image.BufferedImage;

import org.homeunix.joplifter.gui.BattleField;
import org.homeunix.joplifter.level.interfaces.ILevel;

public class Tank extends AAnimatedSprite {
	
	public final static String[] TANK_LEFT1 = new String[] {
		"                                          ",
		"                                          ",
		"             2222                         ",
		"             222222                       ",
		"               2222                       ",
		"               222222                     ",
		"               222222222222               ",
		"             2222222222222222             ",
		"             2222222222222222             ",
		"         11661166116611661166116611       ",
		"     22112222222222222222222222222222     ",
		"     22222222222222222222222222222211     ",
		"     22112222222222222222222222222222     ",
		"     22222222222222222222222222222211     ",
		"       2266116611661166116611661166       ",
		"                                          ",
		"                                          "} ;
	public final static String[] TANK_LEFT2 = new String[] {
		"                                          ",
		"                                          ",
		"             2222                         ",
		"             222222                       ",
		"               2222                       ",
		"               222222                     ",
		"               222222222222               ",
		"             2222222222222222             ",
		"             2222222222222222             ",
		"         66116611661166116611661166       ",
		"     22662222222222222222222222222222     ",
		"     22222222222222222222222222222266     ",
		"     22662222222222222222222222222222     ",
		"     22222222222222222222222222222266     ",
		"       2211661166116611661166116611       ",
		"                                          ",
		"                                          "} ;
	
	
	public final static String[] TANK_CENTER_L = new String[] {
		"                                          ",
		"                                          ",
		"             2222                         ",
		"             222222                       ",
		"               2222                       ",
		"               222222                     ",
		"              222222222222                ",
		"            2222222222222222              ",
		"            2222222222222222              ",
		"        66116611661166116611661166        ",
		"     22662222222222222222222222222222     ",
		"     22222222222222222222222222222266     ",
		"     22662222222222222222222222222222     ",
		"     22222222222222222222222222222266     ",
		"       2211661166116611661166116611       ",
		"                                          ",
		"                                          "} ;
	
	public final static String[] TANK_CENTER = new String[] {
		"                                          ",
		"                                          ",
		"                2222                      ",
		"                22222                     ",
		"                 2222                     ",
		"                 222222                   ",
		"              222222222222                ",
		"            2222222222222222              ",
		"            2222222222222222              ",
		"        66116611661166116611661166        ",
		"     22662222222222222222222222222222     ",
		"     22222222222222222222222222222266     ",
		"     22662222222222222222222222222222     ",
		"     22222222222222222222222222222266     ",
		"       2211661166116611661166116611       ",
		"                                          ",
		"                                          "} ;
	
	
	
	public final static String[] TANK_CRASH1 = new String[] {
		"                                          ",
		"        2  1                              ",
		"       1 2  1       11     1              ",
		"        1        2 2         2            ",
		"        12 2  1   11   1    2 1           ",
		"        21  2 212   1   22  11  22        ",
		"      2   2  1  1      1 2  22     2      ",
		"    111222  2 1 2212 2    12   2 11 11    ",
		"         112    2111  212 2   2   11      ",
		"   1   111  1222    1  1111   1  1        ",
		"    1 1  22 11    11  2 2  2 2 112        ",
		"      22 11    111  2 1  2   1  1 2       ",
		"    1 11   221 2     1 1 1       1        ",
		"  1        1    2 22       1      11      ",
		"          1             11  1             ",
		"                                          ",
		"                                          ",
		"                                          "} ;
	public final static String[] TANK_CRASH2 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                 2 2         2            ",
		"           2  1   1         2 1           ",
		"        21  2 212   1   2                 ",
		"          2  1  1      1 2  22     2      ",
		"         2  2 1  212 2    12   2          ",
		"           2    2  1  212 2   2    1      ",
		"        11  1222    1  1111   1  1        ",
		"         22 11    11  2 2  2 2 112        ",
		"      1   1    111  2 1  2   1            ",
		"                     1 1 1       1        ",
		"             1                            ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          "} ;
	public final static String[] TANK_CRASH3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          "} ;
	
	
	private static BufferedImage[] tankRight = new BufferedImage[] {
		flipHorizontal(TANK_LEFT1),
		flipHorizontal(TANK_LEFT2)
	} ;
	
	private static BufferedImage[] tankLeft = new BufferedImage[] {
		convertAsIs(TANK_LEFT1),
		convertAsIs(TANK_LEFT2)
	} ;
	
	private static BufferedImage[] tankCenterL = new BufferedImage[] {
		convertAsIs(TANK_CENTER_L)
	} ;
	
	private static BufferedImage[] tankCenter = new BufferedImage[] {
		convertAsIs(TANK_CENTER)
	} ;
	
	private static BufferedImage[] tankCenterR = new BufferedImage[] {
		flipHorizontal(TANK_CENTER_L)
	} ;
	
	
	
	private static BufferedImage[] tankCrash = new BufferedImage[] {
		convertAsIs(TANK_CRASH1),
		convertAsIs(TANK_CRASH2),
		convertAsIs(TANK_CRASH3),
	} ;
	
	public final static int DIR_CENTER = 6 ;
	public final static int DIR_CENTER_L = 4 ;
	public final static int DIR_CENTER_R = 5 ;
	public final static int DIR_LEFT = 1 ;
	public final static int DIR_RIGHT = 2 ;
		
	private final static int IMPULSE = 50 ;
	private final static int FULL_THROTTLE = 4 ;
	
	private int stepsX = 0 ;
	private int impulseX = 0 ;
	
	public Tank(ILevel pLevel) {
		this(pLevel, (int) Math.round(Math.random() * (ILevel.MAXWIDTH-400)) + 100) ;
	}
	
	public Tank(ILevel pLevel, int x) {
		setX(x) ;
		setY(pLevel.getStartY() + 19) ;
		setDirection(DIR_RIGHT) ;
		setLevel(pLevel) ;
		loadAnimation() ;
	}
	
	
	public int action() {
		if (getDirection() == CRASH) return -1 ;
		
		if (--impulseX <= 0) {
			if (getLevel().isHelicopterNear(getX())) {
				// Move to helicopter
				impulseX = IMPULSE ;
				if (getX() <  getLevel().getHelicopter().getX()) {
					stepsX = +FULL_THROTTLE ;
				} else {
					stepsX = -FULL_THROTTLE ;
				}
			} else {
				// Random movement
				impulseX = (int) (50 + Math.random() * IMPULSE) ;
				stepsX = Math.random() > 0.5 ? -FULL_THROTTLE : FULL_THROTTLE ;
				int newDirection = stepsX > 0 ? DIR_RIGHT : DIR_LEFT ;
				if (newDirection != getDirection()) {
					toggleDirection() ;
					return -1 ;
				}
			}
		}
		
		if (Math.random() > 0.97) {
			shoot() ;
		}
		
		setX(getX() + stepsX) ;
		
		if (getX() < 50) {
			stepsX = -stepsX ;
		} else if (getX() > getLevel().getLandingCoordsX() - 200) { 
			stepsX = -stepsX ;
		}
		loadAnimation() ;
		return -1 ;
	}
	
	
	public void loadAnimation() {
		switch (getDirection()) {
		case DIR_RIGHT:
			setAnimation(tankRight) ;
			break ;
		case DIR_LEFT:
			setAnimation(tankLeft) ;
			break ;
		case DIR_CENTER_L:
			setAnimation(tankCenterL) ;
			break ;
		case DIR_CENTER:
			setAnimation(tankCenter) ;
			break ;
		case DIR_CENTER_R:
			setAnimation(tankCenterR) ;
			break ;
		case CRASH:
			setAnimation(tankCrash) ;
			break ;
		}
	}		
	
	public void toggleDirection() {
		(new TurnThread(getDirection())).start() ;
	}
	
	private void shoot() {
		getLevel().add(new TankArm(getX(), getY(), getDirection(), getLevel())) ;
	}

	public void remove() {
		Tank reinkarnation = new Tank(getLevel(), 0) ;
		
		if (BattleField.getScrollx() < ILevel.MAXWIDTH/4) {
			reinkarnation.setX(BattleField.getScrollx() + 350) ;
		} else {
			reinkarnation.setX(BattleField.getScrollx() - 200) ;
		}
		
		getLevel().add(reinkarnation) ;
		getLevel().remove(this) ;
	}
	
	

	// Turns the tank
	class TurnThread extends Thread {
		private final static int DELAY = 100 ;
		private int dir = -1 ;
		
		public TurnThread(int dir) {
			super() ;
			this.dir = dir ;
			
		}
		public void run () {
			try {
				Thread.sleep(DELAY) ;
				switch (dir) {
				case DIR_RIGHT:
					setDirection(DIR_CENTER_R) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_CENTER) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_CENTER_L) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_LEFT) ;
					break;
				case DIR_LEFT:
					setDirection(DIR_CENTER_L) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_CENTER) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_CENTER_R) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_RIGHT) ;
					break;
				}
				loadAnimation() ;	
			} catch (InterruptedException e) {}
		}
	}
	
	public String toString() {
		return "Tank" ;
	}
}
