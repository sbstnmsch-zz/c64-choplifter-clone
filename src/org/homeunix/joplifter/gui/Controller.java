package org.homeunix.joplifter.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import org.homeunix.joplifter.level.Level1;
import org.homeunix.joplifter.level.interfaces.ILevel;

public class Controller extends Thread implements KeyListener {

	/** How long space was pressed */
	private long spaceDelta = -1 ;
	/** The gui portion */
	private BattleField battleField ;
	/** The current level */
	private ILevel level ;
	/** Key queue */
	private static List queue = new ArrayList(3) ;
	
	/**
	 * Constructor
	 * @param pBattleField
	 */
	public Controller(BattleField pBattleField) {
		battleField = pBattleField ;
		startNewGame() ;
	}
	
	// ------------------------------------------------------------------------

	private void startNewGame() {
		level = null ;
		level = new Level1() ;
		battleField.setLevel(level) ;
		
		if (! isAlive()) start() ;
	}
	
	/**
	 * Main loop for the game
	 */
	public void run () {
		try {
			while(true) { /////////////////////////////////////
				
				battleField.repaint() ;
				if (queue.contains("" + KeyEvent.VK_LEFT)) {
					level.getHelicopter().moveLeft() ;
				} else 
					if (queue.contains("" + KeyEvent.VK_RIGHT)) {
						level.getHelicopter().moveRight() ;
					} 
						
				if (queue.contains("" + KeyEvent.VK_UP)) {
					level.getHelicopter().moveUp() ;
				} else 
					if (queue.contains("" + KeyEvent.VK_DOWN)) {
						level.getHelicopter().moveDown() ;
					} 
				
				if (queue.contains("" + KeyEvent.VK_SPACE)) {
					if (spaceDelta <= 0) {
						spaceDelta = System.currentTimeMillis() ;
					} 
				} else {
					if (spaceDelta > 0) {
						spaceDelta = System.currentTimeMillis() - spaceDelta ;
						level.getHelicopter().toggleDirection(spaceDelta) ;
						spaceDelta = 0 ;
					}
				}
				
				Thread.sleep(50);
				 
				BattleField.setScrollx(level.heartBeat()) ;
				
				battleField.setStatus(	level.getKilled(),
										level.getPassengers(),
										level.getSaved()) ;
				
			} /////////////////////////////////////////////////
		} catch (InterruptedException e) {}
	}

	// ------------------------------------------------------------------------
	
	/**
	 * KeyLogger stuff
	 * @param e
	 */
	private void enqueue(int e) {
		if (! getLevel().getHelicopter().isAlive()) {
			startNewGame() ;
			return ;
		}
		if (! queue.contains("" + e)) {
			queue.add("" + e) ;
		}
	}

	/**
	 * KeyLogger stuff
	 * @param e
	 */
	private void dequeue(int e) {
		if (queue.contains("" + e)) {
			queue.remove("" + e) ;
		}
	}
	
	/**
	 * KeyLogger stuff
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		if (! level.isStarted()) 
			(new Show1SecThread()).start("FIRST SORTIE") ; 
		level.setStarted(true) ;

		enqueue(e.getKeyCode()) ;
	}

	/**
	 * KeyLogger stuff
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		dequeue(e.getKeyCode()) ;
	}

	/**
	 * KeyLogger stuff
	 * @param e
	 */
	public void keyTyped(KeyEvent e) { }

	// ------------------------------------------------------------------------
	
	/**
	 * Getter
	 * @return
	 */
	public ILevel getLevel() {
		return level;
	}

	/**
	 * Setter
	 */
	public void setLevel(ILevel level) {
		this.level = level;
	}
	
	// ------------------------------------------------------------------------

	/**
	 * Show label for some time
	 *
	 */
	private final class Show1SecThread extends Thread {
		
		private String text = "" ;
		
		public void start(String text) {
			this.text = text ;
			super.start() ;
		}
		
		public void run() {
			try {
				battleField.setSortieLabel(text) ;
				Thread.sleep(2000);
				battleField.setSortieLabel(null) ;
			} catch (InterruptedException e) {}
		}
	}
}
