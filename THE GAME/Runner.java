import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Runner implements Runnable,KeyListener
{
    Thread t;
    JFrame f;
    JLabel rnnr1, rnnr2, fnsh;    
    int rnr1_pos=5;
    int rnr2_pos=5;
    int c=0,a;
    JLabel msg=new JLabel();
    boolean start=false;
    Runner()
    {
        rnnr1=new JLabel(new ImageIcon("0.png"));
        rnnr2=new JLabel(new ImageIcon("0.png"));
        fnsh=new JLabel(new ImageIcon("finish.jpg"));
        f=new JFrame("Foot Race");
        f.setSize(800,500);
        f.add(rnnr1);
        f.add(rnnr2);
        f.add(fnsh);
        rnnr1.setBounds(5,5,100,135);
        rnnr2.setBounds(5,200,100,135);
        fnsh.setBounds(675,5,200,500);
        f.setLayout(null);
        f.addKeyListener(this);
        f.getContentPane().setBackground(Color.WHITE);
        f.add(msg);
        msg.setBounds(400,100,100,100);
        msg.setVisible(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
    }
    public static void main(String[] arg)
    {
        Runner game=new Runner();
        game.t=new Thread(game);
        game.t.start();
    }

    public void run()
    {        
        try
        {
            while(true)
            {
                //rnr1_pos+=10;
                //rnr2_pos+=10;
                if(start)
                {
                  if(a>500)
                    a=1;
                else
                    a+=12;
                if(c==7)
                    c=0;
                else c+=1;
                rnnr1.setBounds(rnr1_pos,5,100,135);
                rnnr2.setBounds(rnr2_pos,200,100,135);
                rnnr1.setIcon(new ImageIcon(c+".png"));
                rnnr2.setIcon(new ImageIcon(c+".png"));
                if(rnr1_pos>=700)
                {
                    msg.setText("Winner: Player 1");
                    msg.setVisible(true);
                    t.stop();                    
                }
                else if(rnr2_pos>=700)
                {
                    msg.setText("Winner: Player 2");
                    msg.setVisible(true);
                    t.stop();                    
                }  
                }
                
                    
                t.sleep(90);
            }
                     
            
        }
        catch(InterruptedException e){}
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e)
    {
        if(!start)
            start=true;
        if(e.getKeyCode()==KeyEvent.VK_A)
        {
            rnr1_pos+=10;
        }
        if(e.getKeyCode()==KeyEvent.VK_L)
        {
            rnr2_pos+=10;
        }
       
    }
    public void keyPressed(KeyEvent e){}

    
}