package com.relegatedthings.simplegame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x, y;
	protected ID id;
	protected float velX, velY;
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	/**
	 * Gets the x position
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x position
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Gets the y position
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the y position
	 * @param y the y to set
	 */
	public void setY(float y) {
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
	public float getVelX() {
		return velX;
	}

	/**
	 * Sets the object velocity
	 * @param velX the velX to set
	 */
	public void setVelX(float velX) {
		this.velX = velX;
	}

	/**
	 * Gets the y velocity
	 * @return the velY
	 */
	public float getVelY() {
		return velY;
	}

	/**
	 * Sets the y velocity
	 * @param velY the velY to set
	 */
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	
	
	

}
