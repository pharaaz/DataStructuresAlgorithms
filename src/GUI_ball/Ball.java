package assignment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
/**
 *
 * @author zsm8422
 */
public class Ball implements Runnable{
    private Random random;
    private int size;
    private Color color;
    private int dx, dy;
    private int x, y;
    private boolean alive;
    private int world_w, world_h;
    
    public Ball(int world_w, int world_h){

        random = new Random();
        this.world_w = world_w;
        this.world_h = world_h;
        
        x = world_w/2;
        y = world_h/2;
        alive = true;
        size = random.nextInt(90)+10;
        color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
        
        while(dx == 0 || dy == 0){
            dx = random.nextInt(9)-6;
            dy = random.nextInt(9)-6;
        }
        
        
        
    }
    
    public void run(){
        alive = true;
        while(alive == true){
            move();
            try{
                Thread.sleep(15);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
    private void move(){
        
        if(x>=world_w-size || x<=0){
            dx*=-1;
        }
        if(y>=world_h-size || y<=0){
            dy*=-1;
        }
        x+=dx;
        y+=dy;
        
    }
    
    public void drawBall(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, size, size);
        
    }
    
    public void stop(){
        alive = false;
    }
    
    
}
