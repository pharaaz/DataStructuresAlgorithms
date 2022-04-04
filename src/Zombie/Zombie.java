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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Zombie extends Human{

	public Zombie(List<Human> others, double x, double y) {
		super(others, x, y);
		// TODO Auto-generated constructor stub
		this.max_speed=super.max_speed/2;
		this.sightDistance=world_width*world_height;
		this.moved = 0; 
		this.totalMoved=0;
		
		
	}
	
	public void near() {
		Human closest = others.get(0);
		double distance = dist(closest);
		
		for(Human human: others) {
			double space = dist(human);
			if(distance>space) {
				closest=human;
				distance=space;
			}
		}
		double neoDx = ((closest.x-this.x)/distance)*this.max_speed;
		double neoDy = ((closest.y-this.y)/distance)*this.max_speed;
		
		dx=neoDx;
		dy=neoDy;
		
		if(distance<super.sightDistance) {
			closest.setDX(dx);
			closest.setDY(dy);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(generator.nextFloat(),generator.nextFloat(),generator.nextFloat()));
		//g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
		//g.fillOval((int)x, (int)y, (int)size, (int)size);
		
	}
	
	
	public void neoMovement() {
		this.totalMoved =  generator.nextInt(30)+10;
		this.moved = 0;
	}
	
	
	@Override
	public void move() {
		bitten();
		
		if(this.x>=world_width-size || this.x<=0){
            this.dx*=-1;
        }
        if(this.y>=world_height-size || this.y<=0){
            this.dy*=-1;
        }
        
		
		if (super.others.size() > 0 && moved>=totalMoved) {
				near();
				neoMovement();
				}		
		else if (super.others.isEmpty() && moved>=totalMoved) {
						this.dx = generator.nextInt((int)max_speed);
			            this.dy = generator.nextInt((int)max_speed);		
		}
		x += dx;
		y += dy;
		try {
			Thread.sleep(10);
		}catch (InterruptedException ex) {
			Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
		}	
		this.moved++;
		
	}
		 
	public void bitten() {
		double dist;
		for (Human human: super.stillHuman()) {
		dist = dist(human);
		if (dist <= size) {
		human.kill();
		break;
			}
		}
	}
	
	
	public double dist(Human human) {
		double calc = Math.hypot(this.x-human.getX(), this.y-human.getY());
		return calc;
		
	}
}