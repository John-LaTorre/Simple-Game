package com.relegatedthings.simplegame;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	
	public GameObject( int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	/**
	 * Gets the x position
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x position
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y position
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y position
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the object ID
	 * @return the id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * Sets the object ID
	 * @param id the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}

	/**
	 * Gets the x velocity
	 * @return the velX
	 */
	public int getVelX() {
		return velX;
	}

	/**
	 * Sets the object velocity
	 * @param velX the velX to set
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	/**
	 * Gets the y velocity
	 * @return the velY
	 */
	public int getVelY() {
		return velY;
	}

	/**
	 * Sets the y velocity
	 * @param velY the velY to set
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	
	
	

}
