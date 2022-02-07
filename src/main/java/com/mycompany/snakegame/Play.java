package com.mycompany.snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Play extends JPanel implements ActionListener, KeyListener
{
    
    private boolean l=false;
    private boolean r=false;
    private boolean u=false;
    private boolean d=false;
    
    private int[] x=new int[750];
    private int[] y=new int[750];
    
    
    private int len=3;
    private int moves=0;
    private Timer t;
    private int delay=100;
    
    private ImageIcon titleImg;
    private ImageIcon rf;
    private ImageIcon lf;
    private ImageIcon uf;
    private ImageIcon df;
    private ImageIcon b;
    private ImageIcon food;
    private Random random =new Random();
    
    private int[] foodxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int[] foodypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
    
    private int xpos= random.nextInt(34);
    private int ypos= random.nextInt(23);
    private int score=0;
    
    public Play()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        t= new Timer(delay, this);
        t.start(); //action perfomed called automatically
    }
    
    @Override
    public void paint(Graphics g)
    {
        if(moves == 0)
        {
            
            x[2]=50;
            x[1]=75;
            x[0]=100;
            
            y[0]=100;
            y[1]=100;
            y[2]=100;
        }
        
        g.setColor(Color.WHITE);
        g.drawRect(24, 10, 851, 55);
        
        titleImg =new ImageIcon("/home/sm/NetBeansProjects/SnakeGame/src/main/java/com/mycompany/Assets/snaketitle.jpg");
        titleImg.paintIcon(this, g, 25, 11);
        
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);
        
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);
        
        
        g.setColor(Color.red);
        g.setFont(new Font("calibri", Font.BOLD, 14));
        g.drawString("Scores: "+score, 780, 30);
        
        g.setColor(Color.red);
        g.setFont(new Font("calibri", Font.BOLD, 14));
        g.drawString("Length: "+len, 780, 50);
        
        rf=new ImageIcon("/home/sm/NetBeansProjects/SnakeGame/src/main/java/com/mycompany/Assets/rightmouth.png");
        
        rf.paintIcon(this, g, x[0], y[0]);
        int i=0;
        for(i=0; i<len; i++)
        {
            if(i==0 && r)
            {
                rf=new ImageIcon("/home/sm/NetBeansProjects/SnakeGame/src/main/java/com/mycompany/Assets/rightmouth.png");
                rf.paintIcon(this, g, x[i], y[i]);
            }
            if(i==0 && l)
            {
                lf=new ImageIcon("/home/sm/NetBeansProjects/SnakeGame/src/main/java/com/mycompany/Assets/leftmouth.png");
                lf.paintIcon(this, g, x[i], y[i]);
            }
            if(i==0 && u)
            {
                uf=new ImageIcon("/home/sm/NetBeansProjects/SnakeGame/src/main/java/com/mycompany/Assets/upmouth.png");
                uf.paintIcon(this, g, x[i], y[i]);
            }
            if(i==0 && d)
            {
                df=new ImageIcon("/home/sm/NetBeansProjects/SnakeGame/src/main/java/com/mycompany/Assets/downmouth.png");
                df.paintIcon(this, g, x[i], y[i]);
            }
            
            
            if(i!=0)
            {
                b=new ImageIcon("/home/sm/NetBeansProjects/SnakeGame/src/main/java/com/mycompany/Assets/snakeimage.png");
                b.paintIcon(this, g, x[i], y[i]);
            }
            
        }
        food=new ImageIcon("/home/sm/NetBeansProjects/SnakeGame/src/main/java/com/mycompany/Assets/enemy.png");
        
        if(foodxpos[xpos]==x[0] && foodypos[ypos]==y[0])
        {
            score++;
            len++;
            xpos=random.nextInt(34);
            ypos=random.nextInt(23);
        }
        
        b.paintIcon(this, g, foodxpos[xpos], foodypos[ypos]);
        g.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        t.start();
        if(r)
        {
            for(int i=len-1; i>=0; i--)
            {
                y[i+1]=y[i];
            }
            
            for(int i=len; i>=0; i--)
            {
                if(i==0)
                {
                    x[i]=x[i]+25;
                }
                else
                {
                    x[i]=x[i-1];
                }
                if(x[i]>850)
                {
                    x[i]=25;
                }
                   
            }
            repaint();
        }
        
        if(l)
        {
            for(int i=len-1; i>=0; i--)
            {
                y[i+1]=y[i];
            }
            
            for(int i=len; i>=0; i--)
            {
                if(i==0)
                {
                    x[i]=x[i]-25;
                }
                else
                {
                    x[i]=x[i-1];
                }
                if(x[i]<25)
                {
                    x[i]=850;
                }
                   
            }
            repaint();
            
        }
        if(u)
        {
            for(int i=len-1; i>=0; i--)
            {
                x[i+1]=x[i];
            }
            
            for(int i=len; i>=0; i--)
            {
                if(i==0)
                {
                    y[i]=y[i]-25;
                }
                else
                {
                    y[i]=y[i-1];
                }
                if(y[i]<75)
                {
                    y[i]=625;
                }
                   
            }
            repaint();
        }
        if(d)
        {
            for(int i=len-1; i>=0; i--)
            {
                x[i+1]=x[i];
            }
            
            for(int i=len; i>=0; i--)
            {
                if(i==0)
                {
                    y[i]=y[i]+25;
                }
                else
                {
                    y[i]=y[i-1];
                }
                if(y[i]>625)
                {
                    y[i]=75;
                }
                   
            }
            repaint();
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            moves=0;
            len=3;
            score=0;
        }
        
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            moves++;
            if(!l)
            {
                r=true;
                l=false;
            }
            else
            {
                r=false;
                l=true;
            }
            u=false;
            d=false;
        }
        
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            moves++;
            if(!r)
            {
                r=false;
                l=true;
            }
            else
            {
                r=true;
                l=false;
            }
            u=false;
            d=false;
        }
        
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            moves++;
            if(!d)
            {
                u=true;
                d=false;
            }
            else
            {
                u=false;
                d=true;
            }
            l=false;
            r=false;
        }
        
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            moves++;
            if(!u)
            {
                d=true;
                u=false;
            }
            else
            {
                d=false;
                u=true;
            }
            l=false;
            r=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        t.start();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
