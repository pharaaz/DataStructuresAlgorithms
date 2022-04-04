package testie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//import testie.Human;
//import testie.Zombie;

public class ZombieSimulator extends JPanel implements ActionListener
{
	private JButton addHuman;
	private JButton addZombie;
	private DrawPanel drawPanel;
	private Timer timer;
	private List<Human>humans;
	private List<Human> zombies; 

   
   public ZombieSimulator()
   {  super(new BorderLayout());
      JPanel southPanel = new JPanel();
      
      addHuman = new JButton("Add Human");
      addZombie = new JButton("Add Zombie");
      
      addHuman.addActionListener(this);
      southPanel.add(addHuman);
      
      addZombie.addActionListener(this);
      southPanel.add(addZombie);
      
      add(southPanel,BorderLayout.SOUTH);
      
      drawPanel = new DrawPanel();
      add(drawPanel,BorderLayout.CENTER);
      
      timer = new Timer(20,this);
      timer.start();
      humans = new ArrayList<>();
      zombies = new ArrayList<>();
      
   }
   
   public void actionPerformed(ActionEvent e)
   { Object source = e.getSource();
     if(source == addHuman)
     {
    	 System.out.println("Add Ball To The Collection");
    	 Human human = new Human(humans, drawPanel.getWidth()/2, drawPanel.getHeight()/2);
    	 humans.add(human);
    	 Thread t = new Thread(human);
    	 t.start();
    	// Ball ball = new Ball(getHeight(), getWidth());
     }
     if(source == addZombie)
     {
    	 System.out.println("Add zom To The Collection");
    	 Zombie zombie = new Zombie(humans, drawPanel.getWidth()/2, drawPanel.getHeight()/2);
    	 zombies.add(zombie);
    	 Thread t = new Thread(zombie);
    	 t.start();
    	// Ball ball = new Ball(getHeight(), getWidth());
     }
     
     if(source == timer) {
    	 drawPanel.repaint();
    	 checkKill();
     }
   }
  
   private class DrawPanel extends JPanel{
	   private Random random;
	   public DrawPanel() {
		   super();
		   setPreferredSize(new Dimension(500,500));
		   setBackground(Color.GRAY);
		   random = new Random();
		   
	   }
	   
	   @Override
	   public void paintComponent(Graphics g)
	   {  super.paintComponent(g);
	   Human.worldWidth=getWidth();
	   Human.worldHeight=getHeight();
	   for(Human human : humans){
           human.draw(g);
       }
	   
	   for (Human zombie: zombies) {
		   zombie.draw(g);
		   }
	   
	   
	   /*
	      g.setColor(new Color(random.nextFloat(),random.nextFloat(),random.nextFloat()));
	      
	      //g.fillOval(getWidth()/4,getHeight()/4, getWidth()/2, getHeight()/2);
	      g.fillOval(40,40, 20, 20);
		  */ 
	   }
   }
   
   public synchronized void checkKill() {
	   
	   Human dead = null;
	   boolean gone = false;
	   for (Human human: humans) {
	   if (human.isAlive == false) {
	   dead = human;
	   double humanX = human.getX();
	   double humanY = human.getY();
	   zombies.add(new Zombie(human.others, humanX,humanY));
	   gone = true;
	   }
	   }
	   if (gone && dead != null) {
	   humans.remove(dead);
	   }
	   }

   
   public static void main(String[] args)
   {  JFrame frame = new JFrame("Zombie Simulator by Faraaz");
      // kill all threads when frame closes
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ZombieSimulator());
      frame.pack();
      // position the frame in the middle of the screen
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screenDimension = tk.getScreenSize();
      Dimension frameDimension = frame.getSize();
      frame.setLocation((screenDimension.width-frameDimension.width)/2,
         (screenDimension.height-frameDimension.height)/2);
      frame.setVisible(true);
      
   }
}
