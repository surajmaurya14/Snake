package com.mycompany.snakegame;

import java.awt.Color;
import javax.swing.JFrame;

public class Example {

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame j=new JFrame("SNAKE GAME");
        Play p=new Play();
  
        j.setBackground(Color.DARK_GRAY);
        j.setBounds(10, 10, 905, 700);
        j.setResizable(false);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(p);
        
    }
    
}
