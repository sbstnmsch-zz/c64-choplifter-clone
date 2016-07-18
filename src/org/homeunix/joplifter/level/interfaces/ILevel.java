package org.homeunix.joplifter.level.interfaces;

import java.awt.Graphics;
import java.util.List;

import org.homeunix.joplifter.level.DestroyedException;
import org.homeunix.joplifter.sprite.Helicopter;
import org.homeunix.joplifter.sprite.Station;
import org.homeunix.joplifter.sprite.interfaces.IAnimatedSprite;
import org.homeunix.joplifter.sprite.interfaces.ISprite;

public interface ILevel {

	/* Constants */
	/** Max widths of a level */
	public final static int MAXWIDTH = 1000 ;

	
	/* Maps */
	/** Whole level map i*/
	List getMap() ;
	/** Set level map */
	void setMap(List map) ;
	/** Sprite at level map i */
	ISprite getMap(int i) ;
	/** Whole active level map */
	List getActiveMap() ;
	/** Sprite at active level map i */
	IAnimatedSprite getActiveMap(int i) ;
	/** Add an element to game */
	void add(ISprite sprite) ;
	/** Remove an element from game */
	void remove(ISprite sprite) ;
	
	/* Paint */
	/** Paint method, dependant from view */
	void paint(int x, Graphics g) ;
	
	/* Main action */
	/** Level action / mainloop */
	int heartBeat() ;

	/* Explosion management */
	/** Explosions Fire fire fire */
	void manageCollision(int x, int y) throws DestroyedException ;

	/* Coordinates */
	/** Level start */
	int getStartX() ;
	/** Level start */
	int getStartY() ;
	/** Level landing */
	int getLandingCoordsX() ;
	/** Level landing */
	int getLandingCoordsY() ;
	
	/* Status fields */
	/** Game status */
	int getKilled() ;
	/** Game status */
	int getPassengers() ;
	/** Game status */
	int getSaved() ;
	/** Game status */
	void incKilled() ;
	/** Game status */
	void incPassengers() ;
	/** Game status */
	void decPassengers() ;
	/** Game status */
	void incSaved() ;
	/** Game status */
	boolean isStarted() ;
	/** Game status */
	void setStarted(boolean started) ;
	
	/* Main actresses */
	/** Helicopter */
	Helicopter getHelicopter() ;
	boolean isHelicopterNear(int x) ;
	/** Station */
	Station getStation() ;
}
