package PongGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle{

    int xSpeed;
    int ySpeed;
    // constructor passes on the size and location(via the super constructor)
    //of the ball to the Rectangle class properties
    Ball(int x, int y, int width, int height){
        super(x, y, width, height);

        Random random = new Random();
        int r = random.nextInt(2);
        if(r==1){
            xSpeed = -5;
        } else {
            xSpeed = 5;

        }
        
        ySpeed = 5;
    }

    // creating a ball 
    public void drawBall(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(this.x, this.y, this.width, this.height);
        g.drawLine(Panel.GAME_WIDTH/2, 0, Panel.GAME_WIDTH/2 , Panel.GAME_HEIGHT);
    }

    public void moveBall(){

        if( y >= Panel.GAME_HEIGHT - Panel.BALL_SIZE || y < 0){
            ySpeed = -ySpeed;
        }
        
        x += xSpeed;
        y += ySpeed;


    }

}