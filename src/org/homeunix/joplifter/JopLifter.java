package org.homeunix.joplifter;

import org.homeunix.joplifter.gui.Game;

/**
 * Joplifter, a Choplifter clone written in Java
 * 
 * Original game, broderbund software, dan gorlin, dane bigham, copyright 1982
 * Clone, Sebastian Misch, copyright 2007
 * 
 * This clone's aim is to be as much as clone as can be, on a java basis. All
 * graphics, except the station ;-), were completely hand-drawn using the
 * original counterparts. The gameplay is exactly the same, as well as the colors
 * and fonts are alike the Commodore 64 compliant. 
 * 
 * Along with my copyright this code is licensed under the BSD License.
 * 
 * You can copy, change and redistribute, as long as my name and copyright
 * notice remains in the game and code.
 * 
 * Have fun!
 * 
 * @author misch
 *
 */
public class JopLifter {

	/*
	 * TODO Issue: Humans beeing shot are not synchronized (think so), results in more humans than created
	 * TODO Scrolling works still not exact the same as in original
	 */
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		new Game() ;
	}

}
