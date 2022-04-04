package testie;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Zombie extends Human{

	private int world_height;


	public Zombie(List<Human> others, double x, double y) {
		super(others, x, y);
		// TODO Auto-generated constructor stub
		this.maxSpeed=super.maxSpeed/2;
		this.sightDistance=worldWidth*worldHeight;
		this.nStepsTaken = 0; 
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
		double neoDx = ((closest.x-this.x)/distance)*this.maxSpeed;
		double neoDy = ((closest.y-this.y)/distance)*this.maxSpeed;
		
		dx=neoDx;
		dy=neoDy;
		
		if(distance<super.sightDistance) {
			closest.setDX(dx);
			closest.setDY(dy);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		//g.setColor(new Color(generator.nextFloat(),generator.nextFloat(),generator.nextFloat()));
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
		//g.fillOval((int)x, (int)y, (int)size, (int)size);
		
	}
	
	public void edge() {
		if(this.x>=worldWidth-size || this.x<=0){
            this.dx*=-1;
        }
        if(this.y>=world_height-size || this.y<=0){
            this.dy*=-1;
        }
		
	}
	
	public void neoMovement() {
	//////////////////////////////////////////////////////////////////////////////
		this.totalMoved =  generator.nextInt(20)+10;
		this.nStepsTaken = 0;
	}
	
	
	@Override
	public void move() {
		bitten();
		
		edge();
        
		if (super.others.size() > 0 && nStepsTaken>=totalMoved) {
				near();
				neoMovement();
				}
				  
				// If no humans and time to change directions, generate random direction
				else if (super.others.isEmpty() && nStepsTaken>=totalMoved) {
						this.dx = generator.nextInt((int)maxSpeed);
			            this.dy = generator.nextInt((int)maxSpeed);
			        
				}
				//setRandomDirection(this.max_speed); //sets random dx and dy limited by maxSpeed
				//generateNewTotalSteps();
				//}
				  
				// Keep travelling in the same direction if the total steps have been completed, regardless of whether humans exist or not
				x += dx;
				y += dy;
				  
				// Threads need to sleep to delay movement for animation. Otherwise, objects would move too fast to be noticable
				try {
				Thread.sleep((int)20);
				} catch (InterruptedException ex) {
					Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
				}
				this.nStepsTaken++;
		 }
		 

	
	
/*	@Override
	public void move() {
		bitten();
		
		if(x>=world_width-size || x<=0){
            dx*=-1;
        }
        if(y>=world_height-size || y<=0){
            dy*=-1;
        }
        
        
        near();
		  
        
        this.x+=dx;
        this.y+=dy;
        
		// Threads need to sleep to delay movement for animation. Otherwise, objects would move too fast to be noticable
		try {
		Thread.sleep((int)20);
		} catch (InterruptedException e) {
		// ignore
		}

	}
	*/
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



/*
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;






/**
*
* This class maintains Zombie objects for the Zombie Simulator. In the Zombie Simulator, Zombies
* are represented by red squares and humans as blue circles. The GUI allows to add
* zombies and humans with button presses. When a zombie touches a human, the human turns into a
* zombie. Zombies have half the speed of humans and always move towards the human it is closest
* to. Humans are twice the speed of zombies and can only see 1/4 of the world around them. If a
* zombie in sight they will change direction and travel away from the nearest zombie. If there
* are no enemies in sight then humans/zombies have random movements. (This occurs if there are no
* zombies in sight of humans, or if there are only zombies in the world and no humans present).

public class Zombie extends Human {
  
public Zombie(List<Human> others, double x, double y) {
super(others, x, y);
this.maxSpeed = super.maxSpeed/2; // Zombies travel at half the speed of humans
super.setRandomDirection(this.maxSpeed); //sets random dx and dy limited by maxSpeed
//super.generateNewTotalSteps();
//this.nStepsTaken = 0;
this.sightDistance = worldWidth * worldHeight;
}
  
/**
* Zombie thread calculates distance between itself and all other humans.
* It is used to determine the movement (dx and dy) for both humans and
* zombies. This method identifies the human that a zombie is closest to
* and then calculates the new direction (dx and dy) that the zombie needs
* to change to. If the distance between a zombie and human is close enough
* so that the human sight the zombie, then this method also alters the
* human's direction (dx and dy) so that runs away in the opposite direction
* that the zombie is moving.

public void near() {
	Human close = others.get(0);
	double distance = dist(close);
	
	/////////////////////////////////////////////////////
	for(Human human: others) {
		double space = dist(human);
		if(distance>space) {
			close=human;
			distance=space;
		}
	}
	double neoDx = ((close.x-this.x)/distance)*this.maxSpeed;
	double neoDy = ((close.y-this.y)/distance)*this.maxSpeed;
	
	dx=neoDx;
	dy=neoDy;
	
	if(distance<super.sightDistance) {
		close.setDX(dx);
		close.setDY(dy);
	}
}
  
/**
* When a zombie thread moves, it needs to first check if it has infected a
* human (i.e. has it intersected a human), then it checks if it has hit a
* world boundary (and needs to turn around). After these two checks, the
* direction of travel is generated (values of dx and dy) and also a random
* number of steps. The zombie will walk in one direction for a random amount
* of steps (or time) before it changes direction. A zombie will always travel
* in the direction of the nearest human, and if there are no humans then it
* will travel in a random direction.
* The thread also needs to sleep after each movement (of dx and dy) to delay
* the movement and create visible animation in the GUI.

@Override
public void move() {
// Checks if a Zombie has touched a Human and if so, infects them
	bitten();
	checkWorldEdgeIntersect();
  
// Checks if Zombie has hit a world boundary, if so, it will change dx or dy to turn around
//checkWorldEdgeIntersect();
	
// If humans exists in the world, and no. of steps walked in 1 direction has exceeded,
// the Zombie needs to find the nearest human and change dx dy to travel towards the nearest Human
if (super.others.size() > 0 ) {
near();
//generateNewTotalSteps();
}
  
// If no humans and time to change directions, generate random direction
else if (super.others.isEmpty() ) {
setRandomDirection(this.maxSpeed); //sets random dx and dy limited by maxSpeed
//generateNewTotalSteps();
}
  
// Keep travelling in the same direction if the total steps have been completed, regardless of whether humans exist or not
x += dx;
y += dy;
  
// Threads need to sleep to delay movement for animation. Otherwise, objects would move too fast to be noticable
try {
Thread.sleep((int)20);
} catch (InterruptedException e) {
// ignore
}
  
this.nStepsTaken++;
}
  
/**
* Draws Zombies in the GUI as red-filled squares with black outlines
* @param g Graphics object to draw

@Override
public void draw(Graphics g) {
g.setColor(Color.RED);
g.fillRect((int) x, (int) y, (int) size, (int) size);
g.setColor(Color.BLACK);
g.drawRect((int) x, (int) y, (int) size, (int) size);
}

/**
* occurring when more than 1 zombie thread tries to infect the same human at the same time.
* It checks to see if a Zombie has intersected/touched a Human.
* If a Zombie intersects a Human, then these actions will follow:
* 1) The isAlive boolean flag is set to false to trigger the thread to stop running
* 2) The infected Human is removed from the list of other humans and creates a new Zombie object
* 3) This new Zombie is added to the zombieList in the MainGUI so that it is drawn in the GUI

public void bitten() {
	double dist;
	for (Human human: super.stillHuman()) {
	dist = dist(human);
	if (dist <= size) {
	human.kill();
	System.out.println(human.toString()+" kileld by " + this.toString());
	break;
		}
	}
}

public double dist(Human human) {
	double calc = Math.hypot(this.x-human.getX(), this.y-human.getY());
	return calc;
	
}


}
*/