package org.homeunix.c64;

import java.lang.reflect.Field;

public final class C64Font {

	/* Two fonts available */
	
	/** Shifted font, containing capital and lower letters */
	public final static int PETSCII_SHIFTED = 0 ;
	/** Unshifted font, containing only capital letters and plenty of glyphs */
	public final static int PETSCII_UNSHIFTED = 1 ;

	/** Font class */
	private static Class font ;
	/** Initialized? */
	private static boolean initialized = false ;
	/** 128 icons / characters */
	private static int[][][] characters = new int[128][8][8] ;
	
	/**
	 * Constructor
	 * @param petscii
	 */
	public C64Font(int petscii) {
		switch (petscii) {
		case PETSCII_SHIFTED: 
			font = PetsciiShifted.class ;
			break ;
		case PETSCII_UNSHIFTED: 
			font = PetsciiUnshifted.class ;
			break ;
		default: throw new RuntimeException(
				"Font not supported") ;
		}
		init() ;
		initialized = true ;
	}

	// ------------------------------------------------------------------------

	/**
	 * Load font and pollute
	 */
	private final static void init() {
		try {
			Object instance = font.newInstance() ;

			for (int i=32; i < 128; ++ i) {
				Field field = font.getField("C64FONT_" + i);
				String[] orig = (String[]) field.get(instance) ;
				characters[i] = new int[orig.length][orig[0].length()] ;
				for (int y=0; y < orig.length; ++y) {
					for (int x=0; x < orig[y].length(); ++x) {
						characters[i][y][x] = (orig[y].charAt(x) != ' ') ? 1 : 0 ;
					}
				}
			}
		} catch (Exception e) {
			System.err.println(
					"Fontclass does not contain specific character. " 
					+ e.toString()) ;
		}
	}

	/**
	 * Build word icon
	 * @param text
	 * @param petscii
	 * @return
	 */
	public final static int[][] getText(String text, int petscii) {
		if (! initialized) new C64Font(petscii) ;
		int[][] result = new int[8][text.length() * 8] ;
		char[] cArray = text.toCharArray() ;

		for (int i = 0; i < cArray.length; ++i) {
			int[][] character = characters[(int) cArray[i]] ;
			for (int y = 0; y < 8; ++y) {
				for (int x = 0; x < 8; ++x) {
					result[y][i * 8 + x] = character[y][x] ;
				} 
			}
		}
		return result ;
	}
}
