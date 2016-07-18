package org.homeunix.joplifter.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.homeunix.c64.C64Theme;

public class Game extends Frame {

	/**
	 * Constructor
	 */
	public Game() {
		init() ;
	}

	// ------------------------------------------------------------------------
	
	/**
	 * Init view
	 */
	private void init() {
		setTitle("Joplifter by Sebastian Misch") ;
		
		addWindowListener(new WindowAdapter(){
		      public void windowClosing(WindowEvent we){
		        System.exit(0);
		      }
		    });
		
		
		setLayout(new FlowLayout()) ;
		setBackground(C64Theme.BLACK) ;
		add(new BattleField()); 
		
		pack() ;
		
		Dimension desktop = Toolkit.getDefaultToolkit().getScreenSize();
		
		setLocation( (desktop.width - getWidth()) / 2, 
				(desktop.height - getHeight()) / 2) ;
		setResizable(false) ;
		setVisible(true) ;
	}
}
