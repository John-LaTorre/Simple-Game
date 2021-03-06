package com.relegatedthings.simplegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	public static final int SIZE = 32;
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.setVelX(0f);
		this.setVelY(0f);
		this.handler = handler;
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, SIZE, SIZE);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 54);
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.white, SIZE, SIZE, 0.04f, handler));
		
		collision();
		
	}
	
	private void collision() {
		for(int i = 0; i <handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH -= 2;
				}
			}
			if(tempObject.getId() == ID.EnemyBoss) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 1000;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, SIZE, SIZE);
	}
	
	

	
}
