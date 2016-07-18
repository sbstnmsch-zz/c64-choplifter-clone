package org.homeunix.joplifter.sprite;

import java.awt.image.BufferedImage;

import org.homeunix.c64.C64Theme;
import org.homeunix.joplifter.level.DestroyedException;
import org.homeunix.joplifter.level.interfaces.ILevel;


public class Helicopter extends AAnimatedSprite {
	
	public final static String[] HELICOPTER_RIGHT1 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"1111111111111111111111111111111111111111  ",
		"                 221111                   ",
		"    22           11111166                 ",
		"  2266         111111111111111111111      ",
		"  1166         1111111111111      2266    ",
		"  1111           11111111111        11    ",
		"222211111111111111111111111122      2266  ",
		"    111111111111111111111111111111111166  ",
		"    2211111111111111111111111111111166    ",
		"        2211111111111111111111111166      ",
		"               1166    1166         11    ",
		"          1111111111111111111111111111    ",
		"          1111111111111111111111111166    ",
		"                                          ",
		"                                          "} ;
	public final static String[] HELICOPTER_RIGHT2 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"               221111111111111111166      ",
		"  22             221111                   ",
		"  22             11111166                 ",
		"  22           111111111111111111111      ",
		"  1166         1111111111111      2266    ",
		"  1111           11111111111        11    ",
		"  2211111111111111111111111122      2266  ",
		"  22111111111111111111111111111111111166  ",
		"    2211111111111111111111111111111166    ",
		"        2211111111111111111111111166      ",
		"               1166    1166         11    ",
		"          1111111111111111111111111111    ",
		"          1111111111111111111111111166    ",
		"                                          ",
		"                                          "} ;
	public final static String[] HELICOPTER_RIGHT3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"    221111111111111111166                 ",
		"                 221111                   ",
		"22               11111166                 ",
		"  11           111111111111111111111      ",
		"  1166         1111111111111      2266    ",
		"  1111           11111111111        11    ",
		"  2211111111111111111111111122      2266  ",
		"    111111111111111111111111111111111166  ",
		"    2211111111111111111111111111111166    ",
		"        2211111111111111111111111166      ",
		"               1166    1166         11    ",
		"          1111111111111111111111111111    ",
		"          1111111111111111111111111166    ",
		"                                          ",
		"                                          "} ;

	public final static String[] HELICOPTER_RIGHT_LAND1 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"1111111111111111111111111111111111111111  ",
		"                 221111                   ",
		"    22           11111166                 ",
		"  2266         111111111111111111111      ",
		"  1166         1111111111111      2266    ",
		"  1111           11111111111        11    ",
		"222211111111111111111111111122      2266  ",
		"    111111111111111111111111111111111166  ",
		"    2211111111111111111111111111111166    ",
		"        221111111111111111111111116611    ",
		"          1111111111111111111111111111    ",
		"          1111111111111111111111111166    ",
		"                                          ",
		"                                          "} ;
	public final static String[] HELICOPTER_RIGHT_LAND2 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"               221111111111111111166      ",
		"  22             221111                   ",
		"  22             11111166                 ",
		"  22           111111111111111111111      ",
		"  1166         1111111111111      2266    ",
		"  1111           11111111111        11    ",
		"  2211111111111111111111111122      2266  ",
		"  22111111111111111111111111111111111166  ",
		"    2211111111111111111111111111111166    ",
		"        221111111111111111111111116611    ",
		"          1111111111111111111111111111    ",
		"          1111111111111111111111111166    ",
		"                                          ",
		"                                          "} ;
	public final static String[] HELICOPTER_RIGHT_LAND3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"    221111111111111111166                 ",
		"                 221111                   ",
		"22               11111166                 ",
		"  11           111111111111111111111      ",
		"  1166         1111111111111      2266    ",
		"  1111           11111111111        11    ",
		"  2211111111111111111111111122      2266  ",
		"    111111111111111111111111111111111166  ",
		"    2211111111111111111111111111111166    ",
		"        221111111111111111111111116611    ",
		"          1111111111111111111111111111    ",
		"          1111111111111111111111111166    ",
		"                                          ",
		"                                          "} ;
	
	public final static String[] HELICOPTER_RIGHT_DOWN1 = new String[] {
		
		"          22                              ",
		"            1166                          ",
		"              1166                        ",
		"    1122        2211                      ",
		"    1166            1166                  ",
		"  221166            111166                ",
		"    1111      2266111111111166            ",
		"    111111    221111111166  2211          ",
		"    2211111166  1111111111      1166      ",
		"      1111111111111111111111        1166  ",
		"        111111111111111111  1166      22  ",
		"          1111111111111111    2266        ",
		"            22111111111166      22        ",
		"        22112266111111111166    22        ",
		"        22111166  221111111166    66      ",
		"          22111111  111111111111  66      ",
		"              11111111  221111111111      ",
		"                22111111    11111166      ",
		"                    11111166              ",
		"                      221111111111        ",
		"                          111166          ",
	};
	public final static String[] HELICOPTER_RIGHT_DOWN2 = new String[] {
		
		"          22                              ",
		"            1166                          ",
		"  22          1166                        ",
		"    11          2211                      ",
		"    1166            1166                  ",
		"    1166            111166                ",
		"    1111      22661111111166              ",
		"    111111    221111111166                ",
		"    2211111166  1111111111                ",
		"      1111111111111111111111              ",
		"        111111111111111111  1166          ",
		"          1111111111111111    2266        ",
		"            22111111111166      22        ",
		"        22112266111111111166    22        ",
		"        22111166  221111111166    66      ",
		"          22111111  111111111111  66      ",
		"              11111111  221111111111      ",
		"                22111111    11111166      ",
		"                    11111166              ",
		"                      221111111111        ",
		"                          111166          ",
	} ;
	public final static String[] HELICOPTER_RIGHT_DOWN3 = new String[] {
		
		"                                          ",
		"                                          ",
		"                                          ",
		"    11  66                                ",
		"    1166            1166                  ",
		"  111166            111166                ",
		"  221111      2266111111111166            ",
		"    111111    221111111166  2211          ",
		"    2211111166  1111111111      1166      ",
		"      1111111111111111111111        1166  ",
		"        111111111111111111  1166      22  ",
		"          1111111111111111    2266        ",
		"            22111111111166      22        ",
		"        22112266111111111166    22        ",
		"        22111166  221111111166    66      ",
		"          22111111  111111111111  66      ",
		"              11111111  221111111111      ",
		"                22111111    11111166      ",
		"                    11111166              ",
		"                      221111111111        ",
		"                          111166          ",
	} ;	
	public final static String[] HELICOPTER_RIGHT_HALFDOWN1 = new String[] {
		"                                          ",
		"                                          ",
		"      111166                              ",
		"          221111                          ",
		"                111166                    ",
		"  22              22111166                ",
		"11111166          111111221111            ",
		"  1166      226611111111      111166      ",
		"  1111      22111111111166        2211    ",
		"  2211111166  22111111111111              ",
		"  221111111111111111111111221111          ",
		"    2211111111111111111166    2266        ",
		"        111111111111111166      66        ",
		"          221111111111111166    22        ",
		"            11  11111111111111112266      ",
		"        111111      1111111111111166      ",
		"        11111111116611    221111          ",
		"            221111111111        22        ",
		"                  1111111111662211        ",
		"                      2211111111          ",
		"                                          ",
		"                                          ",
	} ;
	public final static String[] HELICOPTER_RIGHT_HALFDOWN2 = new String[] {
		"                                          ",
		"                                          ",
		"      111166                              ",
		"          221111                          ",
		"                111166                    ",
		"  22              221111                  ",
		"11111166          111111                  ",
		"  1166      226611111111                  ",
		"  1111      22111111111166                ",
		"  2211111166  22111111111111              ",
		"  221111111111111111111111221111          ",
		"    2211111111111111111166    2266        ",
		"        111111111111111166      66        ",
		"          221111111111111166    22        ",
		"            11  11111111111111112266      ",
		"        111111      1111111111111166      ",
		"        11111111116611    221111          ",
		"            221111111111        22        ",
		"                  1111111111662211        ",
		"                      2211111111          ",
		"                                          ",
		"                                          ",
	} ;
	public final static String[] HELICOPTER_RIGHT_HALFDOWN3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                  1166                    ",
		"  22              22111166                ",
		"11111166          111111221111            ",
		"  1166      226611111111      111166      ",
		"  1111      22111111111166        2211    ",
		"  2211111166  22111111111111              ",
		"  221111111111111111111111221111          ",
		"    2211111111111111111166    2266        ",
		"        111111111111111166      66        ",
		"          221111111111111166    22        ",
		"            11  11111111111111112266      ",
		"        111111      1111111111111166      ",
		"        11111111116611    221111          ",
		"            221111111111        22        ",
		"                  1111111111662211        ",
		"                      2211111111          ",
		"                                          ",
		"                                          ",
	} ;	
	
	
	
	public final static String[] HELICOPTER_RIGHT_BACK1 = new String[] {
		"                                  2266    ",
		"                                1166      ",
		"                              1166        ",
		"                          2211            ",
		"                        2211              ",
		"                      1166      2211      ",
		"                    111166    1166  1166  ",
		"                22111111112211        22  ",
		"              2211  1111111111        11  ",
		"            1166    111111111166  221166  ",
		"          1166    22111111111111111111    ",
		"        11        11111111111111111166  66",
		"    2211          112211111111111111  2266",
		"  2211    66        11111111111166  2211  ",
		"        11        11111111111111  111111  ",
		"      221166  22111111111166  11111166    ",
		"      22111111111111111166  111111        ",
		"      66221111111111662211111166          ",
		"            111166    111111              ",
		"                  22111166                ",
		"                    11                    "} ;
	public final static String[] HELICOPTER_RIGHT_BACK2 = new String[] {
		"                                  2266    ",
		"                                1166      ",
		"                              1166        ",
		"                          2211            ",
		"                        2211              ",
		"                      1166      2211      ",
		"                    111166    1166  1166  ",
		"                22111111112211        22  ",
		"                    1111111111        11  ",
		"                    111111111166  221166  ",
		"                  22111111111111111111    ",
		"                  11111111111111111166  66",
		"                  112211111111111111  2266",
		"      22            11111111111166  2211  ",
		"        11        11111111111111  111111  ",
		"      221166  22111111111166  11111166    ",
		"      22111111111111111166  111111        ",
		"      11221111111111662211111166          ",
		"            111166    111111              ",
		"                  22111166                ",
		"                    11                    "} ;
	public final static String[] HELICOPTER_RIGHT_BACK3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                      1166      2211      ",
		"                    111166    1166  1166  ",
		"                22111111112211        22  ",
		"              2211  1111111111        11  ",
		"            1166    111111111166  221166  ",
		"          1166    22111111111111111111    ",
		"        11        11111111111111111166  66",
		"    2211          112211111111111111  2266",
		"  2211              11111111111166  2211  ",
		"        22        11111111111111  111111  ",
		"    11221166  22111111111166  11111166    ",
		"      22111111111111111166  111111        ",
		"      66221111111111662211111166          ",
		"            111166    111111              ",
		"                  22111166                ",
		"                    11                    "} ;

	
	public final static String[] HELICOPTER_RIGHT_HALFBACK1 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                    111166",
		"                        221111111166      ",
		"                    111111                ",
		"          11111111111166                  ",
		"  2211111166      111111    111166        ",
		"                22111111111111  2266      ",
		"              22111111111111      2266    ",
		"  66          2211111111111166      11    ",
		"  2266          2211111111111122111166    ",
		"  221166    221111111111111111111111      ",
		"  22111111111111111111111111111111        ",
		"    11111111111111111111111166      11    ",
		"      1111111111111166    226611111166    ",
		"                  226611111111111166      ",
		"              2211111111111166            ",
		"              22111166                    "} ;
	public final static String[] HELICOPTER_RIGHT_HALFBACK2 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                  111166  ",
		"                        221111111166      ",
		"                    111111                ",
		"                  111166                  ",
		"                  111111    111166        ",
		"                22111111111111  2266      ",
		"              22111111111111      2266    ",
		"  66          2211111111111166      11    ",
		"  2266          2211111111111122111166    ",
		"  221166    221111111111111111111111      ",
		"  22111111111111111111111111111111        ",
		"    11111111111111111111111166      11    ",
		"      1111111111111166    226611111166    ",
		"                  226611111111111166      ",
		"              2211111111111166            ",
		"              22111166                    "} ;
	public final static String[] HELICOPTER_RIGHT_HALFBACK3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                    1166                  ",
		"          11111111111166                  ",
		"      111166      111111    111166        ",
		"                22111111111111  2266      ",
		"              22111111111111      2266    ",
		"  66          2211111111111166      11    ",
		"  2266          2211111111111122111166    ",
		"  221166    221111111111111111111111      ",
		"  22111111111111111111111111111111        ",
		"    11111111111111111111111166      11    ",
		"      1111111111111166    226611111166    ",
		"                  226611111111111166      ",
		"              2211111111111166            ",
		"              22111166                    "} ;

	
	public final static String[] HELICOPTER_CENTER1 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"  11111111111111111111111111111111111     ",
		"                 11111                    ",
		"                 11111                    ",
		"               111111111                  ",
		"             2266     2266                ",
		"             22         66                ",
		"             11         11                ",
		"             1111111111111                ",
		"             2211111111166                ",
		"               221111166                  ",
		"             2211     1166                ",
		"             1166     2211                ",
		"             1166     2211                "} ;
	public final static String[] HELICOPTER_CENTER2 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"               221111111111111111166      ",
		"                 11111                    ",
		"                 11111                    ",
		"               111111111                  ",
		"             2266     2266                ",
		"             22         66                ",
		"             11         11                ",
		"             1111111111111                ",
		"             2211111111166                ",
		"               221111166                  ",
		"             2211     1166                ",
		"             1166     2211                ",
		"             1166     2211                "} ;
	public final static String[] HELICOPTER_CENTER3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"    221111111111111111166                 ",
		"                 11111                    ",
		"                 11111                    ",
		"               111111111                  ",
		"             2266     2266                ",
		"             22         66                ",
		"             11         11                ",
		"             1111111111111                ",
		"             2211111111166                ",
		"               221111166                  ",
		"             2211     1166                ",
		"             1166     2211                ",
		"             1166     2211                "} ;
	
	public final static String[] HELICOPTER_CENTER_LAND1 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"  11111111111111111111111111111111111     ",
		"                 11111                    ",
		"                 11111                    ",
		"               111111111                  ",
		"             2266     2266                ",
		"             22         66                ",
		"             11         11                ",
		"             1111111111111                ",
		"             2211111111166                ",
		"             2222111116666                ",
		"             1166     2211                ",
		"             1166     2211                "} ;
	public final static String[] HELICOPTER_CENTER_LAND2 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"               221111111111111111166      ",
		"                 11111                    ",
		"                 11111                    ",
		"               111111111                  ",
		"             2266     2266                ",
		"             22         66                ",
		"             11         11                ",
		"             1111111111111                ",
		"             2211111111166                ",
		"             2222111116666                ",
		"             1166     2211                ",
		"             1166     2211                "} ;
	public final static String[] HELICOPTER_CENTER_LAND3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"    221111111111111111166                 ",
		"                 11111                    ",
		"                 11111                    ",
		"               111111111                  ",
		"             2266     2266                ",
		"             22         66                ",
		"             11         11                ",
		"             1111111111111                ",
		"             2211111111166                ",
		"             2222111116666                ",
		"             1166     2211                ",
		"             1166     2211                "} ;

	public final static String[] HELICOPTER_CENTER_ROTATE = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"        22111111111111111111111166        ",
		"                  2211                    ",
		"                 111166                   ",
		"      66       111111111111111111         ",
		"     111       11111111111    2266        ",
		"    2211         111111111       11       ",
		"      111111111111111111111      266      ",
		"      221111111111111111111111111116      ",
		"        21111111111111111111111116        ",
		"          2111111111111111111116          ",
		"                116   116         11      ",
		"            11111111111111111111111       ",
		"            1111111111111111111166        ",
		"                                          ",
		"                                          "} ;	
	
	public final static String[] HELICOPTER_CENTER_LEFT1 = new String[] {
		"                              1166   ",
		"                          2211       ",
		"                        2211         ",
		"                      1166           ",
		"                    1111             ",
		"                 6611111             ",
		"               1122 2211662266       ",
		"             1122   2211111166       ",
		"         6611       11661111         ",
		"                    66    1166       ",
		"                  2266    11         ",
		"                  22    1111         ",
		"                  22  111111         ",
		"                  221111111166       ",
		"                    111166111166     ",
		"                      2266  1111     ",
		"                    2211    66       ",
		"                    1111             ",
		"                    2211             "} ;
	public final static String[] HELICOPTER_CENTER_LEFT2 = new String[] {
		"                                     ",
		"                                     ",
		"                                     ",
		"                      11             ",
		"                    1111             ",
		"                 2211111             ",
		"               2211 2211662266       ",
		"             1166   2211111166       ",
		"           1166     11661111         ",
		"         22         66    1166       ",
		"                  2266    11         ",
		"                  22    1111         ",
		"                  22  111111         ",
		"                  221111111166       ",
		"                    111166111166     ",
		"                      2266  1111     ",
		"                    2211    66       ",
		"                    1111             ",
		"                    2211             "} ;
	public final static String[] HELICOPTER_CENTER_LEFT3= new String[] {
		"                              1166   ",
		"                          2211       ",
		"                        2211         ",
		"                      1166           ",
		"                    1111             ",
		"                22111111             ",
		"                    2211662266       ",
		"                    2211111166       ",
		"                    11661111         ",
		"                    66    1166       ",
		"                  2266    11         ",
		"                  22    1111         ",
		"                  22  111111         ",
		"                  221111111166       ",
		"                    111166111166     ",
		"                      2266  1111     ",
		"                    2211    66       ",
		"                    1111             ",
		"                    2211             "} ;
		
	public final static String[] HELICOPTER_CRASH1 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"            1122111166  11                ",
		"          2211112222112266  6622          ",
		"        1111222211  226666116622          ",
		"  11111111111111111111111111111111111111  ",
		"      1111221122221111116611      11      ",
		"      221122222211221111  221122  66      ",
		"      111122111122112211116611    11      ",
		"      1122  222211222222111166            ",
		"      2266112211111122222266226611        ",
		"        1122111111222211116622  66        ",
		"          1111221111112211  11            ",
		"                1111    22                "} ;
	public final static String[] HELICOPTER_CRASH2 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"          1122111166  11                  ",
		"        2211112222112266  6622            ",
		"  11111111111111111111111111111111111111  ",
		"     111122116611116622111166             ",
		"   22111122222222111122  11      11       ",
		" 2222221122222211111166  221122  66       ",
		" 2211112211111111221111  6611    11       ",
		" 6622222222221111222222  1166             ",
		" 22  111122221122  22221166226611         ",
		"   2222112211111111111166  22  66         ",
		"       221111221111112211  11             ",
		"               1111    22                 "} ;
	public final static String[] HELICOPTER_CRASH3 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                1122111166  11            ",
		"              2211112222112266  6622      ",
		"  11111111111111111111111111111111111111  ",
		"           111122116611116622111166       ",
		"         22111122222222111122  11      11 ",
		"       2222221122222211111166  221122  66 ",
		"       2211112211111111221111  6611    11 ",
		"       6622222222221111222222  1166       ",
		"       22  111122221122  22221166226611   ",
		"         2222112211111111111166  22  66   ",
		"             221111221111112211  11       ",
		"                     1111    22           "} ;
	public final static String[] HELICOPTER_CRASH4 = new String[] {
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"                                          ",
		"             1122111166  11               ",
		"           2211112222112266  6622         ",
		"  11111111111111111111111111111111111111  ",
		"        111122116611116622111166          ",
		"      22111122222222111122  11      11    ",
		"    2222221122222211111166  221122  66    ",
		"    2211112211111111221111  6611    11    ",
		"    6622222222221111222222  1166          ",
		"    22  111122221122  22221166226611      ",
		"      2222112211111111111166  22  66      ",
		"          221111221111112211  11          ",
		"                  1111    22              "} ;
	
	private final static BufferedImage[] helRight = new BufferedImage[] {
		convertAsIs(HELICOPTER_RIGHT1),
		convertAsIs(HELICOPTER_RIGHT2),
		convertAsIs(HELICOPTER_RIGHT3),
	} ;
	private final static BufferedImage[] helRightLand = new BufferedImage[] {
		convertAsIs(HELICOPTER_RIGHT_LAND1),
		convertAsIs(HELICOPTER_RIGHT_LAND2),
		convertAsIs(HELICOPTER_RIGHT_LAND3),
	} ;
	private final static BufferedImage[] helRightDown = new BufferedImage[] {
		convertAsIs(HELICOPTER_RIGHT_DOWN1),
		convertAsIs(HELICOPTER_RIGHT_DOWN2),
		convertAsIs(HELICOPTER_RIGHT_DOWN3),
	} ;
	private final static BufferedImage[] helRightHalfDown = new BufferedImage[] {
		convertAsIs(HELICOPTER_RIGHT_HALFDOWN1),
		convertAsIs(HELICOPTER_RIGHT_HALFDOWN2),
		convertAsIs(HELICOPTER_RIGHT_HALFDOWN3),
	} ;
	private final static BufferedImage[] helRightBack = new BufferedImage[] {
		convertAsIs(HELICOPTER_RIGHT_BACK1),
		convertAsIs(HELICOPTER_RIGHT_BACK2),
		convertAsIs(HELICOPTER_RIGHT_BACK3),
	} ;
	private final static BufferedImage[] helRightHalfBack = new BufferedImage[] {
		convertAsIs(HELICOPTER_RIGHT_HALFBACK1),
		convertAsIs(HELICOPTER_RIGHT_HALFBACK2),
		convertAsIs(HELICOPTER_RIGHT_HALFBACK3),
	} ;
	
	private final static BufferedImage[] helLeft = new BufferedImage[] {
		flipHorizontal(HELICOPTER_RIGHT1),
		flipHorizontal(HELICOPTER_RIGHT2),
		flipHorizontal(HELICOPTER_RIGHT3),
	} ;
	private final static BufferedImage[] helLeftLand = new BufferedImage[] {
		flipHorizontal(HELICOPTER_RIGHT_LAND1),
		flipHorizontal(HELICOPTER_RIGHT_LAND2),
		flipHorizontal(HELICOPTER_RIGHT_LAND3),
	} ;
	private final static BufferedImage[] helLeftDown = new BufferedImage[] {
		flipHorizontal(HELICOPTER_RIGHT_DOWN1),
		flipHorizontal(HELICOPTER_RIGHT_DOWN2),
		flipHorizontal(HELICOPTER_RIGHT_DOWN3),
	} ;
	private final static BufferedImage[] helLeftHalfDown = new BufferedImage[] {
		flipHorizontal(HELICOPTER_RIGHT_HALFDOWN1),
		flipHorizontal(HELICOPTER_RIGHT_HALFDOWN2),
		flipHorizontal(HELICOPTER_RIGHT_HALFDOWN3),
	} ;
	private final static BufferedImage[] helLeftHalfBack = new BufferedImage[] {
		flipHorizontal(HELICOPTER_RIGHT_HALFBACK1),
		flipHorizontal(HELICOPTER_RIGHT_HALFBACK2),
		flipHorizontal(HELICOPTER_RIGHT_HALFBACK3),
	} ;
	private final static BufferedImage[] helLeftBack = new BufferedImage[] {
		flipHorizontal(HELICOPTER_RIGHT_BACK1),
		flipHorizontal(HELICOPTER_RIGHT_BACK2),
		flipHorizontal(HELICOPTER_RIGHT_BACK3),
	} ;
	
	private final static BufferedImage[] helCenter = new BufferedImage[] {
		convertAsIs(HELICOPTER_CENTER1),
		convertAsIs(HELICOPTER_CENTER2),
		convertAsIs(HELICOPTER_CENTER3),
	} ;
	private final static BufferedImage[] helCenterLand = new BufferedImage[] {
		convertAsIs(HELICOPTER_CENTER_LAND1),
		convertAsIs(HELICOPTER_CENTER_LAND2),
		convertAsIs(HELICOPTER_CENTER_LAND3),
	} ;
	private final static BufferedImage[] helCenterLeft = new BufferedImage[] {
		convertAsIs(HELICOPTER_CENTER_LEFT1),
		convertAsIs(HELICOPTER_CENTER_LEFT2),
		convertAsIs(HELICOPTER_CENTER_LEFT3),
	} ;
	private final static BufferedImage[] helCenterRight = new BufferedImage[] {
		flipHorizontal(HELICOPTER_CENTER_LEFT1),
		flipHorizontal(HELICOPTER_CENTER_LEFT2),
		flipHorizontal(HELICOPTER_CENTER_LEFT3),
	} ;
	
	private final static BufferedImage[] helCrash = new BufferedImage[] {
		convertAsIs(HELICOPTER_CRASH1),
		convertAsIs(HELICOPTER_CRASH3),
		convertAsIs(HELICOPTER_CRASH4),
		convertAsIs(HELICOPTER_CRASH2),
		flipHorizontal(HELICOPTER_CRASH4),
		flipHorizontal(HELICOPTER_CRASH3),
		convertAsIs(HELICOPTER_CRASH3),
	} ;
	
	private final static BufferedImage[] helTurnLeft = new BufferedImage[] {
		flipHorizontal(HELICOPTER_CENTER_ROTATE)		
	} ;
	
	private final static BufferedImage[] helTurnRight = new BufferedImage[] {
		convertAsIs(HELICOPTER_CENTER_ROTATE)
	} ;
	
	
	protected final static int DIR_CENTER = 0 ;
	private final static int DIR_CENTER_LAND = 100 + DIR_CENTER ;
	private final static int DIR_CENTER_L = 4 ;
	private final static int DIR_CENTER_R = 5 ;
	protected final static int DIR_LEFT = 1 ;
	private final static int DIR_LEFT_LAND = 100 + DIR_LEFT ;
	protected final static int DIR_RIGHT = 2 ;
	private final static int DIR_RIGHT_LAND = 100 + DIR_RIGHT ;
	
	private final static int IMPULSE = 60 ;
	private final static int FULL_THROTTLE = 10 ;
	private final static float GRAVITY = 0.6f ;
	private final static int ANGLEPOINT = 5 ;
	private final static int MAXANGLEPOINT = ANGLEPOINT + 3 ;
	
	private int v = 0 ;
	private int stepsX = 0 ;
	private int stepsY = 0 ;
	
	private int impulseX = 0 ;
	private int impulseY = 0 ;
	
	public Helicopter(ILevel pLevel) {
		setX(pLevel.getLandingCoordsX()) ;
		setY(pLevel.getLandingCoordsY()) ;
		this.v = pLevel.getStartX() ;
		setLevel(pLevel) ;
		setDirection(DIR_RIGHT) ;
		loadAnimation() ;
	}
	
	public boolean isLanded() {
		return getY() == getLevel().getLandingCoordsY() ;
	}
	
	public boolean canEnter(int x) {
		return isLanded() 
		&& (x > (getX()+12)-4) 
		&&  (x < (getX()+12)+4) ;
	}
	
	public boolean canLeave() {
		return isLanded() 
		&& (getX() > getLevel().getLandingCoordsX()-10) 
		&&  (getX() < getLevel().getLandingCoordsX()+20) ;
	}
	
	
	private void move() throws DestroyedException {
		if (impulseX-- != IMPULSE -1)
		if (impulseX > 0) { 
			if (impulseX % 10 == 0) {
				stepsX = (int) (stepsX * GRAVITY) ;
				loadAnimation() ;
			}
		} else {
			impulseX = 0 ;
		}
		if (--impulseY > 0) { 
			if (impulseY % 10 == 0) {
					stepsY = (int) (stepsY * GRAVITY) ;
					loadAnimation() ;
			}
		} else {
			impulseY = 0 ;
		}
		
		setX(getX() + stepsX) ;
		setY(getY() + stepsY) ;
		
		if (getY() >= getLevel().getLandingCoordsY()) {
			// Don't move when landed
			setY(getLevel().getLandingCoordsY()) ;
			if (Math.sqrt(Math.sqrt(stepsY * stepsY) * Math.sqrt(stepsY * stepsY)) 
					> FULL_THROTTLE) {
				stepsX = 0 ;
				stepsY = 0 ;
				impulseX = 0 ;
				impulseY = 0 ;
				explode() ;
			} else 
				if (Math.sqrt(Math.abs(stepsY) * Math.abs(stepsY)) 
						> FULL_THROTTLE / 4) {
					setDirection(getDirection() + 100) ; // 100 + x is the landing ani
				loadAnimation() ;
			} 
			stepsY = 0 ;
			stepsX = 0 ;
		} else 
			if (getY() < 50) {
				stepsY = 0 ;
				setY(50) ;
				loadAnimation() ;
			}
		
		if (getX() < 50) {
			setX(50) ;
			stepsX = 0 ;
			loadAnimation() ;
		} else if (getX() > ILevel.MAXWIDTH - 50) { 
			setX(ILevel.MAXWIDTH - 50) ; 
			stepsX = 0 ;
			loadAnimation() ;
			return ; 
		}
	}
	
	public void loadAnimation() {
		
		switch (getDirection()) {
		case DIR_RIGHT:
			if (Math.abs(stepsX) <= ANGLEPOINT) 
				setAnimation(helRight) ;
			else if (stepsX > 0) { 
				if (Math.abs(stepsX) < MAXANGLEPOINT)
					setAnimation(helRightHalfDown) ;
				else 
					setAnimation(helRightDown) ;
			} else if (Math.abs(stepsX) < MAXANGLEPOINT) 
				setAnimation(helRightHalfBack) ;
			else 
				setAnimation(helRightBack) ;
			break ;
		case DIR_LEFT:
			if (Math.abs(stepsX) <= ANGLEPOINT) 
				setAnimation(helLeft) ;
			else if (stepsX < 0) {
				if (Math.abs(stepsX) < MAXANGLEPOINT)
					setAnimation(helLeftHalfDown) ;
				else 
					setAnimation(helLeftDown) ;
			} else if (Math.abs(stepsX) < MAXANGLEPOINT) 
				setAnimation(helLeftHalfBack) ;
			else 
				setAnimation(helLeftBack) ;
			break ;
		case DIR_CENTER:
			if (Math.sqrt(stepsX*stepsX) <= ANGLEPOINT) {
				setAnimation(helCenter) ;
			} else if (stepsX > 0) {
				setAnimation(helCenterRight) ;
			} else {
				setAnimation(helCenterLeft) ;
			} break ;
		case DIR_CENTER_L:
			setAnimation(helTurnLeft) ;
			break ;
		case DIR_CENTER_R:
			setAnimation(helTurnRight) ;
			break ;
		case CRASH:
			setAnimation(helCrash) ;
			break ;
		case DIR_RIGHT_LAND:
			setAnimation(helRightLand) ;
			setDirection(DIR_RIGHT) ;
			break ;
		case DIR_LEFT_LAND:
			setAnimation(helLeftLand) ;
			setDirection(DIR_LEFT) ;
			break ;
		case DIR_CENTER_LAND:
			setAnimation(helCenterLand) ;
			setDirection(DIR_CENTER) ;
			break ;
		}
	}		
	
	public void toggleDirection(long spacePressed) {
		if (getY() >= getLevel().getLandingCoordsY()) return ;
		
		if (spacePressed < 300) {
			shoot() ;
			return ;
		}
		(new TurnThread(getDirection(), spacePressed)).start() ;
		
	}
	
	private void shoot() {
		getLevel().add(new Arm(getX(), getY(), stepsX, stepsY, getDirection(), getLevel())) ;
	}
	
	public boolean isAlive() {
		return getDirection() != CRASH ; 
	}
	
	public void moveLeft() {
		if (getY() >= getLevel().getLandingCoordsY()) { setY(getLevel().getLandingCoordsY()); stepsX = 0 ; return ; } // Don't move when landed
		if (getX() <= 10){ setX(10) ; stepsX = 0 ; return ; }
		impulseX = IMPULSE ;
		if (stepsX > - FULL_THROTTLE) {
			stepsX-- ;			
			loadAnimation() ;
		}
	}
	
	public void moveRight() {
		if (getY() >= getLevel().getLandingCoordsY()) { setY(getLevel().getLandingCoordsY()); stepsX = 0 ; return ; } // Don't move when landed
		if (getX() > ILevel.MAXWIDTH - 50) { setX(ILevel.MAXWIDTH - 50) ; stepsX = 0 ; return ; }
		impulseX = IMPULSE ;
		if (stepsX < FULL_THROTTLE) {
			stepsX++ ;
			loadAnimation() ;
		}
	}
	
	public void moveUp() {
		if (! isAlive()) return ;
		if (getY() <= 50) { setY(50) ; stepsY = 0; return ; } // Don't rise higher
		if (stepsY > - FULL_THROTTLE) {
			stepsY-- ;
			impulseY = IMPULSE ;
			loadAnimation() ;
		}
	}

	public void moveDown() {
		if (getY() >= getLevel().getLandingCoordsY()) { setY(getLevel().getLandingCoordsY()) ; stepsY = 0; return ; } // Don't do anything when landed
		if (stepsX < FULL_THROTTLE) {
			stepsY++ ;
			impulseY = IMPULSE ;
			loadAnimation() ;
		}
	}
	
		
	public int action() throws DestroyedException {
		move() ;

		// Right scroll?
		if (getX() > v+ (C64Theme.SCREEN_WIDTH-100)) {
			v = getX() - (C64Theme.SCREEN_WIDTH-100) ;
			return v ;
		}
		// Left scroll?
		if (getX() - 50 < v) {
			v = getX() - 50 ;
		}
		
		return v ;
	}
	
	public boolean isNear(int x, int y) {
		return (Math.abs((double) (x - getX())) < 20) 
			&& Math.abs((double) (y - getY())) < 22;
	}	
	
	public void remove() {
		setDirection(CRASH) ;
		loadAnimation() ;
		while (getLevel().getPassengers() > 0) {
			getLevel().incKilled();
			getLevel().decPassengers();
		}
	}
	
	
	
	// Threads

	// Turns the heli
	class TurnThread extends Thread {
		private final static int DELAY = 100 ;
		private int dir = -1 ;
		
		public TurnThread(int dir, long toggle) {
			super() ;
			this.dir = dir ;
			
		}
		public void run () {
			try {
				Thread.sleep(DELAY) ;
				switch (dir) {
				case DIR_RIGHT:
					setDirection(DIR_CENTER_R) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_CENTER) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_CENTER_L) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_LEFT) ;
					break;
				case DIR_CENTER:
					setDirection(DIR_CENTER_R) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_RIGHT) ;
					break;
				case DIR_LEFT:
					setDirection(DIR_CENTER_L) ;
					loadAnimation() ;
					Thread.sleep(DELAY) ;
					setDirection(DIR_CENTER) ;
					break;
				}
				loadAnimation() ;	
			} catch (InterruptedException e) {}
		}
	}

	public final int getV() {
		return v;
	}
	
	public String toString() {
		return "Helicopter" ;
	}
}
