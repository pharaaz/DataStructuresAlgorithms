/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FishTank;

/**
 *
 * @author Owner
 */

import java.awt.Color;
import java.awt.Graphics;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;


public class Fish implements Runnable{
    
    protected double x,y;
    protected double dx, dy;
    protected double size;
    protected boolean isAlive;
    public static int world_width;
    public static int world_height;
    private FishShoal shoal;
    protected Random generator;
    
    //need to change this part:)
    
    public Fish( double x, double y){
        this.shoal=shoal;
        generator = new Random();
        this.x=x/2;
		this.y=y/2;
		
		world_height=(int) (y);
		world_width=(int) (x);
		isAlive=true;
                
		size= generator.nextInt(50)+10;
		//max_speed=7;
        
        while(dx == 0 || dy == 0){
            dx = generator.nextInt(9)-6;
            dy = generator.nextInt(9)-6;
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
				Logger.getLogger(Fish.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}
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
        
        public void move(){
        
        if(x>=world_width-size || x<=0){
            dx*=-1;
        }
        if(y>=world_height-size || y<=0){
            dy*=-1;
        }
        x+=dx;
        y+=dy;
        
//        Fish fishyy = shoal.canEat(this);
        
//        if(fishyy!=null){
//            
//            double calc = Math.hypot(this.x-fishyy.getX(), this.y-fishyy.getY());
//            
//            double neoDx = ((fishyy.x-this.x)/calc);
//		double neoDy = ((fishyy.y-this.y)/calc);
//		
//		dx=neoDx;
//		dy=neoDy;
//        }
//        
    
	}
        
        public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
                //g.drawArc((int)x, (int)y, (int)size, (int)size);
		g.fillOval((int)x, (int)y, (int)size, (int)size);
		
	}
        public void eat(Fish target){
          Fish fishee= shoal.canEat(this);
        }
            
    
    
}
