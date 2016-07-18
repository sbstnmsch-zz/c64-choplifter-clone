package org.homeunix.joplifter.sprite;

import java.awt.image.BufferedImage;

import org.homeunix.joplifter.level.DestroyedException;
import org.homeunix.joplifter.level.interfaces.ILevel;
import org.homeunix.joplifter.sprite.interfaces.IAnimatedSprite;
import org.homeunix.joplifter.sprite.interfaces.IArm;
import org.homeunix.joplifter.sprite.interfaces.IDestroyable;

public abstract class AAnimatedSprite extends ASprite implements IAnimatedSprite, IDestroyable {

	public final static int CRASH = -1 ; 
	
	private ILevel level ;
	private int ticker = 0 ;
	private int direction ;
	private BufferedImage[] animation = null ;
	
	
	public final int heartBeat() throws DestroyedException {
		if (animation != null) {
			ticker = ++ticker % 16 ;
			setIcon(animation[ticker % animation.length]) ;
		}
		return action() ;
	}
	
	public final void setAnimation(BufferedImage[] pAnimation) {
		animation = pAnimation ;
	}
	
	public boolean isNear(int x, int y) {
		return (Math.abs((double) (x - getX())) < 10) 
			&& Math.abs((double) (y - getY())) < 10;
	}
	
	public final void explode() throws DestroyedException {
		if (getDirection() != CRASH) {
			(new ExplodeThread()).start() ;
			if (this instanceof IArm) {
				getLevel().manageCollision(getX(), getY()) ;
			}
		}
	}
	
	public synchronized void remove() {
		level.remove(this) ;
	}
	
	private final class ExplodeThread extends Thread {
		private final static int DELAY = 400 ;
		
		public void run () {
			try {
				setDirection(CRASH) ;
				loadAnimation() ;
				
				Thread.sleep(DELAY) ;
				remove() ;
			} catch (InterruptedException e) {}
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public ILevel getLevel() {
		return level;
	}

	public void setLevel(ILevel level) {
		this.level = level;
	}
}
