package org.homeunix.joplifter;

import java.applet.Applet;

import org.homeunix.joplifter.gui.BattleField;

public class JopLifterApplet extends Applet {
	
	/**
	 * Init applet
	 */
	public void init() {
		BattleField battleField = new BattleField() ;
		
		add(battleField) ;
		setSize(battleField.getSize()) ;
	}

}
