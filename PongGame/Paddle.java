package PongGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends Rectangle{

    int id = 1;

    int ySpeed = 2;


    Paddle(int x, int y, int width, int height, int id){
        super(x,y,width,height);
        this.id = id;
    }

    public void drawPaddle(Graphics g) {
        if(id == 1){
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.red);

        }      
        g.fillRect(x, y, width, height);
    }

    public void movePaddle(){
        if((y <=0 && ySpeed == -2)   ||     (y >= 420 && ySpeed == 2)){
            ySpeed = 0;
        } else if(y >=420 && ySpeed == -2){
                // do nothing, let ySpeed be same without any change
        } else if(y >=420 || y < 0){
            ySpeed = - ySpeed;
        }
        y = y + ySpeed;

    }

    public void keyPressed(KeyEvent e){
        switch(id){

        case 1 :  if(e.getKeyCode() == KeyEvent.VK_W){
                ySpeed = -2;
            }
    
                  if(e.getKeyCode() == KeyEvent.VK_S){
                ySpeed = 2;
            }
            break;

        case 2 :  if(e.getKeyCode() == KeyEvent.VK_UP){
            ySpeed = -2;
        }

              if(e.getKeyCode() == KeyEvent.VK_DOWN){
            ySpeed = 2;
        }

        }
        
        
    }

    public void keyReleased(KeyEvent e){
        switch(id){

            case 1 :  if(e.getKeyCode() == KeyEvent.VK_W){
                    ySpeed = 0;
                }
        
                      if(e.getKeyCode() == KeyEvent.VK_S){
                    ySpeed = 0;
                }
                break;
    
            case 2 :  if(e.getKeyCode() == KeyEvent.VK_UP){
                ySpeed = 0;
            }
    
                  if(e.getKeyCode() == KeyEvent.VK_DOWN){
                ySpeed = 0;
            }
    
            }
            
            

    }
        

        


       
    }
