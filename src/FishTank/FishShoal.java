/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FishTank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;


/**
 *
 * @author Owner
 */
public class FishShoal {
    private List<Fish> fishList;
    
    public void add(Fish fish) {
		
	}
    
    public void remove(Fish fish) {
		
	}
  public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		//g.fillOval((int)x, (int)y, (int)size, (int)size);
		
	}
  public Fish canEat(Fish fish) {
      int keyy = 1;
      
      for(Fish fishy:fishList){
          if(fish.size>fishy.size&&fish.size<100){
//              Fish closest = fishList.get(0);
//              double distance= Math.hypot(fish.x-closest.getX(),fish.y-closest.getY()); 
              keyy=2;
               return fishy;

          }
      }

        return null;
	}
  





}
