package org.homeunix.joplifter.sprite.interfaces;

import org.homeunix.joplifter.level.DestroyedException;
import org.homeunix.joplifter.level.interfaces.ILevel;

public interface IAnimatedSprite extends ISprite {

	/** Heartbeat called from game */
	int heartBeat() throws DestroyedException ;
	/** Action to be implemented i.e. movement */
	int action() throws DestroyedException ;

	/** Load animation to icon i.e. dependant on direction */
	void loadAnimation() ;
	
	/** For determination whether this is near to another object */ 
	boolean isNear(int x, int y) ;
	/** Start explosion */
	void explode() throws DestroyedException ;

	
	/* Getter / Setter */
	/** Getter */
	ILevel getLevel() ;
	/** Setter */
	void setLevel(ILevel level) ;
	
}
