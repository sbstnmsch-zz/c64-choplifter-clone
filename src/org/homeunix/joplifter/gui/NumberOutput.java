package org.homeunix.joplifter.gui;

import java.awt.Graphics;

public class NumberOutput {
	
	/** Buffer for all numbers 0-99 */
	private final Output[] numbers = new Output[100] ;
	/** Current number */
	private int number = 0 ;
	
	/**
	 * Constructor
	 * @param label Pik, Caro, Heart, or alike
	 * @param number The number
	 * @param c Color
	 * @param x Coordsx
	 * @param y Coordsy
	 */
	public NumberOutput(char label, int number, int x, int y) {
		setNumber(number) ;
		for (int i=0; i < 100; ++i) {
			numbers[i] = new Output(label + format(i), x, y) ;
		}
	}
	
	// ------------------------------------------------------------------------
	
	/**
	 * Paint
	 */
	public final void paint(Graphics g) {
		numbers[number].paint(g) ;
	}
	
	/**
	 * Format number to 2digit string
	 * @param n
	 * @return
	 */
	private final String format(int n) {
		return ((n < 10) ? "0" : "") + n ;
	}
	// ------------------------------------------------------------------------
	
	/**
	 * Getter
	 */
	public int getNumber() {
		return number ;
	}

	/**
	 * Setter
	 */
	public void setNumber(int number) {
		if ((number >= 0 ) && (number <= 100))
			this.number = number ;
	}

	/**
	 * Setter
	 */
	public void incNumber() {
		setNumber(number + 1) ;
	}
	
	/**
	 * Setter
	 */
	public void decNumber() {
		setNumber(number - 1) ;
	}
}
