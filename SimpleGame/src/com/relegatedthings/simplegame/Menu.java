package com.relegatedthings.simplegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.relegatedthings.simplegame.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	
	public Menu(HUD hud, Handler handler) {
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if (Game.gameState == STATE.Menu) {
			//play button
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 -32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}
			
			//Help button
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				Game.gameState = STATE.Help;
			}
			
			//quit button
			if(mouseOver(mx, my, 210,350, 200, 64)) {
				System.exit(1);
			}	
		}
		
		//back button for help
		if(Game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 210,350, 200, 64)) {
				Game.gameState = STATE.Menu;
				return;
			}
		}
		
		//back button for game over
		if(Game.gameState == STATE.End) {
			if(mouseOver(mx, my, 210,350, 200, 64)) {
				Game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				Spawn.setScorekeep(0);
				handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 -32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		if (Game.gameState == STATE.Menu) {
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("My First Game", 150, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 275, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 275, 290);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 275, 390);
			
		} else if(Game.gameState == STATE.Help) {
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 240, 70);
			
			g.setFont(fnt2);
			g.drawString("Use WASD or Arrow keys to dodge enemies", 10, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 275, 390);
		} else if(Game.gameState == STATE.End) {
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 180, 70);
			
			g.setFont(fnt2);
			g.drawString("You lost with a score of:" + hud.getScore(), 120, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try again", 245, 390);
		}
		
	}

}
