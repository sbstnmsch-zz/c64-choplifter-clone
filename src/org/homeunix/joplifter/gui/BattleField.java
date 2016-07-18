package org.homeunix.joplifter.gui;

import java.awt.Dimension;
import java.awt.Graphics;

import org.homeunix.c64.C64Theme;
import org.homeunix.joplifter.level.interfaces.ILevel;

public class BattleField extends ADoubleBuffer {

	/* Static strings to display */
	private final static Output WELCOME = new Output("DO.HOMEUNIX.ORG PRESENTS", 65, 18) ;
	private final static Output COPYRIGHTN = new Output("JOPLIFTER!", 128, 82) ;
	private final static Output COPYRIGHT0 = new Output("DAN GORLIN", 208, 98) ;
	private final static Output COPYRIGHT1 = new Output("DANE BIGHAM", 208, 106) ;
	private final static Output COPYRIGHT2 = new Output("(C) 1982", 208, 114) ;
	private final static Output COPYRIGHT3 = new Output("SEB MISCH", 208, 130) ;
	private final static Output COPYRIGHT4 = new Output("(C) 2007", 208, 138) ;

	/* Status and notification strings to display */
	private static Output labelSortie ;
	private static NumberOutput labelStatusPIK = new NumberOutput('a', 0, 66, 18) ;
	private static NumberOutput labelStatusCARO = new NumberOutput('z', 0,154, 18) ;;
	private static NumberOutput labelStatusHEART = new NumberOutput('s', 0, 242, 18) ;;
	
	/** Blinking stars in background */
	private static Stars stars = new Stars(20) ;
	/** The current level */
	private static ILevel level ;
	/** Scrolling coordinates */
	private static int scrollx = 0 ;
	/** Game controller */
	private static Controller controller ;
		
	/**
	 * Constructor
	 */
	public BattleField() {
		super() ;
		
		setBackground(C64Theme.BLACK) ;
		setSize(new Dimension(
				C64Theme.SCREEN_WIDTH, 
				C64Theme.SCREEN_HEIGHT)) ;
		
		setFocusable(true) ;
		requestFocus() ;
		
		controller = new Controller(this) ;
		
		addKeyListener(controller) ;
	}
	
	public final void setLevel(ILevel pLevel) {
		level = pLevel ;
	}
	
	// ------------------------------------------------------------------------
	
	/**
	 * Paint it all to offscreen
	 */
	public void paintBuffer(Graphics g) {

		// Ground
		g.setColor(C64Theme.GRAY) ;
		g.fillRect(0, 176, C64Theme.SCREEN_WIDTH, 100) ;
	
		// Blinkin stars
		stars.paint(g) ;
		
		// Scroll and paint all action
		if (level != null) {
			level.paint(scrollx, g) ;
		}
		
		// Statusbar
		g.setColor(C64Theme.YELLOW) ;
		g.drawRoundRect(1, 12, 317, 19, 15, 20) ;
		g.drawRoundRect(1, 12, 317, 19, 23, 20) ;
		g.drawRoundRect(2, 13, 315, 17, 15, 20) ;
		
		if (level == null) return ;
		
		if (! level.isStarted()) {
			WELCOME.paint(g) ;
			COPYRIGHTN.paint(g) ;
			COPYRIGHT0.paint(g) ;
			COPYRIGHT1.paint(g) ;
			COPYRIGHT2.paint(g) ;
			COPYRIGHT3.paint(g) ;
			COPYRIGHT4.paint(g) ;
		} else {
			labelStatusPIK.paint(g) ;
			labelStatusCARO.paint(g) ;
			labelStatusHEART.paint(g) ;
			g.setColor(C64Theme.RED) ;
			g.fillRect(10, 18, 55, 8) ;
			g.fillRect(92, 18, 61, 8) ;
			g.fillRect(180, 18, 61, 8) ;
			g.fillRect(268, 18, 42, 8) ;
			if (labelSortie != null)
				labelSortie.paint(g) ;
		}
	}
	
	// ------------------------------------------------------------------------
	
	/**
	 * Setter
	 */
	public void setStatus(int pik, int caro, int heart) {
		labelStatusPIK.setNumber(pik) ;
		labelStatusCARO.setNumber(caro) ; 
		labelStatusHEART.setNumber(heart) ;
	}

	/**
	 * Setter
	 */
	public void setSortieLabel(String text) {
		if (null == text) {
			labelSortie = null ;
		} else
			labelSortie = new Output(text, 132, 82) ;
	}
	
	/**
	 * Getter
	 */
	public static int getScrollx() {
		return scrollx;
	}

	/**
	 * Setter
	 */
	public static void setScrollx(int scrollx) {
		BattleField.scrollx = scrollx;
	}
}
