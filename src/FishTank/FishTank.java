/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FishTank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Owner
 */
public class FishTank extends JPanel implements ActionListener{
    
     //private List<Ball> balls;
     private JButton addFishButton;
     private DrawPanel drawPanel;
     private Timer timer;
     private List<Fish>fishs;
     private List<FishShoal> fishListt;
 
    public FishTank()
{  super(new BorderLayout());
     
    JPanel southPanel = new JPanel();
    addFishButton = new JButton("Add Fish");
    addFishButton.addActionListener(this);
    southPanel.add(addFishButton);
    
    add(southPanel, BorderLayout.SOUTH);
    
    drawPanel = new DrawPanel();
    add(drawPanel, BorderLayout.CENTER);
    
    timer = new Timer(20,this);
    timer.start();
    
    fishs = new ArrayList<>();
    fishListt = new ArrayList<>();
    
}
    
    public void actionPerformed(ActionEvent e)
{  
    Object source = e.getSource();
    if(source == addFishButton){
        System.out.println("Add Fish To The Collection");
        Fish fish = new Fish(drawPanel.getWidth(), drawPanel.getHeight());
        //need to change this parttttttt  
       //Ball ball = new Ball(drawPanel.getWidth(), drawPanel.getHeight());
        fishs.add(fish);
        Thread t = new Thread(fish);
        t.start();
        
    }
    if(source == timer){
        drawPanel.repaint();
    }
}
    
    private class DrawPanel extends JPanel
{
    private Random random;
    public DrawPanel()
    {
        super();
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
        random = new Random();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Fish fish : fishs){
            fish.draw(g);
        }
        
    }
}
    
    
    
    public static void main(String[] args)
{  
    JFrame frame = new JFrame("Fish Bowl by Faraaz");
   // kill all threads when frame closes
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing kills the program
   frame.getContentPane().add(new FishTank());  //puts a new "bouncy ball gui" in the frame
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
