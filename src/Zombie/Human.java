/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie;

/**
 *
 * @author pgx2172
 */
import java.awt.Color;
import java.awt.Graphics;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;




public class Human implements Runnable{
	protected double x,y;
	protected double dx, dy;
	protected double size;
	protected boolean isAlive;
	public static int world_width;
	public static int world_height;
	protected double max_speed;
	protected int sightDistance;
	protected Random generator;
	protected List<Human> others;
	protected int moved;
	protected int totalMoved;
	//int h;
	
	public Human(List<Human> others, double x, double y) {
		generator = new Random();
		
		this.others=others;
		this.x=x;
		this.y=y;
		
		world_height=(int) (y*2);
		world_width=(int) (x*2);
		isAlive=true;
		size=20;
		max_speed=7;
		this.sightDistance=(int) (0.25*world_width*world_height);
		
		
		while(dx == 0 || dy == 0){
			//dx=2;
			//dy=2;
			dx = generator.nextInt((int)max_speed);
            dy = generator.nextInt((int)max_speed);
        }
		
	}

	@Override
	public void run() {
		isAlive = true;
		while(isAlive==true) {
			
			move();
			
			try {
				Thread.sleep(10);
			}catch (InterruptedException ex) {
				Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}
	}
	

	public void move(){
        
        if(x>=world_width-size || x<=0){
            dx*=-1;
        }
        if(y>=world_height-size || y<=0){
            dy*=-1;
        }
        x+=dx;
        y+=dy;
    
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}

	public double getSize() {
		return this.size;
	}
	
	public void kill() {
		isAlive=false;
	}
	
	protected void setDX(double dx) {
		this.dx = dx;
		}
	
	protected void setDY(double dy) {
		this.dy = dy;
		}
	
	public void setDx(double dx) {
		this.dx=dx;
	}
	
	public void setDy(double dy) {
		this.dy=dy;
	}
	
	public List<Human> stillHuman(){
		return this.others;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval((int)x, (int)y, (int)size, (int)size);
		
	}
	
	

}
