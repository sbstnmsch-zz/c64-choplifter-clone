package org.homeunix.joplifter.sprite;

import java.awt.image.BufferedImage;

import org.homeunix.c64.C64Theme;
import org.homeunix.joplifter.level.DestroyedException;
import org.homeunix.joplifter.level.interfaces.ILevel;
import org.homeunix.joplifter.sprite.interfaces.IArm;

public final class TankArm extends AAnimatedSprite implements IArm {
	
	public final static String[] ARM = new String[] {
		"                     ",
		"                     ",
		"         266         ",
		"         116         ",
		"         266         ",
		"                     ",
		"                     "} ;
	
	public final static String[] ARM_CRASH1 = new String[] {
		"   1   12  122   1   ",
		" 1   21121212221  1  ",
		"   1   12212122 11   ",
		"    1122122212212    ",
		"     212212122212  1 ",
		"    22212212221222   ",
		"       21222212      "} ;
	public final static String[] ARM_CRASH2 = new String[] {
		"                     ",
		"        2 21   1     ",
		"       12 1  22      ",
		"       212 212       ",
		"     21 21 12 21     ",
		"       1 212221      ",
		"       21222212      "} ;
	public final static String[] ARM_CRASH3 = new String[] {
		"                     ",
		"                     ",
		"                     ",
		"                     ",
		"                     ",
		"                     ",
		"                     "} ;
	
	private static BufferedImage[] arm = new BufferedImage[] {
		convertAsIs(ARM)
	} ;
	
	private static BufferedImage[] armCrash = new BufferedImage[] {
		convertAsIs(ARM_CRASH1),
		convertAsIs(ARM_CRASH2),
		convertAsIs(ARM_CRASH3)
	} ;
	
	private int ox = 0 ;
	private int sd = -1 ;
	
	private int ground = 1024 ;
		
	public TankArm(int x, int y, int d, ILevel pLevel) {
		this.ox = x ;
		this.sd = d ;
		setLevel(pLevel) ;
		this.ground = pLevel.getLandingCoordsY() + 8;
		setX(x + 8) ;
		setY(10 + y) ;
		setAnimation(arm) ;
	}
	
	public void loadAnimation() {
		if (getDirection() == CRASH) 
			setAnimation(armCrash) ;
	}
	
	public int action() throws DestroyedException {
		if (getDirection() == CRASH) return -1 ;
		
		switch (sd) {
		case Tank.DIR_RIGHT:
			setY(167+ (int)(((Math.sin(0.15-(getX() - ox)/25f)) *18f))) ;
			setX(getX()+15) ;
			break ;
		case Tank.DIR_LEFT:
			setX(getX()-15) ;
			setY(167+ (int)(((Math.sin(0.15-(ox-getX())/25f)) *18f))) ;
			break ;
		}
		if (hasCollision()) {
			explode() ;
		}
		return -1 ;
	}
	
	public boolean hasCollision() {
		return (getX() > ox + C64Theme.SCREEN_WIDTH) 
			|| (getX() < ox - C64Theme.SCREEN_WIDTH)
			|| (getY() < 0)
			|| (getY() >= ground) ;
	}
}
