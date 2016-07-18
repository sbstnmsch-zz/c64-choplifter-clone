package org.homeunix.joplifter.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import org.homeunix.joplifter.gui.interfaces.IDoubleBuffer;

/**
 * Double buffering for AWT Panels
 *
 */
public abstract class ADoubleBuffer extends Canvas implements IDoubleBuffer {

	/** Buffer */
	private Graphics bufferG ;
	/** Buffer */
	private Image buffer ;

	/** Buffer dims */
	private int width ;
	/** Buffer dims */
	private int height ;
	
	/**
	 * Constructor
	 */
	public ADoubleBuffer(){
        super() ;
    }
	
	/**
	 * Override update(g) not to clear screen in onscreen g
	 */
	public final void update(Graphics g) {
        paint(g) ;
    }
	
	/**
	 * Paint offline buffer to onscreen g
	 */
	public final void paint(Graphics g) {
        if ((this.width != getWidth()) 
        	|| (this.height != getHeight()) 
        	|| (null == this.buffer)
        	|| (null == this.bufferG)) 
        {
        	resetBuffer() ;
        }
        
        if (null != this.bufferG) {
        	this.bufferG.clearRect(0, 0, this.width ,this.height) ;
            paintBuffer(this.bufferG) ;
            g.drawImage(this.buffer, 0, 0, this) ;
        }
    }

	/**
	 * Clear and resave buffer
	 */
    private void resetBuffer(){
    	this.width = getWidth() ;
    	this.height = getHeight() ;

        if(null != this.bufferG){
        	this.bufferG.dispose() ;
        	this.bufferG = null ;
        }
        if(null != this.buffer){
        	this.buffer.flush() ;
        	this.buffer = null ;
        }

        this.buffer = createImage(this.width, this.height) ;
        this.bufferG = this.buffer.getGraphics() ;
    }
}
