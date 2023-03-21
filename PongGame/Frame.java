package PongGame;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame{
    Frame(){
        //creating frame
        JFrame frame = new JFrame();
        Panel panel = new Panel();
        //adding panel into frame
        frame.add(panel);
        // making frame as big as panel
        frame.pack();
        //centering the frame 
        frame.setLocationRelativeTo(null);
        //making frame visible of computer window
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}