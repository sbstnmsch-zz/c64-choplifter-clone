package org.homeunix.c64;

public final class C64Theme {

	/* Screen */
	public final static int SCREEN_WIDTH = 320 ;
	public final static int SCREEN_HEIGHT = 200 ;

	/* Colors*/
	public final static C64Color BLACK = C64Color.C64COLOR_0 ;
	public final static C64Color WHITE = C64Color.C64COLOR_1 ;
	public final static C64Color RED = C64Color.C64COLOR_2 ;
	public final static C64Color CYAN = C64Color.C64COLOR_3 ;
	public final static C64Color PURPLE = C64Color.C64COLOR_4 ;
	public final static C64Color GREEN = C64Color.C64COLOR_5 ;
	public final static C64Color BLUE = C64Color.C64COLOR_6 ;
	public final static C64Color YELLOW = C64Color.C64COLOR_7 ;
	public final static C64Color ORANGE = C64Color.C64COLOR_8 ;
	public final static C64Color BROWN = C64Color.C64COLOR_9 ;
	public final static C64Color SKIN = C64Color.C64COLOR_10 ;
	public final static C64Color DARK_GRAY = C64Color.C64COLOR_11 ;
	public final static C64Color GRAY = C64Color.C64COLOR_12 ;
	public final static C64Color LIGHT_GREEN = C64Color.C64COLOR_13 ;
	public final static C64Color LIGHT_PURPLE = C64Color.C64COLOR_14 ;
	public final static C64Color DARK_WHITE = C64Color.C64COLOR_15 ;

	/* Font */
	public final static int C64FONT = C64Font.PETSCII_UNSHIFTED ;
	
	// ------------------------------------------------------------------------
	
	/**
	 * getText wrapper to font
	 * @param text
	 * @return
	 */
	public final static int[][] getText(String text) {
		return C64Font.getText(text, C64FONT) ;
	}
}








