package org.homeunix.c64;

import java.awt.Color;

public final class C64Color extends Color {
	
	/* Original C64 colors */
	public final static C64Color C64COLOR_0 = new C64Color(0x19, 0x1d, 0x19) ;
	public final static C64Color C64COLOR_1 = new C64Color(0xfc, 0xf9, 0xfc) ;
	public final static C64Color C64COLOR_2 = new C64Color(0x93, 0x3a, 0x4c) ;
	public final static C64Color C64COLOR_3 = new C64Color(0xb6, 0xfa, 0xfa) ;
	public final static C64Color C64COLOR_4 = new C64Color(0xd2, 0x7d, 0xed) ;
	public final static C64Color C64COLOR_5 = new C64Color(0x6a, 0xcf, 0x6f) ;
	public final static C64Color C64COLOR_6 = new C64Color(0x4f, 0x44, 0xd8) ;
	public final static C64Color C64COLOR_7 = new C64Color(0xfb, 0xfb, 0x8b) ;
	public final static C64Color C64COLOR_8 = new C64Color(0xd8, 0x9c, 0x5b) ;
	public final static C64Color C64COLOR_9 = new C64Color(0x7f, 0x53, 0x07) ;
	public final static C64Color C64COLOR_10 = new C64Color(0xef, 0x83, 0x9f) ;
	public final static C64Color C64COLOR_11 = new C64Color(0x57, 0x57, 0x53) ;
	public final static C64Color C64COLOR_12 = new C64Color(0xa3, 0xa7, 0xa7) ;
	public final static C64Color C64COLOR_13 = new C64Color(0xb7, 0xfb, 0xbf) ;
	public final static C64Color C64COLOR_14 = new C64Color(0xa3, 0x97, 0xff) ;
	public final static C64Color C64COLOR_15 = new C64Color(0xef, 0xf9, 0xe7) ;

	/** Constructor */
	public C64Color(int r, int g, int b) {
		super(r, g, b) ;
	}
}
