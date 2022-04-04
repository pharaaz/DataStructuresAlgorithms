package testie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


/**
*
* This class maintains the GUI for the Zombie Simulator and includes a main driver method to
* execute the program.
*
* The GUI is built using Swing JComponents. It includes buttons with action listeners so that
* humans and zombies can be added with button clicks. It also includes a Swing Timer object -
* Timer objects register action listeners and are used to periodically trigger actions performed.
* The Timer in this GUI is used to repaint the GUI components to create the visual animations and
* also to check if a human has been killed. When a human is killed, it is removed from the list
* of humans and re-instantiates the object as a zombie thread starting from the same location to
* represent a human turning into a zombie.
*/
public class MainGUI extends JPanel implements ActionListener
{
	private JButton addHuman;
	private JButton addZombie;
	private DrawPanel drawPanel;
	private Timer timer;
	private List<Human>humans;
	private List<Human> zombies; 

   
   public MainGUI()
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
@Override
public void actionPerformed(ActionEvent e) {
Object source = e.getSource();
if (source.equals(addHuman)) {
Human human = new Human(humans, Double.valueOf(drawPanel.getWidth()/2), Double.valueOf(drawPanel.getHeight()/2));
humans.add(human);
}
if (source.equals(addZombie) ){
Zombie zombie = new Zombie(humans, Double.valueOf(drawPanel.getWidth()/2), Double.valueOf(drawPanel.getHeight()/2) );
zombies.add(zombie);
}
if (source.equals(timer)) {
drawPanel.repaint();
checkKill();
}
}
  
/**
* Checks through the list of humans to check if the boolean flag isAlive is false for any human, which
* signals that the thread should be killed. It re-instantiates a new zombie thread in the same
* location as where the human thread was killed (i.e. where the human was infected). The 'killed' human
* is removed from the MainGUI's human list and the new zombie is added to the MainGUI's zombie list.
*
* This method has the keyword "synchronized" which means that it is thread safe and only one thread has
* access to this method at a time. Synchronisation should only be isolated to critical sections of code
* as to not completely slow down the code and reduce the process of multi-threading. Critical section of
* code refers to a code segment where same variables are accessed multiple times by multiple threads (this
* method controls a human being removed from the humanList and re-instantiated as a new zombie, which is
* then added to the zombie list). Synchronisation here avoids an concurrency error that would be caused in
* the scenario that two zombies are very close to each other and kill a human at the same time (or almost
* the same time) resulting in multiple attempts to remove the single human from the humanList.
*/
public synchronized void checkKill() {
Human killedHuman = null;
boolean removeHuman = false;
for (Human human: humans) {
if (human.isAlive == false) {
killedHuman = human;
double humanX = human.getX();
double humanY = human.getY();
zombies.add(new Zombie(human.others, humanX,humanY));
removeHuman = true;
}
}
if (removeHuman && killedHuman != null) {
humans.remove(killedHuman);
}
}
  
/**
* Inner class that represents the window that the humans and zombies move around in.
* It is a subclass of JPanel and the paintComponent method is overridden to define
* that each time the human/zombie window is drawn/redrawn it needs to cycle through
* the list of all humans and zombies and draw each graphic representing each human/
* zombie thread.
*/
private class DrawPanel extends JPanel{
	   //private Random random;
	   public DrawPanel() {
		   super();
		   setPreferredSize(new Dimension(500,500));
		   setBackground(Color.GRAY);
		  // random = new Random();
		   
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
	   }
	   /*
	      g.setColor(new Color(random.nextFloat(),random.nextFloat(),random.nextFloat()));
	      
	      //g.fillOval(getWidth()/4,getHeight()/4, getWidth()/2, getHeight()/2);
	      g.fillOval(40,40, 20, 20);
		  */ 
}
  
/**
* Main driver method that executes the program.
*/
public static void main(String[] args) {
JFrame frame = new JFrame("Zombie Simulator");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().add(new MainGUI());
frame.pack();
frame.setVisible(true);
}
}