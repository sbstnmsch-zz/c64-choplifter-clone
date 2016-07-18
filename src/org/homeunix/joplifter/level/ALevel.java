package org.homeunix.joplifter.level;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.homeunix.c64.C64Theme;
import org.homeunix.joplifter.level.interfaces.ILevel;
import org.homeunix.joplifter.sprite.Fence;
import org.homeunix.joplifter.sprite.Helicopter;
import org.homeunix.joplifter.sprite.Human;
import org.homeunix.joplifter.sprite.Station;
import org.homeunix.joplifter.sprite.interfaces.IAnimatedSprite;
import org.homeunix.joplifter.sprite.interfaces.IArm;
import org.homeunix.joplifter.sprite.interfaces.ISprite;

public abstract class ALevel implements ILevel {
	
	/* Maps */
	/** Map with all icons */
	private List map = new ArrayList(32);
	/** Map with only the active icons */
	private List activeMap = new ArrayList(32) ;
	
	/** The station */
	private Station station ;
	/** The chopper */
	private Helicopter helicopter ;
	
	/* Status */
	/** How many people were killed? */
	private int killed = 0 ;
	/** How many people are passengers right now? */
	private int passengers = 0 ;
	/** How many people entered to station? */
	private int saved = 0 ;
	/** Level started? */
	private boolean started = false ;
	
	// ------------------------------------------------------------------------
	
	/** 
	 * Paint all elements 
	 */
	public void paint(int x, Graphics g) {
		for (int i = 0; i < getMap().size(); ++i) {
			getMap(i).paint(x, g) ;
		}
	}
	
	// ------------------------------------------------------------------------
	
	/**
	 * Pings all active elements and sets view (scrollx)
	 */
	public final int heartBeat() {
		int result = -1 ;
		int newScrollX = -1 ;

		for (int i = 0; i < getActiveMap().size(); ++i) {

			try {
				result = getActiveMap(i).heartBeat() ;
			} catch (DestroyedException de) {
				remove(getActiveMap(i)) ;
			}
			if (result > -1) {
				newScrollX = result ;
			}
		}

		return newScrollX ;
	}
	
	// ------------------------------------------------------------------------

	/**
	 * This handles explosions of arm. Looks for destroyables near to the
	 * explosion.
	 */
	public void manageCollision(int x, int y) throws DestroyedException{
		// Only collide in view
		int sx = getHelicopter().getV() ;
		if ((x < sx) || (x > sx + C64Theme.SCREEN_WIDTH)) return ;
		
		for (int i = 0; i < getActiveMap().size(); ++i) {
			if (! (getActiveMap(i) instanceof IArm)) {
				if (getActiveMap(i).isNear(x, y)) {
					
					if (getActiveMap(i) instanceof Human) {
						if (! ((Human) getActiveMap(i)).isInHelicopter()) {
							incKilled() ;
							getActiveMap(i).explode() ;
							throw new DestroyedException() ;
						} else {
							continue ;
						}
					} else {
						getActiveMap(i).explode() ;
					}
					return ; // only destroy one icon
				}
			}
		}
	}

	// ------------------------------------------------------------------------
	
	/**
	 * Add element to game
	 */
	public void add(ISprite sprite) {
		if (sprite instanceof Human) {
			if (! map.contains(getStation()))
				add(getStation()) ;
			if (! map.contains(getHelicopter()))
				add(getHelicopter()) ;
		}
		map.add(sprite) ;
		if (sprite instanceof IAnimatedSprite) {
			activeMap.add(sprite) ;
		}
	}
	
	/**
	 * Remove element from game
	 */
	public void remove(ISprite sprite) {
		map.remove(sprite) ;
		activeMap.remove(sprite) ;
	}

	// ------------------------------------------------------------------------

	/**
	 * Getter
	 */
	public boolean isHelicopterNear(int x) {
		return (getHelicopter().getY() > getLandingCoordsY() - 30)
			&& Math.abs((double) (x - getHelicopter().getX())) < 100 ; 
	}
	
	/**
	 * Getter
	 */
	public List getActiveMap() {
		return activeMap ;
	}

	/**
	 * Getter
	 */
	public IAnimatedSprite getActiveMap(int i) {
		return (IAnimatedSprite) getActiveMap().get(i) ;
	}
	
	/**
	 * Getter
	 */
	public List getMap() {
		return map ;
	}
	
	/**
	 * Getter
	 */
	public ISprite getMap(int i) {
		return (ISprite) map.get(i) ;
	}
	
	/**
	 * Setter
	 */
	public void setMap(List list) {
		this.map = list ;
	}
	
	/**
	 * Getter
	 */
	public int getKilled() {
		return killed ;
	}
	
	/**
	 * Getter
	 */
	public int getPassengers() {
		return passengers ;
	}
	
	/**
	 * Getter
	 */
	public int getSaved() {
		return saved ;
	}
	
	/**
	 * Setter
	 */
	public void incKilled() {
		killed++ ;
	}
	
	/**
	 * Setter
	 */
	public void incPassengers() {
		passengers++ ;
	}

	/**
	 * Setter
	 */
	public void decPassengers() {
		passengers-- ;
	}
	
	/**
	 * Setter
	 */
	public void incSaved() {
		saved++ ;
	}

	/**
	 * Getter
	 */
	public Helicopter getHelicopter() {
		if (helicopter == null)
			setHelicopter(new Helicopter(this)) ;
		return helicopter ;
	}

	/**
	 * Setter
	 */
	public void setHelicopter(Helicopter helicopter) {
		this.helicopter = helicopter;
	}
	
	/**
	 * Getter
	 */
	public Station getStation() {
		if (station == null) {
			setStation(new Station(getStartX() + 125, getStartY() - 2)) ;
			add(new Fence(getStartX()-10, getStartY()+13)) ; // These ain't no
			add(new Fence(getStartX()+50, getStartY()+15)) ; // real coords
			add(new Fence(getStartX()+170, getStartY()+19)) ;
			add(new Fence(getStartX()+350, getStartY()+25)) ;
		}
		return station ;
	}
	
	/**
	 * Setter
	 */
	public void setStation(Station station) {
		this.station = station ;
	}
	
	/**
	 * Getter
	 */
	public final int getLandingCoordsX() {
		return getStation().getX() + 10 ;
	}
	
	/**
	 * Getter
	 */
	public final int getLandingCoordsY() {
		return getStation().getY() + 2 ;
	}
	
	/**
	 * Getter
	 */
	public boolean isStarted() {
		return started ;
	}
	
	/**
	 * Setter
	 */
	public void setStarted(boolean started) {
		this.started = started ;
	}
}
