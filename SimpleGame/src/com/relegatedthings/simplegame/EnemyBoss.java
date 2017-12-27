package com.relegatedthings.simplegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {

	private Handler handler;
	Random r = new Random();
	public static final int SIZE = 96;
	private int timer = 180;
	private int timer2 = 50;
	
	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 0;
		velY = 2;
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, SIZE, SIZE);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		/*
		if(y <= 0 || y >= (Game.HEIGHT - 32)) {
			velY *= -1;
		}*/
		if(x <= 0 || x >= (Game.WIDTH - 96)) {
			velX *= -1;
		}
		if (timer <= 0) {
			velY = 0;
		} else {
			timer--;
		}
		if (timer <= 0) {
			timer2--;
		}
		if (timer2 <= 0) {
			if (velX == 0) {
				velX = 2;
			}
			if (velX > 0) {
				velX += 0.005f;
			} else {
				velX -= 0.005f;
			}
			velX = Game.clamp(velX,  -10, 10);
			
			int spawn = r.nextInt(10);
			if(spawn == 0) {
				handler.addObject(new EnemyBossBullet((int) x + 48, (int) y + 48, ID.BasicEnemy, handler));
			}
		}
		//handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red, SIZE, SIZE, .008f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, SIZE, SIZE);
		
	}

}