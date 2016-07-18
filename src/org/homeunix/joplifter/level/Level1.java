package org.homeunix.joplifter.level;

import org.homeunix.joplifter.level.interfaces.ILevel;
import org.homeunix.joplifter.sprite.House;
import org.homeunix.joplifter.sprite.Mountain;
import org.homeunix.joplifter.sprite.Tank;

public class Level1 extends ALevel {
	
	/**
	 * Constructor, the first level
	 */
	public Level1() {
		
		add(new Mountain(845, 172)) ;
		add(new Mountain(590, 172)) ;
		add(new Mountain(400, 172)) ;
		add(new Mountain(200, 172)) ;
		add(new Mountain(0, 172)) ;
		
		add(new House(50, 165, this)) ;
		add(new House(250, 165, this)) ;
		House openHouse = new House(450, 165, this) ;
		add(openHouse) ;
		openHouse.remove() ; /// Open (not remove) house
		
		for (int i=0; i < 2; ++i)
			add(new Tank(this)) ;
	}
	
	// ------------------------------------------------------------------------
	
	/**
	 * @implements {@link ILevel#getStartX()}
	 */
	public final int getStartX() {
		return 715 ;
	}
	
	/**
	 * @implements {@link ILevel#getStartX()}
	 */
	public final int getStartY() {
		return 160 ;
	}
}
