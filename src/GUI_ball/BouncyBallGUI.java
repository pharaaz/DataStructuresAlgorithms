package assignment;

/**
A class which demonstrates how a Swing application is multithreaded
with the main thread and the event dispatch thread
@author Andrew Ensor
*/
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

public class BouncyBallGUI extends JPanel implements ActionListener
{
 private JButton addBallButton;
 private DrawPanel drawPanel;
 private Timer timer;
 private List<Ball> balls;
 

public BouncyBallGUI()
{  super(new BorderLayout());
     
    JPanel southPanel = new JPanel();
    addBallButton = new JButton("Add Ball");
    addBallButton.addActionListener(this);
    southPanel.add(addBallButton);
    
    add(southPanel, BorderLayout.SOUTH);
    
    drawPanel = new DrawPanel();
    add(drawPanel, BorderLayout.CENTER);
    
    timer = new Timer(20,this);
    timer.start();
    
    balls = new ArrayList<>();
    
}



public void actionPerformed(ActionEvent e)
{  
    Object source = e.getSource();
    if(source == addBallButton){
        System.out.println("Add Ball To The Collection");
        Ball ball = new Ball(drawPanel.getWidth(), drawPanel.getHeight());
        balls.add(ball);
        Thread t = new Thread(ball);
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
        for(Ball ball : balls){
            ball.drawBall(g);
        }
        
    }
}

public static void main(String[] args)
{  
    JFrame frame = new JFrame("Bouncy Balls");
   // kill all threads when frame closes
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing kills the program
   frame.getContentPane().add(new BouncyBallGUI());  //puts a new "bouncy ball gui" in the frame
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
